import java.util.Scanner;
import java.util.UUID;

public class Main {
    
    public static void main(String[] args) {
        Granja granja = new Granja(); 
        int opcion = 0; 
        Scanner scan = new Scanner(System.in);
        while(opcion != 8){
            System.out.println("MENU GRANJA:");
            System.out.println("1. Agregar animal");
            System.out.println("2. Eliminar animal");
            System.out.println("3. Buscar animal");
            System.out.println("4. Guardar animales en TXT");
            System.out.println("5. Cargar animales en TXT");
            System.out.println("6. Guardar animales en DAT");
            System.out.println("7. Cargar animales en DAT");
            System.out.println("8. Salir");
            String linea; 
            opcion = scan.nextInt();
            switch(opcion){
                case 1: 
                    granja.addAnimalDatoADato();
                    break; 
                
                case 2: 
                    
                    System.out.println("Introduce la ID del animal a eliminar: ");
                    linea = scan.nextLine();
                    granja.removeAnimal(linea);
                    break; 
                case 3: 
                    System.out.println("Introduce la ID del animal a eliminar: ");
                    linea = scan.nextLine();
                    Animal devuelto = granja.buscarAnimal(UUID.fromString(linea));
                    System.out.println(devuelto.getId());
                    break; 

                case 4: 
                    System.out.println("Introduce el archivo txt donde quieres guardar los animales: ");
                    linea = scan.nextLine();
                    granja.guardarAnimalesTxt(linea);
                    break; 
                case 5:
                    System.out.println("Introduce el archivo txt donde quieres cargar los animales: ");
                    linea = scan.nextLine();
                    granja.cargarAnimalesTxt(linea);
                    break; 
                case 6: 
                    System.out.println("Introduce el archivo dat donde quieres guardar los animales: ");
                    linea = scan.nextLine();
                    granja.guardarAnimalesDat(linea);
                    break; 
                case 7:
                    System.out.println("Introduce el archivo dat donde quieres cargar los animales: ");
                    linea = scan.nextLine();
                    granja.cargarAnimalesDat(linea);
                    break; 
                case 8:
                    System.out.println("Saliendo del sistema.");
                    break; 
            }
        }

    }
}
