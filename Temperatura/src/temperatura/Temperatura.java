/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package temperatura;

/**
 *
 * @author USUARIO
 */

class SensorTemperatura {
    private double temperatura;
    
    public SensorTemperatura() {
        this.temperatura = 20.0; 
    }
    
    public double leerTemperatura() {
        temperatura += (Math.random() * 10 - 5);
        return Math.round(temperatura * 100.0) / 100.0; 
    }
}

class ControladorInvernadero {
    private final SensorTemperatura sensor;
    
    public ControladorInvernadero() {
        this.sensor = new SensorTemperatura();
    }
    
    public void verificarTemperatura() {
        double temp = sensor.leerTemperatura();
        System.out.println("\nTemperatura actual: " + temp + "°C");
        
        if (temp < 10) {
            System.out.println("Estado: Calefactor ACTIVADO ❄️🔥");
        } else if (temp <= 25) {
            System.out.println("Estado: Sistema INACTIVO ✅");
        } else {
            System.out.println("Estado: Ventilador ACTIVADO 🌬️");
        }
    }
}

public class Temperatura {
    public static void main(String[] args) {
        ControladorInvernadero controlador = new ControladorInvernadero();
        java.util.Scanner entrada = new java.util.Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Menú de Control de Invernadero ===");
            System.out.println("1. Leer temperatura y verificar estado");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    controlador.verificarTemperatura();
                    try {
                        Thread.sleep(5000); 
                    } catch (InterruptedException e) {
                        System.out.println("Error en la simulación del sensor.");
                    }
                }
                case 2 -> {
                    System.out.println("Saliendo del sistema de control de temperatura...");
                    entrada.close();
                    return;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}

