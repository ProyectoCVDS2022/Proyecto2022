package edu.eci.cvds.samples.services;

import java.util.List;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.exceptions.PersistenceException;

public interface LibraryServices {

    public abstract Usuario consultarUsuario(String username, String password) throws PersistenceException;

    public abstract void agregarRecurso(Recurso r) throws PersistenceException;

    public abstract Recurso buscarRecurso(String nombreBuscar) throws PersistenceException;

    public abstract List<Recurso> buscarRecursos(String nombreBuscar) throws PersistenceException;

    public abstract void cambiarDisponibilidad(String disp, int id) throws PersistenceException;

    public abstract Ubicacion nombreUbicacion(int id) throws PersistenceException;

    public abstract List<Recurso> buscarRecursosComunidad(int filtro) throws PersistenceException;

    public abstract TipoRecurso nombreTipo(int id) throws PersistenceException;

    public abstract void crearReserva(Reserva reserva) throws PersistenceException;

    public abstract List<Reserva> buscarReservasId(int id) throws PersistenceException;

    public abstract List<Reserva> buscarReservasUsuario(String usuario) throws PersistenceException;

}
