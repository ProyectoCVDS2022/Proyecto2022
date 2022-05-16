package edu.eci.cvds.beans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.AdminServices;
import org.primefaces.PrimeFaces;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.charts.hbar.HorizontalBarChartDataSet;
import org.primefaces.model.charts.hbar.HorizontalBarChartModel;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    private DonutChartModel recursosMasUsados = new DonutChartModel();
    private DonutChartModel recursosMenosUsados = new DonutChartModel();

    private BarChartModel horariosMas = new BarChartModel();
    private BarChartModel horariosMenos = new BarChartModel();
    private HorizontalBarChartModel reservasPrograma = new HorizontalBarChartModel();

    @Override
    public void init() {
        super.init();
        ocupacion();
        ocupacionHorarios();
        ocupacionProgramas();
    }

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

    public Recurso buscarRecurso() throws PersistenceException {
        try{
            Recurso recurso = services.buscarRecurso(nombreBuscar);
            recursoEncontrado = recurso;
            return recurso;
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el recurso", ex);
        }
    }

    public void buscarRecursos() throws PersistenceException {
        try{
            recursosEncontrados = services.buscarRecursos(nombreBuscar);
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al buscar el recursos", ex);
        }
    }

    public String estaDisponible(int id) throws PersistenceException{
        try{
            List<Reserva> reservas = services.reservasRecurso(id);
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

    public void cambiarDisponibilidad() throws PersistenceException {
        try{
            if(recursoSeleccionado.getDisponibilidad().equals("Disponible")){
                services.cambiarDisponibilidad("No disponible", recursoSeleccionado.getId());
            }else{
                services.cambiarDisponibilidad("Disponible", recursoSeleccionado.getId());
            }
            addMessage("Nuevo estado del recurso: "+ (services.nombreRecurso(recursoSeleccionado.getId())).getDisponibilidad());
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

    public void ocupacion() {
        ChartData data = new ChartData();

        DonutChartDataSet dataSet = new DonutChartDataSet();
        List<Number> values = new ArrayList<>();
        //List<Map<Integer, Object>> valoresMas = services.recursosMasReservados();
        //List<Map<Integer, Object>> valoresMenos = services.recursosMenosReservados();
        //values.add((int)valoresMas.get(0).get(0));
        //values.add((int)valoresMas.get(1).get(0));
        //values.add((int)valoresMas.get(2).get(0));
        values.add(1);
        values.add(60);
        values.add(25);
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(22, 67, 137)");
        bgColors.add("rgb(41, 95, 142)");
        bgColors.add("rgb(143, 145, 152)");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("1");
        labels.add("2");
        labels.add("3");
        data.setLabels(labels);

        recursosMasUsados.setData(data);
        recursosMenosUsados.setData(data);
    }

    public void ocupacionHorarios() {
        horariosMas = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Cantidad de reservas");

        List<Number> values = new ArrayList<>();
        values.add(65);
        values.add(59);
        values.add(80);
        barDataSet.setData(values);

        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgb(22, 67, 137)");
        bgColor.add("rgb(41, 95, 142)");
        bgColor.add("rgb(143, 145, 152)");
        barDataSet.setBackgroundColor(bgColor);

        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 255, 255)");
        borderColor.add("rgb(255, 255, 255)");
        borderColor.add("rgb(255, 255, 255)");
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(2);

        data.addChartDataSet(barDataSet);

        List<String> labels = new ArrayList<>();
        labels.add("7:00 - 9:00");
        labels.add("9:00 - 11:00");
        labels.add("11:00 - 1:00");
        data.setLabels(labels);
        horariosMas.setData(data);
        horariosMenos.setData(data);
    }

    public void ocupacionProgramas() {
        ChartData data = new ChartData();
        reservasPrograma = new HorizontalBarChartModel();
        HorizontalBarChartDataSet hbarDataSet = new HorizontalBarChartDataSet();
        hbarDataSet.setLabel("Cantidad de reservas");

        List<Number> values = new ArrayList<>();
        values.add(1);
        values.add(3);
        values.add(7);
        hbarDataSet.setData(values);

        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgb(22, 67, 137)");
        bgColor.add("rgb(41, 95, 142)");
        bgColor.add("rgb(143, 145, 152)");
        hbarDataSet.setBackgroundColor(bgColor);

        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 255, 255)");
        borderColor.add("rgb(255, 255, 255)");
        borderColor.add("rgb(255, 255, 255)");
        hbarDataSet.setBorderColor(borderColor);
        hbarDataSet.setBorderWidth(2);

        data.addChartDataSet(hbarDataSet);

        List<String> labels = new ArrayList<>();
        labels.add("Ingeniería de sistemas");
        labels.add("Ingeniería eléctrica");
        labels.add("Ingeniería electrónica");
        data.setLabels(labels);
        reservasPrograma.setData(data);

        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addXAxesData(linearAxes);
        options.setScales(cScales);
        reservasPrograma.setOptions(options);
    }

    /*
     * Cosas adicionales jijija
     */
    public void click() {
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }

    public void addMessage(String summary) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
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

    public DonutChartModel getRecursosMasUsados() {
        return recursosMasUsados;
    }

    public void setRecursosMasUsados(DonutChartModel recursosMasUsados) {
        this.recursosMasUsados = recursosMasUsados;
    }

    public DonutChartModel getRecursosMenosUsados() {
        return recursosMenosUsados;
    }

    public void setRecursosMenosUsados(DonutChartModel recursosMenosUsados) {
        this.recursosMenosUsados = recursosMenosUsados;
    }

    public BarChartModel getHorariosMas() {
        return horariosMas;
    }

    public void setHorariosMas(BarChartModel horariosMas) {
        this.horariosMas = horariosMas;
    }

    public BarChartModel getHorariosMenos() {
        return horariosMenos;
    }

    public void setHorariosMenos(BarChartModel horariosMenos) {
        this.horariosMenos = horariosMenos;
    }

    public HorizontalBarChartModel getReservasPrograma() {
        return reservasPrograma;
    }

    public void setReservasPrograma(HorizontalBarChartModel reservasPrograma) {
        this.reservasPrograma = reservasPrograma;
    }
}
