package org.val.win.service.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.val.win.business.contract.manager.EmpruntManager;
import org.val.win.business.contract.manager.OuvrageManager;
import org.val.win.business.contract.manager.UtilisateurManager;
import org.val.win.business.impl.manager.EmpruntManagerImpl;
import org.val.win.business.impl.manager.OuvrageManagerImpl;
import org.val.win.business.impl.manager.UtilisateurManagerImpl;

import javax.inject.Inject;

/**
 * Created by QHO794 on 04/09/2018.
 */
public enum ContextLoader {

    INSTANCE();

    private EmpruntManager empruntManager;

    private OuvrageManager ouvrageManager;

    private UtilisateurManager utilisateurManager;

    ContextLoader() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bootstrapContext.xml");
        empruntManager = (EmpruntManagerImpl)context.getBean("empruntManagerImpl");
        ouvrageManager = (OuvrageManagerImpl)context.getBean("ouvrageManagerImpl");
        utilisateurManager = (UtilisateurManagerImpl)context.getBean("utilisateurManagerImpl");
    }

    public ContextLoader getInstance() {
        return INSTANCE;
    }

    public EmpruntManager getEmpruntManager() {
        return empruntManager;
    }

    public OuvrageManager getOuvrageManager() {
        return ouvrageManager;
    }

    public UtilisateurManager getUtilisateurManager() {
        return utilisateurManager;
    }

}

