package com.sfempresa.entregas;

import java.util.List;

public class Repartidor implements Runnable {

    private String nombre;
    private List<Pedido> pedidos;

    public Repartidor(String nombre, List<Pedido> pedidos) {
        this.nombre = nombre;
        this.pedidos = pedidos;
    }

    @Override
    public void run() {

        for (Pedido pedido : pedidos) {
            try {
                System.out.println("[Repartidor: " + nombre + "] Entregando "
                        + pedido.getTipoPedido() + " #" + pedido.getIdPedido() + "...");


                int pausa = (int)(1000 + Math.random() * 2000);
                Thread.sleep(pausa);

                System.out.println("[Repartidor: " + nombre + "] Pedido #"
                        + pedido.getIdPedido() + " entregado.\n");

            } catch (InterruptedException e) {
                System.out.println("[Repartidor: " + nombre + "] ERROR: entrega interrumpida.");
                Thread.currentThread().interrupt();
            }
        }
    }
}
