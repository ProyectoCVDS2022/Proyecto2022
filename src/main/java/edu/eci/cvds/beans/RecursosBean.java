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
@ManagedBean(name = "recursosBean")
@ApplicationScoped

public class RecursosBean extends BasePageBean{

    @Inject
    private ComunityServices services;
    @Inject
    private CalendarBean calendarBean;
    private String nombreBuscar = "";
    private List<Recurso> recursosEncontrados;
    private int filtro;

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
            List<Reserva> reservas = services.reservasRecurso(id);
            if(reservas.size() == 0){
                services.cambiarDisponibilidad("Disponible", id);
                return "Disponible";
            }else{
                if(reservas.get(0).isCancelada()){
                    services.cambiarDisponibilidad("Disponible", id);
                    return "Disponible";
                }else{
                    if(reservas.get(0).getFechaInicio().isAfter(LocalDateTime.now())){
                        services.cambiarDisponibilidad("Disponible", id);
                        return "Disponible";
                    }else{
                        services.cambiarDisponibilidad("No disponible", id);
                        return "No disponible";
                    }
                }
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

    public CalendarBean getCalendarBean() {
        return calendarBean;
    }

    public void setCalendarBean(CalendarBean calendarBean) {
        this.calendarBean = calendarBean;
    }
}