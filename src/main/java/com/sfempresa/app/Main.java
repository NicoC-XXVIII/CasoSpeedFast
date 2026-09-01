package com.sfempresa.app;

import com.sfempresa.entregas.*;
import com.sfempresa.interfaces.*;
import com.sfempresa.gestordatos.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n===SERVICIO DE ENTREGAS SPEEDFAST===\n");

        // Uso del gestor de datos para controlar y procesar los pedidos:
        ControladorDeEnvios gestor = new ControladorDeEnvios();
        System.out.println("---Gestión de entregas---");

        // Creación y visualización de instancias de los diferentes tipos de pedidos:
        PedidoComida comida = new PedidoComida("01313", "Av. Matta 321", 6);
        PedidoEncomienda encomienda = new PedidoEncomienda("06767", "Av. La Paz 987", 9);
        PedidoExpress express = new PedidoExpress("04321", "Av. Las Condes 8000", 12);

        // Asignación automática de repartidor:
        comida.asignarRepartidor();
        encomienda.asignarRepartidor();
        express.asignarRepartidor();

        // Asignación manual de repartidor:
        comida.asignarRepartidor("Nicolás K");
        encomienda.asignarRepartidor("Javier C");
        express.asignarRepartidor("Daniela A");

        // Mostrar resumen de los pedidos:
        System.out.println("\nPedido de comida:");
        comida.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: " + comida.calcularTiempoEntrega() + " minutos");
        System.out.println("\nPedido de encomienda:");
        encomienda.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: " + encomienda.calcularTiempoEntrega() + " minutos");
        System.out.println("\nPedido express:");
        express.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: " + express.calcularTiempoEntrega() + " minutos");

        // Registrar pedido en el historial:
        gestor.registrarEntrega("Pedido de comida #01313 despachado por Nicolás");
        gestor.registrarEntrega("Pedido de encomienda #06767 despachado por Javier");
        gestor.registrarEntrega("Pedido express #04321 despachado por Daniela");

        // Cancelación de pedidos:
        System.out.println("\nCancelando pedido de comida #01313...");
        comida.cancelar();

        // Mostrar historial de entregas:
        System.out.println();
        gestor.verHistorial();
        System.out.println("\nGracias por usar nuestro servicio.");
    }
}


