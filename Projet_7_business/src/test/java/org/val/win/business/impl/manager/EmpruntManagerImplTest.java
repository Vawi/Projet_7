package org.val.win.business.impl.manager;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.val.win.business.contract.manager.EmpruntManager;

import org.val.win.model.exception.NotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:businessContextTest.xml"})
@Transactional
@Rollback(true)
public class EmpruntManagerImplTest {

    @Test
    public void emprunt() {
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