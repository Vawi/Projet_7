package org.val.win.service.impl;

import org.val.win.business.contract.ManagerFactory;
import org.val.win.business.contract.manager.OuvrageManager;
import org.val.win.model.bean.Ouvrage;
import org.val.win.service.contract.OuvrageService;

import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

/**
 * implementation du webservice des ouvrages
 */
@WebService(endpointInterface = "org.val.win.service.contract.OuvrageService")
public class OuvrageServiceImpl implements OuvrageService {

    /**
     * Récupérer manager factory
     */
    @Inject
    private OuvrageManager ouvrageManager;

    /**
     * Objet Ouvrage
     */
    private Ouvrage ouvrage;

    /**
     * Methode pour obtenir la liste des ouvrages
     * @return la liste complète des ouvrages
     */
    @Override
    public Object[] getListOuvrage() {
        List<Ouvrage> vListOuvrage = ouvrageManager.getListOuvrage();
        Object[] vArrayOuvrage = vListOuvrage.toArray();
        return vArrayOuvrage;
    }

    /**
     * Methode pour obtneir la liste des ouvrages disponibles
     * @return la liste des ouvrages disponibles
     */
    @Override
    public Object[] getListOuvrageDispo() {
        List<Ouvrage> vListOuvrageDispo = ouvrageManager.getListOuvrageDispo();
        Object[] vArrayOuvrage = vListOuvrageDispo.toArray();
        return vArrayOuvrage;
    }

}
