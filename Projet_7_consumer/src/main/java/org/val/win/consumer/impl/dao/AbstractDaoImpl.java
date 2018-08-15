package org.val.win.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

/**
 * class pour récuprer la DB.
 */
public abstract class AbstractDaoImpl {

    /**
     * Bean datasource.
     */
    @Inject
    @Named("dataSourceP7")
    private DataSource dataSource;

    /**
     * Récupérer la datasource.
     * @return dataSource
     */
    DataSource getDataSource() {
        return dataSource;
    }

}