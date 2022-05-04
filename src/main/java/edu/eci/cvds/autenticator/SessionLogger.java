package edu.eci.cvds.autenticator;

public interface SessionLogger {
    public void login(String nombre, String clave);

    public boolean isLogged();

    public void logout();
}
