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
     * Retour un ouvrage précis
     * @param id l'id de l'ouvrage
     * @return un ouvrage
     */
    Ouvrage getOuvrage(final Integer id);

}
