package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.Utilisateur;

import java.util.List;

public interface UtilisateurDao {

    Utilisateur getUtilisateur(final Integer id);

    List<Utilisateur> getListUtilisateur();

}
