/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package temperatura;

/**
 *
 * @author USUARIO
 */

class Invernadero {
    private double temperatura;
    
    // Método para establecer la temperatura actual
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    
    // Método que verifica y devuelve el estado del sistema según la temperatura
    public String verificarEstado() {
        if (temperatura < 10) {
            return "Temperatura baja. Activando calefactor...";
        } else if (temperatura > 25) {
            return "Temperatura alta. Activando ventilador...";
        } else {
            return "Temperatura estable. Sistema inactivo.";
        }
    }
}

public class Temperatura {
    public static void main(String[] args) throws InterruptedException {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Invernadero invernadero = new Invernadero();
        
        while (true) {
            System.out.println("\n=== Control de Temperatura en el Invernadero ===");
            System.out.println("1. Iniciar monitoreo");
            System.out.println("2. Reiniciar sistema");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    for (int i = 0; i < 5; i++) { // Simula 5 lecturas del sensor
                        System.out.print("Ingrese la temperatura actual: ");
                        double temp = scanner.nextDouble();
                        invernadero.setTemperatura(temp);
                        System.out.println(invernadero.verificarEstado());
                        Thread.sleep(5000); // Simula espera de 5 segundos entre lecturas
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

