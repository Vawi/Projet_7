package org.val.win.business.impl.manager;

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
import org.val.win.model.exception.NotFoundException;

import org.joda.time.LocalDate;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe de gestion des transaction pour les emprunts
 */
@Named
public class EmpruntManagerImpl extends AbstractManager implements EmpruntManager {

    @Inject
    private EmpruntDao empruntDao;

    @Inject
    private OuvrageManager ouvrageManager;

    @Inject
    @Named("txManagerP7")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Retour la liste des emprunts
     * @return la liste d'emprunt
     */
    @Override
    public List<Emprunt> getListEmprunt() {
        return empruntDao.getListEmprunt();
    }

    /**
     * Retour la liste des emprunts d'un utilisateur
     * @param id l'id de l'utilisateur
     * @return la liste d'emprunt d'un utilisateur
     */
    @Override
    public List<Emprunt> getListEmpruntUtilisateur(final Integer id) {
        List<Emprunt> vListEmprunt = this.getListEmprunt();
        vListEmprunt = vListEmprunt.stream()
                .filter(p -> p.getIdUtilisateur().equals(id))
                .collect(Collectors.toList());
        System.out.println(vListEmprunt);
        return vListEmprunt;
    }

    /**
     * Récupérer un emprunt
     * @param id l'id de l'emprunt
     * @return un emprunt
     */
    @Override
    public Emprunt getEmprunt(final Integer id) throws NotFoundException{
        List<Emprunt> vListEmprunt = this.getListEmprunt();
        Emprunt vEmprunt = vListEmprunt.stream()
                .filter(p -> p.getIdEmprunt().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Aucun utilisateur correspondant au couple prenom/password fourni."));
        return vEmprunt;
    }

    /**
     * Methode de creation d'un emprunt
     * @param pEmprunt L'emprunt
     * @param pUtilisateur l'utilisateur qui emprunte
     * @param pOuvrage l'ouvrage emprunté
     */
    @Override
    public void emprunt(final Emprunt pEmprunt, final Utilisateur pUtilisateur, final Ouvrage pOuvrage) throws NotFoundException {
        Ouvrage ouvrage = ouvrageManager.getOuvrage(pOuvrage.getIdOuvrage());
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {

                pEmprunt.setDateDebut(LocalDate.now());
                pEmprunt.setDateFin(pEmprunt.getDateDebut().plusWeeks(4));
                pEmprunt.setIdUtilisateur(pUtilisateur.getIdUtilisateur());
                pEmprunt.setIdOuvrage(ouvrage.getIdOuvrage());
                pEmprunt.setEtat(EmpruntEtat.ENCOURS.toString());
                ouvrage.setNombreDispo(ouvrage.getNombreDispo() - 1);
                empruntDao.emprunt(pEmprunt);
                ouvrageManager.ModifierNombreDispo(ouvrage);
            }
        });
    }

    /**
     * Methode servant a prolonger un emprunt
     * @param pEmprunt l'emprunt a prolonger
     */
    @Override
    public void prolongerEmprunt(final Emprunt pEmprunt) {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                pEmprunt.setEtat(EmpruntEtat.PROLONGE.toString());
                empruntDao.prolongerEmprunt(pEmprunt);
            }
        });
    }

    /**
     * Methode servant a fermer un emprunt
     * @param pEmprunt l'emprunt a clore
     */
    @Override
    public void fermerEmprunt(final Emprunt pEmprunt) throws NotFoundException {
        Ouvrage ouvrage = ouvrageManager.getOuvrage(pEmprunt.getIdOuvrage());
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                pEmprunt.setEtat(EmpruntEtat.RENDU.toString());
                ouvrage.setNombreDispo(ouvrage.getNombreDispo() + 1);
                empruntDao.ChangerEtatEmprunt(pEmprunt);
                ouvrageManager.ModifierNombreDispo(ouvrage);
            }
        });
    }

    /**
     * Changer l'etat d'un emprunt en retard
     * @param pEmprunt l'emprunt dont l'ouvrage n'a pas été rendu
     */
    @Override
    public void retardEmprunt(final Emprunt pEmprunt) {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                pEmprunt.setEtat(EmpruntEtat.RETARD.toString());
                empruntDao.ChangerEtatEmprunt(pEmprunt);
            }
        });
    }

}
