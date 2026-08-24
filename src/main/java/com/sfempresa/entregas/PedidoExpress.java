package com.sfempresa.entregas;

public class PedidoExpress extends Pedido{

    private String idPedido;

    public PedidoExpress(String idPedido, String direccionEntrega,
                         double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.idPedido = idPedido;
    }

    // Método para mostrar el tipo de pedido:
    @Override
    public void mostrarResumen() {
        System.out.println("Pedido Express #" + idPedido);
        super.mostrarResumen();
    }

    /* Cálculo de tiempo de entrega para pedidos expréss
     * tiempo = 10 min base + 5 min extra si distancia > 5 km
     */
    @Override
    public int calcularTiempoEntrega() {
        int tiempo = 10;
        if (getDistanciaKm() > 5) {
            tiempo += 5;
        }
        return tiempo;
    }
}
