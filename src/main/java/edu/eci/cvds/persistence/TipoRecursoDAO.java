package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.exceptions.PersistenceException;

public interface TipoRecursoDAO {

    public TipoRecurso nombreTipo(int id) throws PersistenceException;

}
