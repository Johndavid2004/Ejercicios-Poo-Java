/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fizzbuzz;

/**
 *
 * @author USUARIO
 */

class FizzBuzzJuego {
    private final int inicio;
    private final int limite;

    public FizzBuzzJuego(int inicio, int limite) {
        this.inicio = inicio;
        this.limite = limite;
    }

    public void iniciar() {
        for (int i = inicio; i <= limite; i++) {
            System.out.println(verificarNumero(i));
        }
    }

    private String verificarNumero(int numero) {
        if (numero % 3 == 0 && numero % 5 == 0) {
            return "FizzBuzz";
        } else if (numero % 3 == 0) {
            return "Fizz";
        } else if (numero % 5 == 0) {
            return "Buzz";
        } else {
            return Integer.toString(numero);
        }
    }
}

public class FizzBuzz {
    public static void main(String[] args) {
        java.util.Scanner entrada = new java.util.Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== FizzBuzz ===");
            System.out.println("1. Bienvenidos a FizzBuzz, ¿Desea jugar?");
            System.out.println("2. ¿Desea intentarlo de nuevo?");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    FizzBuzzJuego juego = new FizzBuzzJuego(1, 100);
                    juego.iniciar();
                }
                case 2 -> System.out.println("El juego se ha reiniciado.");
                case 3 -> {
                    System.out.println("Cerrando el programa...");
                    entrada.close();
                    return;
                }
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }
        }
    }
}
