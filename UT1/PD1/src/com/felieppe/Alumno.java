package com.felieppe;

public class Alumno {
    private String nombre;
    public Alumno () {
        this.nombre = "Felipe";
    }
    public String getNombreAdmiracion() {
        return this.nombre.concat("!");
    }
}