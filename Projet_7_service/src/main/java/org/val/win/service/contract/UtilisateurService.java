package org.val.win.service.contract;

import org.val.win.model.bean.Utilisateur;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Interface de la classe UtilisateurServiceImpl
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UtilisateurService {

    /**
     * Obtenir un utilisateur
     * @param pseudonyme le pseudo de l'utilisateur
     * @param mdp le mot de passe de l'utilisateur
     * @return un utilisateur
     */
    @WebMethod
    Utilisateur utilisateurLogin(final String pseudonyme, final String mdp);
}
