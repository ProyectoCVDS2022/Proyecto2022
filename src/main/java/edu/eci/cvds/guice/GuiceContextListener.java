package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.eci.cvds.samples.services.LibraryServices;
import edu.eci.cvds.samples.services.UserServices;
import edu.eci.cvds.samples.services.impl.LibraryServicesImpl;
import edu.eci.cvds.samples.services.impl.UserServicesImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.persistence.mybatisimpl.*;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {

                install(JdbcHelper.MySQL);

                setEnvironmentId("development");

                setClassPathResource("mybatis-config.xml");
                bind(UserServices.class).to(UserServicesImpl.class);
                bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
                bind(ReservaDAO.class).to(MyBatisReservaDAO.class);
                bind(TipoRecursoDAO.class).to(MyBatisTipoRecursoDAO.class);
                bind(UbicacionDAO.class).to(MyBatisUbicacionDAO.class);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(LibraryServices.class).to(LibraryServicesImpl.class);
                //bind(BasePageBean.class).to(LoginBean.class);
                //bind(Logger.class).to(ShiroLogger.class);

            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }

}