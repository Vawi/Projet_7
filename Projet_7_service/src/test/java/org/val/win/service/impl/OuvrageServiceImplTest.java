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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bootstrapContext.xml"})
@Transactional
@Rollback(true)
public class OuvrageServiceImplTest {

    @Autowired
    private OuvrageService ouvrageService;

    /*@Test
    public void getListOuvrage() {

        Object[] arrayOuvrage = ouvrageService.getListOuvrage();
        Assertions.assertTrue(arrayOuvrage.length == 30);
    } */

    @Test
    public void getListOuvrageDispo() {

        Object[] listOuvrageDispo = ouvrageService.getListDispo();
        Assertions.assertNotNull(listOuvrageDispo);
    }

}