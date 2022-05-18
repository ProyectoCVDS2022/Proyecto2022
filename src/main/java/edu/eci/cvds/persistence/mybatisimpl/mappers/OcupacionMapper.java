package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Ocupacion;

import java.util.List;

public interface OcupacionMapper {
    public List<Ocupacion> recursosMenosReservados();

    public List<Ocupacion> recursosMasReservados();

    public List<Ocupacion> reservasPorPrograma();
}
