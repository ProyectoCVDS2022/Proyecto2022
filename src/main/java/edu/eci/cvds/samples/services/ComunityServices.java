package edu.eci.cvds.samples.services;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.exceptions.PersistenceException;

import java.util.List;

public interface ComunityServices {

    public abstract List<Recurso> buscarRecursosComunidad(int filtro) throws PersistenceException;

    public abstract Ubicacion nombreUbicacion(int id) throws PersistenceException;

    public abstract TipoRecurso nombreTipo(int id) throws PersistenceException;

    public abstract Recurso buscarRecurso(String nombreBuscar) throws PersistenceException;

    public abstract List<Recurso> buscarRecursos(String nombreBuscar) throws PersistenceException;

    public abstract void crearReserva(Reserva reserva) throws PersistenceException;

    public abstract void cambiarDisponibilidad(String disp, int id) throws PersistenceException;

    public abstract List<Reserva> buscarReservas(int id, String usuario) throws PersistenceException;

    public Recurso nombreRecurso(int id) throws PersistenceException;

    public int maxIdReserva() throws PersistenceException;

    public List<Reserva> reservasRecurso(int id) throws PersistenceException;

    public void cancelarReserva(int id) throws PersistenceException;

    public int idUsuario(String usuario) throws PersistenceException;

    public List<Reserva> buscarSubReservas(String id) throws PersistenceException;
}
