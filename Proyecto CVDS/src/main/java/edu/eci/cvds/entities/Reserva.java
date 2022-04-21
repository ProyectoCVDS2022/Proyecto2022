package edu.eci.cvds.entities;

import java.sql.Date;

public class Reserva {

    private int id;
    private String usuario;
    private String recurso;
    private Date fechaIncio;
    private Date fechaFin;

    public Reserva(int id, String usuario, String recurso, Date fechaIncio, Date fechaFin) {
        this.id = id;
        this.usuario = usuario;
        this.recurso = recurso;
        this.fechaIncio = fechaIncio;
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getRecurso() {
        return recurso;
    }

    public Date getFechaIncio() {
        return fechaIncio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public void setFechaIncio(Date fechaIncio) {
        this.fechaIncio = fechaIncio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
