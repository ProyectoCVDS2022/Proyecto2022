package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;

public class MyBatisRecursoDAO implements RecursoDAO {

    @Inject
    private RecursoMapper recursoMapper;

    @Override
    public void agregarRecurso(Recurso r) throws PersistenceException {
        try{
            recursoMapper.agregarRecurso(r);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al agregar el recurso",e);
        }
    }

    @Override
    public Recurso buscarRecurso(int id) throws PersistenceException {
        try{
            return recursoMapper.buscarRecurso(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar el recurso",e);
        }
    }

    @Override
    public void cambiarDisponibilidad(String disp, int id) throws PersistenceException {
        try{
            recursoMapper.cambiarDisponibilidad(disp, id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al cambiar la disponibilidad del recurso",e);
        }
    }
}
