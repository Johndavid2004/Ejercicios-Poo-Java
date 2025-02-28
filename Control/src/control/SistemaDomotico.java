/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

/**
 *
 * @author USUARIO
 */

class ControlLuces {
    private boolean esDeNoche;
    private boolean hayMovimiento;
    
    // Método para actualizar las condiciones del sistema
    public void setCondiciones(boolean noche, boolean movimiento) {
        this.esDeNoche = noche;
        this.hayMovimiento = movimiento;
    }
    
    // Método que determina el estado de las luces
    public String verificarLuces() {
        if (esDeNoche && hayMovimiento) {
            return "Luces encendidas. Movimiento detectado de noche.";
        } else {
            return "Luces apagadas.";
        }
    }
}

public class SistemaDomotico {
    public static void main(String[] args) throws InterruptedException {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        ControlLuces control = new ControlLuces();
        
        while (true) {
            System.out.println("\n=== Sistema de Control de Luces Automático ===");
            System.out.println("1. Simular condición actual");
            System.out.println("2. Reiniciar sistema");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    System.out.print("Es de noche? (true/false): ");
                    boolean noche = scanner.nextBoolean();
                    System.out.print("Hay movimiento en la habitación? (true/false): ");
                    boolean movimiento = scanner.nextBoolean();
                    
                    control.setCondiciones(noche, movimiento);
                    for (int i = 0; i < 3; i++) { // Simula 3 ciclos de verificación cada 10 segundos
                        System.out.println(control.verificarLuces());
                        Thread.sleep(10000); // Espera de 10 segundos
                    }
                }
                case 2 -> System.out.println("Sistema reiniciado.");
                case 3 -> {
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }
}
