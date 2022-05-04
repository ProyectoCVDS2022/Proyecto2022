package edu.eci.cvds.autenticator;

import com.google.inject.Inject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

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
    public void login(String nombre,String clave) throws TimeLimitExceptions {
        try{
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(nombre,new Sha256Hash(clave).toHex());
            currentUser.getSession().setAttribute("Correo",nombre);
            currentUser.login( token );
        } catch ( UnknownAccountException a ) {
            throw new TimeLimitExceptions("Usuario o contraseña incorrectos",a);
        } catch ( IncorrectCredentialsException b ) {
            throw new TimeLimitExceptions("Usuario o contraseña incorrectos",b);
        }
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
