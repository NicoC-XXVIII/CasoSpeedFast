package com.sfempresa.entregas;

import com.sfempresa.interfaces.*;

public class PedidoComida extends Pedido implements Despachable, Cancelable {

    public PedidoComida(String idPedido, String direccionEntrega,
                        double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    // Método para asignar repartidor para pedidos de comida:
    @Override
    public void asignarRepartidor() {
        /*Asignación automática.
          Se requiere que el repartidor lleve mochila térmica
        */
        this.repartidorAsignado = "Javier C (lleva mochila térmica)";
        }

        /* Cálculo de tiempo de entrega para pedidos de comida
         * tiempo = 15 min + 2 min por cada kilómetro.
        */
    @Override
    public int calcularTiempoEntrega() {
        return 15 + (int)(2 * getDistanciaKm());
    }

    @Override
    public void despachar() {
        System.out.println("Pedido despachado correctamente!");
    }

    @Override
    public void cancelar() {
        System.out.println("Pedido Comida #" + getIdPedido() + " cancelado exitosamente.");
    }
}
