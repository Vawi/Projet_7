package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.Utilisateur;

import java.util.List;

public interface UtilisateurDao {

    /**
     * Recuperer un utilisateur via son id
     * @param id l'id de l'utilisateur a récupérer
     * @return un utilisateur
     */
    Utilisateur getUtilisateur(final Integer id);

    /**
     * Recuperer une liste d'utilisateur
     * @return la liste des utilisateurs
     */
    List<Utilisateur> getListUtilisateur();

}
