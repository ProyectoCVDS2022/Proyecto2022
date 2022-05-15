package edu.eci.cvds.beans;

import com.google.inject.Inject;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ComunityServices;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
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

    public CalendarBean(){
        eventModel = new DefaultScheduleModel();
        event = new DefaultScheduleEvent<>();
    }

    public void crearCalendario(){
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
}
