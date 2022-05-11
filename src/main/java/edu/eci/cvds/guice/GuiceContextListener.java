package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.eci.cvds.autenticator.SessionLogger;
import edu.eci.cvds.autenticator.ShiroSession;
import edu.eci.cvds.beans.BasePageBean;
import edu.eci.cvds.beans.LoginBean;
import edu.eci.cvds.samples.services.AdminServices;
import edu.eci.cvds.samples.services.ComunityServices;
import edu.eci.cvds.samples.services.UserServices;
import edu.eci.cvds.samples.services.impl.AdminServicesImpl;
import edu.eci.cvds.samples.services.impl.ComunityServicesImpl;
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
                bind(AdminServices.class).to(AdminServicesImpl.class);
                bind(ComunityServices.class).to(ComunityServicesImpl.class);
                bind(UserServices.class).to(UserServicesImpl.class);
                bind(BasePageBean.class).to(LoginBean.class);
                bind(SessionLogger.class).to(ShiroSession.class);

            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }

}