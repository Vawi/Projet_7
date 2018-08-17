package org.val.win.business.impl.manager;

import org.joda.time.LocalDate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.val.win.business.contract.manager.EmpruntManager;
import org.val.win.consumer.contract.dao.EmpruntDao;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.bean.EmpruntEtat;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Classe de gestion des transaction pour les emprunts
 */
@Named
public class EmpruntManagerImpl extends AbstractManager implements EmpruntManager {

    private static final Logger logger = LogManager.getLogger(EmpruntManagerImpl.class);

    @Inject
    private EmpruntDao empruntDao;

    @Inject
    @Named("txManagerP7")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Methode pour l'emprunt
     * @param pEmprunt le nouvel emprunt
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
                pEmprunt.setIdUtilisateur(pUtilisateur.getIdUtilisateur());
                pEmprunt.setIdOuvrage(pOuvrage.getIdOuvrage());
                pEmprunt.setEtat(EmpruntEtat.ENCOURS.toString());
                empruntDao.emprunt(pEmprunt);
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
                pEmprunt.setDateFin(dateFin.plusWeeks(1));
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
    public void fermerEmprunt(Emprunt pEmprunt) {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                pEmprunt.setEtat(EmpruntEtat.RENDU.toString());
                empruntDao.emprunt(pEmprunt);
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
