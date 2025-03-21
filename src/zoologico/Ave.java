/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

public class Ave extends Animal {

    public Ave(int Codigo, String nombre, int edad, Zoologico zoologico, double consumoDiario) {
        super(Codigo, nombre, Dieta.OMNIVORO, edad, zoologico, consumoDiario);
    }

    @Override
    public void alimentar() {
        System.out.println("El ave " + getNombre() + " está siendo alimentada con " + getConsumoDiario() + " libras de semillas.");
    }
}
