package org.val.win.service.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.val.win.business.contract.manager.UtilisateurManager;
import org.val.win.business.impl.manager.UtilisateurManagerImpl;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;
import org.val.win.service.contract.UtilisateurService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Implementation du webservice pour les utilisateur
 */
@WebService(endpointInterface = "org.val.win.service.contract.UtilisateurService", serviceName = "Utilisateur")
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
    @WebMethod
    public Utilisateur utilisateurLogin(final String pseudonyme, final String mdp) {
        try {
            ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("bootstrapContext.xml");
            utilisateurManager = (UtilisateurManagerImpl)context.getBean("utilisateurManagerImpl");
            utilisateur = utilisateurManager.getUtilisateur(pseudonyme, mdp);
        } catch (NotFoundException pEx) {
            System.out.println("Utilisateur non trouvé");
        }
            return utilisateur; }
}
