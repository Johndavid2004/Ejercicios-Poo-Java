/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aireacondicionado;

/**
 *
 * @author USUARIO
 */
class SensorAmbiente {
    private double temperatura;
    private double humedad;
    
    public SensorAmbiente() {
        this.temperatura = 25.0;
        this.humedad = 50.0;
    }
    
    public void leerSensores() {
        this.temperatura = 25 + Math.random() * 10;
        this.humedad = 40 + Math.random() * 40;
    }
    
    public double getTemperatura() {
        return temperatura;
    }
    
    public double getHumedad() {
        return humedad;
    }
}

class SistemaAireAcondicionado {
    private boolean aireEncendido;
    private SensorAmbiente sensor;
    
    public SistemaAireAcondicionado() {
        this.aireEncendido = false;
        this.sensor = new SensorAmbiente();
    }
    
    public void actualizarEstado() {
        sensor.leerSensores();
        double temperatura = sensor.getTemperatura();
        double humedad = sensor.getHumedad();
        
        if ((temperatura > 28 && humedad > 60) || temperatura > 30) {
            aireEncendido = true;
        } else {
            aireEncendido = false;
        }
    }
    
    public void mostrarEstado() {
        System.out.println("\nEstado del sistema de aire acondicionado:");
        System.out.println("Temperatura: " + sensor.getTemperatura() + "°C");
        System.out.println("Humedad: " + sensor.getHumedad() + "%");
        System.out.println("Aire Acondicionado: " + (aireEncendido ? "ENCENDIDO ❄️" : "APAGADO 🔥"));
    }
}

public class ControlAire {
    public static void main(String[] args) {
        SistemaAireAcondicionado sistema = new SistemaAireAcondicionado();
        java.util.Scanner entrada = new java.util.Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Menú del Sistema de Aire Acondicionado ===");
            System.out.println("1. Simular lectura de sensores");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    sistema.actualizarEstado();
                    sistema.mostrarEstado();
                    try {
                        Thread.sleep(5000); 
                    } catch (InterruptedException e) {
                        System.out.println("Error en la simulación.");
                    }
                }
                case 2 -> {
                    System.out.println("Saliendo del sistema de control de aire acondicionado...");
                    entrada.close();
                    return;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}

