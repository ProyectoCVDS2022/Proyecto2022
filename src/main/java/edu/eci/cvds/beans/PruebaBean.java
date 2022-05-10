package edu.eci.cvds.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.AdminServices;

import java.time.LocalTime;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "pruebaBean")
@ApplicationScoped

public class PruebaBean extends BasePageBean {

    @Inject
    private AdminServices services;
    private int id;
    private int tipo;
    private String nombre;
    private int capacidad;
    private LocalTime fechaInicio;
    private LocalTime fechaFin;
    private int ubicacion;
    private String observaciones;

    private String nombreBuscar;
    private String nuevaDisponibilidad;
    private String usuarioBuscarReservas;
    private int idBuscarReservas;

    private Recurso recursoEncontrado;
    private List<Recurso> recursosEncontrados;
    private List<Reserva> reservasEncontradas;

    private List<Recurso> recursosSeleccionados;
    private Reserva reservaSeleccionada;

    public List<Recurso> buscarRecursos() throws PersistenceException {
        try{
            recursosEncontrados = services.buscarRecursos(nombreBuscar);
            return recursosEncontrados;
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar los recursos", ex);
        }
    }

    public void cambiarDisponibilidad() throws PersistenceException {
        try{
            System.out.println(recursosSeleccionados.size());
            for(Recurso r: recursosSeleccionados){
                System.out.println(nuevaDisponibilidad);
                System.out.println(r.getId());
                services.cambiarDisponibilidad(nuevaDisponibilidad, r.getId());
            }
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al cambiar la disponibilidad del recurso", ex);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public LocalTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombreBuscar() {
        return nombreBuscar;
    }

    public void setNombreBuscar(String nombreBuscar) {
        this.nombreBuscar = nombreBuscar;
    }

    public String getNuevaDisponibilidad() {
        return nuevaDisponibilidad;
    }

    public void setNuevaDisponibilidad(String nuevaDisponibilidad) {
        this.nuevaDisponibilidad = nuevaDisponibilidad;
    }

    public String getUsuarioBuscarReservas() {
        return usuarioBuscarReservas;
    }

    public void setUsuarioBuscarReservas(String usuarioBuscarReservas) {
        this.usuarioBuscarReservas = usuarioBuscarReservas;
    }

    public int getIdBuscarReservas() {
        return idBuscarReservas;
    }

    public void setIdBuscarReservas(int idBuscarReservas) {
        this.idBuscarReservas = idBuscarReservas;
    }

    public Recurso getRecursoEncontrado() {
        return recursoEncontrado;
    }

    public void setRecursoEncontrado(Recurso recursoEncontrado) {
        this.recursoEncontrado = recursoEncontrado;
    }

    public List<Recurso> getRecursosEncontrados() {
        return recursosEncontrados;
    }

    public void setRecursosEncontrados(List<Recurso> recursosEncontrados) {
        this.recursosEncontrados = recursosEncontrados;
    }

    public List<Reserva> getReservasEncontradas() {
        return reservasEncontradas;
    }

    public void setReservasEncontradas(List<Reserva> reservasEncontradas) {
        this.reservasEncontradas = reservasEncontradas;
    }

    public List<Recurso> getRecursosSeleccionados() {
        return recursosSeleccionados;
    }

    public void setRecursosSeleccionados(List<Recurso> recursosSeleccionados) {
        this.recursosSeleccionados = recursosSeleccionados;
    }

    public Reserva getReservaSeleccionada() {
        return reservaSeleccionada;
    }

    public void setReservaSeleccionada(Reserva reservaSeleccionada) {
        this.reservaSeleccionada = reservaSeleccionada;
    }
}