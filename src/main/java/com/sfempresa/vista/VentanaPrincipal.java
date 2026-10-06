package com.sfempresa.vista;

import com.sfempresa.modelo.*;
import javax.swing.*;
import java.awt.*;



/**
 * Ventana principal del sistema SpeedFast.
 * Abre las ventanas CRUD sin agregarlas como componentes.
 */
public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        setTitle("SpeedFast - Panel Principal");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnRepartidores = new JButton("Gestionar Repartidores");
        JButton btnPedidos = new JButton("Gestionar Pedidos");
        JButton btnEntregas = new JButton("Gestionar Entregas");
        JButton btnSalir = new JButton("Salir");

        add(btnRepartidores);
        add(btnPedidos);
        add(btnEntregas);
        add(btnSalir);

        // Abrir ventanas CRUD
        btnRepartidores.addActionListener(e -> new VistaRepartidor().setVisible(true));
        btnPedidos.addActionListener(e -> new VistaPedido().setVisible(true));
        btnEntregas.addActionListener(e -> new VistaEntrega().setVisible(true));

        btnSalir.addActionListener(e -> System.exit(0));
    }
}
