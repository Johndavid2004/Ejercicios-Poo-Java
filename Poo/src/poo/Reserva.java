/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo;

/**
 *
 * @author USUARIO
 */

class SalaCine {
    private final boolean[] asientos;
    private final int totalAsientos;
    
    public SalaCine(int totalAsientos) {
        this.totalAsientos = totalAsientos;
        this.asientos = new boolean[totalAsientos];
    }
    
    public boolean asignarAsiento(int numero) {
        if (numero >= 0 && numero < totalAsientos && !asientos[numero]) {
            asientos[numero] = true;
            return true;
        }
        return false;
    }
    
    public int contarAsientosLibres() {
        int disponibles = 0;
        for (boolean ocupado : asientos) {
            if (!ocupado) disponibles++;
        }
        return disponibles;
    }
}

class Cliente {
    private final String nombre;
    private int asientoAsignado;
    
    public Cliente(String nombre) {
        this.nombre = nombre;
        this.asientoAsignado = -1;
    }
    
    public String obtenerNombre() {
        return nombre;
    }
    
    public int obtenerAsiento() {
        return asientoAsignado;
    }
    
    public void asignarAsiento(int asiento) {
        this.asientoAsignado = asiento;
    }
}

public class Reserva {
    public static void main(String[] args) {
        java.util.Scanner entrada = new java.util.Scanner(System.in);
        SalaCine sala = new SalaCine(10);
        
        while (true) {
            System.out.println("\n=== Gestión de Reservas de Cine ===");
            System.out.println("1. Hacer una reserva");
            System.out.println("2. Ver disponibilidad de asientos");
            System.out.println("3. Salir del sistema");
            System.out.print("Seleccione una opción: ");
            int eleccion = entrada.nextInt();
            
            switch (eleccion) {
                case 1 -> {
                    System.out.print("Ingrese su nombre: ");
                    String nombre = entrada.next();
                    Cliente cliente = new Cliente(nombre);
                    
                    System.out.print("Seleccione el número de asiento (0-9): ");
                    int numeroAsiento = entrada.nextInt();
                    
                    if (sala.asignarAsiento(numeroAsiento)) {
                        cliente.asignarAsiento(numeroAsiento);
                        System.out.println("Reserva confirmada para " + cliente.obtenerNombre() + ". Asiento: " + cliente.obtenerAsiento());
                    } else {
                        System.out.println("El asiento está ocupado o fuera de rango.");
                    }
                }
                case 2 -> System.out.println("Asientos libres: " + sala.contarAsientosLibres());
                case 3 -> {
                    System.out.println("Cerrando sistema de reservas...");
                    entrada.close();
                    return;
                }
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }
        }
    }
}
