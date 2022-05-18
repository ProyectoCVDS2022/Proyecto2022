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
import java.util.Arrays;
import java.util.HashMap;
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

    private int filtroReservas;
    private List<Reserva> reservasReportes;

    private DonutChartModel recursosMasUsados = new DonutChartModel();
    private DonutChartModel recursosMenosUsados = new DonutChartModel();
    private DonutChartModel donaReservas = new DonutChartModel();

    private BarChartModel horariosMas = new BarChartModel();
    private BarChartModel horariosMenos = new BarChartModel();
    private HorizontalBarChartModel reservasPrograma = new HorizontalBarChartModel();

    @Override
    public void init() {
        super.init();
        ocupacion();
        ocupacionHorarios();
        ocupacionProgramas();
        graficoReservas();
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

    public List<Reserva> buscarReservasReportes() throws PersistenceException{
        try{
            reservasEncontradas = services.buscarReservasReportes(filtroReservas);
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

    public void ocupacion(){
        try {
            ChartData dataMas = new ChartData();
            ChartData dataMenos = new ChartData();

            DonutChartDataSet dataSetMasReservados = new DonutChartDataSet();
            DonutChartDataSet dataSetMenosReservados = new DonutChartDataSet();
            List<Number> recursosMasReservados = new ArrayList<>();
            List<Number> recursosMenosReservados = new ArrayList<>();

            List<Ocupacion> valoresMas = services.recursosMasReservados();
            recursosMasReservados.add(valoresMas.get(0).getValor());
            recursosMasReservados.add(valoresMas.get(1).getValor());
            recursosMasReservados.add(valoresMas.get(2).getValor());
            dataSetMasReservados.setData(recursosMasReservados);

            List<Ocupacion> valoresMenos = services.recursosMenosReservados();
            recursosMenosReservados.add(valoresMenos.get(0).getValor());
            recursosMenosReservados.add(valoresMenos.get(1).getValor());
            recursosMenosReservados.add(valoresMenos.get(2).getValor());
            dataSetMenosReservados.setData(recursosMenosReservados);

            List<String> bgColors = new ArrayList<>();
            bgColors.add("rgb(110, 17, 17)");
            bgColors.add("rgb(180, 20, 12)");
            bgColors.add("rgb(143, 145, 152)");
            dataSetMasReservados.setBackgroundColor(bgColors);
            dataSetMenosReservados.setBackgroundColor(bgColors);

            dataMas.addChartDataSet(dataSetMasReservados);
            dataMenos.addChartDataSet(dataSetMenosReservados);
            List<String> labelsMas = new ArrayList<>();
            labelsMas.add(nombreRecurso(Integer.parseInt(valoresMas.get(0).getFiltro())).getNombre());
            labelsMas.add(nombreRecurso(Integer.parseInt(valoresMas.get(1).getFiltro())).getNombre());
            labelsMas.add(nombreRecurso(Integer.parseInt(valoresMas.get(2).getFiltro())).getNombre());
            dataMas.setLabels(labelsMas);

            List<String> labelsMenos = new ArrayList<>();
            labelsMenos.add(nombreRecurso(Integer.parseInt(valoresMenos.get(0).getFiltro())).getNombre());
            labelsMenos.add(nombreRecurso(Integer.parseInt(valoresMenos.get(1).getFiltro())).getNombre());

            labelsMenos.add(nombreRecurso(Integer.parseInt(valoresMenos.get(2).getFiltro())).getNombre());
            dataMenos.setLabels(labelsMenos);

            recursosMasUsados.setData(dataMas);
            recursosMenosUsados.setData(dataMenos);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    public void ocupacionHorarios() {
        horariosMas = new BarChartModel();
        horariosMenos = new BarChartModel();
        ChartData dataMas = new ChartData();
        ChartData dataMenos = new ChartData();

        int inicial = 7;
        int Final = 9;
        int[] ocupacion = new int[6];
        HashMap<Integer, String> valoresLabels = new HashMap<>();
        for(int i = 0; i < 5; i++){
            ocupacion[i] = services.reservasPorHorario(inicial, Final);
            valoresLabels.put(ocupacion[i], String.valueOf(inicial).concat(":00 - ").concat(String.valueOf(Final)).concat(":00"));
            inicial += 2;
            Final += 2;
        }

        Arrays.sort(ocupacion);


        BarChartDataSet barDataSetMas = new BarChartDataSet();
        BarChartDataSet barDataSetMenos = new BarChartDataSet();
        barDataSetMas.setLabel("Cantidad de reservas");
        barDataSetMenos.setLabel("Cantidad de reservas");

        List<Number> valuesMas = new ArrayList<>();
        valuesMas.add(ocupacion[0]);
        valuesMas.add(ocupacion[1]);
        valuesMas.add(ocupacion[2]);
        barDataSetMas.setData(valuesMas);

        List<Number> valuesMenos = new ArrayList<>();
        valuesMenos.add(ocupacion[ocupacion.length - 3]);
        valuesMenos.add(ocupacion[ocupacion.length - 2]);
        valuesMenos.add(ocupacion[ocupacion.length - 1]);
        barDataSetMenos.setData(valuesMenos);

        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgb(110, 17, 17)");
        bgColor.add("rgb(180, 20, 12)");
        bgColor.add("rgb(143, 145, 152)");
        barDataSetMas.setBackgroundColor(bgColor);
        barDataSetMenos.setBackgroundColor(bgColor);

        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 255, 255)");
        borderColor.add("rgb(255, 255, 255)");
        borderColor.add("rgb(255, 255, 255)");
        barDataSetMas.setBorderColor(borderColor);
        barDataSetMenos.setBorderColor(borderColor);
        barDataSetMas.setBorderWidth(2);
        barDataSetMenos.setBorderWidth(2);

        dataMas.addChartDataSet(barDataSetMas);
        dataMenos.addChartDataSet(barDataSetMenos);

        List<String> labelsMas = new ArrayList<>();
        labelsMas.add(valoresLabels.get(ocupacion[0]));
        labelsMas.add(valoresLabels.get(ocupacion[1]));
        labelsMas.add(valoresLabels.get(ocupacion[2]));

        List<String> labelsMenos = new ArrayList<>();
        labelsMenos.add(valoresLabels.get(ocupacion[ocupacion.length - 3]));
        labelsMenos.add(valoresLabels.get(ocupacion[ocupacion.length - 2]));
        labelsMenos.add(valoresLabels.get(ocupacion[ocupacion.length - 1]));

        dataMas.setLabels(labelsMas);
        dataMenos.setLabels(labelsMenos);
        horariosMas.setData(dataMenos);
        horariosMenos.setData(dataMas);
    }

    public void ocupacionProgramas() {
        ChartData data = new ChartData();
        reservasPrograma = new HorizontalBarChartModel();
        HorizontalBarChartDataSet hbarDataSet = new HorizontalBarChartDataSet();
        hbarDataSet.setLabel("Cantidad de reservas");

        List<Number> values = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        List<Ocupacion> reservas = services.reservasPorPrograma();

        for(Ocupacion reserva : reservas) {
            values.add(reserva.getValor());
            labels.add(reserva.getFiltro());
        }

        hbarDataSet.setData(values);

        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgb(110, 17, 17)");
        bgColor.add("rgb(180, 20, 12)");
        bgColor.add("rgb(143, 145, 152)");
        bgColor.add("rgb(213, 48, 40)");
        bgColor.add("rgb(211, 110, 31)");
        hbarDataSet.setBackgroundColor(bgColor);

        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 255, 255)");
        borderColor.add("rgb(255, 255, 255)");
        borderColor.add("rgb(255, 255, 255)");
        borderColor.add("rgb(255, 255, 255)");
        borderColor.add("rgb(255, 255, 255)");
        hbarDataSet.setBorderColor(borderColor);
        hbarDataSet.setBorderWidth(2);

        data.addChartDataSet(hbarDataSet);
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

    public void graficoReservas(){
        try {
            ChartData dataReservas = new ChartData();
            DonutChartDataSet dataSetReservas = new DonutChartDataSet();
            List<Number> reservas = new ArrayList<>();

            reservas.add(services.buscarReservasReportes(1).size());
            reservas.add(services.buscarReservasReportes(2).size());
            dataSetReservas.setData(reservas);

            List<String> bgColors = new ArrayList<>();
            bgColors.add("rgb(110, 17, 17)");
            bgColors.add("rgb(143, 145, 152)");
            dataSetReservas.setBackgroundColor(bgColors);

            dataReservas.addChartDataSet(dataSetReservas);
            List<String> labelsReservas = new ArrayList<>();
            labelsReservas.add("Recurrentes");
            labelsReservas.add("Canceladas");
            dataReservas.setLabels(labelsReservas);

            donaReservas.setData(dataReservas);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
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

    public int getFiltroReservas() {
        return filtroReservas;
    }

    public void setFiltroReservas(int filtroReservas) {
        this.filtroReservas = filtroReservas;
    }

    public List<Reserva> getReservasReportes() {
        return reservasReportes;
    }

    public void setReservasReportes(List<Reserva> reservasReportes) {
        this.reservasReportes = reservasReportes;
    }

    public DonutChartModel getDonaReservas() {
        return donaReservas;
    }

    public void setDonaReservas(DonutChartModel donaReservas) {
        this.donaReservas = donaReservas;
    }
}
