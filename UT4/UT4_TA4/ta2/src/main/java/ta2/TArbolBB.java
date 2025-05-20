package ta2;

/* public class TArbolBB<T> {
    private TElementoAB raiz;
    int contador = 0;

    public<T> boolean insertar(Comparable Etiqueta) {
        if (raiz == null) {
            return false;
        } else {
            return raiz.insertar(Etiqueta);
        }

        
    } 
}  */

public class TArbolBB<T> {
    private TElementoAB raiz;
    private int contador = 0;

    public boolean insertar(Comparable etiqueta) {
        contador++;
        System.out.println("Contador: " + contador);
        TElementoAB elElemento = new TElementoAB(etiqueta);
        if (raiz == null) {
            raiz = elElemento;
            return true;
        } else {
            return raiz.insertar(elElemento);
        }
    }

    public int getContador() {
        return contador;
    }

    public TElementoAB buscar(Comparable etiqueta) {
        if (this.raiz == null) {
            return null;
        } else {
            return this.raiz.buscar(etiqueta);
        }
    }

    public String postOrden(){
        int i = 0;
        return i; 
    }

    public int obtenerAltura() {
        int i = 0;
        return i;
    }

    public int obtenerTamaño() {

        if (raiz == null) {
            return 0;
        } else {
            int izquierdo = (raiz.getHijoIzq() == null ? 0 : raiz.getHijoIzq().obtenerTamaño());
            int derecho = (raiz.getHijoDer() == null ? 0 : raiz.getHijoDer().obtenerTamaño());

            return izquierdo + derecho + 1; 
        }
    }

    public void setRaiz(TElementoAB elemento) {
        this.raiz = elemento;
    }
}


/* 
public class TArbolBB<T>{
    private TElementoAB raiz;
    private int contador = 0;

    public boolean insertar(Comparable etiqueta, T dato) {
        contador++;
        System.out.println("Contador: " + contador);
        if (raiz == null) {
            raiz = new TElementoAB<>(etiqueta, dato);
            return true;
        } else {
            return raiz.insertar(new TElementoAB<>(etiqueta, dato));
        }
    }
} */