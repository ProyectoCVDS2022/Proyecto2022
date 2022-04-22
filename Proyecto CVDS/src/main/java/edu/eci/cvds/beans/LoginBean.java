package edu.eci.cvds.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.samples.services.LibraryServices;

import java.io.IOException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "loginBean")
@ApplicationScoped

public class LoginBean extends BasePageBean{

    @Inject
    private LibraryServices services;
    private String username;
    private String password;
    private String rol;

    public String login() throws PersistenceException {
        String redireccion = null;
        Usuario usuario = services.consultarUsuario(username, password);
        if(usuario != null){
            if(usuario.getRol().equals("administrador")){
                setRol(usuario.getRol());
                redireccion = "administrador.xhtml?faces-redirect=true";
            }else{
                redireccion = "comunidad.xhtml?faces-redirect=true";
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
        }
        return redireccion;
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
