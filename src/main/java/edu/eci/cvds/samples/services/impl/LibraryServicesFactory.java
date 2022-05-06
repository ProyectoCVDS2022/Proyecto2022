package edu.eci.cvds.samples.services.impl;

import com.google.inject.Injector;
import edu.eci.cvds.autenticator.SessionLogger;
import edu.eci.cvds.autenticator.ShiroSession;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.persistence.mybatisimpl.*;
import edu.eci.cvds.samples.services.AdminServices;
import edu.eci.cvds.samples.services.ComunityServices;
import edu.eci.cvds.samples.services.UserServices;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class LibraryServicesFactory {

    private static LibraryServicesFactory instance = new LibraryServicesFactory();
    private static Optional<Injector> optInjector = Optional.empty();

    private Injector myBatisInjector(final String env, final String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(UserServices.class).to(UserServicesImpl.class);
                bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
                bind(ReservaDAO.class).to(MyBatisReservaDAO.class);
                bind(TipoRecursoDAO.class).to(MyBatisTipoRecursoDAO.class);
                bind(UbicacionDAO.class).to(MyBatisUbicacionDAO.class);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(AdminServices.class).to(AdminServicesImpl.class);
                bind(ComunityServices.class).to(ComunityServicesImpl.class);
                bind(UserServices.class).to(UserServicesImpl.class);
                bind(SessionLogger.class).to(ShiroSession.class);
            }
        });
    }

    public SessionLogger getLoginServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(SessionLogger.class);
    }
    public static LibraryServicesFactory getInstance(){
        return instance;
    }

}
