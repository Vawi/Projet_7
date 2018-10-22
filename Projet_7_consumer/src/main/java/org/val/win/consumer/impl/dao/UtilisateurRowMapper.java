package org.val.win.consumer.impl.dao;

import org.springframework.jdbc.core.RowMapper;
import org.val.win.model.bean.Utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdUtilisateur(rs.getInt("id_utilisateur"));
        utilisateur.setNom(rs.getString("nom"));
        utilisateur.setPrenom(rs.getString("prenom"));
        utilisateur.setMail(rs.getString("mail"));
        utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
        utilisateur.setPseudonyme(rs.getString("pseudonyme"));
        return utilisateur;
    }

}
