package com.sfempresa.entregas;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Comida");
    }

    // Método genérico:
    @Override
    public void asignarRepartidor() {
        System.out.println("\n[Pedido Comida]");
        System.out.println("Asignando repartidor...");
        System.out.println("Verificando mochila térmica... OK");
    }

    // Método sobrecargado:
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("\n[Pedido Comida]");
        System.out.println("Asignando repartidor...");
        System.out.println("Verificando mochila térmica... OK");
        System.out.println("→ Pedido asignado a " + nombreRepartidor);
    }
}
