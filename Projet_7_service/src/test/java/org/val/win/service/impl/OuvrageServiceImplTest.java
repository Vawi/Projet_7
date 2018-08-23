package org.val.win.service.impl;

import org.junit.Assert;
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
import org.val.win.model.exception.NotFoundException;
import org.val.win.service.contract.OuvrageService;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bootstrapContext.xml"})
@Transactional
@Rollback(true)
public class OuvrageServiceImplTest {

    @Autowired
    private OuvrageManager ouvrageManager;

    private Ouvrage ouvrage;

    @Test
    public void getListOuvrage() {
        List<Ouvrage> listOuvrage = ouvrageManager.getListOuvrage();
        Assertions.assertEquals(listOuvrage.size(), 30);
    }

    @Test
    public void getListOuvrageDispo() throws NotFoundException {
        try {
            ouvrage = ouvrageManager.getOuvrage(15);
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
        }
        Assertions.assertNotNull(ouvrage);
    }
}