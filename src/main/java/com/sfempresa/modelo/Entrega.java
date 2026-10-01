package com.sfempresa.modelo;

/**
 * Representa una entrega realizada por un repartidor,
 * para un pedido específico.
 * Se corresponde con la tabla "entrega" de la BD.
 */
public class Entrega {

    private int id;
    private int idPedido;
    private int idRepartidor;

    public Entrega(int id, int idPedido, int idRepartidor) {
        this.id = id;
        this.idPedido = idPedido;
        this.idRepartidor = idRepartidor;
    }

    public int getId() { return id; }
    public int getIdPedido() { return idPedido; }
    public int getIdRepartidor() { return idRepartidor; }
}
