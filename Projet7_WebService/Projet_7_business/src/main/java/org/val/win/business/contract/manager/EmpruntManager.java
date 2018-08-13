package org.val.win.business.contract.manager;

import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.EmpruntEtat;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;

public interface EmpruntManager {

    /**
     * Emprunt d'un ouvrage
     * @param pEmprunt L'emprunt
     * @param pUtilisateur l'utilisateur qui emprunte
     * @param pOuvrage l'ouvrage emprunté
     */
    void emprunt(Emprunt pEmprunt, Utilisateur pUtilisateur, Ouvrage pOuvrage);

    /**
     * Prolongation d'un emprunt
     * @param pEmprunt l'emprunt a prolonger
     */
    void prolongerEmprunt(Emprunt pEmprunt);

    /**
     * Methode servant a clore un emprunt
     * @param pEmprunt l'emprunt a clore
     */
    void fermerEmprunt(Emprunt pEmprunt);

    /**
     * Methode servant a changer l'etat d'un emprunt
     * si l'ouvrage n'a pas été rendu a la date final prévue
     * @param pEmprunt l'emprunt dont l'ouvrage n'a pas été rendu
     */
    void retardEmprunt(Emprunt pEmprunt);
}
