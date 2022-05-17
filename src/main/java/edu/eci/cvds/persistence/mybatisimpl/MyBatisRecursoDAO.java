package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;

import java.util.List;

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
    public Recurso buscarRecurso(String nombreBuscar) throws PersistenceException {
        try{
            return recursoMapper.buscarRecurso(nombreBuscar);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar el recurso",e);
        }
    }

    @Override
    public List<Recurso> buscarRecursos(String nombreBuscar) throws PersistenceException {
        try{
            return recursoMapper.buscarRecursos(nombreBuscar);
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

    @Override
    public List<Recurso> buscarRecursosComunidad(int filtro) throws PersistenceException {
        try{
            if(filtro == 1){
                return recursoMapper.buscarRecursosTodos();
            }else if(filtro == 2){
                return recursoMapper.buscarRecursosDisponibles();
            }else if(filtro == 3){
                return recursoMapper.buscarRecursosTipo(1);
            }else if(filtro == 4){
                return recursoMapper.buscarRecursosTipo(3);
            }else if(filtro == 5){
                return recursoMapper.buscarRecursosTipo(4);
            }else if(filtro == 6){
                return recursoMapper.buscarRecursosTipo(2);
            }else if(filtro == 7){
                return recursoMapper.buscarRecursosUbicacion(1);
            }else{
                return recursoMapper.buscarRecursosUbicacion(2);
            }
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar los recursos",e);
        }
    }

    @Override
    public Recurso nombreRecurso(int id) throws PersistenceException {
        try{
            return recursoMapper.nombreRecurso(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar el nombre del recurso",e);
        }
    }
}

/**
 * List<Recurso> res = null;
 *         try{
 *             if(filtro == 1){
 *                 res = recursoMapper.buscarRecursosTodos();
 *             }else if(filtro == 2){
 *                 res = recursoMapper.buscarRecursosDisponibles();
 *             }else if(filtro == 3){
 *                 res = recursoMapper.buscarRecursosLibros();
 *             }else if(filtro == 4){
 *                 res = recursoMapper.buscarRecursosPortatiles();
 *             }else if(filtro == 5){
 *                 res = recursoMapper.buscarRecursosPcs();
 *             }else if(filtro == 6){
 *                 res = recursoMapper.buscarRecursosSalas();
 *             }
 *         }catch(org.apache.ibatis.exceptions.PersistenceException e){
 *             throw new PersistenceException("Error al buscar los recuursos",e);
 *         }
 *         return res;
 */
