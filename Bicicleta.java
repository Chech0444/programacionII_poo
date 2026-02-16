public class Bicicleta {
    private String marca;
    private String tipo;
    private String color;
    private String serial;
    private String año;
    private String clienteCedula;

    public Bicicleta(String marca, String tipo, String color, String serial, String año, String clienteCedula) {
        this.marca = marca;
        this.tipo = tipo;
        this.color = color;
        this.serial = serial;
        this.año = año;
        this.clienteCedula = clienteCedula;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public String getColor() {
        return color;
    }

    public String getSerial() {
        return serial;
    }

    public String getAño() {
        return año;
    }

    public String getCedula(){
        return clienteCedula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public void setClienteCedula(String cedula){
        this.clienteCedula = cedula;
    }

    public String mostrarInfo(){
        return "Bicicleta [marca= " + marca + ", tipo= " + tipo + ", color= " + color + ", serial= " + serial + ", año= " + año + ", cedulaCliente= " + clienteCedula + "]";
    }
}
