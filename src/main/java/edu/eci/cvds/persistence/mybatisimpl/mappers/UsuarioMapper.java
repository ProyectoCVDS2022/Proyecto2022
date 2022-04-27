package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsuarioMapper {

    public List<Usuario> consultarUsuario(@Param("user") String username, @Param("password") String password);

}
