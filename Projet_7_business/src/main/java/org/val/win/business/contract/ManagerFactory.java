package org.val.win.business.contract;

import org.val.win.business.contract.manager.EmpruntManager;
import org.val.win.business.contract.manager.OuvrageManager;
import org.val.win.business.contract.manager.UtilisateurManager;

/**
 * Interface de ManagerFactoryImpl
 */
public interface ManagerFactory {

    /**
     * manager de l'utilisateur
     * @return manager des l'utilisateur
     */
    UtilisateurManager getUtilisateurManager();

    /**
     * manager de l'objet ouvrage
     * @return manager des ouvrages
     */
    OuvrageManager getOuvrageManager();

    /**
     * manager de l'objet emprunt
     * @return manager des emprunts
     */
    EmpruntManager getEmpruntManager();

}
