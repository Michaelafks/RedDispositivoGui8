import java.util.ArrayList;

public class Red {

    private String nombre;
    private ArrayList<DispositivoRed> dispositivos;

    public Red(String nombre) {
        this.nombre = nombre;
        dispositivos = new ArrayList<>();
    }

    public void agregarDispositivo(DispositivoRed dispositivo) {
        if (dispositivo != null) {
            dispositivos.add(dispositivo);
        }
    }

    public DispositivoRed buscarPorIP(String direccionIP) {
        for (DispositivoRed dispositivo : dispositivos) {
            if (dispositivo.getDireccionIP().equals(direccionIP)) {
                return dispositivo;
            }
        }
        return null;
    }

    public boolean eliminarDispositivo(String direccionIP) {
        DispositivoRed dispositivo = buscarPorIP(direccionIP);

        if (dispositivo != null) {
            return dispositivos.remove(dispositivo);
        }

        return false;
    }

    public int contarActivos() {
        int contador = 0;

        for (DispositivoRed dispositivo : dispositivos) {
            if (dispositivo.isActivo()) {
                contador++;
            }
        }

        return contador;
    }

    public int contarPorTipo(String tipo) {
        int contador = 0;

        for (DispositivoRed dispositivo : dispositivos) {
            if (dispositivo.getTipo().equals(tipo)) {
                contador++;
            }
        }

        return contador;
    }

    public String mostrarDispositivos() {
        String resultado = "Red: " + nombre + "\n";

        if (dispositivos.isEmpty()) {
            return resultado + "No hay dispositivos registrados.";
        }

        for (DispositivoRed dispositivo : dispositivos) {
            resultado += "\n-------------------------\n";
            resultado += dispositivo.mostrarInformacion() + "\n";
        }

        return resultado;
    }

    public DispositivoRed buscarActivoPorTipo(String tipo) {
        for (DispositivoRed dispositivo : dispositivos) {
            if (dispositivo.getTipo().equals(tipo) && dispositivo.isActivo()) {
                return dispositivo;
            }
        }

        return null;
    }
}
