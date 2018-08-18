package org.val.win.business.impl.manager;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.val.win.business.contract.manager.EmpruntManager;

import org.val.win.business.contract.manager.OuvrageManager;
import org.val.win.business.contract.manager.UtilisateurManager;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.EmpruntEtat;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:businessContextTest.xml"})
@Transactional
@Rollback(true)
public class EmpruntManagerImplTest {

    @Autowired
    private EmpruntManager empruntManager;
    @Autowired
    private UtilisateurManager utilisateurManager;
    @Autowired
    private OuvrageManager ouvrageManager;

    private Emprunt emprunt;
    private Utilisateur utilisateur;
    private Ouvrage ouvrage;


    @Test
    public void emprunt() throws NotFoundException {
        utilisateur = utilisateurManager.getUtilisateur("pnomtest", "mdptest");
        ouvrage = ouvrageManager.getOuvrage(15);
        empruntManager.emprunt(emprunt, utilisateur, ouvrage);
        Assertions.assertNotNull(empruntManager.getListEmprunt(utilisateur.getIdUtilisateur()));
    }

    @Test
    public void prolongerEmprunt() {
        emprunt = empruntManager.getEmprunt(2);
        empruntManager.prolongerEmprunt(emprunt);
        Assertions.assertTrue(emprunt.getEtat() == "l'emprunt a été prolongé");
    }

    @Test
    public void fermerEmprunt() throws NotFoundException {
        emprunt = empruntManager.getEmprunt(1);
        empruntManager.fermerEmprunt(emprunt);
        Assert.assertTrue(emprunt.getEtat() == "l'emprunt est terminé, l'ouvrage à été rendu");
    }

    @Test
    public void retardEmprunt() {
    }
}