package com.sfempresa.main;

import com.sfempresa.entregas.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n===SERVICIO DE ENTREGAS SPEEDFAST===\n");

                // Creación e impresión de instancias de los diferentes tipos de pedidos
                Pedido[] pedidos = {
                        new PedidoComida("00123", "Av. Italia 456", 4),
                        new PedidoEncomienda("00234", "Av. Independencia 567", 6),
                        new PedidoExpress("00321", "Av. Apoquindo 4050", 7)
                };

                for (Pedido pedido : pedidos) {
                    pedido.mostrarResumen();
                    System.out.println("Tiempo estimado: "
                            + pedido.calcularTiempoEntrega() + " minutos");
                    System.out.println();
                }
            }
        }


