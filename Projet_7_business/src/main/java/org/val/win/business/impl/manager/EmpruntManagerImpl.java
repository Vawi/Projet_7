package org.val.win.business.impl.manager;

import org.joda.time.LocalDate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.val.win.business.contract.manager.EmpruntManager;
import org.val.win.business.contract.manager.OuvrageManager;
import org.val.win.consumer.contract.dao.EmpruntDao;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.bean.EmpruntEtat;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.val.win.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Classe de gestion des transaction pour les emprunts
 */
@Named
public class EmpruntManagerImpl extends AbstractManager implements EmpruntManager {

    private static final Logger logger = LogManager.getLogger(EmpruntManagerImpl.class);

    @Inject
    private EmpruntDao empruntDao;

    @Inject
    private OuvrageManager ouvrageManager;

    private Emprunt emprunt;

    @Inject
    @Named("txManagerP7")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Retour la liste des emprunts d'un utilisateur
     * @param id de l'utilisateur
     * @return la liste d'emprunt d'un utilisateur
     */
    @Override
    public List<Emprunt> getListEmprunt(Integer id) {
        return empruntDao.getListEmprunt(id);
    }

    /**
     * Récupérer un emprunt
     * @param id l'id de l'emprunt
     * @return un emprunt
     */
    @Override
    public Emprunt getEmprunt(Integer id) {
        emprunt = empruntDao.getEmprunt(id);
        return emprunt;
    }

    /**
     * Methode de creation d'un emprunt
     * @param pEmprunt L'emprunt
     * @param pUtilisateur l'utilisateur qui emprunte
     * @param pOuvrage l'ouvrage emprunté
     */
    @Override
    public void emprunt(Emprunt pEmprunt, Utilisateur pUtilisateur, Ouvrage pOuvrage) {
        logger.info("un emprunt va etre creer");
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                pEmprunt.setDateDebut(LocalDate.now());
                pEmprunt.setDateFin(LocalDate.now().plusWeeks(4));
                pEmprunt.setIdUtilisateur(pUtilisateur.getIdUtilisateur());
                pEmprunt.setIdOuvrage(pOuvrage.getIdOuvrage());
                pEmprunt.setEtat(EmpruntEtat.ENCOURS.toString());
                pOuvrage.setNombreDispo(pOuvrage.getNombreDispo() - 1);
                empruntDao.emprunt(pEmprunt);
                ouvrageManager.ModifierNombreDispo(pOuvrage);
            }
        });
        logger.info("un emprunt est envoyé vers la DB" + pEmprunt);
    }

    /**
     * Methode servant a prolonger un emprunt
     * @param pEmprunt l'emprunt a prolonger
     */
    @Override
    public void prolongerEmprunt(Emprunt pEmprunt) {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                LocalDate dateFin = pEmprunt.getDateFin();
                pEmprunt.setDateFin(dateFin.plusWeeks(4));
                pEmprunt.setEtat(EmpruntEtat.PROLONGE.toString());
                empruntDao.emprunt(pEmprunt);
            }
        });
    }

    /**
     * Methode servant a fermer un emprunt
     * @param pEmprunt l'emprunt a clore
     */
    @Override
    public void fermerEmprunt(Emprunt pEmprunt) throws NotFoundException {
        Ouvrage ouvrage = ouvrageManager.getOuvrage(pEmprunt.getIdOuvrage());
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                pEmprunt.setEtat(EmpruntEtat.RENDU.toString());
                ouvrage.setNombreDispo(+1);
                empruntDao.emprunt(pEmprunt);
                ouvrageManager.ModifierNombreDispo(ouvrage);
            }
        });
    }

    @Override
    public void retardEmprunt(Emprunt pEmprunt) {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                pEmprunt.setEtat(EmpruntEtat.RETARD.toString());
                empruntDao.emprunt(pEmprunt);
            }
        });
    }

}
