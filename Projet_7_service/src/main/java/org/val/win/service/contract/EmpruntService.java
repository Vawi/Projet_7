package org.val.win.service.contract;

import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;

/**
 * Interface de la classe EmpruntServiceImpl
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface EmpruntService {

    /**
     * Creer un emprunt
     * @param pEmprunt le nouvel emprunt
     * @param pUtilisateur l'utilisateur qui emprunte
     * @param pOuvrage l'ouvrage emprunté
     */
    @WebMethod
    void emprunt(final Emprunt pEmprunt, final Utilisateur pUtilisateur, final Ouvrage pOuvrage);

    /**
     * Prolonger un emprunt
     * @param pEmprunt l'emprunt à prolonger
     */
    @WebMethod
    void prolongationEmprunt(final Emprunt pEmprunt);

    /**
     * Fermer un emprunt
     * @param pEmprunt l'emprunt a fermer
     */
    @WebMethod
    void fermerEmprunt(final Emprunt pEmprunt);

    /**
     * Changer l'etat d'un emprunt si le rendu a du retard
     * @param pEmprunt l'emprunt a modifier
     */
    @WebMethod
    void retardEmprunt(final Emprunt pEmprunt);
}
