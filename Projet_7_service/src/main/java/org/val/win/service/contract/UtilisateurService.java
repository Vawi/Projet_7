package org.val.win.service.contract;

import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * Interface de la classe UtilisateurServiceImpl
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface UtilisateurService {

    /**
     * Obtenir un utilisateur
     * @param pseudonyme le pseudo de l'utilisateur
     * @param mdp le mot de passe de l'utilisateur
     * @return un utilisateur
     */
    @WebMethod
    Utilisateur utilisateurLogin(final String pseudonyme, final String mdp) throws NotFoundException;
}
