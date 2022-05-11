package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import org.apache.ibatis.annotations.Param;

import java.rmi.server.RemoteServer;
import java.util.List;

public interface ReservaMapper {

    public void crearReserva(@Param("reserva") Reserva reserva);

    public List<Reserva> buscarReservasId(@Param("id") int id);

    public List<Reserva> buscarReservasUsuario(@Param("usuario") String usuario);

    public List<Reserva> buscarReservasActivas(@Param("usuario") String usuario);

    public List<Reserva> buscarReservasPasadas(@Param("usuario") String usuario);

    public List<Reserva> buscarReservasCanceladas(@Param("usuario") String usuario);

    public int maxIdReserva();

    public List<Reserva> estaDisponible(@Param("id") int id);
}
