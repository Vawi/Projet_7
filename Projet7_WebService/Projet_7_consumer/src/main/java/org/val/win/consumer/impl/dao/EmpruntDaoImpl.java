package org.val.win.consumer.impl.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.val.win.consumer.contract.dao.EmpruntDao;
import org.val.win.model.bean.Emprunt;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class EmpruntDaoImpl extends AbstractDaoImpl implements EmpruntDao {

    /**
     * Récupérer tous les utilisateurs
     * @return liste d'utilisateur
     */
    @Override
    public List<Emprunt> getListEmprunt(Integer id) {
        String vSQL = "SELECT * FROM public.emprunt " +
                      "WHERE id_utilisateur = ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Emprunt> vRowMapper = new RowMapper<Emprunt>() {
            public Emprunt mapRow(final ResultSet pRS, final int pRowNum) throws SQLException {
                Emprunt vEmprunt = new Emprunt(pRS.getInt("id_emprunt"));
                vEmprunt.setDateDebut(pRS.getDate("date_debut"));
                vEmprunt.setDateFin(pRS.getDate("date_fin"));
                vEmprunt.setEtat(pRS.getString("mail"));
                vEmprunt.setIdOuvrage(pRS.getInt("id_emprunt"));
                vEmprunt.setIdUtilisateur(pRS.getInt("id_utilisateur"));
                return vEmprunt;
            }
        };
        List<Emprunt> vListEmprunt = vJdbcTemplate.query(vSQL, vRowMapper, id);
        return vListEmprunt;
    }

    @Override
    public Emprunt insertEmprunt(final Emprunt pEmprunt){
        String vSQL = "INSERT INTO public.emprunt " +
                " (id_emprunt,\n" +
                "id_utilisateur,\n" +
                "id_ouvrage,\n" +
                "date_debut,\n" +
                "date_fin,\n" +
                "etat)\n" +
                "VALUES\n" +
                "(:idEmprunt, :idUtilisateur, :idOuvrage, :dateDebut, :dateFin, :etat)";

        SqlParameterSource vParams = new MapSqlParameterSource()

                .addValue("idEmprunt", pEmprunt.getIdEmprunt())
                .addValue("idUtilisateur", pEmprunt.getIdUtilisateur())
                .addValue("idOuvrage", pEmprunt.getIdOuvrage())
                .addValue("dateDebut", pEmprunt.getDateDebut())
                .addValue("dateFin", pEmprunt.getDateFin())
                .addValue("etat", pEmprunt.getEtat());

        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams, holder, new String[]{"id_emprunt"});
        pEmprunt.setIdEmprunt(holder.getKey().intValue());
        return pEmprunt;
    }

    @Override
    public void prolongerEmprunt(Integer id){

    }
}
