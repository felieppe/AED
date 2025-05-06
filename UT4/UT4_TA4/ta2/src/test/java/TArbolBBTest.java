import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ta2.TArbolBB;
import ta2.TElementoAB;

public class TArbolBBTest {
    @Test
    void testObtenerAlturaVacio() {
        //Given 
        TArbolBB arbol = new TArbolBB();
        //When
        int t = arbol.obtenerAltura();
        //Then
        assertEquals(t, -1);
               
    }
    @Test
    void testObtenerAlturaSoloRaiz() {
        //Given
        TArbolBB arbol = new TArbolBB();
        //When
        arbol.insertar(10);
        int t = arbol.obtenerAltura();
        //Then
        assertEquals(t, 0);
    }
    @Test
    void testObtenerAlturaConElementos() {
        //Given
        TArbolBB arbol = new TArbolBB();
        
        //When
        TElementoAB elem1 = new TElementoAB(1);
        TElementoAB elem2 = new TElementoAB(2);
        TElementoAB elem3 = new TElementoAB(3);
        TElementoAB elem4 = new TElementoAB(4);

        arbol.setRaiz(elem1);
        elem1.setHijoIzq(elem2);
        elem1.setHijoDer(elem3);
        elem3.setHijoDer(elem4);

        int t = arbol.obtenerAltura();
        //Then
        assertEquals(t, 2);
        
    }

    @Test
    void testObtenerTamañoNoVacio() {
        TElementoAB elem1 = new TElementoAB(1);
        TElementoAB elem2 = new TElementoAB(2);
        TElementoAB elem3 = new TElementoAB(3);
        TElementoAB elem4 = new TElementoAB(4);
        TArbolBB<TElementoAB> arbol = new TArbolBB<>();
        arbol.setRaiz(elem1);
        elem1.setHijoIzq(elem2);
        elem1.setHijoDer(elem3);
        elem3.setHijoDer(elem4);
        int tamaño = arbol.obtenerTamaño();
        assertEquals(tamaño, 4);
        System.out.println("el tamaño es: " + tamaño);
    }

    @Test
    void testObtenerTamañoVacio() {
        TElementoAB raiz = null;
        TArbolBB<TElementoAB> arbol = new TArbolBB<>();
        arbol.setRaiz(raiz);
        int tamaño = arbol.obtenerTamaño();
        assertEquals(tamaño, 0);
        System.out.println("el tamaño es:" + tamaño);
    }

    @Test
    void testObtenerTamañoRaiz() {
        TElementoAB raiz = new TElementoAB(1);
        TArbolBB<TElementoAB> arbol = new TArbolBB<>();
        arbol.setRaiz(raiz);
        int tamaño = arbol.obtenerTamaño();
        assertEquals(tamaño, 1);
        System.out.println("el tamaño es:" + tamaño);
    }
}
