package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.TipoRecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.TipoRecursoMapper;

public class MyBatisTipoRecursoDAO implements TipoRecursoDAO {

    @Inject
    TipoRecursoMapper tipoRecursoMapper;

    @Override
    public TipoRecurso nombreTipo(int id) throws PersistenceException {
        try{
            return tipoRecursoMapper.nombreTipo(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar el nombre de la ubicación",e);
        }
    }
}
