package org.val.win.model.bean;

/**
 * Bean de l'objet ouvrage
 */
public class Ouvrage {


    // ==================== Attributs ====================

    /**
     * id de l'ouvrage
     */
    private Integer idOuvrage;

    /**
     * nombre disponible d'un ouvrage
     */
    private Integer nombreDispo;

    /**
     * nom de l'ouvrage
     */
    private String nomOuvrage;

    /**
     * nom et prenom de(s) l'auteur(s)
     */
    private String auteur;



    // ==================== Constructeurs ====================

    /**
     * constructeur de l'objet ouvrage
     */
    public Ouvrage() {
    }

    /**
     * constructeur
     * @param pId l'id d'un ouvrage
     */
    public Ouvrage(final Integer pId){
        idOuvrage = pId;
    }



    // ==================== Getters/Setters ====================

    /**
     * setter de l'id d'un ouvrage
     * @param pId l'id d'un ouvrage
     */
    public void setIdOuvrage(final Integer pId) {
        idOuvrage = pId;
    }

    /**
     * getter de l'id d'un ouvrage
     * @return l'id d'un ouvrage
     */
    public Integer getIdOuvrage() {
        return idOuvrage;
    }

    /**
     * setter de l'auteur d'un ouvrage
     * @param auteur l'auteur d'un ouvrage
     */
    public void setAuteur(final String auteur) {
        this.auteur = auteur;
    }

    /**
     * getter de l'auteur d'un ouvrage
     * @return l'auteur d'un ouvrage
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * setter du nombre d'exemplaire disponible d'un ouvrage
     * @param nombreDispo le nombre d'exemplaire dispo
     */
    public void setNombreDispo(final Integer nombreDispo) {
        this.nombreDispo = nombreDispo;
    }

    /**
     * getteur du nombre d'exemplaire disponible d'un ouvrage
     * @return le nombre d'exemplaire disponible d'un ouvrage
     */
    public Integer getNombreDispo() {
        return nombreDispo;
    }

    /**
     * setter du nom d'un ouvrage
     * @param nomOuvrage le nom de l'ouvrage
     */
    public void setNomOuvrage(final String nomOuvrage) {
        this.nomOuvrage = nomOuvrage;
    }

    /**
     * getter du nom de l'ouvrage
     * @return le nom d'un ouvrage
     */
    public String getNomOuvrage() {
        return nomOuvrage;
    }



    // ==================== Méthodes ====================

    /**
     * StringBuilder de l'objet ouvrage
     * @return toutes les informations de l'ouvrage
     */
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("Ouvrage id de l'ouvrage=").append(idOuvrage)
                .append(vSEP).append("nom=\"").append(nomOuvrage).append('"')
                .append(vSEP).append("prenom=\"").append(auteur).append('"')
                .append(vSEP).append("mail=\"").append(nombreDispo).append('"')
                .append("}");
        return vStB.toString();
    }



}
