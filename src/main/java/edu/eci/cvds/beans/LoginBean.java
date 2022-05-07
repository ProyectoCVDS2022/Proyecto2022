package edu.eci.cvds.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import edu.eci.cvds.autenticator.SessionLogger;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.impl.LibraryServicesFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresGuest;

import java.io.IOException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "loginBean")
@ApplicationScoped

public class LoginBean extends BasePageBean{

    private String username;
    private String password;
    private String rol;
    private boolean logg;
    private SessionLogger logger = LibraryServicesFactory.getInstance().getLoginServices();


    public void setLogg(boolean logg) {
        this.logg = logg;
    }

    @RequiresGuest
    public void login() throws  PersistenceException{
        System.out.println("1");
        try {
            System.out.println("U :" + username);
            System.out.println("P :" + password);
            logger.login(username, password);
            setLogg(true);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index2.xhtml");

        } catch (PersistenceException | IOException e){
            FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no registrado", "Este usuario no se encuentra en nuestra base de datos"));
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }
}
