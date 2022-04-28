package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Ubicacion;

public interface UbicacionDAO {

    public Ubicacion nombreUbicacion(int id) throws PersistenceException;

}
