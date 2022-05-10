package edu.eci.cvds.beans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.AdminServices;
import org.primefaces.PrimeFaces;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.time.LocalTime;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "adminBean")
@ApplicationScoped

public class AdminBean extends BasePageBean{

    @Inject
    private AdminServices services;
    private int id;
    private Recurso recursoSeleccionado;
    private int tipo;
    private String nombre;
    private int capacidad;
    private LocalTime fechaInicio;
    private LocalTime fechaFin;
    private int ubicacion;
    private String observaciones;
    private String nombreBuscar;
    private Recurso recursoEncontrado;


    private List<Recurso> recursosEncontrados;
    private List<Reserva> reservasEncontradas;
    private String usuarioBuscarReservas;
    private Reserva reservaSeleccionada;

    /*
     * Primer Servicio
     */
    public void agregarRecurso() throws PersistenceException {
        try{
            services.agregarRecurso(new Recurso(id, nombre, capacidad, fechaInicio, fechaFin, "Disponible", observaciones, tipo, ubicacion));
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al agregar el recurso", ex);
        }
    }

    /*
     * Segundo Servicio
     */
    public void buscarRecursos() throws PersistenceException {
        try{
            recursosEncontrados = services.buscarRecursos(nombreBuscar);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el recursos", ex);
        }
    }
    public void cambiarDisponibilidad() throws PersistenceException {
        try{
            System.out.println(recursoSeleccionado.getDisponibilidad());
            if(recursoSeleccionado.getDisponibilidad().equals("Disponible")){
                services.cambiarDisponibilidad("No disponible", recursoSeleccionado.getId());
            }else{
                services.cambiarDisponibilidad("Disponible", recursoSeleccionado.getId());
            }

        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al cambiar la disponibilidad del recurso", ex);
        }
    }

    public Ubicacion nombreUbicacionDialogo() throws PersistenceException{
        try{
            return services.nombreUbicacion(ubicacion);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre de la ubicación", ex);
        }
    }

    public TipoRecurso nombreTipoDialogo() throws PersistenceException{
        try{
            return services.nombreTipo(tipo);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre de la ubicación", ex);
        }
    }

    public Ubicacion nombreUbicacion(int idUbicacion) throws PersistenceException{
        try{
            return services.nombreUbicacion(idUbicacion);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre de la ubicación", ex);
        }
    }

    public TipoRecurso nombreTipo(int idTipo) throws PersistenceException{
        try{
            return services.nombreTipo(idTipo);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre de la ubicación", ex);
        }
    }

    public void click() {
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }

    /*
     * Tercer Servicio
     */
    public List<Reserva> buscarReservasUsuario() throws PersistenceException {
        try{
            reservasEncontradas = services.buscarReservasUsuario(usuarioBuscarReservas);
            return reservasEncontradas;
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al consultar las reservas", ex);
        }
    }

    public Usuario infoUsuario(int idUsuario) throws PersistenceException{
        try{
            return services.infoUsuario(idUsuario);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar la información del usuario", ex);
        }
    }

    public Recurso nombreRecurso(int id) throws PersistenceException{
        try{
            return services.nombreRecurso(id);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre del recurso", ex);
        }
    }


    public List<Reserva> getReservasEncontradas() {return reservasEncontradas;}

    public void setReservasEncontradas(List<Reserva> reservasEncontradas) {this.reservasEncontradas = reservasEncontradas;}

    public String getUsuarioBuscarReservas() {return usuarioBuscarReservas;}

    public void setUsuarioBuscarReservas(String usuarioBuscarReservas) {this.usuarioBuscarReservas = usuarioBuscarReservas;}

    public Reserva getReservaSeleccionada() {return reservaSeleccionada;}

    public void setReservaSeleccionada(Reserva reservaSeleccionada) {this.reservaSeleccionada = reservaSeleccionada;}

    public Recurso getRecursoSeleccionado() {return recursoSeleccionado;}

    public void setRecursoSeleccionado(Recurso recursoSeleccionado) {this.recursoSeleccionado = recursoSeleccionado;}

    public int getId() {return id;}

    public int getTipo() {return tipo;}

    public String getNombre() {return nombre;}

    public int getCapacidad() {return capacidad;}

    public LocalTime getFechaInicio() {return fechaInicio;}

    public LocalTime getFechaFin() {return fechaFin;}

    public int getUbicacion() {return ubicacion;}

    public String getObservaciones() {return observaciones;}


    public String getNombreBuscar() {return nombreBuscar;}


    public Recurso getRecursoEncontrado() {return recursoEncontrado;}

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setFechaInicio(LocalTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


    public void setNombreBuscar(String nombreBuscar) {
        this.nombreBuscar = nombreBuscar;
    }


    public void setRecursoEncontrado(Recurso recursoEncontrado) {
        this.recursoEncontrado = recursoEncontrado;
    }

    public List<Recurso> getRecursosEncontrados() {
        return recursosEncontrados;
    }

    public void setRecursosEncontrados(List<Recurso> recursosEncontrados) {this.recursosEncontrados = recursosEncontrados;}

    public AdminServices getServices() {return services;}

    public void setServices(AdminServices services) {this.services = services;}


}
