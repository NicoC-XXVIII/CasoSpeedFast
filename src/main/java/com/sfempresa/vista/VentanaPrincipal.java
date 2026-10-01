package com.sfempresa.vista;

import com.sfempresa.modelo.*;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal de SpeedFast.
 * Contiene pestañas para registrar pedidos, repartidores y listar pedidos.
 */
public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        super("SpeedFast - Servicio de entregas");

        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Registrar Pedido", new VentanaRegistroPedido());
        tabs.addTab("Registrar Repartidor", new VentanaRegistroPedido());
        tabs.addTab("Listar Pedidos", new VentanaListaPedidos());

        setContentPane(tabs);
        setVisible(true);
    }
}
