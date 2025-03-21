/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

import zoologico.Animal;
import zoologico.Zoologico;

public class Mamifero extends Animal {

    public Mamifero(int Codigo, String nombre, int edad, Zoologico zoologico, double consumoDiario) {
        super(Codigo, nombre, Dieta.CARNIVORO, edad, zoologico, consumoDiario);
    }

    @Override
    public void alimentar() {
        System.out.println("El mamífero " + getNombre() + " está siendo alimentado con " + getConsumoDiario() + " libras de carne.");
    }
}
