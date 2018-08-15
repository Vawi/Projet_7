package org.val.win.business.contract.manager;

import org.val.win.model.bean.Ouvrage;

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

}
