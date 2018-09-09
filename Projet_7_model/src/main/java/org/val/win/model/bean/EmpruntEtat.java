package org.val.win.model.bean;

/**
 * enum de l'etat de l'emprunt
 */
public enum EmpruntEtat {
    ENCOURS ("En cours"),
    PROLONGE ("Prolongé"),
    RETARD ("Retard"),
    RENDU ("Terminé");

    private String etat = "";

    //Constructeur
    EmpruntEtat(String etat){
        this.etat = etat;
    }

    public String toString(){
        return etat;
    }
}
