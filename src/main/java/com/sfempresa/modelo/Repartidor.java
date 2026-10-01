package com.sfempresa.modelo;

/**
 * Representa un repartidor de SpeedFast.
 * Se corresponde con la tabla "repartidor" en la BD.
 */
public class Repartidor {

    private int id;
    private String nombre;

    public Repartidor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}
