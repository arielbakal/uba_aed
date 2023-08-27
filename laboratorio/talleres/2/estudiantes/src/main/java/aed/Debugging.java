package aed;

class Debugging {
    boolean xor(boolean a, boolean b) {
        return (a || b) && !(a && b);
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;

        if (ys.length != xs.length) {
            res = false;
            return res;
        }

        for (int i = 0; i < xs.length; i++) {
            if (xs[i] != ys[i]) {
                res = false;
            }
        }
        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;

        if (xs.length > 1) {
            for (int i = 0; i < xs.length - 1; i++) {
                if (xs[i] > xs[i+1]) {
                    res = false;
                }
            }
        }
        
        return res;
    }

    int maximo(int[] xs) {
        int res = 0;

        if (xs.length > 0) {
            res = xs[0];
            for (int i = 0; i < xs.length; i++) {
                if (xs[i] > res) {
                    res = xs[i];
                }
            }
        }

        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = true;

        if (xs.length > 0) {
            for (int x : xs) {
                if (x > 0) {
                    res = true;
                } else {
                    res = false;
                    return res;
                }
            }
        }
        
        return res;
    }
}
