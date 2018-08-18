package org.val.win.business.contract.manager;

import org.val.win.model.bean.Ouvrage;
import org.val.win.model.exception.NotFoundException;

import java.util.List;

public interface OuvrageManager {

    /**
     * Lister les ouvrages
     * @return la liste des ouvrages
     */
    List<Ouvrage> getListOuvrage();

    /**
     * Lister les ouvrages disponibles
     * @return la liste des ouvrages disponibles
     */
    List<Ouvrage> getListOuvrageDispo();

    /**
     * récupérer un ouvrage
     * @param id l'id de l'ouvrage
     * @return l'ouvrage en question
     */
    Ouvrage getOuvrage(Integer id) throws NotFoundException;

}
