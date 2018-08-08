package org.val.win.business.impl.manager;

import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.business.contract.manager.OuvrageManager;
import org.val.win.consumer.contract.dao.OuvrageDao;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * classe de gestion des transactions pour les ouvrages
 */
@Named
public class OuvrageManagerImpl extends AbstractManager implements OuvrageManager {

    @Inject
    private OuvrageDao ouvrageDao;

    @Inject
    @Named("txManagerP7")
    private PlatformTransactionManager platformTransactionManager;
}
