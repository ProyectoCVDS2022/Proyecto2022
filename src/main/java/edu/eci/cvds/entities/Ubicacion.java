package edu.eci.cvds.entities;

import java.io.Serializable;

public class Ubicacion implements Serializable {

    private int id;
    private String lugar;

    public Ubicacion(int id, String lugar) {
        this.id = id;
        this.lugar = lugar;
    }

    public int getId() {
        return id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
