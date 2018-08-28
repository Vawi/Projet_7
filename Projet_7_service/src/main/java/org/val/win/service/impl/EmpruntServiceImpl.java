package org.val.win.service.impl;

import org.val.win.business.contract.manager.EmpruntManager;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;
import org.val.win.service.contract.EmpruntService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;
import java.util.List;

/**
 * Implementation du webservice de l'emprunt
 */
@WebService(endpointInterface = "org.val.win.service.contract.EmpruntService")
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
    public Object[] getListEmpruntUtilisateur(final Utilisateur pUtilisateur) {
        List<Emprunt> vListEmprunt = empruntManager.getListEmpruntUtilisateur(pUtilisateur.getIdUtilisateur());
        Object[] vArrayEmprunt = vListEmprunt.toArray();
        return vArrayEmprunt;
    }


    /**
     * Creer un emprunt
     * @param pEmprunt le nouvel emprunt
     * @param pUtilisateur l'utilisateur qui emprunte
     * @param pOuvrage l'ouvrage emprunté
     */
    @Override
    public void emprunt(final Emprunt pEmprunt, final Utilisateur pUtilisateur, final Ouvrage pOuvrage){
        empruntManager.emprunt(pEmprunt, pUtilisateur, pOuvrage);
    }

    /**
     * Prolonger un emprunt
     * @param pEmprunt l'emprunt à prolonger
     */
    @Override
    public void prolongationEmprunt(final Emprunt pEmprunt) {
        empruntManager.prolongerEmprunt(pEmprunt);
    }

    /**
     * Fermer un emprunt
     * @param pEmprunt l'emprunt a fermer
     */
    @Override
    public void fermerEmprunt(final Emprunt pEmprunt) throws NotFoundException {
        empruntManager.fermerEmprunt(pEmprunt);
    }

    /**
     * Changer l'etat d'un emprunt si le rendu a du retard
     * @param pEmprunt l'emprunt a modifier
     */
    @Override
    public void retardEmprunt(final Emprunt pEmprunt) {
        empruntManager.retardEmprunt(pEmprunt);
    }

}
