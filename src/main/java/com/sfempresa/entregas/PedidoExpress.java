package com.sfempresa.entregas;

import com.sfempresa.interfaces.*;

public class PedidoExpress extends Pedido implements Despachable, Cancelable {

    public PedidoExpress(String idPedido, String direccionEntrega,
                         double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    // Método para asignar repartidor para pedidos express:
    @Override
    public void asignarRepartidor() {
        /*Asignación automática.
          Búsqueda de repartidor más cercano disponible
        */
        this.asignarRepartidor( "Repartidor Express cercano disponible");
    }

    /* Cálculo de tiempo de entrega para pedidos expréss
     * tiempo = 10 min base + 5 min extra si la distancia > 5 km
     */
    @Override
    public int calcularTiempoEntrega() {
        int tiempo = 10;
        if (getDistanciaKm() > 5) {
            tiempo += 5;
        }
        return tiempo;
    }

    @Override
    public void despachar() {
        System.out.println("Pedido despachado correctamente!");
    }

    @Override
    public void cancelar() {
        System.out.println("Pedido Express #" + getIdPedido() + " cancelado exitosamente.");
    }
}
