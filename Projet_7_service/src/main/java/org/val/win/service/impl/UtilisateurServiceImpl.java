package org.val.win.service.impl;

import org.val.win.business.contract.manager.UtilisateurManager;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;
import org.val.win.service.contract.UtilisateurService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;

/**
 * Implementation du webservice pour les utilisateur
 */
@WebService(endpointInterface = "org.val.win.service.contract.UtilisateurService")
@Named
public class UtilisateurServiceImpl implements UtilisateurService {

    /**
     * Récupérer manager factory
     */
    @Inject
    private UtilisateurManager utilisateurManager;

    private Utilisateur utilisateur;

    /**
     * Recuperer un utilisateur
     * @param pseudonyme son pseudonyme
     * @param mdp son mot de passe
     * @return un utilisateur
     */
    @Override
    public Utilisateur utilisateurLogin(final String pseudonyme, final String mdp) throws NotFoundException {

        utilisateur = utilisateurManager.getUtilisateur(pseudonyme, mdp);

        return utilisateur;
    }
}
