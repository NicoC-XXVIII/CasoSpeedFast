package com.sfempresa.vista;

import com.sfempresa.modelo.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Ventana que muestra los pedidos registrados en una tabla.
 */
public class VentanaListaPedidos extends JPanel {

    public VentanaListaPedidos(ControladorPedidos controlador) {

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columnas = {"ID", "Dirección", "Tipo"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Pedido p : controlador.getPedidos()) {
            modelo.addRow(new Object[]{p.getId(), p.getDireccion(), p.getTipo()});
        }

        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(25);

        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
}
