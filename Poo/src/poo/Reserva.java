/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo;

/**
 *
 * @author USUARIO
 */
import java.util.Scanner;

// Clase que representa una Sala de Cine
class Sala {
    private final boolean[] asientos;
    
    public Sala(int capacidad) {
        asientos = new boolean[capacidad]; // false indica que el asiento está libre
    }
    
    public boolean reservarAsiento(int numAsiento) {
        if (numAsiento < 0 || numAsiento >= asientos.length) {
            System.out.println("Número de asiento inválido.");
            return false;
        }
        if (asientos[numAsiento]) {
            System.out.println("El asiento ya está ocupado.");
            return false;
        }
        asientos[numAsiento] = true;
        System.out.println("Asiento " + numAsiento + " reservado con éxito.");
        return true;
    }
    
    public boolean hayAsientosDisponibles() {
        for (boolean asiento : asientos) {
            if (!asiento) {
                return true;
            }
        }
        return false;
    }
    
    public void mostrarAsientos() {
        System.out.print("Estado de asientos: ");
        for (int i = 0; i < asientos.length; i++) {
            System.out.print((asientos[i] ? "[X]" : "[O]") + " ");
        }
        System.out.println();
    }
}

// Clase principal con el menú
public class Reserva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sala sala = new Sala(10); // Sala con 10 asientos
        
        while (true) {
            System.out.println("\n--- Menú de Reservas ---");
            System.out.println("1. Ver asientos disponibles");
            System.out.println("2. Reservar un asiento");
            System.out.println("3. Reiniciar sala");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1 -> sala.mostrarAsientos();
                case 2 -> {
                    if (!sala.hayAsientosDisponibles()) {
                        System.out.println("No hay asientos disponibles.");
                        break;
                    }
                    System.out.print("Ingrese el número de asiento (0-9): ");
                    int numAsiento = scanner.nextInt();
                    sala.reservarAsiento(numAsiento);
                }
                case 3 -> {
                    sala = new Sala(10);
                    System.out.println("La sala ha sido reiniciada.");
                }
                case 4 -> {
                    System.out.println("Saliendo del sistema de reservas...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}

