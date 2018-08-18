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

    private LocalDate actualDate = LocalDate.now();

    @Test
    public void emprunt() throws NotFoundException {

        try {
            utilisateur = utilisateurManager.getUtilisateur("pnomtest", "mdptest");
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
        }

        ouvrage = ouvrageManager.getOuvrage(15);

        empruntManager.emprunt(emprunt, utilisateur, ouvrage);

        List<Emprunt> listEmprunt = empruntManager.getListEmprunt(utilisateur.getIdUtilisateur());

        Assertions.assertEquals(listEmprunt.size(), 1);

    }

    @Test
    public void prolongerEmprunt() {
    }

    @Test
    public void fermerEmprunt() {
    }

    @Test
    public void retardEmprunt() {
    }
}