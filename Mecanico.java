public class Mecanico {
    private String id;
    private String nombre;
    private String especialidad;
    private String certificado;

    public Mecanico(String id, String nombre, String especialidad, String certificado){
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

    public String mostrarInfo(){
        return "Mecanico [id= " + id + ", nombre= " + nombre + ", especialidad= " + especialidad + ", certificado= " + certificado + "]";
    }
}
