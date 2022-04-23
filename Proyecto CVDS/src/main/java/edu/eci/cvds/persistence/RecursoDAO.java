package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;

public interface RecursoDAO {

    public void agregarRecurso(Recurso r) throws PersistenceException;

    public Recurso buscarRecurso(String nombre) throws PersistenceException;

    public void cambiarDisponibilidad(String disp, String nombre) throws PersistenceException;

}
