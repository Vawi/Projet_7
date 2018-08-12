package org.val.win.business.contract.manager;

import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;

public interface EmpruntManager {

    void emprunt(Emprunt pEmprunt, Utilisateur pUtilisateur, Ouvrage pOuvrage);

    void prolongerEmprunt(Emprunt pEmprunt);
}
