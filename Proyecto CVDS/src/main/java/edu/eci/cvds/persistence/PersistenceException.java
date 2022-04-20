package edu.eci.cvds.persistence;

public class PersistenceException extends Exception{

    public PersistenceException(String mensaje,Exception e){
        super(mensaje,e);
    }

}
