package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.UbicacionDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.samples.services.LibraryServices;

import java.util.List;

public class LibraryServicesImpl implements LibraryServices {

    @Inject
    private UsuarioDAO usuarioDAO;
    @Inject
    private RecursoDAO recursoDAO;
    @Inject
    private UbicacionDAO ubicacionDAO;

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
            throw new PersistenceException("Error al registrar el recursos" , ex);
        }
    }

    @Override
    public Recurso buscarRecurso(String nombreBuscar) throws PersistenceException {
        try{
            return recursoDAO.buscarRecurso(nombreBuscar);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el recurso" , ex);
        }
    }
    public List<Recurso> buscarRecursos(String nombreBuscar) throws PersistenceException {
        try{
            return recursoDAO.buscarRecursos(nombreBuscar);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el recurso" , ex);
        }
    }
    @Override
    public void cambiarDisponibilidad(String disp, int id) throws PersistenceException {
        try{
           recursoDAO.cambiarDisponibilidad(disp, id);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al cambiar la disponibilidad del recurso" , ex);
        }
    }

    @Override
    public Ubicacion nombreUbicacion(int id) throws PersistenceException {
        try{
            return ubicacionDAO.nombreUbicacion(id);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre de la ubicación" , ex);
        }
    }

    @Override
    public List<Recurso> buscarRecursosComunidad(int filtro) throws PersistenceException {
        try{
            return recursoDAO.buscarRecursosComunidad(filtro);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar los recursos" , ex);
        }
    }
}