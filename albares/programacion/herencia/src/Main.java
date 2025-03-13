import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Animal> animales = new ArrayList<Animal>();
        Animal perro = new Mamifero("Firulais", 3, "macho", true);
        Animal gaviota = new Ave("Palomina", 83, "hembra", 4);

        animales.add(perro);
        animales.add(gaviota);
        System.out.println("A continuacion, se listan los animales: ");
        for (Animal animal : animales) {
            System.out.println(animal.getNombre());
            System.out.println(animal.getEdad());
            System.out.println(animal.getSexo());
            if (animal instanceof Ave) {
                Ave a = (Ave) animal;
                System.out.println(a.getPlumas());
            }
            if (animal instanceof Mamifero) {
                Mamifero m = (Mamifero) animal;
                System.out.println(m.isCarnivoro());
            }
        }
    }
}