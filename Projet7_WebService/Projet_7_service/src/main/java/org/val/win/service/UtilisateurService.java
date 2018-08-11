package org.val.win.service;

import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Web service pour les utilisateurs
 */
@WebService(serviceName = "Utilisateur")
public class UtilisateurService {

    /**
     * Récupérer manager factory
     */
    @Inject
    private ManagerFactory managerFactory;

    private Utilisateur utilisateur;

    @WebMethod
    public Utilisateur utilisateurLogin(final String pseudonyme, final String mdp) {
        try {
            utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(pseudonyme, mdp);
        } catch (NotFoundException pEx) {
            System.out.println("Utilisateur non trouvé");
        }
        return utilisateur;
    }
}
