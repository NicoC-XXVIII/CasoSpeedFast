package com.sfempresa.entregas;

public class Pedido {

    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;

    public Pedido(String idPedido, String direccionEntrega, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    // Método de salida genérico:
    public void asignarRepartidor() {
        System.out.println("[Pedido genérico]");
        System.out.println("Asignando a un repartidor...");
        System.out.println("→ Pedido asignado a un repartidor");
    }

    // Método de salida sobrecargado:
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[Pedido genérico]");
        System.out.println("Asignando a un repartidor...");
        System.out.println("→ Pedido asignado a " + nombreRepartidor);

    }
}
