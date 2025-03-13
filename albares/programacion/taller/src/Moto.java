package programacion.taller.src;

import programacion.taller.interfaces.Usado;

public class Moto extends Vehiculo implements Usado{
    
    private int cilindrada;
    
    public Moto(String modelo, String marca, String matricula, boolean apto, int cilindrada) {
        super(modelo, marca, matricula, apto);
        this.cilindrada = cilindrada;
    }


    //GETTERS AND SETTERS
    
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }


    @Override
    public void diagnosticar(String diagnostico) {
        System.out.println("La moto "+ this.getMarca() + this.getModelo() + " sufre de estos problemas: " + diagnostico);
    } 


}
