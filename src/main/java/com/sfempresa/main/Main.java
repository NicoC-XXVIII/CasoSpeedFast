package com.sfempresa.main;

import com.sfempresa.entregas.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n===EMPRESA SPEEDFAST===\nIniciando entregas...");

        Pedido pedido1 = new PedidoComida("123A", "Av. Independencia 1234");
        Pedido pedido2 = new PedidoEncomienda("456B", "Av. Vitacura 5678");
        Pedido pedido3 = new PedidoExpress("789C", "Calle Lisboa 9012");

        // Métodos sobreescritos (genéricos):
        pedido1.asignarRepartidor();
        pedido2.asignarRepartidor();
        pedido3.asignarRepartidor();

        System.out.println("\n");

        // Métodos por sobrecarga:
        pedido1.asignarRepartidor("Juan A.");
        pedido2.asignarRepartidor("Katiusca B.");
        pedido3.asignarRepartidor("Luis C.");

        System.out.println("\n Entregas finalizadas.");
    }
}


