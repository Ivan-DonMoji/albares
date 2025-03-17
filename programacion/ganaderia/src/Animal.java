import java.util.UUID;

import lib.interfaces.IAnimal;

public abstract class Animal implements IAnimal{
    private UUID id; 
    private String raza; 
    private double peso; 
    private int edad;


    public Animal( String raza, double peso, int edad) {
        this.id = UUID.randomUUID();
        this.raza = raza;
        this.peso = peso;
        this.edad = edad;
    }

    //GETTERS AND SETTERS
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    } 

    
}