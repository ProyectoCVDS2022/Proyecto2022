package edu.eci.cvds.samples.services;

import java.util.List;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.persistence.PersistenceException;

public interface LibraryServices {

    public abstract Usuario consultarUsuario(String username, String password) throws PersistenceException;

    public abstract void agregarRecurso(Recurso r) throws PersistenceException;

    public abstract Recurso buscarRecurso(String nombreBuscar) throws PersistenceException;

    public abstract List<Recurso> buscarRecursos(String nombreBuscar) throws PersistenceException;


    public abstract void cambiarDisponibilidad(String disp, int id) throws PersistenceException;

}
