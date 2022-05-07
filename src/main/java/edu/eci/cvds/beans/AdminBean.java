package edu.eci.cvds.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.AdminServices;
import org.primefaces.PrimeFaces;

import java.time.LocalTime;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "adminBean")
@ApplicationScoped

public class AdminBean extends BasePageBean{

    @Inject
    private AdminServices services;
    private int id;
    private int tipo;
    private String nombre;
    private int capacidad;
    private LocalTime fechaInicio;
    private LocalTime fechaFin;
    private int ubicacion;
    private String observaciones;

    private String nombreBuscar;
    private String nuevaDisponibilidad;
    private String usuarioBuscarReservas;
    private int idBuscarReservas;

    private Recurso recursoEncontrado;
    private List<Recurso> recursosEncontrados;
    private List<Reserva> reservasEncontradas;

    private List<Recurso> recursosSeleccionados;
    private Reserva reservaSeleccionada;

    public void agregarRecurso() throws PersistenceException {
        try{
            System.out.println(fechaInicio);
            System.out.println(fechaFin);
            services.agregarRecurso(new Recurso(id, nombre, capacidad, fechaInicio, fechaFin, "Disponible", observaciones, tipo, ubicacion));
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al agregar el recurso", ex);
        }
    }

    public Recurso buscarRecurso() throws PersistenceException {
        try{
            Recurso recurso = services.buscarRecurso(nombreBuscar);
            recursoEncontrado = recurso;
            return recurso;
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el recurso", ex);
        }
    }

    public List<Recurso> buscarRecursos() throws PersistenceException {
        try{
            recursosEncontrados = services.buscarRecursos(nombreBuscar);
            return recursosEncontrados;
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar los recursos", ex);
        }
    }

    public void cambiarDisponibilidad() throws PersistenceException {
        try{
            System.out.println(recursosSeleccionados.size());
            for(Recurso r: recursosSeleccionados){
                System.out.println(nuevaDisponibilidad);
                System.out.println(r.getId());
                services.cambiarDisponibilidad(nuevaDisponibilidad, r.getId());
            }
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al cambiar la disponibilidad del recurso", ex);
        }
    }

    public Usuario infoUsuario(int idUsuario) throws PersistenceException{
        try{
            return services.infoUsuario(idUsuario);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre del usuario", ex);
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

    public Recurso nombreRecurso(int id) throws PersistenceException{
        try{
            return services.nombreRecurso(id);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre del recurso", ex);
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

    public List<Reserva> buscarReservasId() throws PersistenceException {
        try{
            reservasEncontradas = services.buscarReservasId(idBuscarReservas);
            return reservasEncontradas;
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al consultar las reservas", ex);
        }
    }

    public List<Reserva> buscarReservasUsuario() throws PersistenceException {
        try{
            reservasEncontradas = services.buscarReservasUsuario(usuarioBuscarReservas);
            return reservasEncontradas;
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al consultar las reservas", ex);
        }
    }

    public void prueba(){
        System.out.println(reservaSeleccionada.getId());
    }

    public void click() {
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }

    public int getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public LocalTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalTime getFechaFin() {
        return fechaFin;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public AdminServices getServices() {
        return services;
    }

    public String getNombreBuscar() {
        return nombreBuscar;
    }

    public String getNuevaDisponibilidad() {
        return nuevaDisponibilidad;
    }

    public Recurso getRecursoEncontrado() {
        return recursoEncontrado;
    }

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

    public void setServices(AdminServices services) {
        this.services = services;
    }

    public void setNombreBuscar(String nombreBuscar) {
        this.nombreBuscar = nombreBuscar;
    }

    public void setNuevaDisponibilidad(String nuevaDisponibilidad) {
        this.nuevaDisponibilidad = nuevaDisponibilidad;
    }

    public void setRecursoEncontrado(Recurso recursoEncontrado) {
        this.recursoEncontrado = recursoEncontrado;
    }

    public List<Recurso> getRecursosEncontrados() {
        return recursosEncontrados;
    }

    public List<Recurso> getRecursosSeleccionados() {
        return recursosSeleccionados;
    }

    public void setRecursosEncontrados(List<Recurso> recursosEncontrados) {
        this.recursosEncontrados = recursosEncontrados;
    }

    public void setRecursosSeleccionados(List<Recurso> recursosSeleccionados) {
        this.recursosSeleccionados = recursosSeleccionados;
    }

    public List<Reserva> getReservasEncontradas() {
        return reservasEncontradas;
    }

    public void setReservasEncontradas(List<Reserva> reservasEncontradas) {
        this.reservasEncontradas = reservasEncontradas;
    }

    public String getUsuarioBuscarReservas() {
        return usuarioBuscarReservas;
    }

    public void setUsuarioBuscarReservas(String usuarioBuscarReservas) {
        this.usuarioBuscarReservas = usuarioBuscarReservas;
    }

    public int getIdBuscarReservas() {
        return idBuscarReservas;
    }

    public void setIdBuscarReservas(int idBuscarReservas) {
        this.idBuscarReservas = idBuscarReservas;
    }

    public Reserva getReservaSeleccionada() {
        return reservaSeleccionada;
    }

    public void setReservaSeleccionada(Reserva reservaSeleccionada) {
        this.reservaSeleccionada = reservaSeleccionada;
    }
}
