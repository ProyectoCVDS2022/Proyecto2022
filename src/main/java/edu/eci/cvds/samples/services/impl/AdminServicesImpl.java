package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.samples.services.AdminServices;

import java.util.List;
import java.util.Map;

public class AdminServicesImpl implements AdminServices {

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
    @Inject
    private OcupacionDAO ocupacionDAO;


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
    public TipoRecurso nombreTipo(int id) throws PersistenceException {
        try{
            return tipoRecursoDAO.nombreTipo(id);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre del tipo" , ex);
        }
    }

    @Override
    public List<Reserva> buscarReservasId(int id) throws PersistenceException {
        try{
            return reservaDAO.buscarReservasId(id);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al consultar las reservas" , ex);
        }
    }

    @Override
    public List<Reserva> buscarReservasUsuario(String usuario) throws PersistenceException {
        try{
            return reservaDAO.buscarReservasUsuario(usuario);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al consultar las reservas" , ex);
        }
    }

    @Override
    public Usuario infoUsuario(int idUsuario) throws PersistenceException {
        try{
            return usuarioDAO.infoUsuario(idUsuario);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre del usuario" , ex);
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
    public List<Reserva> reservasRecurso(int id) throws PersistenceException {
        try{
            return reservaDAO.reservasRecurso(id);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar la disponibilidad del recurso" , ex);
        }
    }

    @Override
    public List<Ocupacion> recursosMasReservados() {
        return ocupacionDAO.recursosMasReservados();
    }

    @Override
    public List<Ocupacion> recursosMenosReservados() {
        return ocupacionDAO.recursosMenosReservados();
    }

    @Override
    public List<Reserva> buscarReservasReportes(int filtro) throws PersistenceException {
        try{
            return reservaDAO.buscarReservasReportes(filtro);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar la disponibilidad del recurso" , ex);
        }
    }

    @Override
    public List<Ocupacion> reservasPorPrograma() {
        return ocupacionDAO.reservasPorPrograma();
    }

    @Override
    public int reservasPorHorario(int i, int f){
        return ocupacionDAO.reservasPorHorario(i, f);
    }
}
