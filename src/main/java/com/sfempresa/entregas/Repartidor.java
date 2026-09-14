package com.sfempresa.entregas;

public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zona;

    public Repartidor(String nombre, ZonaDeCarga zona) {
        this.nombre = nombre;
        this.zona = zona;
    }

    @Override
    public void run() {

        while (true) {

            Pedido pedido = zona.retirarPedido();

            if (pedido == null) {
                // No quedan pedidos
                break;
            }

            System.out.println("\n[Repartidor - " + nombre + "] Retirando pedido #" + pedido.getId() + "...");

            pedido.setEstado(EstadoPedido.EN_REPARTO);
            System.out.println("\n[Repartidor - " + nombre + "] Estado: EN_REPARTO");

            try {
                System.out.println("\n[Repartidor - " + nombre + "] Entregando pedido #" + pedido.getId() + "...");
                Thread.sleep(2000); // Simulación de entrega
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.println("\n[Repartidor - " + nombre + "] Estado: ENTREGADO\n");
        }
    }
}
