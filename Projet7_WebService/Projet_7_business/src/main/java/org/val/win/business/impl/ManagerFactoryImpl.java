package org.val.win.business.impl;

import org.val.win.business.contract.ManagerFactory;
import org.val.win.business.contract.manager.EmpruntManager;
import org.val.win.business.contract.manager.OuvrageManager;
import org.val.win.business.contract.manager.UtilisateurManager;
import org.val.win.model.bean.Emprunt;

import javax.inject.Inject;
import javax.inject.Named;

@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private UtilisateurManager utilisateurManager;

    @Inject
    private OuvrageManager ouvrageManager;

    @Inject
    private EmpruntManager empruntManager;

    @Override
    public UtilisateurManager getUtilisateurManager() {
        return this.utilisateurManager;
    }
    public void setUtilisateurManager(UtilisateurManager pUtilisateurManager) {
        utilisateurManager = pUtilisateurManager;
    }

    @Override
    public OuvrageManager getOuvrageManager() {
        return this.ouvrageManager;
    }
    public void setOuvrageManager(OuvrageManager pOuvrageManager) {
        ouvrageManager = pOuvrageManager;
    }

    @Override
    public EmpruntManager getEmpruntManager() {
        return this.empruntManager;
    }
    public void setEmpruntManager(EmpruntManager pEmpruntManager){
        empruntManager = pEmpruntManager;
    }

}
