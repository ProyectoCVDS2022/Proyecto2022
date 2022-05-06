package edu.eci.cvds.samples.services;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.PersistenceException;

public interface UserServices {

    public abstract Usuario consultarUsuario(String username, String password) throws PersistenceException;

}
