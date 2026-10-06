package com.sfempresa.vista;

import com.sfempresa.modelo.*;
import com.sfempresa.dao.*;
import javax.swing.*;
import java.awt.*;


import com.sfempresa.dao.PedidoDAO;
import com.sfempresa.modelo.Pedido;
import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {

    private JTextField txtDireccion;
    private JComboBox<String> cbTipo;
    private JComboBox<String> cbEstado;

    public VentanaRegistroPedido() {

        setTitle("Registrar Pedido");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Campos del formulario
        add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"COMIDA", "ENCOMIENDA", "EXPRESS"});
        add(cbTipo);

        add(new JLabel("Estado:"));
        cbEstado = new JComboBox<>(new String[]{"PENDIENTE", "EN_REPARTO", "ENTREGADO"});
        add(cbEstado);

        JButton btnGuardar = new JButton("Guardar Pedido");
        add(btnGuardar);

        JButton btnLimpiar = new JButton("Limpiar");
        add(btnLimpiar);

        // Acción: Guardar pedido
        btnGuardar.addActionListener(e -> {

            String dir = txtDireccion.getText().trim();
            String tipo = cbTipo.getSelectedItem().toString();
            String estado = cbEstado.getSelectedItem().toString();

            // Validación
            if (dir.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La dirección es obligatoria");
                return;
            }

            // Crear objeto Pedido
            Pedido p = new Pedido(0, dir, tipo, estado);

            // Guardar en BD usando el método correcto: create()
            PedidoDAO dao = new PedidoDAO();

            if (dao.create(p)) {
                JOptionPane.showMessageDialog(this, "Pedido registrado correctamente");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el pedido");
            }
        });

        // Acción: Limpiar campos
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    /**
     * Limpia los campos del formulario
     */
    private void limpiarCampos() {
        txtDireccion.setText("");
        cbTipo.setSelectedIndex(0);
        cbEstado.setSelectedIndex(0);
    }
}
