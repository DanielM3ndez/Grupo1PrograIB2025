/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoologico;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zoologico {
    
    private static int contadorCodigo = 1;
    private int codigo;
    private String zona;
    private final List<Animal> animales;  

    public Zoologico(int codigo, String zona) {
        this.codigo = codigo;
        this.zona = zona;
        this.animales = new ArrayList<>(); 
    }

    // Métodos de acceso (getters y setters)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    // Método para agregar un animal
    public void agregarAnimal(Animal animal) {
        if (animal != null) {
            animales.add(animal);
            System.out.println(animal.getNombre() + "Animal " + " agregado correctamente.");
        } else {
            System.out.println("El animal no pudo ser agregado.");
        }
    }

    // Método para listar todos los animales
    public void listarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales en el zoologico.");
        } else {
            System.out.println("Animales en el zoologico:");
            for (Animal animal : animales) {
                System.out.println(animal);
            }
        }
    }

    // Método para alimentar a todos los animales
    public void alimentarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales para alimentar.");
        } else {
            for (Animal animal : animales) {
                animal.alimentar();  // Llama al método 'alimentar' de cada animal
            }
        }
    }

    // Método para calcular la comida consumida durante varios días
    public void calcularComida(int dias) {
        for (Animal animal : animales) {
            double comidaTotal = animal.calcularComida(dias);
            System.out.println("El animal " + animal.getNombre() + " necesita " + comidaTotal + " libras de comida durante " + dias + " días.");
        }
    }

    // Exportar los datos de los animales a un archivo CSV
    public void exportarDatosCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("zoologico.csv"))) {
            writer.write("Codigo, Nombre, Dieta, Edad, Consumo Diario (libras)\n");
            for (Animal animal : animales) {
                writer.write(animal.getCodigo() + "," + animal.getNombre() + "," + animal.getDieta() + "," 
                        + animal.getEdad() + "," + animal.getConsumoDiario() + "\n");
            }
            System.out.println("Datos exportados a zoologico.csv.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos.");
        }
    }
    public static int obtenerNuevoCodigo() {
        return contadorCodigo++;
    }
}
