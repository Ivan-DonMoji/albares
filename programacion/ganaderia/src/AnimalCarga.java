public class AnimalCarga extends Animal{
    private int carga; 
    private String trabajo; 
    private float resistencia;


    public AnimalCarga(String raza, double peso, int edad, int carga, String trabajo, float resistencia) {
        super(raza, peso, edad);
        this.carga = carga;
        this.trabajo = trabajo;
        this.resistencia = resistencia;
    }

    
    @Override
    public void mostrarDatos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarDatos'");
    }



    //GETTERS AND SETTERS
    public int getCarga() {
        return carga;
    }
    public void setCarga(int carga) {
        this.carga = carga;
    }
    public String getTrabajo() {
        return trabajo;
    }
    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }
    public float getResistencia() {
        return resistencia;
    }
    public void setResistencia(float resistencia) {
        this.resistencia = resistencia;
    }


}
