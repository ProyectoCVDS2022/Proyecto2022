package edu.eci.cvds.beans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ComunityServices;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("deprecation")
@ManagedBean(name = "CalendarView")
@ApplicationScoped

public class CalendarBean extends BasePageBean implements Serializable {

    @Inject
    private ComunityServices services;

    private ScheduleModel eventModel;
    private ScheduleEvent<?> event;

    private Recurso recursoSeleccionado;
    private boolean recurrente;
    private String recurrencia;

    public CalendarBean(){
        eventModel = new DefaultScheduleModel();
    }

    public void crearCalendario() throws PersistenceException {
        System.out.println(services.buscarRecursosComunidad(1).size());
        eventModel = new DefaultScheduleModel();
        event = DefaultScheduleEvent.builder()
                .title("Reservado")
                .startDate(LocalDateTime.now().minusDays(2).withHour(20).withMinute(0).withSecond(0).withNano(0))
                .endDate(LocalDateTime.now().minusDays(2).withHour(23).withMinute(0).withSecond(0).withNano(0))
                .borderColor("orange")
                .build();
        eventModel.addEvent(event);
        event = new DefaultScheduleEvent<>();
    }

    public void crearEvento(SelectEvent<LocalDateTime> selectEvent){
        event = DefaultScheduleEvent.builder()
                .startDate(selectEvent.getObject())
                .endDate(selectEvent.getObject().plusHours(1))
                .build();
    }

    public void reservarRecurso() throws PersistenceException{
        try{
            if(recursoSeleccionado.getDisponibilidad().equals("Disponible")){
                if(event.getEndDate().isEqual(event.getStartDate().plusHours(2)) || (event.getEndDate().isBefore(event.getStartDate().plusHours(2)) && event.getEndDate().isAfter(event.getStartDate()))){
                    if(event.getStartDate().getHour() >= recursoSeleccionado.getFechaInicio().getHour() && event.getEndDate().getHour() <= recursoSeleccionado.getFechaFin().getHour()){
                        services.crearReserva(new Reserva(maxIdReserva()+1, 2, recursoSeleccionado.getId(), LocalDateTime.now(), event.getStartDate(), event.getEndDate(), recurrente, recurrencia, false));
                        services.cambiarDisponibilidad("No disponible", recursoSeleccionado.getId());
                        addMessage("¡Recurso reservado exitosamente!");
                        PrimeFaces.current().executeScript("PF('dlg').hide();");
                        System.out.println("Hacer colisiones con otras reservas");
                    }else{
                        addMessage("La hora seleccionada debe estar en el horario de disponibilidad del recurso");
                    }

                }else{
                    if(event.getEndDate().isAfter(event.getStartDate().plusHours(2)) && !recurrente){
                        addMessage("El tiempo máximo de la reserva es de dos horas");
                    }else if(event.getEndDate().isBefore(event.getStartDate())){
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

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ScheduleEvent<?> getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent<?> event) {
        this.event = event;
    }

    public ComunityServices getServices() {
        return services;
    }

    public void setServices(ComunityServices services) {
        this.services = services;
    }

    public Recurso getRecursoSeleccionado() {
        return recursoSeleccionado;
    }

    public void setRecursoSeleccionado(Recurso recursoSeleccionado) {
        this.recursoSeleccionado = recursoSeleccionado;
    }

    public boolean isRecurrente() {
        return recurrente;
    }

    public void setRecurrente(boolean recurrente) {
        this.recurrente = recurrente;
    }

    public String getRecurrencia() {
        return recurrencia;
    }

    public void setRecurrencia(String recurrencia) {
        this.recurrencia = recurrencia;
    }
}
