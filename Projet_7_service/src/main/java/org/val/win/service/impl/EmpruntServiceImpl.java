package org.val.win.service.impl;

import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;
import org.val.win.service.contract.EmpruntService;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Implementation du webservice de l'emprunt
 */
@WebService(endpointInterface = "org.val.win.service.contract.EmpruntService")
public class EmpruntServiceImpl implements EmpruntService {

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
    @Override
    public void emprunt(final Emprunt pEmprunt, final Utilisateur pUtilisateur, final Ouvrage pOuvrage){
        managerFactory.getEmpruntManager().emprunt(pEmprunt, pUtilisateur, pOuvrage);
    }

    /**
     * Prolonger un emprunt
     * @param pEmprunt l'emprunt à prolonger
     */
    @Override
    public void prolongationEmprunt(final Emprunt pEmprunt) {
        managerFactory.getEmpruntManager().prolongerEmprunt(pEmprunt);
    }

    /**
     * Fermer un emprunt
     * @param pEmprunt l'emprunt a fermer
     */
    @Override
    public void fermerEmprunt(final Emprunt pEmprunt) throws NotFoundException {
        managerFactory.getEmpruntManager().fermerEmprunt(pEmprunt);
    }

    /**
     * Changer l'etat d'un emprunt si le rendu a du retard
     * @param pEmprunt l'emprunt a modifier
     */
    @Override
    public void retardEmprunt(final Emprunt pEmprunt) {
        managerFactory.getEmpruntManager().retardEmprunt(pEmprunt);
    }

}
