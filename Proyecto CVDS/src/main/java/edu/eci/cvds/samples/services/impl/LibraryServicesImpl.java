package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.samples.services.LibraryServices;

import java.util.List;

public class LibraryServicesImpl implements LibraryServices {

    @Inject
    private UsuarioDAO usuarioDAO;
    private RecursoDAO recursoDAO;

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

    @Override
    public void agregarRecurso(Recurso r) throws PersistenceException {
        try{
            recursoDAO.agregarRecurso(r);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al registrar el recurso" , ex);
        }
    }
}
