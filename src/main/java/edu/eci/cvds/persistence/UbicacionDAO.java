package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.exceptions.PersistenceException;

public interface UbicacionDAO {

    public Ubicacion nombreUbicacion(int id) throws PersistenceException;

}
