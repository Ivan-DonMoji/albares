package programacion.taller.src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TallerMecanico {

    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        List<Coche> coches = new ArrayList<Coche>();
        List<Moto> motos = new ArrayList<Moto>();
        List<Camion> camiones = new ArrayList<Camion>();
        Vehiculo aceptado = new Coche("Camaro", "Chevrolet", "123123", false, "Deportivo");
        // AQUI AÑADID LOS VEHICULOS QUE QUERÁIS PARA IR PROBANDO, AHORA MISMO ES NORMAL
        // QUE SALGAN LOS WARNING.
        // EN LA SIGUIENTE CLASE LO VEREMOS CON MÁS PROFUNDIDAD
        escribirDat(aceptado);
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        do {
            clearScreen();
            System.out.println("Menu del taller:");
            System.out.println("1. Listar Vehiculos");
            System.out.println("2. Aceptar nuevo vehiculo");
            System.out.println("3. Filtrar vehiculos");
            System.out.println("4. Salir");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    listarVehiculos(vehiculos);
                    break;
                case 2:
                    aceptarVehiculo(vehiculos, aceptado);
                    break;
                case 3:
                    filtrarVehiculos(vehiculos, coches, motos, camiones);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    break;
            }
        } while (opcion != 4);
        scan.close();
    }

    public static void listarVehiculos(List<Vehiculo> vehiculos) {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.getMatricula());
            System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo());
        }
    }

    public static void aceptarVehiculo(List<Vehiculo> vehiculos, Vehiculo v) {
        vehiculos.add(v);
        System.out.println("El vehiculo ha sido añadido");
    }

    public static void filtrarVehiculos(List<Vehiculo> vehiculos, List<Coche> coches, List<Moto> motos,
            List<Camion> camiones) {
        coches.clear();
        motos.clear();
        camiones.clear();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Coche) {
                Coche c = (Coche) vehiculo;
                coches.add(c);
            } else if (vehiculo instanceof Moto) {
                Moto m = (Moto) vehiculo;
                motos.add(m);
            } else if (vehiculo instanceof Camion) {
                Camion c = (Camion) vehiculo;
                camiones.add(c);
            }

        }
    }

    public static void escribirDat(Vehiculo aceptado){
        String filename = "ejemplo.dat";
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(aceptado);
            oos.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static void clearScreen() {
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
