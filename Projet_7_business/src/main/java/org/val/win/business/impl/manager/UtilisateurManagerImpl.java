package org.val.win.business.impl.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.business.contract.manager.UtilisateurManager;
import org.val.win.consumer.contract.dao.UtilisateurDao;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * classe de gestion des transactions pour les utilisateurs
 */
@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    public static final Logger logger = LogManager.getLogger(UtilisateurManagerImpl.class);

    @Inject
    private UtilisateurDao utilisateurDao;

    @Inject
    @Named("txManagerP7")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Liste d'utilisateur
     * @return une liste d'utilisateur
     */
    @Override
    public List<Utilisateur> getListUtilisateur() {
        return utilisateurDao.getListUtilisateur();
    }

    /**
     * recuperer un utilisateur en fonction de ces identifiants
     * @param pPseudonyme pseudonyme de l'utilisateur
     * @param pPassword mot de passe de l'utilisateur
     * @throws NotFoundException en cas d'utilisateur non trouvé
     * @return un utilisateur
     */
    @Override
    public Utilisateur getUtilisateur(String pPseudonyme, String pPassword) throws NotFoundException {
        List<Utilisateur> listUtilisateur = this.getListUtilisateur();
        Utilisateur vUtilisateur
                = listUtilisateur.stream()
                .filter(p -> p.getPseudonyme().equals(pPseudonyme))
                .filter(p -> p.getMotDePasse().equals(pPassword))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Aucun utilisateur correspondant au couple prenom/password fourni."));
        return vUtilisateur;
    }

    @Override
    public Utilisateur getUtilisateur(Integer id) {
        Utilisateur vUtilisateur = utilisateurDao.getUtilisateur(id);
        return vUtilisateur;
    }

}
