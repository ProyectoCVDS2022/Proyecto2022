package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Ocupacion;

import java.util.List;

public interface OcupacionDAO {
    public List<Ocupacion> recursosMasReservados();

    public List<Ocupacion> recursosMenosReservados();

    public List<Ocupacion> reservasPorPrograma();
}
