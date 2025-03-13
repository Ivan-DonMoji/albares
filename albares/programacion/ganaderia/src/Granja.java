import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class Granja {
    Scanner scan = new Scanner(System.in);
    private HashMap<UUID, Animal> animales;

    public Granja() {
        animales = new HashMap<UUID, Animal>();
    }

    public void addAnimalDatoADato(){
        Animal animal = null; 
        int aux; 
        String datos[] = new String[10];
        System.out.println("Introduzca 1 si es de Carga, y 2 si es de Carne");
        aux = scan.nextInt();
        System.out.println("Introduzca la raza del animal: ");
        scan.nextLine();
        datos[0] = scan.nextLine();
        System.out.println("Introduzca el peso del animal: ");
        datos[1] = scan.nextLine();
        System.out.println("Introduzca la edad del animal: ");
        datos[2] = scan.nextLine();
        if(aux == 1){
            System.out.println("Introduzca la carga del animal: ");
            datos[3] = scan.nextLine(); 
            scan.reset();
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
        getAnimales().put(animal.getId(), animal);
    }

    public void addAnimal(Animal animal){

        animales.put(animal.getId(), animal);

    }

    public void removeAnimal(String id){
        animales.remove(UUID.fromString(id));
    }

    public Animal buscarAnimal(UUID id){
        if(animales.containsKey(id)){
            return animales.get(id);
        } else{
            System.out.println("No ha sido posible encontrar un animal");
            return null; 
        }
    }

    public void guardarAnimalesTxt(String filename){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            for(Animal a: animales.values()){
                bw.write(a.getRaza() + ": "+ a.getId());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            // TODO: handle exceptio
            e.printStackTrace();
        }
    }

    public void cargarAnimalesTxt(String filename){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String linea; 
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            /* while(true){
                linea = br.readLine();
                if(linea == null){
                    break; 
                }
                System.out.println(linea);
            } */
            br.close();
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    public void guardarAnimalesDat(String filename){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            for(Animal a: animales.values()){
                oos.writeObject(a);
            }
            oos.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void cargarAnimalesDat(String filename){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            while(true){
                try {
                    Object obj = ois.readObject();
                    if(obj instanceof Animal){
                        Animal a = (Animal)obj; 
                        System.out.println(a.getRaza() + ": "+ a.getId());

                    }
                } catch (EOFException | ClassNotFoundException e) {
                    // TODO: handle exception
                    System.out.println("El archivo se ha leido correctamente.");
                    break; 
                }
            }
            ois.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    //GETTERS AND SETTERS

    public HashMap<UUID, Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(HashMap<UUID, Animal> animales) {
        this.animales = animales;
    } 

    
}
