package org.val.win.service.impl;

import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.Ouvrage;
import org.val.win.service.contract.OuvrageService;

import javax.inject.Inject;
import javax.jws.WebMethod;
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
    private ManagerFactory managerFactory;

    /**
     * Objet Ouvrage
     */
    private Ouvrage ouvrage;

    /**
     * Methode pour obtenir la liste des ouvrages
     * @return la liste complète des ouvrages
     */
    @Override
    public List<Ouvrage> getListOuvrage() {
        List<Ouvrage> vListOuvrage;
        vListOuvrage = managerFactory.getOuvrageManager().getListOuvrage();
        return vListOuvrage;
    }

    /**
     * Methode pour obtneir la liste des ouvrages disponibles
     * @return la liste des ouvrages disponibles
     */
    @Override
    public List<Ouvrage> getListOuvrageDispo() {
        List<Ouvrage> vListOuvrageDispo;
        vListOuvrageDispo = managerFactory.getOuvrageManager().getListOuvrage();
        return vListOuvrageDispo;
    }

}
