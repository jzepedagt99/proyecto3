
package proyectolll;

/**
 *
 * @author jzepeda
 */
public class ProyectoIII {

    public static void main(String[] args) {
        MatrizVehiculos matriz = new MatrizVehiculos();

        matriz.insertar("ABC123", "Rojo", "Sedan", "2025", "Carlos", 0, 0);
        matriz.insertar("DEF456", "Azul", "SUV", "2025", "Ana", 0, 2);
        matriz.insertar("GHI789", "Verde", "Hatchback", "2025", "Luis", 2, 1);        
        matriz.insertar("GHI111", "Verde", "Hatchback", "2025", "Luis", 5, 4);        
        matriz.insertar("GHI222", "Verde", "Hatchback", "2025", "Luis", 3, 3);
        matriz.insertar("GHI333", "Verde", "Hatchback", "2025", "Luis", 3, 2);
        matriz.insertar("GHI333", "Verde", "Hatchback", "2025", "Luis", 3, 1);                
        matriz.insertar("GHI333", "Verde", "Hatchback", "2025", "Luis", 5, 5);                
        matriz.insertar("GHI333", "Verde", "Hatchback", "2025", "Luis", 10, 4);

        Vehiculo encontrado = matriz.buscar("DEF456");
        if (encontrado != null) {
            System.out.println("\nVehículo encontrado: " + encontrado.placa + ", Propietario: " + encontrado.propietario);
        } else {
            System.out.println("\nVehículo no encontrado.");
        }
    }
    
}
