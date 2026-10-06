package com.sfempresa.vista;

import com.sfempresa.dao.RepartidorDAO;
import com.sfempresa.modelo.Repartidor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VistaRepartidor extends JFrame {

    private JTextField txtNombre;
    private JTable tabla;
    private DefaultTableModel modelo;
    private RepartidorDAO dao = new RepartidorDAO();

    public VistaRepartidor() {
        setTitle("Gestión de Repartidores");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con formulario
        JPanel panelForm = new JPanel(new FlowLayout());
        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(15);
        panelForm.add(txtNombre);

        JButton btnCrear = new JButton("Crear");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");

        panelForm.add(btnCrear);
        panelForm.add(btnEditar);
        panelForm.add(btnEliminar);

        add(panelForm, BorderLayout.NORTH);

        // Tabla
        modelo = new DefaultTableModel(new String[]{"ID", "Nombre"}, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        cargarTabla();

        // Acción: Crear repartidor
        btnCrear.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre es obligatorio");
                return;
            }

            Repartidor r = new Repartidor(0, nombre);

            if (dao.create(r)) {
                JOptionPane.showMessageDialog(this, "Repartidor creado");
                cargarTabla();
                txtNombre.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear repartidor");
            }
        });

        // Acción: Editar repartidor
        btnEditar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un repartidor");
                return;
            }

            int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
            String nombre = txtNombre.getText().trim();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre es obligatorio");
                return;
            }

            Repartidor r = new Repartidor(id, nombre);

            if (dao.update(r)) {
                JOptionPane.showMessageDialog(this, "Repartidor actualizado");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar");
            }
        });

        // Acción: Eliminar repartidor
        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un repartidor");
                return;
            }

            int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());

            if (dao.delete(id)) {
                JOptionPane.showMessageDialog(this, "Repartidor eliminado");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar");
            }
        });

        // Cargar datos al seleccionar fila
        tabla.getSelectionModel().addListSelectionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila != -1) {
                txtNombre.setText(tabla.getValueAt(fila, 1).toString());
            }
        });
    }

    // Carga todos los repartidores en la tabla
    private void cargarTabla() {
        modelo.setRowCount(0);
        List<Repartidor> lista = dao.readAll();

        for (Repartidor r : lista) {
            modelo.addRow(new Object[]{r.getId(), r.getNombre()});
        }
    }
}