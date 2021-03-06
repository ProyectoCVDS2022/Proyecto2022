package edu.eci.cvds.entities;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int id;
    private String rol;
    private String clave;
    private String correo;
    private String programa;

    public Usuario(int id, String rol, String clave, String correo, String programa) {
        this.id = id;
        this.clave = clave;
        this.rol = rol;
        this.correo = correo;
        this.programa = programa;
    }

    public int getId() {
        return id;
    }

    public String getRol() {
        return rol;
    }

    public String getClave() {
        return clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return "Usuario{id= " + id +
                ", rol= " + rol +
                ", correo= " + correo +
                ", clave= " + clave +
                '}';
    }
}
