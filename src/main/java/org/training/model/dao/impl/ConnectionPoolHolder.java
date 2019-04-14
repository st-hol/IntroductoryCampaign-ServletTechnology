package org.training.model.dao.impl;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionPoolHolder {

    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {

                    try {
                        Properties properties = new Properties();

                        properties.load(new FileInputStream(
                                "E:\\Java\\epam courses\\IntroductoryCampaign\\src\\main\\resources\\db.properties"));


//                        String propFileName = "db.properties";
//                        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propFileName);
//                        if (inputStream != null) {
//                            properties.load(inputStream);
//                        } else {
//                            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
//                        }

                        Class.forName(properties.getProperty("db.connection.driver"));

                        BasicDataSource ds = new BasicDataSource();
                        ds.setUrl(properties.getProperty("db.connection.url"));
                        ds.setUsername(properties.getProperty("db.connection.username"));
                        ds.setPassword(properties.getProperty("db.connection.password"));

                        ds.setMinIdle(5);
                        ds.setMaxIdle(10);
                        ds.setMaxOpenPreparedStatements(100);

                        dataSource = ds;

                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return dataSource;
    }

}
