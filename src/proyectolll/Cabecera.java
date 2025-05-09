
package proyectolll;

/**
 *
 * @author jzepeda
 */
public class Cabecera {
    int indice; // Índice de la fila o columna
    Cabecera siguiente; // Puntero a la siguiente cabecera
    Vehiculo acceso; // Nodo inicial de la fila o columna

    public Cabecera(int indice) {
        this.indice = indice;
        this.siguiente = null;
        this.acceso = null;
    }
}
