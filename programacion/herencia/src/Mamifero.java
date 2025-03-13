import programacion.herencia.interfaces.Embarazado;

public class Mamifero extends Animal implements Embarazado {

    private boolean carnivoro;

    public Mamifero(String nombre, int edad, String sexo, boolean carnivoro) {
        super(nombre, edad, sexo);
        this.carnivoro = carnivoro;
    }

    // GETTERS AND SETTERS
    public boolean isCarnivoro() {
        return carnivoro;
    }

    public void setCarnivoro(boolean carnivoro) {
        this.carnivoro = carnivoro;
    }

    @Override
    public void parir() {
        System.out.println("Este mamifero ha dado a luz.");
    }

    @Override
    public void hacerSonido(String sonido) {
        System.out.println("Soy un mamifero llamado " + this.getNombre() + " y hagoe este sonido: " + sonido);
    }

}