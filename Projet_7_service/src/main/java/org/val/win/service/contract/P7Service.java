package org.val.win.service.contract;

import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface P7Service {

    /**
     * Recuperer la liste des ouvrages
     * @return la liste des ouvrages
     */
    @WebMethod
    Ouvrage[] getListOuvrage();

    /**
     * Recuperer la liste des ouvrages disponible
     * @return la liste des ouvrages disponible
     */
    @WebMethod
    Ouvrage[] getListDispo();

    /**
     * Recuperer un utilisateur via ses identifiants
     * @param pseudonyme pseudo de l'utilisateur
     * @param mdp mot de passe de l'utilisateur
     * @return un utilisateur
     */
    @WebMethod
    Utilisateur utilisateurLogin(final String pseudonyme, final String mdp);

    /**
     * Recuperer la liste des emprunts
     * @return la liste des emprunts
     */
    @WebMethod
    Emprunt[] getListEmprunt();

    /**
     * Methode servant a obtenir les emprunts d'un utilisateur
     * @param pUtilisateur l'id de l'utilisateur
     * @return une liste d'emprunt
     */
    @WebMethod
    Emprunt[] getListEmpruntUtilisateur(final Utilisateur pUtilisateur);

    /**
     * Creer un emprunt
     * @param pEmprunt le nouvel emprunt
     * @param pUtilisateur l'utilisateur qui emprunte
     * @param pOuvrage l'ouvrage emprunté
     */
    @WebMethod
    void emprunt(final Emprunt pEmprunt, final Utilisateur pUtilisateur, final Ouvrage pOuvrage) throws NotFoundException;

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
    void fermerEmprunt(final Emprunt pEmprunt) throws NotFoundException;

    /**
     * Changer l'etat d'un emprunt si le rendu a du retard
     * @param pEmprunt l'emprunt a modifier
     */
    @WebMethod
    void retardEmprunt(final Emprunt pEmprunt);


}
