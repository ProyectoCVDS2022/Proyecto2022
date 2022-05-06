package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.samples.services.UserServices;

import java.util.List;

public class UserServicesImpl implements UserServices {

    @Inject
    private UsuarioDAO usuarioDAO;
    @Override
    public Usuario consultarUsuario(String username, String password) throws PersistenceException {
        Usuario usuario = null;
        try{
            List<Usuario> lista = usuarioDAO.consultarUsuario(username, password);
            if(!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        }catch (PersistenceException e){
            throw new PersistenceException("Error", e);
        }
        return usuario;
    }
}
