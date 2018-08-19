package org.val.win.consumer.impl.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.val.win.consumer.contract.dao.OuvrageDao;
import org.val.win.model.bean.Ouvrage;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class OuvrageDaoImpl extends AbstractDaoImpl implements OuvrageDao {

    /**
     * Récupérer tous les ouvrages
     * @return une liste d'ouvrage
     */
    @Override
    public List<Ouvrage> getListOuvrage() {
        String vSQL = "SELECT * FROM public.ouvrage";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Ouvrage> vRowMapper = new RowMapper<Ouvrage>() {
            public Ouvrage mapRow(final ResultSet pRS, final int pRowNum) throws SQLException {
                Ouvrage vOuvrage = new Ouvrage(pRS.getInt("id_ouvrage"));
                vOuvrage.setNombreDispo(pRS.getInt("nombre_disponible"));
                vOuvrage.setAuteur(pRS.getString("auteur"));
                vOuvrage.setNomOuvrage(pRS.getString("titre"));
                return vOuvrage;
            }
        };
        List<Ouvrage> vListOuvrage = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListOuvrage;
    }

    /**
     * Modifier le nombre d'exemplaire disponible d'un ouvrage
     * @param pOuvrage l'ouvrage concerné par le changement de nombre d'exemplaire
     */
    @Override
    public void ModifierNombreDispo(Ouvrage pOuvrage) {
        String vSQL = "UPDATE public.ouvrage " +
                "SET nombre_disponible =:nombreDispo " +
                "WHERE id_ouvrage =:idOuvrage";

        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pOuvrage);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }
}
