package edu.eci.cvds.samples.services;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.entities.Ubicacion;
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

    public List<Reserva> estaDisponible(int id) throws PersistenceException;

}
