package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Date;

public class Recurso implements Serializable {

    private int id;
    private int tipo;
    private String nombre;
    private int capacidad;
    private Date fechaInicio;
    private Date fechaFin;
    private int ubicacion;
    private String disponibilidad;
    private String observaciones;

    public Recurso(int id, int tipo, String nombre, int capacidad, Date fechaInicio, Date fechaFin, int ubicacion, String disponibilidad, String observaciones) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ubicacion = ubicacion;
        this.disponibilidad = disponibilidad;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Recurso{id= " + id +
                ", tipo= " + tipo +
                ", nombre= " + nombre +
                ", capacidad= " + capacidad +
                ", fechaInicio= " + fechaInicio.toString() +
                ", fechaFin= " + fechaFin.toString() +
                ", ubicacion= " + ubicacion +
                ", disponibilidad= " + disponibilidad +
                ", observaciones= " + observaciones +
                '}';
    }
}
