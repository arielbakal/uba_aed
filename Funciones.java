package aed;

class Funciones {
    int cuadrado(int x) {
        int res = x * x;
        return res;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt( x * x + y * y );
        return res;
    }

    boolean esPar(int n) {
        boolean res = n % 2 == 0;
        return res;
    }

    boolean esBisiesto(int n) {
        boolean res = ( (n % 4 == 0) && !(n % 100 == 0) ) || (n % 400 == 0);
        return res;
    }

    int factorialIterativo(int n) {
        int res = 1;
        if (n == 0) {
            return res;
        } else {
            for(int i = n; i != 0; i = i -1) {
                res = res * i;
            }
            return res;
        }
            
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if ( n == 0 ) {
            return res;
        } else {
            res = n * factorialIterativo(n-1);
        }
        return res;
    }

    boolean esPrimo(int n) {
        boolean res;
        int contador = 0;
        for (int i = 1; n+1 != i; i++){
            if (n % i == 0){
                contador += 1;
            }
        }
        res = contador == 2;
        return res;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        if (numeros.length == 0) {
            return res;
        }
        for (int i = 0; numeros.length != i ;i = i + 1) {
            res += numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;
        for(int i = 0; numeros.length != i; i++){
            if (buscado == numeros[i]) {
                res = i;
                return res;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        for(int i = 0; numeros.length != i; i++) {
            if (esPrimo(numeros[i])) {
                return true;
            }
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;
        for(int i = 0; numeros.length != i ; i++){
            res = res && esPar(numeros[i]);
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res = true;
        if (s1.length() > s2.length()) {
            return false;
        }
        for(int i = 0; s1.length() != i ; i++){
            res = res && s2.charAt(i) == s1.charAt(i);
        }
        return res;
    }

    String reverse(String str){
        if (str.isEmpty()) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    boolean esSufijo(String s1, String s2) {
        boolean res = esPrefijo(reverse(s1), reverse(s2));
        return res;
    }
}
