package edu.eci.cvds.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.samples.services.LibraryServices;

import java.io.IOException;
import java.sql.Date;

@SuppressWarnings("deprecation")
@ManagedBean(name = "loginBean")
@ApplicationScoped

public class AdminBean extends BasePageBean{

    private int id;
    private int tipo;
    private String nombre;
    private int capacidad;
    private Date fechaInicio;
    private Date fechaFin;
    private int ubicacion;
    private String observaciones;
    private LibraryServices services;

    public void agregarRecurso() throws PersistenceException {
        try{
            services.agregarRecurso(new Recurso(id, tipo, nombre, capacidad, fechaInicio, fechaFin, ubicacion, observaciones));
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al registrar el Cliente", ex);
        }
    }
}
