package edu.eci.cvds.autenticator;

import com.google.inject.Inject;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.UserServices;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;

public class ShiroSession implements SessionLogger {
    @Inject
    private UserServices userServices;


    public UserServices getUserServices() {
        return userServices;
    }

    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }
    @Override
    public void login(String nombre,String clave) throws PersistenceException {
        //UsernamePasswordToken token = new UsernamePasswordToken(nombre,clave);
        System.out.println("--------SignIn--------");
        Logger log = LoggerFactory.getLogger(ShiroSession.class);
        Subject currentUser = SecurityUtils.getSubject();
        // Do some stuff with a Session (no need for a web or EJB container!!!)
        Session session = currentUser.getSession();
        session.setAttribute("correo", nombre);
        String value = (String) session.getAttribute("correo");
        if (value.equals(nombre)) {
            log.info("Retrieved the correct value! [" + value + "]");
        }
        // let's login the current user so we can check against roles and permissions:
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(nombre, clave);
            token.setRememberMe(true);
            log.info("Sale del IF authenticated");
            try {
                currentUser.login(token);
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/index.xhtml");
                log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Credenciales Incorrectas"));
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Credenciales Incorrectas"));
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            catch (AuthenticationException | IOException ae) {
                log.info(ae.getMessage());
            }
        }

        //say who they are:
        //print their identifying princip   al (in this case, a username):
        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");
    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    @Override
    public void logout(){
        SecurityUtils.getSubject().logout();
    }


}
