package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

public class Reserva implements Serializable{

    private int id;
    private int usuario;
    private int recurso;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public Reserva(int id, int usuario, int recurso, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
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

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
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

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
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
