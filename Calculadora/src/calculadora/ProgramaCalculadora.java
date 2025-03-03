/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

/**
 *
 * @author USUARIO
 */

class Calculadora {
    // Método para realizar operaciones matemáticas básicas
    public double operar(double num1, double num2, char operacion) {
        return switch (operacion) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> (num2 != 0) ? num1 / num2 : Double.NaN;
            default -> Double.NaN;
        }; // Evita la división por cero
        // Retorna NaN si la operación no es válida
    }
}

class InterfazCalculadora {
    private final Calculadora calculadora;
    
    public InterfazCalculadora() {
        calculadora = new Calculadora();
    }
    
    public void mostrarMenu() {
        System.out.println("\n=== Menú de Calculadora ===");
        System.out.println("1. Realizar una operación");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    public void iniciar() {
        java.util.Scanner entrada = new java.util.Scanner(System.in);
        
        while (true) {
            mostrarMenu();
            int opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el primer número: ");
                    double num1 = entrada.nextDouble();
                    System.out.print("Ingrese el segundo número: ");
                    double num2 = entrada.nextDouble();
                    System.out.print("Ingrese la operación (+, -, *, /): ");
                    char operacion = entrada.next().charAt(0);
                    
                    double resultado = calculadora.operar(num1, num2, operacion);
                    System.out.println("Resultado: " + resultado);
                }
                case 2 -> {
                    System.out.println("Saliendo de la calculadora...");
                    entrada.close();
                    return;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}

public class ProgramaCalculadora {
    public static void main(String[] args) {
        InterfazCalculadora interfaz = new InterfazCalculadora();
        interfaz.iniciar();
    }
}
