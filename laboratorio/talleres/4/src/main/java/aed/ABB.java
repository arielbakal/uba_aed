package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    
    private Nodo _raiz;
    private int _cardinal;

    private class Nodo {
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;
        
        Nodo(T v){
            valor = v;
            izq = null;
            der = null;
            padre = null;
        }
    }

    public ABB() {
        _raiz = null;
        _cardinal = 0;
    }

    public int cardinal() {
        return _cardinal;
    }

    public T minimo(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public T maximo(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void insertar(T elem) {
        if (!pertenece(elem)) {
            _raiz = insertarRec(_raiz, elem);
            _cardinal++;
        }
    }
    
    private Nodo insertarRec(Nodo nodo, T elem) {
        if (nodo == null) {
            return new Nodo(elem);
        }
        if (elem.compareTo(nodo.valor) < 0) {
            nodo.izq = insertarRec(nodo.izq, elem);
        } else if (elem.compareTo(nodo.valor) > 0) {
            nodo.der = insertarRec(nodo.der, elem);
        }
        return nodo;
    }

    public boolean pertenece(T elem){
        Nodo actual = _raiz;
        while (actual != null) {
            if (elem.compareTo(actual.valor) == 0) {
                return true;
            } else if (elem.compareTo(actual.valor) < 0) {
                actual = actual.izq;
            } else {
                actual = actual.der;
            }
        }
        return false;
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
