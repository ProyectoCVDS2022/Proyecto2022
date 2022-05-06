package edu.eci.cvds.exceptions;

public class PersistenceException extends Exception{

    public PersistenceException(String mensaje,Exception e){
        super(mensaje,e);
    }

}
