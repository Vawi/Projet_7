package org.val.win.service;

import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.Ouvrage;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "Ouvrage")
public class OuvrageService {

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
    @WebMethod
    public List<Ouvrage> getListOuvrage() {
        List<Ouvrage> vListOuvrage;
        vListOuvrage = managerFactory.getOuvrageManager().getListOuvrage();
        return vListOuvrage;
    }

    /**
     * Methode pour obtneir la liste des ouvrages disponibles
     * @return la liste des ouvrages disponibles
     */
    @WebMethod
    public List<Ouvrage> getListOuvrageDispo() {
        List<Ouvrage> vListOuvrageDispo;
        vListOuvrageDispo = managerFactory.getOuvrageManager().getListOuvrage();
        return vListOuvrageDispo;
    }

}
