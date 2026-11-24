public class Main {

    public static void main(String[] args) {

        // Crear dispositivos independientemente
        DispositivoRed r1 = new DispositivoRed("RouterCentral", "192.168.1.1", "Router", true);
        DispositivoRed s1 = new DispositivoRed("Switch01", "192.168.1.10", "Switch", true);
        DispositivoRed s2 = new DispositivoRed("Switch02", "192.168.1.11", "Switch", false);
        DispositivoRed ap1 = new DispositivoRed("AccessPoint01", "192.168.1.20", "Access Point", true);
        DispositivoRed srv1 = new DispositivoRed("Servidor01", "192.168.1.30", "Servidor", true);

        // Crear red
        Red red = new Red("Laboratorio");

        // Mostrar red vacía
        System.out.println("===== RED VACÍA =====");
        System.out.println(red.mostrarDispositivos());

        // Agregar dispositivos
        red.agregarDispositivo(r1);
        red.agregarDispositivo(s1);
        red.agregarDispositivo(s2);
        red.agregarDispositivo(ap1);
        red.agregarDispositivo(srv1);

        // Mostrar dispositivos
        System.out.println("\n===== DISPOSITIVOS REGISTRADOS =====");
        System.out.println(red.mostrarDispositivos());

        // Buscar IP existente
        System.out.println("\n===== BÚSQUEDA DE IP EXISTENTE =====");
        DispositivoRed encontrado = red.buscarPorIP("192.168.1.1");

        if (encontrado != null) {
            System.out.println(encontrado.mostrarInformacion());
        } else {
            System.out.println("Dispositivo no encontrado.");
        }

        // Buscar IP inexistente
        System.out.println("\n===== BÚSQUEDA DE IP INEXISTENTE =====");
        encontrado = red.buscarPorIP("192.168.1.99");

        if (encontrado != null) {
            System.out.println(encontrado.mostrarInformacion());
        } else {
            System.out.println("Dispositivo no encontrado.");
        }

        // Eliminar dispositivo existente
        System.out.println("\n===== ELIMINAR DISPOSITIVO EXISTENTE =====");
        System.out.println("Eliminado: " + red.eliminarDispositivo("192.168.1.11"));

        // Eliminar dispositivo inexistente
        System.out.println("\n===== ELIMINAR DISPOSITIVO INEXISTENTE =====");
        System.out.println("Eliminado: " + red.eliminarDispositivo("192.168.1.99"));

        // Contar dispositivos activos
        System.out.println("\n===== DISPOSITIVOS ACTIVOS =====");
        System.out.println("Cantidad de activos: " + red.contarActivos());

        // Contar dispositivos por tipo
        System.out.println("\n===== CONTEO POR TIPO =====");
        System.out.println("Cantidad de Switches: " + red.contarPorTipo("Switch"));

        // Buscar primer dispositivo activo por tipo
        System.out.println("\n===== BUSCAR ACTIVO POR TIPO =====");
        DispositivoRed activo = red.buscarActivoPorTipo("Router");

        if (activo != null) {
            System.out.println(activo.mostrarInformacion());
        } else {
            System.out.println("No se encontró un dispositivo activo de ese tipo.");
        }

        // Mostrar estado final de la red
        System.out.println("\n===== ESTADO FINAL DE LA RED =====");
        System.out.println(red.mostrarDispositivos());
    }
}