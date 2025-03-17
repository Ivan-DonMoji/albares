public class AnimalCarne extends Animal{
    private double produccionCarnica;



    public AnimalCarne(String raza, double peso, int edad, double produccionCarnica) {
        super(raza, peso, edad);
        this.produccionCarnica = produccionCarnica;
    }

    @Override
    public void mostrarDatos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarDatos'");
    }

    //GETTERS AND SETTERS
    public double getProduccionCarnica() {
        return produccionCarnica;
    }

    public void setProduccionCarnica(double produccionCarnica) {
        this.produccionCarnica = produccionCarnica;
    } 

    
}
