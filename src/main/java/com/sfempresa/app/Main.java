package com.sfempresa.app;

import com.sfempresa.entregas.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n==SERVICIO DE ENTREGAS SPEEDFAST==\n");
        System.out.println("[Zona de carga inicializada]\n");

        ZonaDeCarga zona = new ZonaDeCarga();

        // Creación e impresión de pedidos:
        zona.agregarPedido(new Pedido(1, "Santiago Centro"));
        zona.agregarPedido(new Pedido(2, "Providencia"));
        zona.agregarPedido(new Pedido(3, "Ñuñoa"));
        zona.agregarPedido(new Pedido(4, "Recoleta"));
        zona.agregarPedido(new Pedido(5, "Las Condes"));

        // Creación y asignación de repartidores:
        Repartidor juan = new Repartidor("Juan", zona);
        Repartidor camila = new Repartidor("Camila", zona);
        Repartidor pedro = new Repartidor("Pedro", zona);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(juan);
        executor.execute(camila);
        executor.execute(pedro);

        executor.shutdown();

        while (!executor.isTerminated()) {
            // Esperando que todas las entregas terminen...
        }

        System.out.println("\n---Zona de carga vacía---\n");
        System.out.println("Todos los pedidos han sido entregados exitosamente.");
    }
}
