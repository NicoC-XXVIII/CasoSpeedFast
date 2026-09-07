package com.sfempresa.app;

import com.sfempresa.entregas.*;
import com.sfempresa.interfaces.*;
import com.sfempresa.gestordatos.*;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

    public class Main {
        public static void main(String[] args) {

            System.out.println("\n===SERVICIO DE ENTREGAS SPEEDFAST===\n");
            System.out.println("Visualización de entregas en tiempo real:\n");

            // Creación e impresión de objetos por consola:
            PedidoComida comida1 = new PedidoComida("101", "Av. Italia 456", 4);
            PedidoExpress express1 = new PedidoExpress("102", "Av. Matta 900", 3);
            PedidoEncomienda encomienda1 = new PedidoEncomienda("103", "Av. Santa Rosa 567", 7);

            PedidoComida comida2 = new PedidoComida("104", "Av. Portugal 200", 2);
            PedidoExpress express2 = new PedidoExpress("105", "Av. Apoquindo 1500", 6);
            PedidoEncomienda encomienda2 = new PedidoEncomienda("106", "Av. Independencia 123", 5);

            // Repartidores con sus pedidos correspondientes:
            Repartidor camila = new Repartidor("Camila",
                    Arrays.asList(comida1, encomienda1));

            Repartidor luis = new Repartidor("Luis",
                    Arrays.asList(express1, comida2));

            Repartidor daniela = new Repartidor("Daniela",
                    Arrays.asList(express2, encomienda2));

            /* Utilización de ExecutorService para ejecutar hilos en paralelo:
             */
            ExecutorService executor = Executors.newFixedThreadPool(3);

            executor.execute(camila);
            executor.execute(luis);
            executor.execute(daniela);

            executor.shutdown();

            while (!executor.isTerminated()) {
                // Esperando que todos los repartidores terminen...
            }
            System.out.println("Simulación completada. Todos los pedidos han sido entregados.");
        }
    }
