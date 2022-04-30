package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.TipoRecurso;

public interface TipoRecursoDAO {

    public TipoRecurso nombreTipo(int id) throws PersistenceException;

}
