package proyectolll;

/**
 *
 * @author jzepeda
 */
public class MatrizVehiculos {
    Cabecera filaInicio; // Inicio de la lista de cabeceras de filas
    Cabecera columnaInicio; // Inicio de la lista de cabeceras de columnas

    public MatrizVehiculos() {
        filaInicio = null;
        columnaInicio = null;
    }
    
    // Método privado para obtener o crear una cabecera (fila o columna)
    private Cabecera obtenerOCrearCabecera(boolean esFila, int indice) {
        Cabecera inicio = esFila ? filaInicio : columnaInicio;
        Cabecera anterior = null;
        Cabecera actual = inicio;

        // Buscar la cabecera correspondiente
        while (actual != null && actual.indice < indice) {
            anterior = actual;
            actual = actual.siguiente;
        }
        // Si ya existe, la retornamos    
        if (actual != null && actual.indice == indice) {
            return actual;
        }

        Cabecera nueva = new Cabecera(indice);

        if (anterior == null) {
            nueva.siguiente = inicio;
            if (esFila) {
                filaInicio = nueva;
            } else {
                columnaInicio = nueva;
            }
        } else {
            anterior.siguiente = nueva;
            nueva.siguiente = actual;
        }

        return nueva;
    }
    
    public void insertar(String placa, String color, String linea, String modelo, String propietario, int fila, int columna) {
        Vehiculo nuevo = new Vehiculo(placa, color, linea, modelo, propietario, fila, columna);

        Cabecera filaCab = obtenerOCrearCabecera(true, fila);
        Cabecera colCab = obtenerOCrearCabecera(false, columna);

        // Insertar en fila (horizontal)
        Vehiculo actualFila = filaCab.acceso;
        Vehiculo anteriorFila = null;

        while (actualFila != null && actualFila.columna < columna) {
            anteriorFila = actualFila;
            actualFila = actualFila.derecha;
        }

        if (anteriorFila == null) {
            nuevo.derecha = filaCab.acceso;
            if (filaCab.acceso != null) {
                filaCab.acceso.izquierda = nuevo;
            }
            filaCab.acceso = nuevo;
        } else {
            nuevo.derecha = actualFila;
            nuevo.izquierda = anteriorFila;
            anteriorFila.derecha = nuevo;
            if (actualFila != null) {
                actualFila.izquierda = nuevo;
            }
        }

        // Insertar en columna (vertical)
        Vehiculo actualCol = colCab.acceso;
        Vehiculo anteriorCol = null;

        while (actualCol != null && actualCol.fila < fila) {
            anteriorCol = actualCol;
            actualCol = actualCol.abajo;
        }

        if (anteriorCol == null) {
            nuevo.abajo = colCab.acceso;
            if (colCab.acceso != null) {
                colCab.acceso.arriba = nuevo;
            }
            colCab.acceso = nuevo;
        } else {
            nuevo.abajo = actualCol;
            nuevo.arriba = anteriorCol;
            anteriorCol.abajo = nuevo;
            if (actualCol != null) {
                actualCol.arriba = nuevo;
            }
        }
    }
    
    public void imprimirFilas() {
        Cabecera fila = filaInicio;

        while (fila != null) {
            System.out.print("Fila " + fila.indice + ": ");
            Vehiculo actual = fila.acceso;

            while (actual != null) {
                System.out.print("[" + actual.placa + "] ");
                actual = actual.derecha;
            }

            System.out.println();
            fila = fila.siguiente;
        }
    }
    
    // Método para buscar un nodo por cualquier propiedad del vehículo
    public Vehiculo buscar(String valor) {
        Cabecera fila = filaInicio;

        while (fila != null) {
            Vehiculo actual = fila.acceso;
            while (actual != null) {
                // Comparar cada propiedad
                if (actual.placa.equals(valor) || actual.color.equals(valor) || actual.linea.equals(valor) ||
                    actual.modelo.equals(valor) || actual.propietario.equals(valor)) {
                    return actual;
                }
                actual = actual.derecha;
            }
            fila = fila.siguiente;
        }
        return null; // No encontrado
    }

    // Método para eliminar un nodo según su posición (fila, columna)
    public void eliminar(int fila, int columna) {
        // Buscar cabecera de la fila
        Cabecera filaCab = filaInicio;
        while (filaCab != null && filaCab.indice != fila) {
            filaCab = filaCab.siguiente;
        }
        if (filaCab == null) return; // Fila no existe

        // Buscar el nodo en esa fila
        Vehiculo actual = filaCab.acceso;
        while (actual != null && actual.columna != columna) {
            actual = actual.derecha;
        }
        if (actual == null) return; // Nodo no existe

        // Desconectar horizontalmente
        if (actual.izquierda != null) {
            actual.izquierda.derecha = actual.derecha;
        } else {
            filaCab.acceso = actual.derecha;
        }
        if (actual.derecha != null) {
            actual.derecha.izquierda = actual.izquierda;
        }

        // Buscar cabecera de la columna
        Cabecera colCab = columnaInicio;
        while (colCab != null && colCab.indice != columna) {
            colCab = colCab.siguiente;
        }
        if (colCab == null) return;

        // Buscar nodo en esa columna
        Vehiculo actualCol = colCab.acceso;
        while (actualCol != null && actualCol.fila != fila) {
            actualCol = actualCol.abajo;
        }
        if (actualCol == null) return;

        // Desconectar verticalmente
        if (actualCol.arriba != null) {
            actualCol.arriba.abajo = actualCol.abajo;
        } else {
            colCab.acceso = actualCol.abajo;
        }
        if (actualCol.abajo != null) {
            actualCol.abajo.arriba = actualCol.arriba;
        }
    }
}
