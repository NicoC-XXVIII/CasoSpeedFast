package com.sfempresa.controlador;

import com.sfempresa.modelo.ControladorPedidos;
import com.sfempresa.vista.VentanaPrincipal;

/**
 * Punto de entrada de la aplicación.
 */
public class Main {
    public static void main(String[] args) {
        ControladorPedidos controlador = new ControladorPedidos();
        new VentanaPrincipal(controlador);
    }
}
