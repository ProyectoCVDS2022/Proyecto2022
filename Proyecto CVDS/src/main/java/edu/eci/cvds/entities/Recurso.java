package edu.eci.cvds.entities;

import java.util.Date;

public class Recurso {

    private int id;
    private int tipo;
    private Date fechaInicio;
    private Date fechaFin;
    private int ubicacion;
    private String observaciones;

    public Recurso(int id, int tipo, Date fechaInicio, Date fechaFin, int ubicacion, String observaciones) {
        this.id = id;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ubicacion = ubicacion;
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
}
