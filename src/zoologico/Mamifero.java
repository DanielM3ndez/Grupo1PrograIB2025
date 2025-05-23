/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

import zoologico.Animal;
import zoologico.Zoologico;

public class Mamifero extends Animal {

  
    public Mamifero(int idAnimal, String nombre, int edad, Zoologico zoologico, double consumoDiario) {
        super(idAnimal, nombre,  Dieta.CARNIVORO, edad, zoologico, consumoDiario);
    }

    @Override
    public void alimentar() {
        System.out.println( "El mamifero " + getNombre() + " esta siendo alimentado con " + getConsumoDiario() + " libras de carne.");
    }
}
