
public class Ave extends Animal {

    private int plumas;

    public Ave(String nombre, int edad, String sexo, int plumas) {
        super(nombre, edad, sexo);
        this.plumas = plumas;
    }

    @Override
    public void hacerSonido(String sonido) {
        System.out.println("Soy un ave llamada " + this.getNombre() + " y hago este sonido: " + sonido);
    }

    // GETTERS AND SETTERS
    public int getPlumas() {
        return plumas;
    }

    public void setPlumas(int plumas) {
        this.plumas = plumas;
    }

}