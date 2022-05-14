package edu.eci.cvds.autenticator;

import edu.eci.cvds.exceptions.PersistenceException;

import java.io.IOException;

public interface SessionLogger {
    public void login(String nombre, String clave) throws PersistenceException, IOException;

    public boolean isLogged();

    public void logout();
}
