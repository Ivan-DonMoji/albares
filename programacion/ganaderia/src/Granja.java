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
import java.util.UUID;

public class Granja {
    private HashMap<UUID, Animal> animales;

    public Granja() {
        animales = new HashMap<UUID, Animal>();
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
