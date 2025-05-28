package uy.edu.ucu.aed;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uy.edu.ucu.aed.modelo.CatalogoPeliculas;
import uy.edu.ucu.aed.modelo.ClavePelicula;
import uy.edu.ucu.aed.modelo.Pelicula;
import uy.edu.ucu.aed.parcial.CatalogoPeliculasAVL;
import uy.edu.ucu.aed.tdas.ILista;
import uy.edu.ucu.aed.tdas.Lista;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for implemented methods.
 */
public class Parcial1Test_Junit5
{
    CatalogoPeliculas catalogo;

    @BeforeEach
    public void setUp() {
        catalogo = new CatalogoPeliculasAVL();
    }

    @AfterEach
    public void tearDown() {
        catalogo = null;
    }

    @Test
    public void insertarPeliculaNula() {
        Pelicula pelicula = new Pelicula("Harry Potter", 2000, "Cualquiera", 2.5f);
        ClavePelicula clave = new ClavePelicula(pelicula.getPuntaje(), pelicula.getTitulo());
        
        catalogo.insertarPelicula(pelicula);
    
        ILista encontradas = new Lista<Pelicula>();
        encontradas = catalogo.buscarPorGenero("Cualquiera");
        
        assertEquals(pelicula, encontradas.buscar(clave));
    }

    @Test
    public void buscarPorGenero() {
        String genero = "Cualquiera";

        Pelicula pelicula = new Pelicula("Harry Potter", 2000, genero, 2.5f);
        ClavePelicula clave = new ClavePelicula(pelicula.getPuntaje(), pelicula.getTitulo());
        
        Pelicula pelicula2 = new Pelicula("Harry Potter 2", 2000, genero, 2.5f);
        ClavePelicula clave2 = new ClavePelicula(pelicula.getPuntaje(), pelicula.getTitulo());

        catalogo.insertarPelicula(pelicula);
        catalogo.insertarPelicula(pelicula2);

        ILista encontradas = new Lista<Pelicula>();
        encontradas = catalogo.buscarPorGenero(genero);
        
        assertEquals(pelicula, encontradas.buscar(clave));
        assertEquals(pelicula, encontradas.buscar(clave2));
    }

    @Test
    public void buscarPorGeneroQueNoExiste() {
        String genero = "Cualquiera";

        Pelicula pelicula = new Pelicula("Harry Potter", 2000, "Terror", 2.5f);
        ClavePelicula clave = new ClavePelicula(pelicula.getPuntaje(), pelicula.getTitulo());
        
        Pelicula pelicula2 = new Pelicula("Harry Potter 2", 2000, "Terror", 2.5f);
        ClavePelicula clave2 = new ClavePelicula(pelicula.getPuntaje(), pelicula.getTitulo());

        catalogo.insertarPelicula(pelicula);
        catalogo.insertarPelicula(pelicula2);

        ILista encontradas = new Lista<Pelicula>();
        encontradas = catalogo.buscarPorGenero(genero);

        assertEquals(0, encontradas.cantElementos());
    }

    @Test
    public void buscarPorPuntajeTodosNulos() {
        Float minimo = null;
        Float maximo = null;

        Pelicula pelicula = new Pelicula("Harry Potter", 2000, "Cualquiera", 2.5f);
        ClavePelicula clave = new ClavePelicula(pelicula.getPuntaje(), pelicula.getTitulo());
        
        Pelicula pelicula2 = new Pelicula("Harry Potter 2", 2000, "Cualquiera", 2.5f);
        ClavePelicula clave2 = new ClavePelicula(pelicula.getPuntaje(), pelicula.getTitulo());

        catalogo.insertarPelicula(pelicula);
        catalogo.insertarPelicula(pelicula2);

        ILista encontradas = new Lista<Pelicula>();
        encontradas = catalogo.buscarPorPuntaje(minimo, maximo);
        
        assertEquals(pelicula, encontradas.buscar(clave));
        assertEquals(pelicula, encontradas.buscar(clave2));
    }

