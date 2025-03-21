/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

/**
 *
 * @author Daniel
 */
package zoologico;

public class Reptil extends Animal {

    public Reptil(int Codigo, String nombre, int edad, Zoologico zoologico, double consumoDiario) {
        super(Codigo, nombre, Dieta.HERBIVORO, edad, zoologico, consumoDiario);
    }

    @Override
    public void alimentar() {
        System.out.println("El reptil " + getNombre() + " está siendo alimentado con " + getConsumoDiario() + " libras de vegetales.");
    }
}


