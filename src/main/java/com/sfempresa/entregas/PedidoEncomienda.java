package com.sfempresa.entregas;

public class PedidoEncomienda extends Pedido {

    private String idPedido;

    public PedidoEncomienda(String idPedido, String direccionEntrega,
                            double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.idPedido = idPedido;
    }

    // Método para mostrar el tipo de pedido:
    @Override
    public void mostrarResumen() {
        System.out.println("Pedido Encomienda #" + idPedido);
        super.mostrarResumen();
    }

    /* Cálculo de tiempo de entrega para pedidos de encomienda
     * tiempo = 20 min + 1.5 min por kilómetro
     */
    @Override
    public int calcularTiempoEntrega() {
        double tiempo = 20 + (1.5 * getDistanciaKm());
        return (int) Math.round(tiempo);
    }
}
