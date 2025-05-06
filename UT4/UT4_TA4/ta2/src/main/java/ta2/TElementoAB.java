package ta2;

public class TElementoAB {
    Comparable Etiqueta;
    TElementoAB HijoIzq;
    TElementoAB HijoDer;

    public TElementoAB(Comparable etiqueta) {
        this.Etiqueta = etiqueta;
    }

    public Comparable getEtiqueta() {
        return this.Etiqueta;
    }

    public TElementoAB getHijoIzq() {
        return this.HijoIzq;
    }

    public TElementoAB getHijoDer() {
        return this.HijoDer;
    }    
    public void setHijoIzq(TElementoAB elemento) {
        this.HijoIzq = elemento;
    }
    public void setHijoDer(TElementoAB elemento) {
        this.HijoDer = elemento;
    }

    public boolean insertar(TElementoAB unElemento) {
        if (unElemento.Etiqueta.compareTo(this.Etiqueta) == 0) {
            return false;  // ya está en el árbol
        }
        if (unElemento.Etiqueta.compareTo(this.Etiqueta) < 0) {
            if (this.HijoIzq == null) {
                this.HijoIzq = unElemento;
                return true;
            } else {
                return this.HijoIzq.insertar(unElemento);
            }
        } else {
            if (this.HijoDer == null) {
                this.HijoDer = unElemento;
                return true;
            } else {
                return this.HijoDer.insertar(unElemento);
            }
        }
    }

    public TElementoAB buscar(Comparable etiqueta) {
        if (etiqueta == this.Etiqueta) {
            return this;
        } else if (etiqueta.compareTo(this.Etiqueta) < 0) {
            if(getHijoIzq() != null) {
                return getHijoIzq().buscar(etiqueta);
            } else {
                return null;
            }
        } else if (etiqueta.compareTo(this.Etiqueta) > 0){
            if(getHijoDer() != null) {
                return getHijoDer().buscar(etiqueta);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    public String postOrden(){
        String postorden = "";
        if (getHijoIzq() == null) {
            getHijoDer().postOrden();
        } else {
            getHijoIzq().postOrden();
        }
        if(getHijoDer() == null) {
            postorden += this.getEtiqueta();
        } else {
            getHijoDer().postOrden();
        }
        return postorden;
    }   

    public <T> boolean insertar(Comparable etiqueta2, T dato) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    public TElementoAB eliminarNodo(Comparable etiqueta) {
        if (etiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.getHijoIzq() != null) {
                getHijoIzq().eliminarNodo(etiqueta);
            }
            return this;
        } else if(etiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.getHijoDer() != null) {
                getHijoDer().eliminarNodo(etiqueta);
            }
            return this;
        }
        return null;
    }

    public int obtenerAltura() {
        return 0;
    }

    public int obtenerTamaño() {
        return 1 + (this.HijoIzq != null ? this.HijoIzq.obtenerTamaño() : 0) + (this.HijoDer != null ? this.HijoDer.obtenerTamaño() : 0);
    }
}
