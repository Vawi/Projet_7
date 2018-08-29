package org.val.win.service.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.val.win.business.contract.manager.EmpruntManager;
import org.val.win.business.impl.manager.EmpruntManagerImpl;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;
import org.val.win.service.contract.EmpruntService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Implementation du webservice de l'emprunt
 */
@WebService(endpointInterface = "org.val.win.service.contract.EmpruntService", serviceName = "Emprunt")
@Named
public class EmpruntServiceImpl implements EmpruntService {

    /**
     * Récupérer manager factory
     */
    @Inject
    private EmpruntManager empruntManager;

    /**
     * Methode servant a obtenir la liste d'emprunt d'un utilisateur
     * @param pUtilisateur l'id de l'utilisateur
     * @return les emprunts d'un utilisateur
     */

    @Override
    @WebMethod
    public Object[] getListEmpruntUtilisateur(final Utilisateur pUtilisateur) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bootstrapContext.xml");
        empruntManager = (EmpruntManagerImpl)context.getBean("empruntManagerImpl");
        Object[] vArrayEmprunt = empruntManager.getListEmpruntUtilisateur(pUtilisateur.getIdUtilisateur()).toArray();
        return vArrayEmprunt;
    }


    /**
     * Creer un emprunt
     * @param pEmprunt le nouvel emprunt
     * @param pUtilisateur l'utilisateur qui emprunte
     * @param pOuvrage l'ouvrage emprunté
     */
    @Override
    @WebMethod
    public void emprunt(final Emprunt pEmprunt, final Utilisateur pUtilisateur, final Ouvrage pOuvrage){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bootstrapContext.xml");
        empruntManager = (EmpruntManagerImpl)context.getBean("empruntManagerImpl");
        empruntManager.emprunt(pEmprunt, pUtilisateur, pOuvrage);
    }

    /**
     * Prolonger un emprunt
     * @param pEmprunt l'emprunt à prolonger
     */
    @Override
    @WebMethod
    public void prolongationEmprunt(final Emprunt pEmprunt) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bootstrapContext.xml");
        empruntManager = (EmpruntManagerImpl)context.getBean("empruntManagerImpl");
        empruntManager.prolongerEmprunt(pEmprunt);
    }

    /**
     * Fermer un emprunt
     * @param pEmprunt l'emprunt a fermer
     */
    @Override
    @WebMethod
    public void fermerEmprunt(final Emprunt pEmprunt) throws NotFoundException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bootstrapContext.xml");
        empruntManager = (EmpruntManagerImpl)context.getBean("empruntManagerImpl");
        empruntManager.fermerEmprunt(pEmprunt);
    }

    /**
     * Changer l'etat d'un emprunt si le rendu a du retard
     * @param pEmprunt l'emprunt a modifier
     */
    @Override
    @WebMethod
    public void retardEmprunt(final Emprunt pEmprunt) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bootstrapContext.xml");
        empruntManager = (EmpruntManagerImpl)context.getBean("empruntManagerImpl");
        empruntManager.retardEmprunt(pEmprunt);
    }

}
