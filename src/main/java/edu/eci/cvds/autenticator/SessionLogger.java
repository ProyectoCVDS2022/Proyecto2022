package edu.eci.cvds.autenticator;

import edu.eci.cvds.exceptions.PersistenceException;

public interface SessionLogger {
    public void login(String nombre, String clave) throws PersistenceException;

    public boolean isLogged();

    public void logout();
}
