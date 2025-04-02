package com.felieppe;

public class Marcapasos {
    short presionSanguinea;
    short frecuenciaCardiaca;
    int nivelAzucarSangre;
    long maximaFuerzaExpuesta;
    float tiempoEntreLatidos;
    double bateriaRestante;
    String codigoFabricante;

    /**
     * short: 2 bytes
     * int: 4 bytes
     * long: 8bytes
     * float: 4 bytes
     * double: 8 bytes
     * String: 8 bytes
     *
     * TOTAL: 28 bytes
     * */

    public Marcapasos(short presionSanguinea, short frecuenciaCardiaca, int nivelAzucarSangre, long maximaFuerzaExpuesta, float tiempoEntreLatidos, double bateriaRestante, String codigoFabricante) {
        this.presionSanguinea = presionSanguinea;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.nivelAzucarSangre = nivelAzucarSangre;
        this.maximaFuerzaExpuesta = maximaFuerzaExpuesta;
        this.tiempoEntreLatidos = tiempoEntreLatidos;
        this.bateriaRestante = bateriaRestante;
        this.codigoFabricante = codigoFabricante;
    }
}
