package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Usuario;

import java.util.List;

public interface UsuarioDAO {

    public List<Usuario> consultarUsuario(String username, String password) throws PersistenceException;
}
