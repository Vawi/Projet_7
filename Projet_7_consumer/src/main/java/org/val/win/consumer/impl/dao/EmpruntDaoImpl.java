package org.val.win.consumer.impl.dao;

import org.joda.time.LocalDate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
    public List<Emprunt> getListEmprunt() {
        String vSQL = "SELECT * FROM public.emprunt ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Emprunt> vRowMapper = new RowMapper<Emprunt>() {
            public Emprunt mapRow(final ResultSet pRS, final int pRowNum) throws SQLException {
                Emprunt vEmprunt = new Emprunt(pRS.getInt("id_emprunt"));
                vEmprunt.setDateDebut(LocalDate.fromDateFields(pRS.getDate("date_debut")));
                vEmprunt.setDateFin(LocalDate.fromDateFields(pRS.getDate("date_fin")));
                vEmprunt.setEtat(pRS.getString("etat"));
                vEmprunt.setIdOuvrage(pRS.getInt("id_ouvrage"));
                vEmprunt.setIdUtilisateur(pRS.getInt("id_utilisateur"));
                return vEmprunt;
            }
        };
        List<Emprunt> vListEmprunt = vJdbcTemplate.query(vSQL, vRowMapper);
        return vListEmprunt;
    }

    /**
     * Creer un emprunt dans la db
     * @param pEmprunt l'emprunt a creer
     * @return l'emprunt crée
     */
    @Override
    public Emprunt emprunt(final Emprunt pEmprunt){
        String vSQL = "INSERT INTO public.emprunt " +
                " (id_utilisateur,\n" +
                "id_ouvrage,\n" +
                "date_debut,\n" +
                "date_fin,\n" +
                "etat)\n" +
                "VALUES\n" +
                "(:idUtilisateur, :idOuvrage, :dateDebut, :dateFin, :etat)";

        SqlParameterSource vParams = new MapSqlParameterSource()

                .addValue("idUtilisateur", pEmprunt.getIdUtilisateur())
                .addValue("idOuvrage", pEmprunt.getIdOuvrage())
                .addValue("dateDebut", pEmprunt.getDateDebut().toDate())
                .addValue("dateFin", pEmprunt.getDateFin().toDate())
                .addValue("etat", pEmprunt.getEtat());

        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams, holder, new String[]{"id_emprunt"});
        pEmprunt.setIdEmprunt(holder.getKey().intValue());
        return pEmprunt;
    }

    /**
     * Prolongation d'un emprunt
     * @param pEmprunt l'emprunt a prolonger
     */
    @Override
    public void prolongerEmprunt(final Emprunt pEmprunt){
        String vSQL = "UPDATE public.emprunt " +
                "SET date_fin = date_fin + interval '4 week'," +
                "etat = :etat " +
                "WHERE id_emprunt = :idEmprunt";


        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("dateFin", pEmprunt.getDateFin().toDate());
        vParams.addValue("etat", pEmprunt.getEtat());
        vParams.addValue("idEmprunt", pEmprunt.getIdEmprunt());

        NamedParameterJdbcTemplate vJdbcTemplate =
                new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    /**
     * Methode servant a changer l'etat d'un emprunt
     * Cette methode servira a modifier l'etat en cas de retard ou d'emprunt rendu
     * @param pEmprunt l'emprunt a modifier
     */
    @Override
    public void ChangerEtatEmprunt(final Emprunt pEmprunt){
        String vSQL = "UPDATE public.emprunt " +
                "SET etat = :etat " +
                "WHERE id_emprunt = :idEmprunt";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pEmprunt);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }
}
