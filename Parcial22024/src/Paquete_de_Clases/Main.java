package Paquete_de_Clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Cliente> clientes = new ArrayList<>();

        try {
            System.out.print("Ingrese el número de clientes: ");
            int n = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n; i++) {
                System.out.println("\nCliente " + (i + 1) + ":");
                System.out.print("Nombre: ");
                String nombre = reader.readLine();

                System.out.print("Sexo: ");
                String sexo = reader.readLine();

                int edad = 0;
                boolean edadValida = false;

                while (!edadValida) {
                    System.out.print("Edad: ");
                    String edadStr = reader.readLine();
                    try {
                        edad = Integer.parseInt(edadStr);
                        if (edad >= 0 && edad <= 130) {
                            edadValida = true;
                        } else {
                            System.out.println("Edad inválida. Por favor, ingrese una edad razonable (0-130).");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                    }
                }

                LocalDate fechaCumpleanos = null;
                boolean fechaValida = false;

                while (!fechaValida) {
                    System.out.print("Fecha de cumpleaños (dd-MM): ");
                    String fechaCumpleStr = reader.readLine();

                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");
                        MonthDay monthDay = MonthDay.parse(fechaCumpleStr, formatter);
                        fechaCumpleanos = monthDay.atYear(LocalDate.now().getYear());
                        fechaValida = true;
                    } catch (DateTimeParseException e) {
                        System.out.println("Fecha de cumpleaños inválida. Intente de nuevo.");
                    }
                }

                Cliente cliente = new Cliente(nombre, sexo, edad, fechaCumpleanos);
                cliente.setPrediccion(Prediccion.obtenerPrediccion(cliente.getFechaCumpleanos()));
                cliente.setNumerosDeLaSuerte(generarNumerosDeLaSuerte());

                clientes.add(cliente);
            }

            // Imprimir datos de los clientes
            for (Cliente cliente : clientes) {
                System.out.println("\nDatos del Cliente:");
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Sexo: " + cliente.getSexo());
                System.out.println("Edad: " + cliente.getEdad());
                System.out.println("Fecha de Cumpleaños: " + cliente.getFechaCumpleanos().format(DateTimeFormatter.ofPattern("dd-MM")));
                System.out.println("Predicción: " + cliente.getPrediccion());
                System.out.println("Números de la Suerte: " + String.join(", ", cliente.getNumerosDeLaSuerte()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] generarNumerosDeLaSuerte() {
        Random random = new Random();
        String[] numeros = new String[3];
        for (int i = 0; i < 3; i++) {
            int numero = random.nextInt(100);
            numeros[i] = String.format("%02d", numero);
        }
        return numeros;
    }
}
