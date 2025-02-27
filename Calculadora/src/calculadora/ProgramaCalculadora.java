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
    private double numero1;
    private double numero2;
    private char operacion;
    
    // Método para recibir los números y la operación a realizar
    public void ingresarDatos(double num1, double num2, char op) {
        this.numero1 = num1;
        this.numero2 = num2;
        this.operacion = op;
    }
    
    // Método que realiza la operación seleccionada y devuelve el resultado
    public double calcular() {
        return switch (operacion) {
            case '+' -> numero1 + numero2;
            case '-' -> numero1 - numero2;
            case '*' -> numero1 * numero2;
            case '/' -> (numero2 != 0) ? numero1 / numero2 : Double.NaN;
            default -> Double.NaN;
        }; // Suma
        // Resta
        // Multiplicación
        // División con validación para evitar división por cero
        // En caso de operación inválida
    }
}

public class ProgramaCalculadora {
    public static void main(String[] args) {
        java.util.Scanner entrada = new java.util.Scanner(System.in);
        
        while (true) {
            // Menú de opciones para el usuario
            System.out.println("\n=== Bienvenidos a la Calculadora Simple ===");
            System.out.println("1. Realizar cálculo");
            System.out.println("2. intentar de nuevo el cálculo");
            System.out.println("3. Abandonar");
            System.out.print("Seleccione una opción: ");
            int opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    // Solicita los valores al usuario
                    System.out.print("Escribe el primer número: ");
                    double num1 = entrada.nextDouble();
                    System.out.print("Escribe el segundo número: ");
                    double num2 = entrada.nextDouble();
                    System.out.print("Escribe la operación (+, -, *, /): ");
                    char op = entrada.next().charAt(0);
                    
                    // Crea una instancia de la calculadora y realiza el cálculo
                    Calculadora calc = new Calculadora();
                    calc.ingresarDatos(num1, num2, op);
                    double resultado = calc.calcular();
                    
                    // Muestra el resultado o un mensaje de error si la operación no es válida
                    if (Double.isNaN(resultado)) {
                        System.out.println("Operación inválida o división por cero.");
                    } else {
                        System.out.println("El resultado es: " + resultado);
                    }
                }
                case 2 -> System.out.println("Calculadora reiniciada."); // Indica que se puede iniciar un nuevo cálculo
                case 3 -> {
                    System.out.println("haz salido del programa..."); // Termina la ejecución del programa
                    entrada.close();
                    return;
                }
                default -> System.out.println("Opción no válida, intente de nuevo."); // Manejo de opciones incorrectas
            }
        }
    }
}

