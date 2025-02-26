/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javabasico;

/**
 *
 * @author USUARIO
 */
import java.util.Scanner;
public class Ejercicio1 {
    public static void main(String[] args) {
        ejecutar();
    }
    
    public static void ejecutar() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("================================");
            System.out.println("        CREACIÓN DE FACTURA");
            System.out.println("================================");
            
            String cliente = tomarNombreCliente(scanner);
            String producto = tomarProducto(scanner);
            int cantidad = tomarCantidad(scanner);
            double precioUnitario = tomarPrecioUnitario(scanner);
            boolean esEstudiante = tomarEstadoEstudiante(scanner);
            char tipoCliente = tomarTipoCliente(scanner);
            
            double subtotal = calcularSubtotal(cantidad, precioUnitario);
            double impuesto = calcularImpuesto(subtotal, esEstudiante);
            double total = calcularTotal(subtotal, impuesto);
            
            mostrarFactura(cliente, producto, cantidad, precioUnitario, esEstudiante, tipoCliente, subtotal, impuesto, total);
        }
    }
    
    public static String tomarNombreCliente(Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        return scanner.nextLine();
    }
    
    public static String tomarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        return scanner.nextLine();
    }
    
    public static int tomarCantidad(Scanner scanner) {
        System.out.print("Ingrese la cantidad de productos: ");
        return scanner.nextInt();
    }
    
    public static double tomarPrecioUnitario(Scanner scanner) {
        System.out.print("Ingrese el precio unitario del producto: ");
        return scanner.nextDouble();
    }
    
    public static boolean tomarEstadoEstudiante(Scanner scanner) {
        System.out.print("¿El cliente es estudiante? (true/false): ");
        return scanner.nextBoolean();
    }
    
    public static char tomarTipoCliente(Scanner scanner) {
        System.out.print(" Por favor. Ingrese el tipo de cliente (A, B, C, etc.): ");
        return scanner.next().charAt(0);
    }
    
    public static double calcularSubtotal(int cantidad, double precioUnitario) {
        return cantidad * precioUnitario;
    }
    
    public static double calcularImpuesto(double subtotal, boolean esEstudiante) {
        return esEstudiante ? subtotal * 0.05 : subtotal * 0.13;
    }
    
    public static double calcularTotal(double subtotal, double impuesto) {
        return subtotal + impuesto;
    }
    
    public static void mostrarFactura(String cliente, String producto, int cantidad, double precioUnitario, 
                                      boolean esEstudiante, char tipoCliente, double subtotal, double impuesto, double total) {
        
        System.out.println("================================ FACTURA GENERADA ================================");
        System.out.println("Nombre del Cliente: " + cliente);
        System.out.println("Nombre del Producto: " + producto);
        System.out.println("Cantidad dl producto: " + cantidad);
        System.out.println("Precio unitario: $" + precioUnitario);
        System.out.println("Tipo de cliente: " + tipoCliente);
        System.out.println("Es estudiante: " + (esEstudiante ? "Sí" : "No"));
        System.out.println("Subtotal de la compra: $" + subtotal);
        System.out.println("Impuesto de la compra: $" + impuesto);
        System.out.println("Total a pagar de la compra: $" + total);
    }
}
