package org.val.win.model.bean;

import org.joda.time.LocalDate;

/**
 * bean de l'objet emprunt
 */
public class Emprunt {


    // ==================== Attributs ====================

    /**
     * id de l'emprunt
     */
    private Integer idEmprunt;

    /**
     * id de l'utilisateur
     */
    private Integer idUtilisateur;

    /**
     * id de l'ouvrage
     */
    private Integer idOuvrage;

    /**
     * date de debut de l'emprunt
     */
    private LocalDate dateDebut;

    /**
     * date de fin de l'emprunt
     */
    private LocalDate dateFin;

    /**
     * etat de l'emprunt
     */
    private String etat;



    // ==================== Constructeurs ====================

    /**
     * constructeur
     */
    public Emprunt(){
    }

    /**
     * constructeur avec id
     * @param pId
     */
    public Emprunt(final Integer pId){
        idEmprunt = pId;
    }



    // ==================== Getters/Setters ====================

    /**
     * setter id de l'emprunt
     * @param idEmprunt id de l'emprunt
     */
    public void setIdEmprunt(final Integer idEmprunt) {
        this.idEmprunt = idEmprunt;
    }

    /**
     * getter id de l'emprunt
     * @return l'id de l'emprunt
     */
    public Integer getIdEmprunt() {
        return idEmprunt;
    }

    /**
     * setter id de l'ouvrage
     * @param idOuvrage l'id de l'ouvrage
     */
    public void setIdOuvrage(final Integer idOuvrage) {
        this.idOuvrage = idOuvrage;
    }

    /**
     * getter de l'id de l'ouvrage
     * @return l'id de l'ouvrage
     */
    public Integer getIdOuvrage() {
        return idOuvrage;
    }

    /**
     * setter de l'id de l'utilisateur
     * @param idUtilisateur l'id de l'utilisateur
     */
    public void setIdUtilisateur(final Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    /**
     * getter de l'id de l'utilisateur
     * @return l'id de l'utilisateur
     */
    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * setter de la date du debut de l'emprunt
     * @param dateDebut date de debut de l'emprunt
     */
    public void setDateDebut(final LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * getter de la date du debut de l'emprunt
     * @return la date de debut de l'emprunt
     */
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    /**
     * setter de la date de fin de l'emprunt
     * @param dateFin la date de fin de l'emprunt
     */
    public void setDateFin(final LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * getter de la date de fin de l'emprunt
     * @return la date de fin de l'emprunt
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * setter de l'etat de l'emprunt
     * @param etat l'etat de l'emprunt
     */
    public void setEtat(final String etat) {
        this.etat = etat;
    }

    /**
     * getter de l'etat de l'emprunt
     * @return l'etat de l'emprunt
     */
    public String getEtat() {
        return etat;
    }

    // ==================== Méthodes ====================

    /**
     * StringBuilder de l'objet emprunt
     * @return toutes les informations de l'emprunt
     */
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("Utilisateur idUtilisateur=").append(idEmprunt)
                .append(vSEP).append("nom=\"").append(idOuvrage).append('"')
                .append(vSEP).append("prenom=\"").append(idUtilisateur).append('"')
                .append(vSEP).append("mail=\"").append(dateDebut).append('"')
                .append(vSEP).append("mail=\"").append(dateFin).append('"')
                .append(vSEP).append("mail=\"").append(etat).append('"')
                .append("}");
        return vStB.toString();
    }


}
