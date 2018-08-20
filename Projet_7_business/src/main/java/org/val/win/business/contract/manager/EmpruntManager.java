package org.val.win.business.contract.manager;

import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.EmpruntEtat;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;

import java.util.List;

public interface EmpruntManager {

    /**
     * Obtenir la liste des emprunts
     * @return la liste d'emprunt
     */
    List<Emprunt> getListEmprunt();

    /**
     * Recuperer la liste d'emprunt d'un utilisateur
     * @param id l'id de l'utilisateur
     * @return la liste d'emprunt d'un utilisateur
     */
    List<Emprunt> getListEmpruntUtilisateur(Integer id);

    /**
     * Récupérer un emprunt
     * @param id l'id de l'emprunt
     * @return un emprunt
     */
    Emprunt getEmprunt(final Integer id) throws NotFoundException;

    /**
     * Emprunt d'un ouvrage
     * @param pEmprunt L'emprunt
     * @param pUtilisateur l'utilisateur qui emprunte
     * @param pOuvrage l'ouvrage emprunté
     */
    void emprunt(final Emprunt pEmprunt, final Utilisateur pUtilisateur, final Ouvrage pOuvrage);

    /**
     * Prolongation d'un emprunt
     * @param pEmprunt l'emprunt a prolonger
     */
    void prolongerEmprunt(final Emprunt pEmprunt);

    /**
     * Methode servant a clore un emprunt
     * @param pEmprunt l'emprunt a clore
     */
    void fermerEmprunt(final Emprunt pEmprunt) throws NotFoundException;

    /**
     * Methode servant a changer l'etat d'un emprunt
     * si l'ouvrage n'a pas été rendu a la date final prévue
     * @param pEmprunt l'emprunt dont l'ouvrage n'a pas été rendu
     */
    void retardEmprunt(final Emprunt pEmprunt);
}
