package org.val.win.consumer.impl.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.val.win.consumer.contract.dao.UtilisateurDao;
import org.val.win.model.bean.Utilisateur;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

    /**
     * Récupérer tous les utilisateurs
     * @return liste d'utilisateur
     */
    @Override
    public List<Utilisateur> getListUtilisateur() {
        String vSQL = "SELECT * FROM public.utilisateur";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Utilisateur> vRowMapper = new RowMapper<Utilisateur>() {
            public Utilisateur mapRow(final ResultSet pRS, final int pRowNum) throws SQLException {
                Utilisateur vUtilisateur = new Utilisateur(pRS.getInt("id_utilisateur"));
                vUtilisateur.setNom(pRS.getString("nom"));
                vUtilisateur.setPrenom(pRS.getString("prenom"));
                vUtilisateur.setMail(pRS.getString("mail"));
                vUtilisateur.setMotDePasse(pRS.getString("mot_de_passe"));
                vUtilisateur.setPseudonyme(pRS.getString("pseudonyme"));
                return vUtilisateur;
            }
        };
        List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListUtilisateur;
    }

    /**
     * Recuperer un utilisateur en fonction de son id
     * @param id prenom de l'utilisateur
     * @return un utilisateur
     */
    @Override
    public Utilisateur getUtilisateur(final Integer id) {
        String vSQL = "SELECT * FROM public.utilisateur " +
                      "WHERE id_utilisateur = ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        Utilisateur utilisateur = (Utilisateur)vJdbcTemplate.queryForObject(
                vSQL, new Object[] { id }, new UtilisateurRowMapper());

        //Utilisateur utilisateur = vJdbcTemplate.queryForObject(vSQL, Utilisateur.class, id);
        return utilisateur;
    }

}
