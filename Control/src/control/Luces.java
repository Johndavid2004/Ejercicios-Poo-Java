/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

/**
 *
 * @author USUARIO
 */

class SensorMovimiento {
    private boolean movimiento;
    
    public SensorMovimiento() {
        this.movimiento = false;
    }
    
    public void detectarMovimiento() {
        this.movimiento = Math.random() > 0.5;
    }
    
    public boolean hayMovimiento() {
        return movimiento;
    }
}

class SistemaLuces {
    private boolean esDeNoche;
    private boolean lucesEncendidas;
    private final SensorMovimiento sensor;
    
    public SistemaLuces() {
        this.esDeNoche = true; 
        this.lucesEncendidas = false;
        this.sensor = new SensorMovimiento();
    }
    
    public void actualizarEstado() {
        sensor.detectarMovimiento();
        
        if (esDeNoche && sensor.hayMovimiento()) {
            lucesEncendidas = true;
        } else {
            lucesEncendidas = false;
        }
    }
    
    public void mostrarEstado() {
        System.out.println("\nEstado del sistema de luces:");
        System.out.println("Es de noche: " + (esDeNoche ? "Sí 🌙" : "No ☀️"));
        System.out.println("Movimiento detectado: " + (sensor.hayMovimiento() ? "Sí 🚶" : "No ❌"));
        System.out.println("Luces: " + (lucesEncendidas ? "ENCENDIDAS 💡" : "APAGADAS 🌑"));
    }
    
    public void alternarDiaNoche() {
        esDeNoche = !esDeNoche;
        System.out.println("Se ha cambiado a " + (esDeNoche ? "noche 🌙" : "día ☀️"));
    }
}

public class Luces {
    public static void main(String[] args) {
        SistemaLuces sistema = new SistemaLuces();
        java.util.Scanner entrada = new java.util.Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Menú del Sistema de Luces ===");
            System.out.println("1. Simular sistema de luces (actualización cada 10 segundos)");
            System.out.println("2. Alternar entre día y noche");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    for (int i = 0; i < 3; i++) { 
                        sistema.actualizarEstado();
                        sistema.mostrarEstado();
                        try {
                            Thread.sleep(10000); 
                        } catch (InterruptedException e) {
                            System.out.println("Error en la simulación.");
                        }
                    }
                }
                case 2 -> sistema.alternarDiaNoche();
                case 3 -> {
                    System.out.println("Saliendo del sistema de control de luces...");
                    entrada.close();
                    return;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}


