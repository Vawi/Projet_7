package org.val.win.business.impl.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.business.contract.manager.OuvrageManager;
import org.val.win.consumer.contract.dao.OuvrageDao;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

/**
 * classe de gestion des transactions pour les ouvrages
 */
@Named
public class OuvrageManagerImpl extends AbstractManager implements OuvrageManager {

    private static final Logger logger = LogManager.getLogger(EmpruntManagerImpl.class);

    @Inject
    private OuvrageDao ouvrageDao;

    @Inject
    @Named("txManagerP7")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Liste d'utilisateur
     * @return une liste d'utilisateur
     */
    @Override
    public List<Ouvrage> getListOuvrage() {
        return ouvrageDao.getListOuvrage();
    }

    @Override
    public List<Ouvrage> getListOuvrageDispo() {
        List<Ouvrage> vListOuvrage = this.getListOuvrage();
        vListOuvrage = vListOuvrage.stream()
                .filter(p -> p.getNombreDispo() >= 1)
                .collect(Collectors.toList());
        return vListOuvrage;
    }

    /**
     * Obtenir un ouvrage
     * @param id l'id de l'ouvrage
     * @return un ouvrage
     */
    @Override
    public Ouvrage getOuvrage(Integer id) throws NotFoundException {
        List<Ouvrage> vListOuvrage = this.getListOuvrage();
        Ouvrage vOuvrage =
                vListOuvrage.stream()
                .filter(p -> p.getIdOuvrage().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Ouvrage non trouvé"));
        return vOuvrage;
    }

    /**
     * Modifier le nombre d'exemplaire disponible d'un ouvrage
     * @param pOuvrage l'ouvrage concerné par le changement de nombre d'exemplaire
     */
    @Override
    public void ModifierNombreDispo(Ouvrage pOuvrage) {
        this.ouvrageDao.ModifierNombreDispo(pOuvrage);
    }
}
