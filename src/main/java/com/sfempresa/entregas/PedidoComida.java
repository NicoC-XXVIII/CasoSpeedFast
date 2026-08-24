package com.sfempresa.entregas;

public class PedidoComida extends Pedido {

    private String idPedido;

    public PedidoComida(String idPedido, String direccionEntrega,
                        double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.idPedido = idPedido;
    }

    // Método para mostrar el tipo de pedido:
    @Override
    public void mostrarResumen() {
        System.out.println("Pedido Comida #" + idPedido);
        super.mostrarResumen();
    }

    /* Cálculo de tiempo de entrega para pedidos de comida
     * tiempo = 15 min + 2 min por cada kilómetro.
     */
    @Override
    public int calcularTiempoEntrega() {
        return 15 + (int)(2 * getDistanciaKm());
    }
}
