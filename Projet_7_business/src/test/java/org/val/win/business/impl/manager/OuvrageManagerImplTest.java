package org.val.win.business.impl.manager;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.val.win.business.contract.manager.OuvrageManager;

import org.val.win.model.bean.Ouvrage;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:businessContextTest.xml"})
@Transactional
@Rollback(true)
public class OuvrageManagerImplTest {

    private static final Logger logger = LogManager.getLogger(OuvrageManagerImplTest.class);

    @Autowired
    private OuvrageManager ouvrageManager;

    @Test
    public void getListOuvrage() {
        List<Ouvrage> listOuvrage = ouvrageManager.getListOuvrage();
        Assertions.assertEquals(listOuvrage.size(), 30);
        logger.info("Voila la liste des ouvrages " + listOuvrage);
    }

    @Test
    public void getListOuvrageDispo() {
    }
}