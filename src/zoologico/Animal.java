

package zoologico;

public abstract class Animal {

    public enum Dieta {
        CARNIVORO, HERBIVORO, OMNIVORO;
    }

    private int idAnimal;
    private String nombre;
    private Dieta dieta; // Usamos el enum en lugar de String
    private int edad;
    private Zoologico zoologico;
    private double consumoDiario;

    public Animal(int idAnimal, String nombre, Dieta dieta, int edad, Zoologico zoologico, double consumoDiario) {
        this.idAnimal = idAnimal;
        this.nombre = nombre;
        this.dieta = dieta;
        this.edad = edad;
        this.zoologico = zoologico;
        this.consumoDiario = consumoDiario;
    }

    public int getidAnimal() {
        return idAnimal;
    }

    public void setidAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Zoologico getZoologico() {
        return zoologico;
    }

    public void setZoologico(Zoologico zoologico) {
        this.zoologico = zoologico;
    }

    public double getConsumoDiario() {
        return consumoDiario;
    }

    public void setConsumoDiario(double consumoDiario) {
        this.consumoDiario = consumoDiario;
    }

    // Método abstracto que debe ser implementado por las subclases de una manera mas comoda
    public abstract void alimentar();

    // Método para calcular la comida consumida en 'dias' días.
    public double calcularComida(int dias) {
        return consumoDiario * dias;
    }

    @Override
    public String toString() {
        return "Id: " + idAnimal + ", Nombre: " + nombre + ", Dieta: " + dieta + ", Edad: " + edad +
               ", Consumo Diario: " + consumoDiario + " libras.";
     
    
    }
}
