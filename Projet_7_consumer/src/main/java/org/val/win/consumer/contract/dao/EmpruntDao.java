package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.Emprunt;

import java.util.List;

public interface EmpruntDao {

    /**
     * Obtenir la liste des emprunts d'un utilisateur
     * @return la liste d'emprunt
     */
    List<Emprunt> getListEmprunt();

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

}
