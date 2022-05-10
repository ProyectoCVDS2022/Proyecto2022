package edu.eci.cvds.beans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("deprecation")
@ManagedBean(name = "CalendarView")
@ApplicationScoped

public class CalendarBean extends BasePageBean implements Serializable {

    private ScheduleModel eventModel = new DefaultScheduleModel();
    private ScheduleEvent<?> event = new DefaultScheduleEvent<>();

    @PostConstruct
    public void init(){
        event = DefaultScheduleEvent.builder()
                .title("Reservado")
                .startDate(LocalDateTime.now().minusDays(1).withHour(20).withMinute(0).withSecond(0).withNano(0))
                .endDate(LocalDateTime.now().minusDays(1).withHour(23).withMinute(0).withSecond(0).withNano(0))
                .borderColor("orange")
                .build();
        eventModel.addEvent(event);
    }

    public void crearCalendario(Recurso recurso){
        System.out.println(recurso.getDisponibilidad());
        event = DefaultScheduleEvent.builder()
                .title("Reservado prueba")
                .startDate(LocalDateTime.now().minusDays(1).withHour(10).withMinute(0).withSecond(0).withNano(0))
                .endDate(LocalDateTime.now().minusDays(1).withHour(13).withMinute(0).withSecond(0).withNano(0))
                .borderColor("orange")
                .build();
        eventModel.addEvent(event);
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
}
