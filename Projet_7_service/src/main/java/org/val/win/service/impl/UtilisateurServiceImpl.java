package org.val.win.service.impl;

import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;
import org.val.win.service.contract.UtilisateurService;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Implementation du webservice pour les utilisateur
 */
@WebService(endpointInterface = "org.val.win.service.contract.UtilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {

    /**
     * Récupérer manager factory
     */
    @Inject
    private ManagerFactory managerFactory;

    private Utilisateur utilisateur;

    /**
     * Recuperer un utilisateur
     * @param pseudonyme son pseudonyme
     * @param mdp son mot de passe
     * @return un utilisateur
     */
    @Override
    public Utilisateur utilisateurLogin(final String pseudonyme, final String mdp) {
        try {
            utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(pseudonyme, mdp);
        } catch (NotFoundException pEx) {
            System.out.println("Utilisateur non trouvé");
        }
        return utilisateur;
    }
}
