package com.example;

public class TNodoArbolGenerico {
    private String etiqueta;
    private TNodoArbolGenerico primerHijo;
    private TNodoArbolGenerico hermanoDerecho;
    private Object datos;  // Puede ser cualquier tipo de objeto que almacene información relevante.

    public TNodoArbolGenerico(String etiqueta) {
        this.etiqueta = etiqueta;
        this.primerHijo = null;
        this.hermanoDerecho = null;
        this.datos = null;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public TNodoArbolGenerico getPrimerHijo() {
        return primerHijo;
    }

    public void setPrimerHijo(TNodoArbolGenerico primerHijo) {
        this.primerHijo = primerHijo;
    }

    public TNodoArbolGenerico getHermanoDerecho() {
        return hermanoDerecho;
    }

    public void setHermanoDerecho(TNodoArbolGenerico hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }

    // Método para insertar un hijo en este nodo.
    public boolean insertarHijo(TNodoArbolGenerico nodo) {
        if (primerHijo == null) {
            primerHijo = nodo;
        } else {
            TNodoArbolGenerico temp = primerHijo;
            while (temp.hermanoDerecho != null) {
                temp = temp.hermanoDerecho;
            }
            temp.setHermanoDerecho(nodo);
        }
        return true;
    }

    // Método para buscar un nodo en los hijos y hermanos de este nodo.
    public TNodoArbolGenerico buscar(String etiqueta) {
        if (this.etiqueta.equals(etiqueta)) {
            return this;
        }
        if (primerHijo != null) {
            TNodoArbolGenerico resultado = primerHijo.buscar(etiqueta);
            if (resultado != null) {
                return resultado;
            }
        }
        if (hermanoDerecho != null) {
            return hermanoDerecho.buscar(etiqueta);
        }
        return null;
    }
    
    public TNodoArbolGenerico getRoot() {
        return this;
    }

    public char[] getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

    public TNodoArbolGenerico getHijoIzquierdo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHijoIzquierdo'");
    }
}
