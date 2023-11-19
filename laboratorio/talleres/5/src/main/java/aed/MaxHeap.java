package aed;

public class MaxHeap {
    
    private Router[] heap;
    private int size;

    public MaxHeap(Router[] s){ // Array2Heap

        // inicializo size y heap
        this.size = s.length;
        this.heap = s;

        // Algoritmo de Floyd
        for (int i = (size / 2) - 1; i >= 0; i--) {
            bajar(i);
        }
    }

    public MaxHeap(int n){
        heap = new Router[n];
        size = 0;
    }

    public Router desencolarRaiz (){

        Router raizOriginal = heap[0];

        intercambiar(0, size-1);
        size --;
        bajar(0);
        
        return raizOriginal;

    }

    public void bajar(int indice) {
        while (!esHoja(indice)) {
            int indiceHijoIzquierdo = posHijoIzquierdo(indice);
            int indiceHijoDerecho = posHijoDerecho(indice);
            int indiceMayor = indiceHijoIzquierdo;

            if (posHijoDerecho(indice) < size && heap[indiceHijoDerecho].getTrafico() > heap[indiceHijoIzquierdo].getTrafico()) {
                indiceMayor = indiceHijoDerecho;
            }

            if (heap[indice].getTrafico() > heap[indiceMayor].getTrafico()) {
                break;
            } else {
                intercambiar(indice, indiceMayor);
            }

            indice = indiceMayor;
        }
    }

    public void intercambiar(int indice1, int indice2) {
        Router temp = this.heap[indice1];
        heap[indice1] = heap[indice2];
        heap[indice2] = temp;
    }

    public boolean esHoja(int indice) {return posHijoIzquierdo(indice) >= size;}

    public int posHijoDerecho(int indice) {return 2*indice + 2;}

    public int posHijoIzquierdo(int indice) {return 2*indice + 1;}
}
