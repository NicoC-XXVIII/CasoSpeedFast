package com.sfempresa.modelo;

/**
 * Modelo que representa un pedido dentro del sistema SpeedFast.
 */
public class Pedido {

    private int id;
    private String direccion;
    private String tipo;     // COMIDA | ENCOMIENDA | EXPRESS
    private String estado;   // PENDIENTE | EN_REPARTO | ENTREGADO

    public Pedido(int id, String direccion, String tipo, String estado) {
        this.id = id;
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = estado;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
