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

    public List<Reserva> buscarReservasComunidad(@Param("usuario") String usuario);

}
