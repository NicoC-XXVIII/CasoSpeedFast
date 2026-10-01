package com.sfempresa.vista;

import com.sfempresa.modelo.*;
import com.sfempresa.dao.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Panel que muestra los pedidos almacenados en la BD,
 * utilizando JTable.
 */
public class VentanaListaPedidos extends JPanel {

    public VentanaListaPedidos() {

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columnas = {"ID", "Dirección", "Tipo"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        List<Pedido> pedidos = new PedidoDAO().listarTodos();

        for (Pedido p : pedidos) {
            modelo.addRow(new Object[]{p.getId(), p.getDireccion(), p.getTipo()});
        }

        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(25);

        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
}
