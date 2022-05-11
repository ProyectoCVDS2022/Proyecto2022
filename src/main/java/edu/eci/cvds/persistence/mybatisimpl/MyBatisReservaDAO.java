package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ReservaMapper;

import java.util.List;

public class MyBatisReservaDAO implements ReservaDAO {

    @Inject
    ReservaMapper reservaMapper;

    @Override
    public void crearReserva(Reserva reserva) throws PersistenceException {
        try{
            reservaMapper.crearReserva(reserva);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al reservar el recurso",e);
        }
    }

    @Override
    public List<Reserva> buscarReservasId(int id) throws PersistenceException {
        try{
            return reservaMapper.buscarReservasId(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar las reservas",e);
        }
    }

    @Override
    public List<Reserva> buscarReservasUsuario(String usuario) throws PersistenceException {
        try{
            return reservaMapper.buscarReservasUsuario(usuario);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar las reservas",e);
        }
    }

    @Override
    public List<Reserva> buscarReservasComunidad(int id, String usuario) throws PersistenceException {
        try{
            if(id == 1){
                return reservaMapper.buscarReservasActivas(usuario);
            }else if(id == 2){
                return reservaMapper.buscarReservasPasadas(usuario);
            }else{
                return reservaMapper.buscarReservasCanceladas(usuario);
            }
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar las reservas",e);
        }
    }

    @Override
    public int maxIdReserva() throws PersistenceException {
        try{
            return reservaMapper.maxIdReserva();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar el nombre del recurso",e);
        }
    }

    @Override
    public List<Reserva> estaDisponible(int id) throws PersistenceException {
        try{
            return reservaMapper.estaDisponible(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar la disponibilidad del recurso",e);
        }
    }

}
