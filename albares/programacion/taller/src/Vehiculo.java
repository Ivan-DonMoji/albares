package programacion.taller.src;

public abstract class Vehiculo {
    private String modelo;
    private String marca;
    private String matricula;
    private boolean apto;

    public Vehiculo(String modelo, String marca, String matricula, boolean apto) {
        this.modelo = modelo;
        this.marca = marca;
        this.matricula = matricula;
        this.apto = apto;
    }

    public abstract void diagnosticar(String diagnostico);

    public void reparar() {
        this.apto = true;
        System.out.println("El vehiculo ha sido reparado y puede salir del taller");
    }

    // GETTERS AND SETTERS

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isApto() {
        return apto;
    }

    public void setApto(boolean apto) {
        this.apto = apto;
    }
}
