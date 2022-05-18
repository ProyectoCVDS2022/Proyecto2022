package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;

import java.util.List;

public class MyBatisUsuarioDAO implements UsuarioDAO {

    @Inject
    private UsuarioMapper usuarioMapper;

    @Override
    public List<Usuario> consultarUsuario(String username, String password) throws PersistenceException {
        try{
            return usuarioMapper.consultarUsuario(username, password);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar el usuario", e);
        }
    }

    @Override
    public Usuario infoUsuario(int idUsuario) throws PersistenceException {
        try{
            return usuarioMapper.infoUsuario(idUsuario);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar la información del usuario", e);
        }
    }

    @Override
    public int idUsuario(String usuario) throws PersistenceException {
        try{
            return usuarioMapper.idUsuario(usuario);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar el id del usuario", e);
        }
    }
}
