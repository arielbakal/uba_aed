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

    public T minimo() {
        Nodo nodo_minimo = buscarMinimo(_raiz);
        return (nodo_minimo != null) ? nodo_minimo.valor : null;
    }
    
    public T maximo() {
        Nodo nodo_maximo = buscarMaximo(_raiz);
        return (nodo_maximo != null) ? nodo_maximo.valor : null;
    }
    
    private Nodo buscarMinimo(Nodo nodo) {
        if (nodo == null) {return null;}
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }
    
    private Nodo buscarMaximo(Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        while (nodo.der != null) {
            nodo = nodo.der;
        }
        return nodo;
    }
    
    public void insertar(T elem) {
        if (!pertenece(elem)) {
            _raiz = insertarRecursivo(_raiz, elem);
            _cardinal++;
        }
    }
    
    private Nodo insertarRecursivo(Nodo nodo, T elem) {
        if (nodo == null) {
            return new Nodo(elem);
        }
        if (elem.compareTo(nodo.valor) < 0) {
            nodo.izq = insertarRecursivo(nodo.izq, elem);
        } else if (elem.compareTo(nodo.valor) > 0) {
            nodo.der = insertarRecursivo(nodo.der, elem);
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

    private Nodo buscarNodo(Nodo nodo, T valor) {
        if (nodo == null || valor.compareTo(nodo.valor) == 0) {
            return nodo;
        }
        if (valor.compareTo(nodo.valor) < 0) {
            return buscarNodo(nodo.izq, valor);
        } else {
            return buscarNodo(nodo.der, valor);
        }
    }

    public void eliminar(T elem) {
        if (pertenece(elem)) {
            _raiz = eliminarNodo(_raiz, elem);
            _cardinal--;
        }
    }
    
    private Nodo eliminarNodo(Nodo nodo, T elem) {
        if (nodo == null) {
            return nodo;
        }
    
        if (elem.compareTo(nodo.valor) < 0) {
            nodo.izq = eliminarNodo(nodo.izq, elem);
        } else if (elem.compareTo(nodo.valor) > 0) {
            nodo.der = eliminarNodo(nodo.der, elem);
        } else {
            // Nodo a eliminar encontrado
    
            // Caso 1: Nodo sin hijos o con un solo hijo
            if (nodo.izq == null) {
                return nodo.der;
            } else if (nodo.der == null) {
                return nodo.izq;
            }
    
            // Caso 2: Nodo con dos hijos
            Nodo sucesor = buscarMinimo(nodo.der);
            nodo.valor = sucesor.valor;
            nodo.der = eliminarNodo(nodo.der, sucesor.valor);
        }
        return nodo;
    }
    
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("{");
        imprimirEnOrden(_raiz, buffer);
        if (buffer.length() > 1) {
            buffer.setLength(buffer.length() - 1);
        }
        buffer.append("}");
        return buffer.toString();
    }
    
    private void imprimirEnOrden(Nodo nodo, StringBuilder buffer) {
        if (nodo == null) {
            return;
        }
        imprimirEnOrden(nodo.izq, buffer);
        buffer.append(nodo.valor).append(",");
        imprimirEnOrden(nodo.der, buffer);
    }

    private class ABB_Iterador implements Iterador<T> {
        private Stack<Nodo> pila;

        public ABB_Iterador() {
            pila = new Stack<>();
            Nodo nodo = _raiz;
            while (nodo != null) {
                pila.push(nodo);
                nodo = nodo.izq;
            }
        }

        public boolean haySiguiente() {
            return !pila.isEmpty();
        }

        public T siguiente() {
            if (!haySiguiente()) {
                throw new UnsupportedOperationException("No hay más elementos");
            }
            Nodo nodoActual = pila.pop();
            T valor = nodoActual.valor;

            // Agregar nodos del subárbol derecho al camino hacia el sucesor
            Nodo subarbolDerecho = nodoActual.der;
            while (subarbolDerecho != null) {
                pila.push(subarbolDerecho);
                subarbolDerecho = subarbolDerecho.izq;
            }

            return valor;
        }
    }


    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
