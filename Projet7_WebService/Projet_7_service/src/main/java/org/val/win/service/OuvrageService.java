package org.val.win.service;

import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.Ouvrage;

import javax.inject.Inject;
import javax.jws.WebService;

@WebService(serviceName = "Ouvrage")
public class OuvrageService {

    /**
     * Récupérer manager factory
     */
    @Inject
    private ManagerFactory managerFactory;

    private Ouvrage ouvrage;

}
