package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Reserva;

import java.util.List;

public interface ReservaDAO {

    public void crearReserva(Reserva reserva) throws PersistenceException;

    public List<Reserva> buscarReservasId(int id) throws PersistenceException;

    public List<Reserva> buscarReservasUsuario(String usuario) throws PersistenceException;

}
