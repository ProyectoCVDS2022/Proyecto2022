package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Ocupacion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OcupacionMapper {
    public List<Ocupacion> recursosMenosReservados();

    public List<Ocupacion> recursosMasReservados();

    public List<Ocupacion> reservasPorPrograma();

    public int reservasPorHorario(@Param("inicio") int i, @Param("fin") int f);
}
