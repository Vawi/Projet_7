package org.val.win.service.impl;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.val.win.service.contract.OuvrageService;
import org.val.win.service.contract.UtilisateurService;

public class UtilisateurServiceImplTest {

    @Autowired
    private UtilisateurService utilisateurService;

    @Test
    public void utilisateurLogin() {
    }
}