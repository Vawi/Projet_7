package org.val.win.service.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;
import org.val.win.service.contract.P7Service;
import org.val.win.service.util.ContextLoader;

import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "org.val.win.service.contract.P7Service")
@Named
public class P7ServiceImpl implements P7Service {

    public static final Logger logger = LogManager.getLogger(P7Service.class);

    private Utilisateur utilisateur;

    /**
     * Recuperer la liste des emprunts
     * Seul le batch a acces a cette méthode
     * @return une liste d'emprunt
     */
    @Override
    @WebMethod
    public Emprunt[] getListEmprunt() {
        List<Emprunt> listEmprunt = ContextLoader.INSTANCE.getEmpruntManager().getListEmprunt();
        Emprunt[] vArrayEmprunt = listEmprunt.toArray(new Emprunt[listEmprunt.size()]);
        return vArrayEmprunt;
    }

    /**
     * Methode servant a obtenir la liste d'emprunt d'un utilisateur
     * @param pUtilisateur l'id de l'utilisateur
     * @return les emprunts d'un utilisateur
     */
    @Override
    @WebMethod
    public Emprunt[] getListEmpruntUtilisateur(final Utilisateur pUtilisateur) {
        List<Emprunt> listEmpruntUtil = ContextLoader.INSTANCE.getEmpruntManager()
                .getListEmpruntUtilisateur(pUtilisateur.getIdUtilisateur());
        Emprunt[] vArrayEmprunt = listEmpruntUtil.toArray(new Emprunt[listEmpruntUtil.size()]);
        logger.info(pUtilisateur.getPrenom() + " " + pUtilisateur.getNom() + " a chargé sa liste d'emprunt");
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
    public void emprunt(final Emprunt pEmprunt, final Utilisateur pUtilisateur, final Ouvrage pOuvrage) throws NotFoundException {
        ContextLoader.INSTANCE.getEmpruntManager().emprunt(pEmprunt, pUtilisateur, pOuvrage);

        logger.info(pUtilisateur.getPrenom() + " " + pUtilisateur.getNom() + " à emprunter un nouvel ouvrage : " + pOuvrage.getNomOuvrage());
    }

    /**
     * Prolonger un emprunt
     * @param pEmprunt l'emprunt à prolonger
     */
    @Override
    @WebMethod
    public void prolongationEmprunt(final Utilisateur pUtilisateur, final Emprunt pEmprunt) throws NotFoundException {

        ContextLoader.INSTANCE.getEmpruntManager().prolongerEmprunt(pEmprunt);

        Emprunt emprunt = ContextLoader.INSTANCE.getEmpruntManager().getEmprunt(pEmprunt.getIdEmprunt());
        Ouvrage ouvrage = ContextLoader.INSTANCE.getOuvrageManager().getOuvrage(emprunt.getIdOuvrage());

        logger.info(pUtilisateur.getPrenom() + " " + pUtilisateur.getNom() + "  à prolonger son emprunt de " + ouvrage.getNomOuvrage());

    }

    /**
     * Fermer un emprunt
     * @param pEmprunt l'emprunt a fermer
     */
    @Override
    @WebMethod
    public void fermerEmprunt(final Utilisateur pUtilisateur, final Emprunt pEmprunt) throws NotFoundException {
        ContextLoader.INSTANCE.getEmpruntManager().fermerEmprunt(pEmprunt);

        Emprunt emprunt = ContextLoader.INSTANCE.getEmpruntManager().getEmprunt(pEmprunt.getIdEmprunt());
        Utilisateur utilisateur = ContextLoader.INSTANCE.getUtilisateurManager().getUtilisateur(emprunt.getIdUtilisateur());
        Ouvrage ouvrage = ContextLoader.INSTANCE.getOuvrageManager().getOuvrage(emprunt.getIdOuvrage());

        logger.info("L\'Emprunt de " + utilisateur.getPrenom() +
                " " + utilisateur.getNom() + "  pour " + ouvrage.getNomOuvrage() +
                " Est terminé");
    }

    /**
     * Changer l'etat d'un emprunt si le rendu a du retard
     * @param pEmprunt l'emprunt a modifier
     */
    @Override
    @WebMethod
    public void retardEmprunt(final Emprunt pEmprunt) throws NotFoundException {
        ContextLoader.INSTANCE.getEmpruntManager().retardEmprunt(pEmprunt);

        Emprunt emprunt = ContextLoader.INSTANCE.getEmpruntManager().getEmprunt(pEmprunt.getIdEmprunt());
        Utilisateur utilisateur = ContextLoader.INSTANCE.getUtilisateurManager().getUtilisateur(emprunt.getIdUtilisateur());
        Ouvrage ouvrage = ContextLoader.INSTANCE.getOuvrageManager().getOuvrage(emprunt.getIdOuvrage());

        logger.info("L\'Emprunt de " + utilisateur.getPrenom() +
                " " + utilisateur.getNom() + "  pour " + ouvrage.getNomOuvrage() +
                " est en retard");
    }

    /**
     * Methode pour obtenir la liste des ouvrages
     * @return la liste complète des ouvrages
     */
    @Override
    @WebMethod
    public Ouvrage[] getListOuvrage(final Utilisateur pUtilisateur) {

        if (pUtilisateur == null) {
            logger.info(pUtilisateur.getPrenom() + " a chargé une liste d'ouvrage");
        } else
            logger.info(pUtilisateur.getPrenom() + " " + pUtilisateur.getNom() + " a chargé une liste d'ouvrage");

        List<Ouvrage> listOuvrage = ContextLoader.INSTANCE.getOuvrageManager().getListOuvrage();
        Ouvrage[] vArrayOuvrage = listOuvrage.toArray(new Ouvrage[listOuvrage.size()]);
        return vArrayOuvrage;
    }

    /**
     * Methode pour obtneir la liste des ouvrages disponibles
     * @return la liste des ouvrages disponibles
     */
    @Override
    @WebMethod
    public Ouvrage[] getListDispo(final Utilisateur pUtilisateur) {

        if (pUtilisateur == null) {
            logger.info("Anonymous a chargé une liste d'ouvrage disponible");
        } else
            logger.info(pUtilisateur.getPrenom() + " " + pUtilisateur.getNom() + " a chargé une liste d'ouvrage disponible");

        List<Ouvrage> listOuvrageDispo = ContextLoader.INSTANCE.getOuvrageManager().getListOuvrageDispo();
        Ouvrage[] vArrayOuvrageDispo = listOuvrageDispo.toArray(new Ouvrage[listOuvrageDispo.size()]);
        return vArrayOuvrageDispo;
    }

    /**
     * Recuperer un ouvrage
     * @param id l'id de l'ouvrage
     * @return un ouvrage
     * @throws NotFoundException en cas d'ouvrage non trouvé
     */
    @Override
    @WebMethod
    public Ouvrage getOuvrage(final Integer id) throws NotFoundException {
        Ouvrage ouvrage = ContextLoader.INSTANCE.getOuvrageManager().getOuvrage(id);
        return ouvrage;
    }

    /**
     * Recuperer un utilisateur
     * @param pseudonyme son pseudonyme
     * @param mdp son mot de passe
     * @return un utilisateur
     */
    @Override
    @WebMethod
    public Utilisateur utilisateurLogin(final String pseudonyme, final String mdp) {
        try {
            utilisateur = ContextLoader.INSTANCE.getUtilisateurManager().getUtilisateur(pseudonyme, mdp);
        } catch (NotFoundException pEx) {
            System.out.println("Utilisateur non trouvé");
        }
        logger.info(utilisateur.getPrenom() + " " + utilisateur.getNom() + "est connecté");
        return utilisateur;
    }

    /**
     * Recuperer un utilisateur
     * @param id l'id de l'utilisateur
     * @return un utilisateur
     */
    @Override
    @WebMethod
    public Utilisateur getUtilisateur(Integer id) {
        utilisateur = ContextLoader.INSTANCE.getUtilisateurManager().getUtilisateur(id);
        return utilisateur;
    }

}
