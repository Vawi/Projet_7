package org.val.win.service.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.val.win.business.contract.manager.OuvrageManager;
import org.val.win.business.impl.manager.OuvrageManagerImpl;
import org.val.win.service.contract.OuvrageService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * implementation du webservice des ouvrages
 */
@WebService(endpointInterface = "org.val.win.service.contract.OuvrageService")
@Named
public class OuvrageServiceImpl implements OuvrageService {

    /**
     * Récupérer manager factory
     */
    @Inject
    private OuvrageManager ouvrageManager;

    /**
     * Methode pour obtenir la liste des ouvrages
     * @return la liste complète des ouvrages
     */
    @Override
    @WebMethod
    public Object[] getListOuvrage() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bootstrapContext.xml");
        ouvrageManager = (OuvrageManagerImpl)context.getBean("ouvrageManagerImpl");
        Object[] vArrayOuvrage = ouvrageManager.getListOuvrage().toArray();
        return vArrayOuvrage;
    }

    /**
     * Methode pour obtneir la liste des ouvrages disponibles
     * @return la liste des ouvrages disponibles
     */
    @Override
    @WebMethod
    public Object[] getListOuvrageDispo() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bootstrapContext.xml");
        ouvrageManager = (OuvrageManagerImpl)context.getBean("ouvrageManagerImpl");
        Object[] vArrayOuvrage = ouvrageManager.getListOuvrageDispo().toArray();
        return vArrayOuvrage;
    }

}
