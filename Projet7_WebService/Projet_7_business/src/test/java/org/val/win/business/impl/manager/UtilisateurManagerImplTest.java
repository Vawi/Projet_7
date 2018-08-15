package org.val.win.business.impl.manager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.val.win.business.contract.manager.UtilisateurManager;
import org.val.win.model.exception.NotFoundException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/businessContextTest.xml"})
@Transactional
@Rollback(true)
public class UtilisateurManagerImplTest {

    @Autowired
    private UtilisateurManager utilisateurManager;

    @Test
    public void getUtilisateur() throws NotFoundException {
        Assert.assertEquals(true, utilisateurManager.getUtilisateur("pnomtest","mdptest"));
        Assert.assertEquals(false, utilisateurManager.getUtilisateur("pnomtest","wrongpassword"));
    }
}
