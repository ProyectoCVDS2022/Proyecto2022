package edu.eci.cvds.samples.services;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.persistence.PersistenceException;

public interface LibraryServices {

    public abstract Usuario consultarUsuario(String username, String password) throws PersistenceException;

    public abstract void agregarRecurso(Recurso r) throws PersistenceException;

}
