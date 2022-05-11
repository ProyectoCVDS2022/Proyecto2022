package edu.eci.cvds.persistence.mybatisimpl.mappers;


import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.exceptions.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecursoMapper {

    public void agregarRecurso(@Param("recurso") Recurso r);

    public Recurso buscarRecurso(@Param("nombrerecurso") String nombreBuscar);

    public List<Recurso> buscarRecursos(@Param("nombrerecurso") String nombreBuscar);

    public void cambiarDisponibilidad(@Param("dispo") String disp, @Param("idRecurso") int id);

    public List<Recurso> buscarRecursosTodos();

    public List<Recurso> buscarRecursosDisponibles();

    public List<Recurso> buscarRecursosTipo(@Param("tipo") int tipo);

    public List<Recurso> buscarRecursosUbicacion(@Param("id") int id);

    public Recurso nombreRecurso(@Param("id") int id);

}
