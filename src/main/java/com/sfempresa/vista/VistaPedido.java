package com.sfempresa.vista;

import com.sfempresa.dao.PedidoDAO;
import com.sfempresa.modelo.Pedido;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VistaPedido extends JFrame {

    private JTextField txtDireccion;
    private JComboBox<String> cbTipo, cbEstado;
    private JTable tabla;
    private DefaultTableModel modelo;
    private PedidoDAO dao = new PedidoDAO();

    public VistaPedido() {
        setTitle("Gestión de Pedidos");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior
        JPanel panelForm = new JPanel(new FlowLayout());

        panelForm.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField(15);
        panelForm.add(txtDireccion);

        panelForm.add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"COMIDA", "ENCOMIENDA", "EXPRESS"});
        panelForm.add(cbTipo);

        panelForm.add(new JLabel("Estado:"));
        cbEstado = new JComboBox<>(new String[]{"PENDIENTE", "EN_REPARTO", "ENTREGADO"});
        panelForm.add(cbEstado);

        JButton btnCrear = new JButton("Crear");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");

        panelForm.add(btnCrear);
        panelForm.add(btnEditar);
        panelForm.add(btnEliminar);

        add(panelForm, BorderLayout.NORTH);

        // Tabla
        modelo = new DefaultTableModel(new String[]{"ID", "Dirección", "Tipo", "Estado"}, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        cargarTabla();

        // Crear pedido
        btnCrear.addActionListener(e -> {
            String dir = txtDireccion.getText().trim();

            if (dir.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La dirección es obligatoria");
                return;
            }

            Pedido p = new Pedido(0, dir, cbTipo.getSelectedItem().toString(), cbEstado.getSelectedItem().toString());

            if (dao.create(p)) {
                JOptionPane.showMessageDialog(this, "Pedido creado");
                cargarTabla();
                txtDireccion.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear pedido");
            }
        });

        // Editar pedido
        btnEditar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un pedido");
                return;
            }

            int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
            String dir = txtDireccion.getText().trim();

            if (dir.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La dirección es obligatoria");
                return;
            }

            Pedido p = new Pedido(id, dir, cbTipo.getSelectedItem().toString(), cbEstado.getSelectedItem().toString());

            if (dao.update(p)) {
                JOptionPane.showMessageDialog(this, "Pedido actualizado");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar");
            }
        });

        // Eliminar pedido
        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un pedido");
                return;
            }

            int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());

            if (dao.delete(id)) {
                JOptionPane.showMessageDialog(this, "Pedido eliminado");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar");
            }
        });

        // Cargar datos al seleccionar fila
        tabla.getSelectionModel().addListSelectionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila != -1) {
                txtDireccion.setText(tabla.getValueAt(fila, 1).toString());
                cbTipo.setSelectedItem(tabla.getValueAt(fila, 2).toString());
                cbEstado.setSelectedItem(tabla.getValueAt(fila, 3).toString());
            }
        });
    }

    private void cargarTabla() {
        modelo.setRowCount(0);
        List<Pedido> lista = dao.readAll();

        for (Pedido p : lista) {
            modelo.addRow(new Object[]{p.getId(), p.getDireccion(), p.getTipo(), p.getEstado()});
        }
    }
}
