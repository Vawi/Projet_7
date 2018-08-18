package org.val.win.business.contract.manager;

import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;

import java.util.List;

public interface UtilisateurManager {

    List<Utilisateur> getListUtilisateur();

    Utilisateur getUtilisateur(String pPseudonyme, String pPassword) throws NotFoundException;

}
