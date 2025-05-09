# Proyecto #3 de programación III

# Manual de Usuario y Técnico - Sistema de Matriz Ortogonal de Vehículos

---

## Manual de Usuario

### Descripción General
Este sistema permite registrar, buscar y eliminar vehículos dentro de una **matriz ortogonal dinámica**, optimizando el uso de memoria para estructuras dispersas.

### Requisitos del Sistema
- Java Development Kit (JDK) 8 o superior  
- Entorno de desarrollo como IntelliJ, Eclipse o NetBeans

### Instrucciones de Uso

#### Ejecución del Programa
1. Compila el archivo `Main.java` que contiene el método `main`.
2. Ejecuta el programa desde tu entorno de desarrollo o desde la línea de comandos.

#### Insertar Vehículo
```java
matriz.insertar("ABC123", "Rojo", "Sedan", "2020", "Carlos", 0, 0);
```
Parámetros:

placa: identificador del vehículo
color: color del vehículo
linea: tipo o categoría
modelo: año del modelo
propietario: nombre del dueño
fila, columna: posición en la matriz

#### Buscar vehiculo
```java
matriz.buscar("ABC123");
```
#### Eliminar Vehiculo
```java
matriz.eliminar(0, 0);
```
#### Imprimir
```java
matriz.imprimirFilas();
```
## Manual Técnico

###  Estructura de Datos
- **NodoVehiculo**: contiene información del vehículo y punteros `arriba`, `abajo`, `izquierda`, `derecha`.
- **Cabecera**: lista enlazada de filas o columnas con acceso a los nodos.
- **MatrizOrtogonal**: contiene las cabeceras y métodos para insertar, buscar y eliminar.

### Lógica de Inserción
- Se ubica la cabecera de fila y columna, **creándolas si no existen**.
- Se inserta el nodo en la posición adecuada enlazando a vecinos .

### Lógica de Búsqueda
- Se recorre cada fila y cada nodo, **comparando el valor buscado con todas las propiedades** del vehículo.

### Lógica de Eliminación
- Se ubica el nodo por fila y columna.
- Se eliminan las referencias en ambas direcciones.
- Si una fila o columna queda vacía, **se elimina su cabecera**.
