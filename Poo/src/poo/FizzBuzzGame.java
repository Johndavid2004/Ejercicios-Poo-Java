/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author USUARIO
 */

class JuegoFizzBuzz {
    private final int inicio;
    private final int fin;

    public JuegoFizzBuzz(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public void ejecutar() {
        for (int i = inicio; i <= fin; i++) {
            System.out.println(analizarNumero(i));
        }
    }

    private String analizarNumero(int numero) {
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

public class FizzBuzzGame {
    public static void main(String[] args) {
        JuegoFizzBuzz juego = new JuegoFizzBuzz(1, 100);
        juego.ejecutar();
    }
}

