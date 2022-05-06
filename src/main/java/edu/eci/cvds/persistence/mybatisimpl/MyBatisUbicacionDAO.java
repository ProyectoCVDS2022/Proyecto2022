package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.persistence.UbicacionDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UbicacionMapper;

public class MyBatisUbicacionDAO implements UbicacionDAO {

    @Inject
    private UbicacionMapper ubicacionMapper;

    @Override
    public Ubicacion nombreUbicacion(int id) throws PersistenceException {
        try{
            return ubicacionMapper.nombreUbicacion(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar el nombre de la ubicación",e);
        }
    }
}
