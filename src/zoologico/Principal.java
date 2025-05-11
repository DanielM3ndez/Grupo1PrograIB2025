/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

import java.util.Arrays;
import java.util.Scanner;

public class Principal {
    
    static Animal[] arregloAnimal = new Animal[10];
    static int contadorArray = 0;
    
    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        

        // Crear un Zoológico
        Zoologico zoo = new Zoologico(1, "Zona Tropical");

        while (true) {
            // Menú principal
            System.out.println("Bienvenido al Zoologico");
            System.out.println("1. Agregar nuevo animal");
            System.out.println("2. Arreglos");
            System.out.println("3. Alimentar animales");
            System.out.println("4. Calcular comida consumida en un periodo");
            System.out.println("5. Exportar datos a CSV");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (opcion) {
                case 1 -> agregarAnimal(zoo, scanner);

                case 2 ->  submenuArreglo(scanner);

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
        }
    }
    
      public static void submenuArreglo(Scanner scanner) {
        char opcion;
        do {
            System.out.println("\n--- Submenú de Arreglos ---");
            System.out.println("a. Agregar Mamífero");
            System.out.println("b. Agregar Ave");
            System.out.println("c. Agregar Reptil");
            System.out.println("d. Ordenar arreglo por ID");
            System.out.println("e. Mostrar animales en el arreglo");
            System.out.println("x. Regresar al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.next().toLowerCase().charAt(0);

            switch (opcion) {
                case 'a', 'b', 'c' -> agregarAnimalArray(scanner, opcion);
                case 'd' -> ordenarArreglo(scanner);
                case 'e' -> mostrarArreglo();
                case 'x' -> {
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        } while (true);
    }

    // Agregar animal al arreglo
    public static void agregarAnimalArray(Scanner scanner, char tipo) {
        if (contadorArray >= 10) {
            System.out.println("El arreglo está lleno.");
            return;
        }

        System.out.print("Ingrese el ID del animal: ");
        int id = validarEntradaInt(scanner);
        if (existeIdEnArreglo(id)) {
            System.out.println("El ID ya existe. Debe ser único.");
            return;
        }

        scanner.nextLine();
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = validarEntradaInt(scanner);

        System.out.print("Comida diaria (libras): ");
        double comida = validarEntradaDouble(scanner);

        Animal animal = switch (tipo) {
            case 'a' -> new Mamifero(id, nombre, edad, null, comida);
            case 'b' -> new Ave(id, nombre, edad, null, comida);
            case 'c' -> new Reptil(id, nombre, edad, null, comida);
            default -> null;
        };

        if (animal != null) {
            arregloAnimal[contadorArray++] = animal;
            System.out.println("Animal agregado correctamente.");
        }
    }

    public static boolean existeIdEnArreglo(int id) {
        for (int i = 0; i < contadorArray; i++) {
            if (arregloAnimal[i].getidAnimal() == id) {
                return true;
            }
        }
        return false;
    }

    public static void ordenarArreglo(Scanner scanner) {
        if (contadorArray == 0) {
            System.out.println("No hay animales en el arreglo.");
            return;
        }

        System.out.print("¿Ordenar ascendente o descendente? (asc/desc): ");
        String orden = scanner.next();

        Arrays.sort(arregloAnimal, 0, contadorArray, (a1, a2) -> {
            if (orden.equalsIgnoreCase("asc")) {
                return Integer.compare(a1.getidAnimal(), a2.getidAnimal());
            } else {
                return Integer.compare(a2.getidAnimal(), a1.getidAnimal());
            }
        });

        System.out.println("Arreglo ordenado.");
    }

    public static void mostrarArreglo() {
        if (contadorArray == 0) {
            System.out.println("No hay animales en el arreglo.");
            return;
        }

        System.out.println("--- Animales en el arreglo ---");
        for (int i = 0; i < contadorArray; i++) {
            Animal a = arregloAnimal[i];
            System.out.println("ID: " + a.getidAnimal() + " | Nombre: " + a.getNombre() + " | Tipo: " + a.getClass().getSimpleName());
        }
    }

    public static void agregarAnimal(Zoologico zoo, Scanner scanner) {
        System.out.println("Que tipo de animal deseas agregar? (1. Mamifero, 2. Ave, 3. Reptil)");
        int tipo = validarEntradaInt(scanner);

        int idAnimal = Zoologico.obtenerNuevoCodigo();
        System.out.println("IdAnimal: " + idAnimal);
        
         scanner.nextLine();
         
        System.out.print("Ingrese el nombre del animal: ");
         String nombre = scanner.nextLine();
          
        System.out.print("Ingrese la edad del animal: ");
        int edad = validarEntradaInt(scanner);

        System.out.print("Ingrese la cantidad de comida diaria en libras: ");
        double comidaDiaria = validarEntradaDouble(scanner);

        Zoologico zoologico = zoo;  

        switch (tipo) {
            case 1 -> zoo.agregarAnimal(new Mamifero(idAnimal, nombre, edad, zoologico, comidaDiaria));
            case 2 -> zoo.agregarAnimal(new Ave(idAnimal, nombre, edad, zoologico, comidaDiaria));
            case 3 -> zoo.agregarAnimal(new Reptil(idAnimal, nombre, edad, zoologico, comidaDiaria));
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
            System.out.println("Por favor, ingresa un numero valido.");
            scanner.next(); // Consumir el valor no válido
        }
        return scanner.nextDouble();
    }
    
}
//// Gerson dormite