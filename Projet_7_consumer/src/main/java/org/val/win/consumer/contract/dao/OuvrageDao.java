package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.Ouvrage;

import java.util.List;

public interface OuvrageDao {

    /**
     * Récupérer tous les ouvrages
     * @return une liste d'ouvrage
     */
    List<Ouvrage> getListOuvrage();

    /**
     * Modifier le nombre d'exemplaire disponible d'un ouvrage
     * @param pOuvrage l'ouvrage concerné par le changement de nombre d'exemplaire
     */
    void ModifierNombreDispo(Ouvrage pOuvrage);

}
