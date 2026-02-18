public class Mecanico {
    private String id;
    private String nombre;
    private String especialidad;
    private String certificado;
    private double ingreso;

    public Mecanico(String id, String nombre, String especialidad, String certificado, double ingreso){
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.certificado = certificado;
    }

    public String getId(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getCertificado() {
        return certificado;
    }

    public double getIngreso(){
        return ingreso;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public void setIngreso(double ingreso){
        this.ingreso += ingreso;
    }

    public String mostrarInfo(){
        return "Mecanico [id= " + id + ", nombre= " + nombre + ", especialidad= " + especialidad + ", certificado= " + certificado + ", ingreso= " + ingreso + "]\n";
    }

    public String mostrarIngreso(){
        return " Tiene un ingreso actualmente de: " + ingreso;
    }
}
