package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.exceptions.PersistenceException;

import java.util.List;

public interface ReservaDAO {

    public void crearReserva(Reserva reserva) throws PersistenceException;

    public List<Reserva> buscarReservasId(int id) throws PersistenceException;

    public List<Reserva> buscarReservasUsuario(String usuario) throws PersistenceException;

    public List<Reserva> buscarReservasComunidad(int id, String usuario) throws PersistenceException;

    public int maxIdReserva() throws PersistenceException;

    public List<Reserva> reservasRecurso(int id) throws PersistenceException;

    public void cancelarReserva(int id) throws PersistenceException;

    public List<Reserva> buscarReservasReportes(int filtro) throws PersistenceException;

    public List<Reserva> buscarSubReservas(String id) throws PersistenceException;
}
