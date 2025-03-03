/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fizzbuzz;

/**
 *
 * @author USUARIO
 */

class FizzBuzz {
    // Método para evaluar cada número y devolver el resultado correspondiente
    public String procesarNumero(int numero) {
        if (numero % 3 == 0 && numero % 5 == 0) {
            return "FizzBuzz";
        } else if (numero % 3 == 0) {
            return "Fizz";
        } else if (numero % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(numero);
        }
    }
}

class Juego {
    private final FizzBuzz fizzBuzz;
    
    public Juego() {
        fizzBuzz = new FizzBuzz();
    }
    
    public void iniciar() {
        System.out.println("\n=== Juego FizzBuzz ===");
        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzz.procesarNumero(i));
        }
    }
}

public class Fizz {
    public static void main(String[] args) {
        java.util.Scanner entrada = new java.util.Scanner(System.in);
        Juego juego = new Juego();
        
        while (true) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Jugar FizzBuzz");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1 -> juego.iniciar();
                case 2 -> {
                    System.out.println("Saliendo del juego...");
                    entrada.close();
                    return;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
