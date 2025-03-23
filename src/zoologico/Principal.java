/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);
            boolean menu = true;
        // Crear un Zoológico
        Zoologico zoo = new Zoologico(1, "Zona Tropical");

        while (menu) {
            // Menú principal
            System.out.println("Bienvenido al Zoologico");
            System.out.println("1. Agregar nuevo animal");
            System.out.println("2. Ver todos los animales");
            System.out.println("3. Alimentar animales");
            System.out.println("4. Calcular comida consumida en un periodo");
            System.out.println("5. Exportar datos a CSV");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opcion: ");

            
        try{
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            // Limpiar el buffer de entrada

        
            switch (opcion) {
                case 1 -> agregarAnimal(zoo, scanner);

                case 2 -> zoo.listarAnimales();

                case 3 -> zoo.alimentarAnimales();

                case 4 -> {
                    System.out.print("Ingrese el numero de dias: ");
                    int dias = scanner.nextInt();
                    zoo.calcularComida(dias);
                }

                case 5 -> zoo.exportarDatosCSV();

                case 6 -> {
                    System.out.println("Gracias por usar el sistema del Zoológico La Aurora. ¡Hasta pronto!");
                    scanner.close();
                    return;  // Salir del programa
                }
                default -> System.out.println("Opcion no valida. Por favor, ingrese una opcion valida.");
            }
            }catch (java.util.InputMismatchException e) {
                System.out.println("Error Por favor ingrese un numero valido para la opcion., presione Enter para regresar al menu");
                scanner.nextLine();
                scanner.nextLine();
            }
            
        }
    }

    public static void agregarAnimal(Zoologico zoo, Scanner scanner) {
        System.out.println("Que tipo de animal deseas agregar? (1. Mamifero, 2. Ave, 3. Reptil)");
        int tipo = validarEntradaInt(scanner);

        int codigo = Zoologico.obtenerNuevoCodigo();
        System.out.println("Codigo: " + codigo);
        
         scanner.nextLine();
         
        System.out.print("Ingrese el nombre del animal: ");
         String nombre = scanner.nextLine();
          
        System.out.print("Ingrese la edad del animal: ");
        int edad = validarEntradaInt(scanner);

        System.out.print("Ingrese la cantidad de comida diaria en libras: ");
        double comidaDiaria = validarEntradaDouble(scanner);

        Zoologico zoologico = zoo;  

        switch (tipo) {
            case 1 -> zoo.agregarAnimal(new Mamifero(codigo, nombre, edad, zoologico, comidaDiaria));
            case 2 -> zoo.agregarAnimal(new Ave(codigo, nombre, edad, zoologico, comidaDiaria));
            case 3 -> zoo.agregarAnimal(new Reptil(codigo, nombre, edad, zoologico, comidaDiaria));
            default -> System.out.println("Opcion invalida.");
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
//// daniel que onda mdklsmelkdmclss