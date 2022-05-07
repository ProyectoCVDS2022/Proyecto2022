package edu.eci.cvds.samples.services.client;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ReservaMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;


public class MyBatis {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException
     */
    public static void main(String args[]) throws SQLException, ParseException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();

        UsuarioMapper usuarioMapper = sqlss.getMapper(UsuarioMapper.class);
        RecursoMapper recursoMapper = sqlss.getMapper(RecursoMapper.class);
        ReservaMapper reservaMapper = sqlss.getMapper(ReservaMapper.class);

        System.out.println(recursoMapper.buscarRecursos("Proba"));
        System.out.println(reservaMapper.buscarReservasId(1));
        System.out.println(reservaMapper.buscarReservasUsuario("juank"));
        recursoMapper.cambiarDisponibilidad("No disponible", 101);

        reservaMapper.crearReserva(new Reserva(4, 2, 102, LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()));

        sqlss.commit();
        sqlss.close();
    }
}