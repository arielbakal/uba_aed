package aed;

public class InternetToolkit {

    public InternetToolkit() {
    }

    public Fragment[] tcpReorder(Fragment[] fragments) { // promedio O(n)

        // Dado que la probabilidad de que haya un elemento fuera de orden es muy baja (0.01) y ademas en ese caso el elemento en general 
        // esta ubicado en una posicion “relativamente cercana” a la que le corresponde, podriamos utilizar insertion sort. El cual
        // solamente necesitaria arreglar esa posicion y tendria un bajo costo por su cercania a la posicion correspondiente
        
        for (int i = 1; i < fragments.length; i++) { // itera todos las posiciones i O(n)
            Fragment key = fragments[i]; // O(1)
            int j = i - 1; // O(1)

            // Mover los elementos mayores que key a una posición adelante
            while (j >= 0 && fragments[j].compareTo(key) == 1) { // true si j (inicialmente i-1) es mayor a i. Θ(n)
                fragments[j + 1] = fragments[j]; // O(1)
                j--; // O(1)
            }
            
            fragments[j + 1] = key; // O(1)
        }

        // Tenemos nuestro peor caso Θ(n*n). Sin embargo, anteriormente mencionamos que tenemos una sola posicion 
        // desordenada, la cual, esta relativamente cerca a su posicion correspondiente. Ademas tenemos una probabilidad
        // de 0.01 de que tengamos que ordenar. Esto reduce drasticamente el costo promedio de ejecutar el bloque a O(1). 
        // Luego tenemos una complejidad promedio O(n*1)=O(n) 

        return fragments;
    }

    public Router[] kTopRouters(Router[] routers, int k, int umbral) { // O( n + k*log n )
        // IMPLEMENTAR
        return null;
    }

    public IPv4Address[] sortIPv4(String[] ipv4) { // puede ser O(n^2), Posible radix sort
        // IMPLEMENTAR
        return null;
    }

}
