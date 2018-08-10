package org.val.win.service;

import org.val.win.business.contract.ManagerFactory;

import javax.inject.Inject;
import javax.jws.WebService;

@WebService(serviceName = "Emprunt")
public class EmpruntService {

    /**
     * Récupérer manager factory
     */
    @Inject
    private ManagerFactory managerFactory;

}
