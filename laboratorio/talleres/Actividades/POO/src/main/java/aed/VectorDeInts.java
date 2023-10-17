package aed;

class VectorDeInts implements SecuenciaDeInts {
    private static final int CAPACIDAD_INICIAL = 1;
    private int[] arreglo;
    private int size;

    public VectorDeInts() {
        arreglo = new int[CAPACIDAD_INICIAL];
        size = 0;
    }

    public VectorDeInts(VectorDeInts vector) {
        this.arreglo = new int[vector.arreglo.length];
        this.size = vector.size;
        System.arraycopy(vector.arreglo, 0, this.arreglo, 0, vector.size);
    }

    public int longitud() {
        return size;
    }

    public void agregarAtras(int i) {
        if (size == arreglo.length) {
            int nuevaCapacidad = arreglo.length * 2;
            int[] nuevoArreglo = new int[nuevaCapacidad];
            System.arraycopy(arreglo, 0, nuevoArreglo, 0, size);
            arreglo = nuevoArreglo;
        }
        arreglo[size] = i;
        size++;
    }

    public int obtener(int i) {
        if (i >= 0 && i < size) {
            return arreglo[i];
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }

    public void quitarAtras() {
        if (size > 0) {
            size--;
        } else {
            throw new IllegalStateException("El vector está vacío, no se puede quitar ningún elemento.");
        }
    }

    public void modificarPosicion(int indice, int valor) {
        if (indice >= 0 && indice < size) {
            arreglo[indice] = valor; 
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }

    public VectorDeInts copiar() {
        VectorDeInts nuevoVector = new VectorDeInts(); // Se reserva memoria para el nuevo arreglo
        nuevoVector.arreglo = new int[this.size]; // Se reserva memoria para el nuevo arreglo interno

        // Copiar elementos del vector original al nuevo vector
        for (int i = 0; i < this.size; i++) {
            nuevoVector.arreglo[i] = this.arreglo[i];
        }

        nuevoVector.size = this.size; // Establece el tamaño del nuevo vector
        return nuevoVector;
    }

}
