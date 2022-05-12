package edu.eci.cvds.beans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ComunityServices;
import org.primefaces.PrimeFaces;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "comunidadBean")
@ApplicationScoped

public class ComunidadBean extends BasePageBean{

    @Inject
    private ComunityServices services;
    @Inject
    private CalendarBean calendarBean;
    private String nombreBuscar = "";
    private List<Recurso> recursosEncontrados;
    private int filtro;
    private int filtroReservas;
    private Recurso recursoSeleccionado;
    private LocalDateTime fechaInicioReserva;
    private LocalDateTime fechaFinReserva;
    private boolean recurrente;
    private List<Reserva> reservasEncontradas;
    private String recurrencia;
    private Reserva reservaSeleccionada;
    private Recurso recursoEncontrado;


    public Recurso buscarRecurso(String nombreBuscar) throws PersistenceException {
        try{
            Recurso recurso = services.buscarRecurso(nombreBuscar);
            recursoEncontrado = recurso;
            return recurso;
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el recurso", ex);
        }
    }

    public Recurso buscarRecursoReserva() throws PersistenceException{
        try{
            Recurso recurso = services.nombreRecurso(reservaSeleccionada.getRecurso());
            recursoEncontrado = recurso;
            return recurso;
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el recurso", ex);
        }
    }

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

    public String estaDisponible(int id) throws PersistenceException{
        try{
            List<Reserva> reservas = services.estaDisponible(id);
            if(reservas.size() == 0){
                services.cambiarDisponibilidad("Disponible", id);
                return "Disponible";
            }else{
                services.cambiarDisponibilidad("No disponible", id);
                return "No disponible";
            }
        }catch (PersistenceException ex){
            throw new PersistenceException("Error al buscar la disponibilidad de los recursos", ex);
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

    public Recurso nombreRecurso(int id) throws PersistenceException{
        try{
            return services.nombreRecurso(id);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el nombre del recurso", ex);
        }
    }

    public void reservarRecurso() throws PersistenceException{
        try{
            if(recursoSeleccionado.getDisponibilidad().equals("Disponible")){
                if(fechaFinReserva.isEqual(fechaInicioReserva.plusHours(2)) || (fechaFinReserva.isBefore(fechaInicioReserva.plusHours(2)) && fechaFinReserva.isAfter(fechaInicioReserva))){
                    if(fechaInicioReserva.getHour() >= recursoSeleccionado.getFechaInicio().getHour() && fechaFinReserva.getHour() <= recursoSeleccionado.getFechaFin().getHour()){
                        services.crearReserva(new Reserva(maxIdReserva()+1, 2, recursoSeleccionado.getId(), LocalDateTime.now(), fechaInicioReserva, fechaFinReserva, recurrente, recurrencia, false));
                        services.cambiarDisponibilidad("No disponible", recursoSeleccionado.getId());
                        addMessage("¡Recurso reservado exitosamente!");
                        PrimeFaces.current().executeScript("PF('dlg').hide();");
                        System.out.println("Hacer colisiones con otras reservas");
                    }else{
                        addMessage("La hora seleccionada debe estar en el horario de disponibilidad del recurso");
                    }

                }else{
                    if(fechaFinReserva.isAfter(fechaInicioReserva.plusHours(2))){
                        addMessage("El tiempo máximo de la reserva es de dos horas");
                    }else if(fechaFinReserva.isBefore(fechaInicioReserva)){
                        addMessage("La fecha de fin debe ser mayor a la fecha de inicio");
                    }
                }
            }else{
                addMessage("El recurso no se encuentra disponible actualmente");
            }
        }catch (PersistenceException ex) {
            throw new PersistenceException("Error al reservar el recurso", ex);
        }
    }

    public int maxIdReserva() throws PersistenceException {
        try{
            return services.maxIdReserva();
        }catch (PersistenceException e){
            throw new PersistenceException("Error en la busqueda del numero de reservas",e);
        }
    }

    public List<Reserva> buscarReservas() throws PersistenceException {
        try{
            //reservasEncontradas = services.buscarReservas(loginBean.getUsername());
            reservasEncontradas = services.buscarReservas(filtroReservas, "julian@gmail.com");
            return reservasEncontradas;
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar las reservas", ex);
        }
    }

    public void addMessage(String summary) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

    public void click() {
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }

    public ComunityServices getServices() {
        return services;
    }

    public void setServices(ComunityServices services) {
        this.services = services;
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

    public Recurso getRecursoSeleccionado() {
        return recursoSeleccionado;
    }

    public void setRecursoSeleccionado(Recurso recursoSeleccionado) {
        this.recursoSeleccionado = recursoSeleccionado;
    }

    public CalendarBean getCalendarBean() {
        return calendarBean;
    }

    public void setCalendarBean(CalendarBean calendarBean) {
        this.calendarBean = calendarBean;
    }

    public LocalDateTime getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(LocalDateTime fechaInicioReserva) {
        this.fechaInicioReserva = fechaInicioReserva;
    }

    public LocalDateTime getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(LocalDateTime fechaFinReserva) {
        this.fechaFinReserva = fechaFinReserva;
    }

    public boolean isRecurrente() {
        return recurrente;
    }

    public void setRecurrente(boolean recurrente) {
        this.recurrente = recurrente;
    }

    public List<Reserva> getReservasEncontradas() {
        return reservasEncontradas;
    }

    public void setReservasEncontradas(List<Reserva> reservasEncontradas) {
        this.reservasEncontradas = reservasEncontradas;
    }

    public String getRecurrencia() {
        return recurrencia;
    }

    public void setRecurrencia(String recurrencia) {
        this.recurrencia = recurrencia;
    }

    public int getFiltroReservas() {
        return filtroReservas;
    }

    public void setFiltroReservas(int filtroReservas) {
        this.filtroReservas = filtroReservas;
    }

    public Reserva getReservaSeleccionada() {
        return reservaSeleccionada;
    }

    public void setReservaSeleccionada(Reserva reservaSeleccionada) {
        this.reservaSeleccionada = reservaSeleccionada;
    }

    public Recurso getRecursoEncontrado() {
        return recursoEncontrado;
    }

    public void setRecursoEncontrado(Recurso recursoEncontrado) {
        this.recursoEncontrado = recursoEncontrado;
    }
}
