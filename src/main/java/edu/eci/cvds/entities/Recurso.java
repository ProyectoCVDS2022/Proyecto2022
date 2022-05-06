package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class Recurso implements Serializable {

    private int id;
    private int tipo;
    private String nombre;
    private int capacidad;
    private LocalTime fechaInicio;
    private LocalTime fechaFin;
    private int ubicacion;
    private String disponibilidad;
    private String observaciones;

    public Recurso(int id, String nombre, int capacidad, LocalTime fechaInicio, LocalTime fechaFin, String disponibilidad, String observaciones, int tipo, int ubicacion) {
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
