package com.sfempresa.modelo;

import java.util.ArrayList;

/**
 * Controlador encargado de almacenar y gestionar los pedidos registrados.
 */
public class ControladorPedidos {

    private final ArrayList<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido p) {
        pedidos.add(p);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
