package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.Emprunt;

import java.util.List;

public interface EmpruntDao {

    /**
     * Obtenir la liste des emprunts d'un utilisateur
     * @param id l'id de l'utilisateur
     * @return la liste d'emprunt
     */
    List<Emprunt> getListEmprunt(Integer id);

    /**
     * Emprunter un ouvrage
     * @param pEmprunt l'emprunt a creer
     * @return l'emprunt
     */
    Emprunt emprunt(final Emprunt pEmprunt);

    /**
     * prolongation d'un emprunt
     * @param pEmprunt l'emprunt a prolonger
     */
    void prolongerEmprunt(final Emprunt pEmprunt);

    /**
     * Changer l'etat d'un emprunt
     * @param pEmprunt l'emprunt dont l'etat va changer
     */
    void ChangerEtatEmprunt(final Emprunt pEmprunt);

    /**
     * Obtenir un emprunt en particulier
     * @param id l'id de l'emprunt
     * @return l'emprunt
     */
    Emprunt getEmprunt(Integer id);

}
