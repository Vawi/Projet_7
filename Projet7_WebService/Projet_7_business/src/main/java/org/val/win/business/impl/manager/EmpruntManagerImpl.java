package org.val.win.business.impl.manager;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.val.win.business.contract.manager.EmpruntManager;
import org.val.win.consumer.contract.dao.EmpruntDao;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Classe de gestion des transaction pour les emprunts
 */
@Named
public class EmpruntManagerImpl extends AbstractManager implements EmpruntManager {

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
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                pEmprunt.setIdUtilisateur(pUtilisateur.getIdUtilisateur());
                pEmprunt.setIdOuvrage(pOuvrage.getIdOuvrage());
                empruntDao.emprunt(pEmprunt);
            }
        });
    }
}
