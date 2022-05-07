package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reserva implements Serializable{

    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";
    private int id;
    private int usuario;
    private int recurso;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private LocalDateTime fechaSolicitud;

    public Reserva(int id, int usuario, int recurso, LocalDateTime fechaSolicitud, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.id = id;
        this.usuario = usuario;
        this.recurso = recurso;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getFechaInicioF(){
        return fechaInicio.format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
    }

    public String getFechaFinF(){
        return fechaFin.format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
    }

    public String getFechaSolicitudF(){
        return fechaSolicitud.format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
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

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
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