    @Test
    public void buscarPorPuntajeMinimo() {
        Float minimo = 2.0f;
        Float maximo = null;

        Pelicula pelicula = new Pelicula("Harry Potter", 2000, "Cualquiera", 2.5f);
        ClavePelicula clave = new ClavePelicula(pelicula.getPuntaje(), pelicula.getTitulo());
        
        Pelicula pelicula2 = new Pelicula("Harry Potter 2", 2000, "Cualquiera", 1f);
        ClavePelicula clave2 = new ClavePelicula(pelicula.getPuntaje(), pelicula.getTitulo());

        catalogo.insertarPelicula(pelicula);
        catalogo.insertarPelicula(pelicula2);

        ILista encontradas = new Lista<Pelicula>();
        encontradas = catalogo.buscarPorPuntaje(minimo, maximo);
        
        assertEquals(pelicula, encontradas.buscar(clave));
    }

    @Test
    public void buscarPorPuntajeMaximo() {
        Float minimo = null;
        Float maximo = 5.0f;

        Pelicula pelicula = new Pelicula("Harry Potter", 2000, "Cualquiera", 2.5f);
        ClavePelicula clave = new ClavePelicula(pelicula.getPuntaje(), pelicula.getTitulo());
        
        Pelicula pelicula2 = new Pelicula("Harry Potter 2", 2000, "Cualquiera", 1f);
        ClavePelicula clave2 = new ClavePelicula(pelicula2.getPuntaje(), pelicula2.getTitulo());

        catalogo.insertarPelicula(pelicula);
        catalogo.insertarPelicula(pelicula2);

        ILista<Pelicula> encontradas = new Lista<Pelicula>();
        encontradas = catalogo.buscarPorPuntaje(minimo, maximo);

        assertEquals(pelicula2, encontradas.buscar(clave2));
        assertEquals(pelicula, encontradas.buscar(clave));
    }

    @Test
    public void buscarPorPuntaje() {
        Float minimo = 2.0f;
        Float maximo = 5.0f;

        Pelicula pelicula = new Pelicula("Harry Potter", 2000, "Cualquiera", 2.5f);
        ClavePelicula clave = new ClavePelicula(pelicula.getPuntaje(), pelicula.getTitulo());
        
        Pelicula pelicula2 = new Pelicula("Harry Potter 2", 2000, "Cualquiera", 1f);
        ClavePelicula clave2 = new ClavePelicula(pelicula.getPuntaje(), pelicula.getTitulo());

        catalogo.insertarPelicula(pelicula);
        catalogo.insertarPelicula(pelicula2);

        ILista encontradas = new Lista<Pelicula>();
        encontradas = catalogo.buscarPorPuntaje(minimo, maximo);
        
        assertEquals(pelicula, encontradas.buscar(clave));
        assertNotEquals(pelicula2, encontradas.buscar(clave2));
    }

    @Test
    public void buscarPorGeneroVacio() {
        String genero = "";

        Pelicula pelicula = new Pelicula("Harry Potter", 2000, "Terror", 2.5f);
        Pelicula pelicula2 = new Pelicula("Harry Potter 2", 2000, "Terror", 2.5f);

        catalogo.insertarPelicula(pelicula);
        catalogo.insertarPelicula(pelicula2);

        ILista encontradas = new Lista<Pelicula>();
        encontradas = catalogo.buscarPorGenero(genero);

        assertEquals(2, encontradas.cantElementos());
    }

    @Test
    public void buscarPorGeneroDevuelveListaOrdenadaPorAñoAscendente(){
        String genero = "Terror";

        Pelicula pelicula = new Pelicula("Harry Potter", 2005, genero, 2.5f);
        Pelicula pelicula2 = new Pelicula("Harry Potter 2", 2001, genero, 2.5f);

        catalogo.insertarPelicula(pelicula);
        catalogo.insertarPelicula(pelicula2);

        ILista<Pelicula> encontradas = new Lista<Pelicula>();
        encontradas = catalogo.buscarPorGenero(genero);
        int[] expectativa = {2001, 2005};
        int[] anios = new int[2];
        int x = 0;
        for (Pelicula peli : encontradas){
            anios[x] = peli.getAnio();
            x++;
        }

        assertArrayEquals(expectativa, anios);
    }

}
