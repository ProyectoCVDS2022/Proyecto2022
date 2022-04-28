package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Ubicacion;
import org.apache.ibatis.annotations.Param;

public interface UbicacionMapper {

    public Ubicacion nombreUbicacion(@Param("id") int id);

}
