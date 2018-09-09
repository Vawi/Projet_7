package org.val.win.business.contract.manager;

import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;

import java.util.List;

public interface UtilisateurManager {

    /**
     * Recuperer une liste d'utilisateur
     * @return une liste d'utilisateur
     */
    List<Utilisateur> getListUtilisateur();

    /**
     * Recuperer un utilisateur
     * @param pPseudonyme le pseudonyme de l'utilisateur
     * @param pPassword le mot de passe de l'utilisateur
     * @return un utilisateur
     * @throws NotFoundException si l'utilisateur n'a pas été trouvé
     */
    Utilisateur getUtilisateur(String pPseudonyme, String pPassword) throws NotFoundException;

    /**
     * Recuperer un utilisateur
     * @param id l'id de l'utilisateur
     * @return un utilisateur
     */
    Utilisateur getUtilisateur(Integer id);

}
