/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tienda;

/**
 *
 * @author USUARIO
 */
class Cliente {
    private final boolean tieneMembresia;
    private final boolean esEmpleado;
    
    public Cliente(boolean tieneMembresia, boolean esEmpleado) {
        this.tieneMembresia = tieneMembresia;
        this.esEmpleado = esEmpleado;
    }
    
    public boolean tieneMembresia() {
        return tieneMembresia;
    }
    
    public boolean esEmpleado() {
        return esEmpleado;
    }
}

class Tienda {
    private final int horaApertura;
    private final int horaCierre;
    
    public Tienda(int apertura, int cierre) {
        this.horaApertura = apertura;
        this.horaCierre = cierre;
    }
    
    public boolean estaAbierta(int horaActual) {
        return horaActual >= horaApertura && horaActual <= horaCierre;
    }
    
    public boolean permitirAcceso(Cliente cliente, int horaActual) {
        return cliente.esEmpleado() || (cliente.tieneMembresia() && estaAbierta(horaActual));
    }
}

public class ControlAccesoTienda {
    public static void main(String[] args) {
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            Tienda tienda = new Tienda(9, 21);
            
            while (true) {
                System.out.println("\n=== Menú de Control de Acceso ===");
                System.out.println("1. Intentar ingresar a la tienda");
                System.out.println("2. Consultar horario de la tienda");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                
                if (opcion == 3) {
                    System.out.println("Saliendo del sistema de control de acceso...");
                    break;
                }
                
                if (opcion == 2) {
                    System.out.println("El horario de la tienda es de 9:00 a 21:00.");
                    continue;
                }
                
                System.out.print("Ingrese la hora actual (0-23): ");
                int horaActual = scanner.nextInt();
                System.out.print("¿Tiene membresía? (true/false): ");
                boolean tieneMembresia = scanner.nextBoolean();
                System.out.print("¿Es empleado? (true/false): ");
                boolean esEmpleado = scanner.nextBoolean();
                
                Cliente cliente = new Cliente(tieneMembresia, esEmpleado);
                
                if (tienda.permitirAcceso(cliente, horaActual)) {
                    System.out.println("Acceso permitido. Bienvenido a la tienda.");
                } else {
                    System.out.println("Acceso denegado. No cumple con los requisitos.");
                }
            }
        }
    }
}
