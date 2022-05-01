package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;

public class Reserva implements Serializable{

    private int id;
    private int usuario;
    private int recurso;
    private Date fechaInicio;
    private Date fechaFin;

    public Reserva(int id, int usuario, int recurso, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.usuario = usuario;
        this.recurso = recurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public int getUsuario() {
        return usuario;
    }

    public int getRecurso() {
        return recurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public void setRecurso(int recurso) {
        this.recurso = recurso;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Reserva{id= " + id +
                ", usuario= " + usuario +
                ", recurso= " + recurso +
                ", fechaInicio= " + fechaInicio.toString() +
                ", fechaFin= " + fechaFin.toString() +
                '}';
    }

}
