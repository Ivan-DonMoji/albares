package programacion.taller.src;

public class Camion extends Vehiculo {

    private int peso;

    public Camion(String modelo, String marca, String matricula, boolean apto, int peso) {
        super(modelo, marca, matricula, apto);
        this.peso = peso;
    }

    @Override
    public void diagnosticar(String diagnostico) {
        System.out.println(
                "El camion " + this.getMarca() + this.getModelo() + " sufre de estos problemas: " + diagnostico);
    }

    // GETTERS AND SETTERS

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

}
