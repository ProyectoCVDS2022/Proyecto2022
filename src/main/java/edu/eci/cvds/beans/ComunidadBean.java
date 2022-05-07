package edu.eci.cvds.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ComunityServices;
import org.primefaces.PrimeFaces;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "comunidadBean")
@ApplicationScoped

public class ComunidadBean extends BasePageBean{

    @Inject
    private LoginBean loginBean;

    @Inject
    private ComunityServices services;
    private int idReserva = 1;
    private int usuario;
    private int filtro;
    private String nombreBuscar = "";

    private int id;
    private int tipo;
    private String nombre;
    private int capacidad;
    private LocalTime fechaInicio;
    private LocalTime fechaFin;
    private int ubicacion;
    private String observaciones;

    private String ubicacionNombre;

    private List<Reserva> reservasEncontradas;
    private List<Recurso> recursosEncontrados;
    private Recurso recursoSeleccionado;

    private LocalDateTime fechaInicioReserva;
    private LocalDateTime fechaFinReserva;


    public List<Recurso> buscarRecursos() throws PersistenceException {
        try{
            if(!nombreBuscar.equals("")){
                recursosEncontrados = services.buscarRecursos(nombreBuscar);
            }else{
                recursosEncontrados = services.buscarRecursosComunidad(filtro);
            }
            return recursosEncontrados;
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar los recursos", ex);
        }
    }

    public void reservarRecurso() throws PersistenceException{
        try{
            if(recursoSeleccionado.getDisponibilidad().equals("Disponible")){
                services.crearReserva(new Reserva(idReserva, usuario, recursoSeleccionado.getId(), LocalDateTime.now(), fechaInicioReserva, fechaFinReserva));
                services.cambiarDisponibilidad("No disponible", recursoSeleccionado.getId());
                idReserva += 1;
            }
            System.out.println("hacer mensaje de error recurso no disponible");
        }catch (PersistenceException ex) {
            throw new PersistenceException("Error al reservar el recurso", ex);
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
            throw new PersistenceException("Error al buscar el nombre del tipo del recurso", ex);
        }
    }

    public List<Reserva> buscarReservas() throws PersistenceException {
        try{
            //reservasEncontradas = services.buscarReservas(loginBean.getUsername());
            reservasEncontradas = services.buscarReservas("julian");
            return reservasEncontradas;
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar las reservas", ex);
        }
    }

    public String nombreRecurso(int id) throws PersistenceException{
        try{
            return services.nombreRecurso(id).getNombre();
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre del recurso", ex);
        }
    }

    public void click() {
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public LocalTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombreBuscar() {
        return nombreBuscar;
    }

    public void setNombreBuscar(String nombreBuscar) {
        this.nombreBuscar = nombreBuscar;
    }

    public List<Recurso> getRecursosEncontrados() {
        return recursosEncontrados;
    }

    public void setRecursosEncontrados(List<Recurso> recursosEncontrados) {
        this.recursosEncontrados = recursosEncontrados;
    }

    public int getFiltro() {
        return filtro;
    }

    public void setFiltro(int filtro) {
        this.filtro = filtro;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int idUsuario) {
        this.usuario = idUsuario;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDateTime getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(LocalDateTime horaInicioReserva) {
        this.fechaInicioReserva = horaInicioReserva;
    }

    public LocalDateTime getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(LocalDateTime horaFinReserva) {
        this.fechaFinReserva = horaFinReserva;
    }

    public Recurso getRecursoSeleccionado() {
        return recursoSeleccionado;
    }

    public void setRecursoSeleccionado(Recurso recursoSeleccionado) {
        this.recursoSeleccionado = recursoSeleccionado;
    }

    public List<Reserva> getReservasEncontradas() {
        return reservasEncontradas;
    }

    public void setReservasEncontradas(List<Reserva> reservasEncontradas) {
        this.reservasEncontradas = reservasEncontradas;
    }
}