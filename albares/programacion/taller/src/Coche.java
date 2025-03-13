package programacion.taller.src;



public class Coche extends Vehiculo{
    private String tipo;

    public Coche(String modelo, String marca, String matricula, boolean apto, String tipo) {
        super(modelo, marca, matricula, apto);
        this.tipo = tipo;
    }

    @Override
    public void diagnosticar(String diagnostico) {
        System.out.println(
                "El coche " + this.getMarca() + this.getModelo() + " sufre de estos problemas: " + diagnostico);
    }

    // GETTERS AND SETTERS

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
