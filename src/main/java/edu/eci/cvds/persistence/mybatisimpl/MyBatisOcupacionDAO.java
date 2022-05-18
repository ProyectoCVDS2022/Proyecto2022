package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Ocupacion;
import edu.eci.cvds.persistence.OcupacionDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.OcupacionMapper;

import java.util.List;

public class MyBatisOcupacionDAO implements OcupacionDAO {
    @Inject
    OcupacionMapper ocupacionMapper;

    @Override
    public List<Ocupacion> recursosMasReservados() {
        return ocupacionMapper.recursosMasReservados();
    }

    @Override
    public List<Ocupacion> recursosMenosReservados() {
        return ocupacionMapper.recursosMenosReservados();
    }

    @Override
    public List<Ocupacion> reservasPorPrograma(){
        return ocupacionMapper.reservasPorPrograma();
    }

    @Override
    public int reservasPorHorario(int i, int f){
        return ocupacionMapper.reservasPorHorario(i, f);
    }
}
