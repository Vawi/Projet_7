package org.val.win.business.impl.manager;

import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.business.contract.manager.UtilisateurManager;
import org.val.win.consumer.contract.dao.UtilisateurDao;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * classe de gestion des transactions pour les utilisateurs
 */
@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    @Inject
    private UtilisateurDao utilisateurDao;

    @Inject
    @Named("txManagerP7")
    private PlatformTransactionManager platformTransactionManager;
}
