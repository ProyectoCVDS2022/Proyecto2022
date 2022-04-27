package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

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

    public Recurso(int id, String nombre, int capacidad, Date fechaInicio, Date fechaFin, String disponibilidad, String observaciones, int tipo, int ubicacion) {
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
