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
       
        // Convierto routers en un MaxHeap usando Array2Heap O(n)
        MaxHeap heap = new MaxHeap(routers); // O(n)
        Router[] routers_temp = new Router[k]; // O(1)

        // Desencolar k veces y asignar a routers_temp hasta que no supere umbral O(k*log n)
        for(int i = 0; i < k; i++){ // O(k)
            Router temp = heap.desencolarRaiz(); // O(log n)
            if (temp.getTrafico() > umbral){
                routers_temp[i] = temp;
            }
        }

        // O(n + k*log n)

        return routers_temp;
    }

    public IPv4Address[] sortIPv4(String[] ipv4) { // O(n^2)

        IPv4Address[] ipv4_res = new IPv4Address[ipv4.length]; // O(1)

        // Radix sort, ordeno 4 veces para cada octeto empezando con el de menor prioridad
        for(int k = 3; k >= 0; k--){ // O(4)

            // Ordeno usando Insertion Sort O(n*n)
            for (int i = 1; i < ipv4.length; i++) { // itera todos las posiciones i O(n)
                String key = ipv4[i]; // O(1)
                int j = i - 1; // O(1)

                // Mover los elementos mayores que key a una posición adelante
                while (j >= 0 && getOcteto(ipv4[j], k) > getOcteto(key, k)) { // true si j (inicialmente i-1) es mayor a i. Θ(n)
                    ipv4[j + 1] = ipv4[j]; // O(1)
                    j--; // O(1)
                }

                ipv4[j + 1] = key; // O(1)
            }
        }

        // Transformo los strings a IPv4Adresses
        for (int i = 0; i < ipv4.length; i++){ // O(n)
            IPv4Address temp = new IPv4Address(ipv4[i]);
            ipv4_res[i] = temp;
        }

        // Complejidad O(1 + 4*O(n*n) + O(n)) = O(n*(n+1)) = O(n*n)

        return ipv4_res;
    }

    private int getOcteto(String ipv4, int k){
        IPv4Address temp = new IPv4Address(ipv4);
        int octeto = temp.getOctet(k);
        return octeto;
    }

}
