import java.time.LocalDate;
import java.time.LocalTime;

public class Servicio {
    private LocalDate fecha;
    private LocalTime hora;
    private String biciSerial;
    private String mecanicoResponsable;
    private String motivo;
    private String diagnostico;
    private String trabajosRealizados;
    private double costoTotal;

    public Servicio(LocalDate fecha, LocalTime hora, String biciSerial, String mecanicoResponsable,
                    String motivo, String diagnostico, String trabajosRealizados, double costoTotal) {
        this.fecha = fecha;
        this.hora = hora;
        this.biciSerial = biciSerial;
        this.mecanicoResponsable = mecanicoResponsable;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.trabajosRealizados = trabajosRealizados;
        this.costoTotal = costoTotal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getBiciSerial() {
        return biciSerial;
    }

    public void setBiciSerial(String biciSerial) {
        this.biciSerial = biciSerial;
    }

    public String getMecanicoResponsable() {
        return mecanicoResponsable;
    }

    public void setMecanicoResponsable(String mecanicoResponsable) {
        this.mecanicoResponsable = mecanicoResponsable;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTrabajosRealizados() {
        return trabajosRealizados;
    }

    public void setTrabajosRealizados(String trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String mostrarInfo(){
        return "Servicio [fecha= " + fecha + ", hora= " + hora + ", serial= " + biciSerial + ", mecanico= " + mecanicoResponsable + ", motivo= " + motivo + ", diagnostico= " + diagnostico + ", trabajos hechos= " + trabajosRealizados + ", costo total= " + costoTotal + "]\n";
    }
}
