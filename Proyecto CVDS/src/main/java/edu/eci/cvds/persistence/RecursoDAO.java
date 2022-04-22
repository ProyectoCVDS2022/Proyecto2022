package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;

public interface RecursoDAO {

    public void agregarRecurso(Recurso r) throws PersistenceException;

    public Recurso buscarRecurso(int id) throws PersistenceException;

    public void cambiarDisponibilidad(String disp, int id) throws PersistenceException;

}
