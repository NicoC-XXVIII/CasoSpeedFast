package com.sfempresa.entregas;

public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(String idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Encomienda");
    }

    // Método genérico:
    @Override
    public void asignarRepartidor() {
        System.out.println("\n[Pedido Encomienda]");
        System.out.println("Asignando repartidor...");
        System.out.println("→ Validando peso y embalaje... OK");
    }

    // Método sobrecargado:
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("\n[Pedido Encomienda]");
        System.out.println("Asignando repartidor...");
        System.out.println("→ Validando peso y embalaje... OK");
        System.out.println("→ Pedido asignado a " + nombreRepartidor);
    }
}
