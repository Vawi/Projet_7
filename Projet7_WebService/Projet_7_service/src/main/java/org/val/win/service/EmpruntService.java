package org.val.win.service;

import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "emprunt")
public class EmpruntService {

    /**
     * Récupérer manager factory
     */
    @Inject
    private ManagerFactory managerFactory;

    private Emprunt emprunt;

    /**
     * Creer un emprunt
     * @param pEmprunt le nouvel emprunt
     * @param pUtilisateur l'utilisateur qui emprunte
     * @param pOuvrage l'ouvrage emprunté
     */
    @WebMethod
    public void emprunt(final Emprunt pEmprunt, final Utilisateur pUtilisateur, final Ouvrage pOuvrage){
        managerFactory.getEmpruntManager().emprunt(pEmprunt, pUtilisateur, pOuvrage);
    }

    /**
     * Prolonger un emprunt
     * @param pEmprunt l'emprunt à prolonger
     * @return un emprunt prolongé
     */
    @WebMethod
    public void prolongation(final Emprunt pEmprunt) {
        managerFactory.getEmpruntManager().prolongerEmprunt(pEmprunt);
    }

}
