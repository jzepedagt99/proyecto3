package proyectolll;

/**
 *
 * @author jzepeda
 */
public class Vehiculo {
    String placa;
    String color;
    String linea;
    String modelo;
    String propietario;

    Vehiculo arriba;
    Vehiculo abajo;
    Vehiculo izquierda;
    Vehiculo derecha;

    int fila;
    int columna;
    
    public Vehiculo(String placa, String color, String linea, String modelo, String propietario, int fila, int columna) {
        this.placa = placa;
        this.color = color;
        this.linea = linea;
        this.modelo = modelo;
        this.propietario = propietario;
        this.fila = fila;
        this.columna = columna;
    }
}
