package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;

import java.util.List;

public interface RecursoDAO {

    public void agregarRecurso(Recurso r) throws PersistenceException;

    public Recurso buscarRecurso(String nombreBuscar) throws PersistenceException;

    public List<Recurso> buscarRecursos(String nombreBuscar) throws PersistenceException;

    public void cambiarDisponibilidad(String disp, int id) throws PersistenceException;

    public List<Recurso> buscarRecursosComunidad(int filtro) throws PersistenceException;

}