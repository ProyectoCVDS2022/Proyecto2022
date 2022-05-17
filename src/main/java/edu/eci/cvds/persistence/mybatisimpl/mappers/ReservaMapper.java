package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.exceptions.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.rmi.server.RemoteServer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ReservaMapper {

    public void crearReserva(@Param("reserva") Reserva reserva);

    public List<Reserva> buscarReservasId(@Param("id") int id);

    public List<Reserva> buscarReservasUsuario(@Param("usuario") String usuario);

    public List<Reserva> buscarReservasActivas(@Param("fechactual")LocalDateTime fechactual);

    public List<Reserva> buscarReservasPasadas(@Param("fechactual")LocalDateTime fechactual);

    public List<Reserva> buscarReservasCanceladas(@Param("usuario") String usuario);

    public int maxIdReserva();

    public List<Reserva> reservasRecurso(@Param("id") int id);

    public void cancelarReserva(@Param("id") int id) throws PersistenceException;

}