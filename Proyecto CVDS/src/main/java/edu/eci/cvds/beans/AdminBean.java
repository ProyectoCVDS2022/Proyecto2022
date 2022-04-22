package edu.eci.cvds.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.samples.services.LibraryServices;

import java.io.IOException;
import java.sql.Date;

@SuppressWarnings("deprecation")
@ManagedBean(name = "adminBean")
@ApplicationScoped

public class AdminBean extends BasePageBean{

    @Inject
    private LibraryServices services;
    private int id;
    private int tipo;
    private String nombre;
    private int capacidad;
    private Date fechaInicio;
    private Date fechaFin;
    private int ubicacion;
    private String observaciones;
    private int idBuscar;
    private String nuevaDisponibilidad;

    public void agregarRecurso() throws PersistenceException {
        try{
            services.agregarRecurso(new Recurso(id, nombre, capacidad, fechaInicio, fechaFin, "disponible", observaciones, tipo, ubicacion));
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al agregar el recurso", ex);
        }
    }

    public Recurso buscarRecurso() throws PersistenceException {
        try{
            return services.buscarRecurso(idBuscar);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el recurso", ex);
        }
    }

    public void cambiarDisponibilidad(String nuevaDisponibilidad, int idBuscar) throws PersistenceException {
        try{
            services.cambiarDisponibilidad(nuevaDisponibilidad, idBuscar);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al cambiar la disponibilidad del recurso", ex);
        }
    }

    public int getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public LibraryServices getServices() {
        return services;
    }

    public int getIdBuscar() {
        return idBuscar;
    }

    public String getNuevaDisponibilidad() {
        return nuevaDisponibilidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setServices(LibraryServices services) {
        this.services = services;
    }

    public void setIdBuscar(int idBuscar) {
        this.idBuscar = idBuscar;
    }

    public void setNuevaDisponibilidad(String nuevaDisponibilidad) {
        this.nuevaDisponibilidad = nuevaDisponibilidad;
    }
}
