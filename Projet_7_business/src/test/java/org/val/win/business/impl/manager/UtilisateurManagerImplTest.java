package org.val.win.business.impl.manager;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.val.win.business.contract.manager.UtilisateurManager;

import org.val.win.model.bean.Utilisateur;
import org.val.win.model.exception.NotFoundException;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:businessContextTest.xml"})
@Transactional
@Rollback(true)
public class UtilisateurManagerImplTest {

    @Autowired
    private UtilisateurManager utilisateurManager;

    @Test
    public void getUtilisateur() throws NotFoundException {
        assertEquals("nomTest", utilisateurManager.getUtilisateur("pnomtest", "mdptest").getNom());
        try {
            utilisateurManager.getUtilisateur("pnomtest", "wrongpassword");
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
        }
    }

    @Test
    public void getListUtilisateur() {
        List<Utilisateur> listUtilisateur = utilisateurManager.getListUtilisateur();
        Assertions.assertEquals(listUtilisateur.size(), 5);
    }
}