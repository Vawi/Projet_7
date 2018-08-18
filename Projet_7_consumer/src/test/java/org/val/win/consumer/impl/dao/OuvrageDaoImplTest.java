package org.val.win.consumer.impl.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.val.win.consumer.contract.dao.OuvrageDao;
import org.val.win.model.bean.Ouvrage;
import org.junit.runner.RunWith;
import org.springframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.val.win.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:consumerContext.xml"})
@Transactional
@Rollback(true)
class OuvrageDaoImplTest {

    @Inject
    private OuvrageDao ouvrageDao;

    @Test
    public void getListOuvrage() {

    }
}