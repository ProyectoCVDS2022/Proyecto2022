package edu.eci.cvds.samples.services.impl;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.persistence.mybatisimpl.*;
import edu.eci.cvds.samples.services.LibraryServices;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class LibraryServicesFactory {

    private static LibraryServicesFactory instance = new LibraryServicesFactory();
    private static Injector injector;
    private static Injector testInjector;

    public LibraryServicesFactory(){
        injector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config.xml");
            }
        });

        testInjector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config-h2.xml");
            }
        });
    }

    public LibraryServices getLibraryServices(){
        return injector.getInstance(LibraryServices.class);
    }

    public LibraryServices getLibraryServicesTesting(){
        return testInjector.getInstance(LibraryServices.class);
    }

    public static LibraryServicesFactory getInstance(){
        return instance;
    }

}
