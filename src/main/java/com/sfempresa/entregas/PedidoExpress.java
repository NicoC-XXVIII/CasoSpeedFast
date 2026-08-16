package com.sfempresa.entregas;

public class PedidoExpress extends Pedido{

    public PedidoExpress(String idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Express");
    }

    // Método genérico:
    @Override
    public void asignarRepartidor() {
        System.out.println("\n[Pedido Express]");
        System.out.println("Asignando repartidor...");
        System.out.println("→ Repartidor más cercano con disponibilidad inmediata");
    }

    // Método sobrecargado:
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("\n[Pedido Express]");
        System.out.println("Asignando repartidor...");
        System.out.println("→ Repartidor más cercano con disponibilidad inmediata");
        System.out.println("→ Pedido asignado a " + nombreRepartidor);
    }
}
