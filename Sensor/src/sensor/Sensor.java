/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sensor;

/**
 *
 * @author USUARIO
 */
class SistemaSeguridad {
    private boolean sensor1;
    private boolean sensor2;
    private boolean sensor3;
    private boolean esDeNoche;
    
    // Método para configurar los sensores y la hora del día
    public void setDatos(boolean s1, boolean s2, boolean s3, boolean noche) {
        this.sensor1 = s1;
        this.sensor2 = s2;
        this.sensor3 = s3;
        this.esDeNoche = noche;
    }
    
    // Método que verifica si la alarma debe activarse
    public String verificarAlarma() {
        int sensoresActivados = (sensor1 ? 1 : 0) + (sensor2 ? 1 : 0) + (sensor3 ? 1 : 0);
        if (sensoresActivados >= 2 && esDeNoche) {
            return "¡Alarma activada! Movimiento detectado de noche.";
        } else {
            return "Sistema en calma. No hay amenaza detectada.";
        }
    }
}

public class Sensor {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        SistemaSeguridad sistema = new SistemaSeguridad();
        
        while (true) {
            System.out.println("\n=== Sistema de Detección de Intrusos ===");
            System.out.println("1. Simular detección");
            System.out.println("2. Reiniciar sistema");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    System.out.print("Sensor 1 detecta movimiento? (true/false): ");
                    boolean s1 = scanner.nextBoolean();
                    System.out.print("Sensor 2 detecta movimiento? (true/false): ");
                    boolean s2 = scanner.nextBoolean();
                    System.out.print("Sensor 3 detecta movimiento? (true/false): ");
                    boolean s3 = scanner.nextBoolean();
                    System.out.print("Es de noche? (true/false): ");
                    boolean noche = scanner.nextBoolean();
                    
                    sistema.setDatos(s1, s2, s3, noche);
                    System.out.println(sistema.verificarAlarma());
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

