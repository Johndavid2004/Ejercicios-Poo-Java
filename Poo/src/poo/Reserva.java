/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo;

/**
 *
 * @author USUARIO
 */
class Cine {
    private final boolean[] butacas;
    
    public Cine(int totalAsientos) {
        butacas = new boolean[totalAsientos];
    }
    
    public boolean ocuparAsiento(int asiento) {
        if (asiento < 0 || asiento >= butacas.length) {
            System.out.println(" !Error¡. Número de asiento incorrecto.");
            return false;
        }
        if (butacas[asiento]) {
            System.out.println("Esta silla ya se encuentra ocupada.");
            return false;
        }
        butacas[asiento] = true;
        System.out.println(" Silla " + asiento + " reservada correctamente.");
        return true;
    }
    
    public boolean quedanAsientosLibres() {
        for (boolean ocupado : butacas) {
            if (!ocupado) {
                return true;
            }
        }
        return false;
    }
    
    public void visualizarButacas() {
        System.out.print("Estado de las butacas: ");
        for (int i = 0; i < butacas.length; i++) {
            System.out.print((butacas[i] ? "[X]" : "[O]") + " ");
        }
        System.out.println();
    }
}

public class Reserva {
    public static void main(String[] args) {
        java.util.Scanner entrada = new java.util.Scanner(System.in);
        Cine cine = new Cine(10);
        
        while (true) {
            System.out.println("\n--- Opciones de Reserva ---");
            System.out.println("1. Mostrar asientos");
            System.out.println("2. Hacer una reserva");
            System.out.println("3. Restablecer asientos");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            int eleccion = entrada.nextInt();
            
            switch (eleccion) {
                case 1 -> cine.visualizarButacas();
                case 2 -> {
                    if (!cine.quedanAsientosLibres()) {
                        System.out.println(" !!Lo siento¡¡. Ya no quedan sillas disponibles.");
                        break;
                    }
                    System.out.print("Seleccione el número de silla que desea (0-9): ");
                    int asiento = entrada.nextInt();
                    cine.ocuparAsiento(asiento);
                }
                case 3 -> {
                    cine = new Cine(10);
                    System.out.println("Las sillas han sido restablecidas.");
                }
                case 4 -> {
                    System.out.println("Cerrando el sistema de reservas...");
                    entrada.close();
                    return;
                }
                default -> System.out.println("Opción no reconocida, intente de nuevo.");
            }
        }
    }
}
