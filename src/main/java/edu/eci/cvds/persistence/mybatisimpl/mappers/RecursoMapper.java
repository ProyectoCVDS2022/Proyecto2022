package edu.eci.cvds.persistence.mybatisimpl.mappers;


import edu.eci.cvds.entities.Recurso;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecursoMapper {

    public void agregarRecurso(@Param("recurso") Recurso r);

    public Recurso buscarRecurso(@Param("nombrerecurso") String nombreBuscar);

    public List<Recurso> buscarRecursos(@Param("nombrerecurso") String nombreBuscar);

    public void cambiarDisponibilidad(@Param("dispo") String disp, @Param("idRecurso") int id);

}
