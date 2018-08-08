package org.val.win.business.impl.manager;

import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.business.contract.manager.EmpruntManager;
import org.val.win.consumer.contract.dao.EmpruntDao;

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
}
