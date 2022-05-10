package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.exceptions.PersistenceException;

import java.util.List;

public interface RecursoDAO {

    public void agregarRecurso(Recurso r) throws PersistenceException;

    public Recurso buscarRecurso(String nombreBuscar) throws PersistenceException;

    public List<Recurso> buscarRecursos(String nombreBuscar) throws PersistenceException;

    public void cambiarDisponibilidad(String disp, int id) throws PersistenceException;

    public List<Recurso> buscarRecursosComunidad(int filtro) throws PersistenceException;

    public Recurso nombreRecurso(int id) throws PersistenceException;


}
