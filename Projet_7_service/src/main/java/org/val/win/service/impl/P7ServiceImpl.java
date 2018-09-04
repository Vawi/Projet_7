package org.val.win.service.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.val.win.business.contract.manager.EmpruntManager;
import org.val.win.business.contract.manager.OuvrageManager;
import org.val.win.business.contract.manager.UtilisateurManager;
import org.val.win.business.impl.manager.EmpruntManagerImpl;
import org.val.win.business.impl.manager.OuvrageManagerImpl;
import org.val.win.business.impl.manager.UtilisateurManagerImpl;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;
import org.val.win.service.contract.P7Service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "org.val.win.service.contract.P7Service")
@Named
public class P7ServiceImpl implements P7Service {

    /**
     * Récupérer manager factory
     */
    @Inject
    private EmpruntManager empruntManager;

    @Inject
    private OuvrageManager ouvrageManager;

    @Inject
    private UtilisateurManager utilisateurManager;
    private Utilisateur utilisateur;

    /**
     * Recuperer la liste des emprunts
     * @return une liste d'emprunt
     */
    @Override
    @WebMethod
    public Object[] getListEmprunt() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bootstrapContext.xml");
        empruntManager = (EmpruntManagerImpl)context.getBean("empruntManagerImpl");
        Object[] vArrayEmprunt = empruntManager.getListEmprunt().toArray();
        return vArrayEmprunt;
    }

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
    public void emprunt(final Emprunt pEmprunt, final Utilisateur pUtilisateur, final Ouvrage pOuvrage) throws NotFoundException {
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

    /**
     * Methode pour obtenir la liste des ouvrages
     * @return la liste complète des ouvrages
     */
    @Override
    @WebMethod
    public Ouvrage[] getListOuvrage() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bootstrapContext.xml");
        ouvrageManager = (OuvrageManagerImpl)context.getBean("ouvrageManagerImpl");
        List<Ouvrage> listOuvrage = ouvrageManager.getListOuvrage();
        Ouvrage[] vArrayOuvrage = listOuvrage.toArray(new Ouvrage[listOuvrage.size()]);
        return vArrayOuvrage;
    }

    /**
     * Methode pour obtneir la liste des ouvrages disponibles
     * @return la liste des ouvrages disponibles
     */
    @Override
    @WebMethod
    public Object[] getListDispo() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bootstrapContext.xml");
        ouvrageManager = (OuvrageManagerImpl)context.getBean("ouvrageManagerImpl");
        List<Ouvrage> listOuvrageDispo = ouvrageManager.getListOuvrageDispo();
        Object[] vArrayOuvrageDispo = listOuvrageDispo.toArray(new Ouvrage[listOuvrageDispo.size()]);
        return vArrayOuvrageDispo;
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
            ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("bootstrapContext.xml");
            utilisateurManager = (UtilisateurManagerImpl)context.getBean("utilisateurManagerImpl");
            utilisateur = utilisateurManager.getUtilisateur(pseudonyme, mdp);
        } catch (NotFoundException pEx) {
            System.out.println("Utilisateur non trouvé");
        }
        return utilisateur;
    }


}
