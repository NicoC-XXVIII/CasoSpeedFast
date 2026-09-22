package com.sfempresa.vista;

import com.sfempresa.modelo.*;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana para registrar nuevos pedidos.
 */
public class VentanaRegistroPedido extends JPanel {

    public VentanaRegistroPedido(ControladorPedidos controlador) {

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel formulario = new JPanel(new GridLayout(0, 2, 5, 5));
        formulario.setBorder(BorderFactory.createTitledBorder("Registrar Pedido"));

        JTextField txtId = new JTextField();
        JTextField txtDireccion = new JTextField();
        JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"Comida", "Encomienda", "Express"});

        formulario.add(new JLabel("ID:"));
        formulario.add(txtId);

        formulario.add(new JLabel("Dirección:"));
        formulario.add(txtDireccion);

        formulario.add(new JLabel("Tipo:"));
        formulario.add(cmbTipo);

        JButton btnGuardar = new JButton("Guardar Pedido");

        btnGuardar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String dir = txtDireccion.getText();
                String tipo = cmbTipo.getSelectedItem().toString();

                if (dir.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "La dirección no puede estar vacía");
                    return;
                }

                controlador.agregarPedido(new Pedido(id, dir, tipo));
                JOptionPane.showMessageDialog(this, "Pedido registrado correctamente");

                txtId.setText("");
                txtDireccion.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID debe ser numérico");
            }
        });

        add(formulario, BorderLayout.NORTH);
        add(btnGuardar, BorderLayout.SOUTH);
    }
}
