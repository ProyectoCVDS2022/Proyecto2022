package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.samples.services.ComunityServices;

import java.util.List;

public class ComunityServicesImpl implements ComunityServices {

    @Inject
    private UsuarioDAO usuarioDAO;
    @Inject
    private RecursoDAO recursoDAO;
    @Inject
    private UbicacionDAO ubicacionDAO;
    @Inject
    private TipoRecursoDAO tipoRecursoDAO;
    @Inject
    private ReservaDAO reservaDAO;

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
    public Ubicacion nombreUbicacion(int id) throws PersistenceException {
        try{
            return ubicacionDAO.nombreUbicacion(id);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre de la ubicación" , ex);
        }
    }

    @Override
    public TipoRecurso nombreTipo(int id) throws PersistenceException {
        try{
            return tipoRecursoDAO.nombreTipo(id);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre del tipo" , ex);
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

    @Override
    public void crearReserva(Reserva reserva) throws PersistenceException {
        try{
            reservaDAO.crearReserva(reserva);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al reservar el recurso" , ex);
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
    public List<Reserva> buscarReservas(String usuario) throws PersistenceException {
        try{
            return reservaDAO.buscarReservasComunidad(usuario);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar las reservas" , ex);
        }
    }

    @Override
    public Recurso nombreRecurso(int id) throws PersistenceException {
        try{
            return recursoDAO.nombreRecurso(id);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre del recurso" , ex);
        }
    }

    @Override
    public int maxIdReserva() throws PersistenceException {
        try{
            return reservaDAO.maxIdReserva();
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el numero de la reserva maxima" , ex);
        }
    }


}
