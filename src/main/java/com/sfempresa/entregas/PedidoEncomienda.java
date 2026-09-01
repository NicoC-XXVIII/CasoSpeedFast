package com.sfempresa.entregas;

import com.sfempresa.interfaces.*;

public class PedidoEncomienda extends Pedido implements Despachable, Cancelable {

    public PedidoEncomienda(String idPedido, String direccionEntrega,
                            double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    // Método para asignar repartidor para pedidos de encomienda:
    @Override
    public void asignarRepartidor() {
        /*Asignación automática.
          Se requiere validación de peso y embalaje
        */
        this.repartidorAsignado = "Daniela A (validación de peso y embalaje)";
    }

    /* Cálculo de tiempo de entrega para pedidos de encomienda
     * tiempo = 20 min + 1.5 min por kilómetro
     */
    @Override
    public int calcularTiempoEntrega() {
        double tiempo = 20 + (1.5 * getDistanciaKm());
        return (int) Math.round(tiempo);
    }

    @Override
    public void despachar() {
        System.out.println("Pedido despachado correctamente!");
    }

    @Override
    public void cancelar() {
        System.out.println("Pedido Encomienda #" + getIdPedido() + " cancelado exitosamente.");
    }
}
