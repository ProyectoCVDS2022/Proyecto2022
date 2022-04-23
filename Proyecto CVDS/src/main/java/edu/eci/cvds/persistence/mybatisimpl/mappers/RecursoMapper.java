package edu.eci.cvds.persistence.mybatisimpl.mappers;


import edu.eci.cvds.entities.Recurso;
import org.apache.ibatis.annotations.Param;

public interface RecursoMapper {

    public void agregarRecurso(Recurso r);

    public Recurso buscarRecurso(@Param("nombrerecurso") String nombre);

    public void cambiarDisponibilidad(@Param("dispo") String disp, @Param("nombreRecurso") String nombre);

}
