package edu.eci.cvds.samples.services;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.exceptions.PersistenceException;

import java.util.List;
import java.util.Map;

public interface AdminServices {

    public abstract void agregarRecurso(Recurso r) throws PersistenceException;

    public abstract Recurso buscarRecurso(String nombreBuscar) throws PersistenceException;

    public abstract List<Recurso> buscarRecursos(String nombreBuscar) throws PersistenceException;

    public abstract void cambiarDisponibilidad(String disp, int id) throws PersistenceException;

    public abstract Ubicacion nombreUbicacion(int id) throws PersistenceException;

    public abstract TipoRecurso nombreTipo(int id) throws PersistenceException;

    public abstract List<Reserva> buscarReservasId(int id) throws PersistenceException;

    public abstract List<Reserva> buscarReservasUsuario(String usuario) throws PersistenceException;

    public Usuario infoUsuario(int idUsuario) throws PersistenceException;

    public Recurso nombreRecurso(int id) throws PersistenceException;

    public List<Reserva> reservasRecurso(int id) throws PersistenceException;

    public List<Ocupacion> recursosMasReservados();

    public List<Ocupacion> recursosMenosReservados();
}
