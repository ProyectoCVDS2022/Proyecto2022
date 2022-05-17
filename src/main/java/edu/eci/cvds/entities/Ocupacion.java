package edu.eci.cvds.entities;

import java.io.Serializable;

public class Ocupacion implements Serializable {

    private int valor;
    private String filtro;

    public Ocupacion(int valor, String filtro){
        this.valor = valor;
        this.filtro = filtro;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
}
