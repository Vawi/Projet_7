package org.val.win.model.bean;

/**
 * enum de l'etat de l'emprunt
 */
public enum EmpruntEtat {
    ENCOURS ("l'emprunt est en cours"),
    PROLONGE ("l'emprunt a été prolongé"),
    RETARD ("l'emprunt n'est pas terminé suite a un retard dans le rendu"),
    RENDU ("l'emprunt est terminé, l'ouvrage à été rendu");

    private String etat = "";

    //Constructeur
    EmpruntEtat(String etat){
        this.etat = etat;
    }

    public String toString(){
        return etat;
    }
}
