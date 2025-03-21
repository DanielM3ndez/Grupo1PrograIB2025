/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un Zoológico
        Zoologico zoo = new Zoologico(1, "Zona Tropical");

        while (true) {
            // Menú principal
            System.out.println("Bienvenido al Zoológico La Aurora");
            System.out.println("1. Agregar nuevo animal");
            System.out.println("2. Ver todos los animales");
            System.out.println("3. Alimentar animales");
            System.out.println("4. Calcular comida consumida en un periodo");
            System.out.println("5. Exportar datos a CSV");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (opcion) {
                case 1 -> agregarAnimal(zoo, scanner);

                case 2 -> zoo.listarAnimales();

                case 3 -> zoo.alimentarAnimales();

                case 4 -> {
                    System.out.print("Ingrese el número de días: ");
                    int dias = scanner.nextInt();
                    zoo.calcularComida(dias);
                }

                case 5 -> zoo.exportarDatosCSV();

                case 6 -> {
                    System.out.println("Gracias por usar el sistema del Zoológico La Aurora. ¡Hasta pronto!");
                    scanner.close();
                    return;  // Salir del programa
                }
                default -> System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }
    }

    public static void agregarAnimal(Zoologico zoo, Scanner scanner) {
        System.out.println("¿Qué tipo de animal deseas agregar? (1. Mamífero, 2. Ave, 3. Reptil)");
        int tipo = validarEntradaInt(scanner);

        System.out.print("Ingrese el código del animal: ");
        int codigo = validarEntradaInt(scanner);

        System.out.print("Ingrese el nombre del animal: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del animal: ");
        int edad = validarEntradaInt(scanner);

        System.out.print("Ingrese la cantidad de comida diaria en libras: ");
        double comidaDiaria = validarEntradaDouble(scanner);

        Zoologico zoologico = zoo;  // Asumimos que ya tienes un zoológico instanciado

        switch (tipo) {
            case 1 -> zoo.agregarAnimal(new Mamifero(codigo, nombre, edad, zoologico, comidaDiaria));
            case 2 -> zoo.agregarAnimal(new Ave(codigo, nombre, edad, zoologico, comidaDiaria));
            case 3 -> zoo.agregarAnimal(new Reptil(codigo, nombre, edad, zoologico, comidaDiaria));
            default -> System.out.println("Opción inválida.");
        }
    }

    // Método para validar la entrada de tipo int
    public static int validarEntradaInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingresa un número válido.");
            scanner.next(); // Consumir el valor no válido
        }
        return scanner.nextInt();
    }

    // Método para validar la entrada de tipo double
    public static double validarEntradaDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, ingresa un número válido.");
            scanner.next(); // Consumir el valor no válido
        }
        return scanner.nextDouble();
    }
}
