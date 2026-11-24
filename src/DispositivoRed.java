public class DispositivoRed {

    private String nombre;
    private String direccionIP;
    private String tipo;
    private boolean activo;

    public DispositivoRed(String nombre, String direccionIP, String tipo, boolean activo) {
        this.nombre = nombre;
        this.direccionIP = direccionIP;
        this.tipo = tipo;
        this.activo = activo;
    }

    public String getDireccionIP() {
        return direccionIP;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isActivo() {
        return activo;
    }

    public String mostrarInformacion() {
        return "Nombre: " + nombre +
                "\nIP: " + direccionIP +
                "\nTipo: " + tipo +
                "\nEstado: " + (activo ? "Activo" : "Inactivo");
    }
}
