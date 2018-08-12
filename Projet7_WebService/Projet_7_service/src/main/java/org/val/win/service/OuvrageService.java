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
     * Liste d'ouvrage
     */
    private List<Ouvrage> listOuvrage;

    @WebMethod
    public List<Ouvrage> getListOuvrage() {
        listOuvrage = managerFactory.getOuvrageManager().getListOuvrage();
        return listOuvrage;
    }

}
