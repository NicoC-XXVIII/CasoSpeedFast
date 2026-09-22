package com.sfempresa.vista;



import com.sfempresa.modelo.*;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal del sistema SpeedFast.
 */
public class VentanaPrincipal extends JFrame {

    private final ControladorPedidos controlador;

    public VentanaPrincipal(ControladorPedidos controlador) {
        super("SPEEDGFAST - Gestión de Entregas");
        this.controlador = controlador;

        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Registrar Pedido", crearPanelRegistro());
        tabs.addTab("Listar Pedidos", crearPanelListado());
        tabs.addTab("Simular Entrega", crearPanelEntrega());

        setContentPane(tabs);
        setVisible(true);
    }

    private JPanel crearPanelRegistro() {
        return new VentanaRegistroPedido(controlador);
    }

    private JPanel crearPanelListado() {
        return new VentanaListaPedidos(controlador);
    }

    private JPanel crearPanelEntrega() {
        JPanel panel = new JPanel(new BorderLayout());
        JButton btnSimular = new JButton("Simular entrega");

        btnSimular.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Simulación de entrega iniciada (versión gráfica)."));

        panel.add(btnSimular, BorderLayout.NORTH);
        return panel;
    }
}
