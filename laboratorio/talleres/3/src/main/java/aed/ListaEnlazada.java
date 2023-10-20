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
        Nodo temp = actual;
        // Itero hasta el i-esimo nodo
        for (int j = 0; j < i; j++) {
            temp = temp.sig;
        }
        // Si tengo anterior => asigno al siguiente del anterior de temp el siguiente de temp.
        // Basicamente conecto el Nodo anterior (temp.ant) con el Nodo siguiente (temp.sig), 
        // descartando el Nodo intermedio (temp). 
        // temp.ant <-> temp.sig
        if (temp.ant != null) {
            temp.ant.sig = temp.sig;
        } else { 
            // Si no tengo anterior => quiero eliminar el primero
            actual = temp.sig;
        }
        // Si no tengo siguiente => quiero eliminar el ultimo
        if (temp.sig != null) {
            temp.sig.ant = temp.ant;
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
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
