
package programacion.herencia.interfaces;

public interface Embarazado {

    void parir();

    default void estadoParto(boolean correcto) {
        if (correcto) {
            System.out.println("El parto ha salido bien.");
        } else {
            System.out.println("Ha habido un problema con el parto.");
        }
    }

}