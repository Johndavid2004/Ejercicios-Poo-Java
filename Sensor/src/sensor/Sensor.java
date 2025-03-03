/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sensor;

/**
 *
 * @author USUARIO
 */
class SensorMovimiento {
    private boolean estado;
    
    public SensorMovimiento() {
        this.estado = false;
    }
    
    public void detectarMovimiento() {
        // Simula detección de movimiento aleatoria
        this.estado = Math.random() > 0.5;
    }
    
    public boolean hayMovimiento() {
        return estado;
    }
}

class SistemaSeguridad {
    private final SensorMovimiento sensor1;
    private final SensorMovimiento sensor2;
    private final SensorMovimiento sensor3;
    private boolean esDeNoche;
    private boolean alarmaActivada;
    
    public SistemaSeguridad() {
        this.sensor1 = new SensorMovimiento();
        this.sensor2 = new SensorMovimiento();
        this.sensor3 = new SensorMovimiento();
        this.esDeNoche = true; // Se asume que comienza de noche
        this.alarmaActivada = false;
    }
    
    public void verificarSensores() {
        sensor1.detectarMovimiento();
        sensor2.detectarMovimiento();
        sensor3.detectarMovimiento();
        
        int sensoresActivos = 0;
        if (sensor1.hayMovimiento()) sensoresActivos++;
        if (sensor2.hayMovimiento()) sensoresActivos++;
        if (sensor3.hayMovimiento()) sensoresActivos++;
        
        if (esDeNoche && sensoresActivos >= 2) {
            alarmaActivada = true;
        } else {
            alarmaActivada = false;
        }
    }
    
    public void mostrarEstado() {
        System.out.println("\nEstado del sistema de seguridad:");
        System.out.println("Sensor 1: " + (sensor1.hayMovimiento() ? "Movimiento detectado" : "Sin movimiento"));
        System.out.println("Sensor 2: " + (sensor2.hayMovimiento() ? "Movimiento detectado" : "Sin movimiento"));
        System.out.println("Sensor 3: " + (sensor3.hayMovimiento() ? "Movimiento detectado" : "Sin movimiento"));
        System.out.println("Periodo: " + (esDeNoche ? "Noche 🌙" : "Día ☀️"));
        System.out.println("Alarma: " + (alarmaActivada ? "ACTIVADA 🚨" : "Desactivada ✅"));
    }
    
    public void alternarDiaNoche() {
        esDeNoche = !esDeNoche;
        System.out.println("Ahora es " + (esDeNoche ? "Noche 🌙" : "Día ☀️"));
    }
}

public class Sensor {
    public static void main(String[] args) {
        SistemaSeguridad seguridad = new SistemaSeguridad();
        java.util.Scanner entrada = new java.util.Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Menú del Sistema de Seguridad ===");
            System.out.println("1. Simular detección de movimiento");
            System.out.println("2. Alternar entre día y noche");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    seguridad.verificarSensores();
                    seguridad.mostrarEstado();
                }
                case 2 -> seguridad.alternarDiaNoche();
                case 3 -> {
                    System.out.println("Saliendo del sistema de seguridad...");
                    entrada.close();
                    return;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
