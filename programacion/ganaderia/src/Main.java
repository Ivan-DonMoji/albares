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
                    Animal animal = null; 
                    int aux; 
                    String datos[] = new String[10];
                    System.out.println("Introduzca 1 si es de Carga, y 2 si es de Carne");
                    aux = scan.nextInt();
                    System.out.println("Introduzca la raza del animal: ");
                    datos[0] = scan.nextLine();
                    System.out.println("Introduzca el peso del animal: ");
                    datos[1] = scan.nextLine();
                    System.out.println("Introduzca la edad del animal: ");
                    datos[2] = scan.nextLine();
                    if(aux == 1){
                        System.out.println("Introduzca la carga del animal: ");
                        datos[3] = scan.nextLine(); 
                        System.out.println("Introduzca el trabajo del animal: ");
                        datos[4] = scan.nextLine(); 
                        System.out.println("Introduzca la resistencia del animal: ");
                        datos[5] = scan.nextLine(); 
                        animal = new AnimalCarga(datos[0], Double.parseDouble(datos[1]), Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), datos[4], Float.parseFloat(datos[5]));
                    } else if(aux == 2){
                        System.out.println("Introduzca la produccion carnica del animal: ");
                        datos[3] = scan.nextLine(); 
                        animal = new AnimalCarne(datos[0], Double.parseDouble(datos[1]), Integer.parseInt(datos[2]), Double.parseDouble(datos[3]));
                    } else {
                        System.out.println("El valor introducido no es correcto.");
                    }
                    granja.getAnimales().put(animal.getId(), animal);
                    scan.close();
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
