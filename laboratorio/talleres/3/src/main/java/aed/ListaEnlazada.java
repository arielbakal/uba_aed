package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo actual;
    private int size;

    private class Nodo {
        T valor;
        Nodo sig;
        Nodo ant;

        Nodo(T v) {
            valor = v;
        };
    }

    public ListaEnlazada() {
        actual = null;
    }

    public int longitud() {
        return size;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        // Conecto Nodo nuevo con Nodo actual
        // Nuevo -> Actual
        nuevo.sig = actual; 
        // Mi Head ahora es Nodo nuevo
        actual = nuevo;
        size++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        // Si no tengo elementos => es mi primer nodo
        if (actual == null) {
            actual = nuevo;
        } else {
            // Nodo temporal para iterarlo
            Nodo temp = actual;
            // Itero hasta el ultimo nodo
            while (temp.sig != null) {
                temp = temp.sig;
            }
            // Conecto Nodo temp con Nodo nuevo
            // temp -> nuevo
            temp.sig = nuevo;
            // Conecto Nodo nuevo con Nodo temp
            // temp <- nuevo
            nuevo.ant = temp;
        }
        size++;
    }

    public T obtener(int i) {
        Nodo temp = actual;
        // Itero hasta el i-esimo nodo
        for (int j = 0; j < i; j++) {
            temp = temp.sig;
        }
        return temp.valor;
    }

    public void eliminar(int i) {
        Nodo actual_temp = actual;
        Nodo anterior_temp = null; 
        // Itero hasta el i-esimo nodo
        for (int j = 0; j < i; j++) {
            anterior_temp = actual_temp;
            actual_temp = actual_temp.sig;
        }
        if (i==0) { 
            // Descarto el Head
            actual = actual_temp.sig;
        } else {
            // temp.ant <-> temp.sig . Conecto los nodos dejando a temp sin conexion, por ende no forma parte de la secuencia. 
            anterior_temp.sig = actual_temp.sig;
        }
        size--;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo nuevo = new Nodo(elem);
        Nodo temp = actual;
        // Itero hasta el i-esimo nodo
        for (int j = 0; j < indice; j++) {
            temp = temp.sig;
        }
        // Nodo nuevo apunta al siguiente Nodo de temp
        nuevo.sig = temp.sig;
        // Si tengo anterior => conecto Nodo anterior al Nuevo
        if (temp.ant != null) {
            temp.ant.sig = nuevo;
        } else {
            // Si no tengo anterior => Asigno al primero
            actual = nuevo;
        }
        temp.sig = nuevo;
        nuevo.ant = temp;
        // temp.ant <-> nuevo <-> temp.sig 
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> copia = new ListaEnlazada<>(null);
        Nodo temp = actual;
        while (temp != null) {
            T v = temp.valor;
            copia.agregarAtras(v);
            temp = temp.sig;
        }
        return copia;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        if (lista != null) {
            ListaEnlazada<T> templista = lista.copiar();
            this.actual = templista.actual;
            this.size = templista.size;
        } else {
            this.actual = null;
            this.size = 0;
        }
    }
    
    @Override
    public String toString() {
        Nodo temp = actual;
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        while (temp.sig != null) {
            buffer.append(temp.valor);
            buffer.append(", ");
            temp = temp.sig;
        }
        buffer.append(temp.valor);
        buffer.append("]");
        return buffer.toString();
    }

    private class ListaIterador implements Iterador<T> {
    	int indice;

        ListaIterador(){
            indice = 0;
        }

        public boolean haySiguiente() {
	        return indice != size;
        }
        
        public boolean hayAnterior() {
	        return indice != 0;
        }

        public T siguiente() {
            int i = indice;
            indice++;
	        return obtener(i);
        }
        

        public T anterior() {
	        indice--;
            return obtener(indice);
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}
