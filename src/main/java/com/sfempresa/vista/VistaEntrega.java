package com.sfempresa.vista;

import com.sfempresa.dao.*;
import com.sfempresa.modelo.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class VistaEntrega extends JFrame {

    private JComboBox<String> cbPedido;
    private JComboBox<String> cbRepartidor;
    private JTextField txtFecha;
    private JComboBox<String> cbHora;

    private DefaultTableModel modeloTabla;
    private JTable tabla;

    public VistaEntrega() {

        setTitle("Gestión de Entregas");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(6, 2, 10, 10));

        // Pedido
        panelForm.add(new JLabel("Pedido:"));
        cbPedido = new JComboBox<>();
        panelForm.add(cbPedido);

        // Repartidor
        panelForm.add(new JLabel("Repartidor:"));
        cbRepartidor = new JComboBox<>();
        panelForm.add(cbRepartidor);

        // Fecha
        panelForm.add(new JLabel("Fecha (DD-MM-YYYY):"));
        txtFecha = new JTextField();
        panelForm.add(txtFecha);

        // Hora (ComboBox)
        panelForm.add(new JLabel("Hora (HH:MM):"));
        cbHora = new JComboBox<>(new String[]{
                "08:00","09:00","10:00","11:00",
                "12:00","13:00","14:00","15:00",
                "16:00","17:00","18:00","19:00",
                "20:00","21:00","22:00"
        });
        panelForm.add(cbHora);

        // Botones
        JButton btnCrear = new JButton("Crear");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");

        panelForm.add(btnCrear);
        panelForm.add(btnEditar);
        panelForm.add(btnEliminar);

        add(panelForm, BorderLayout.NORTH);

        // Tabla
        modeloTabla = new DefaultTableModel(new String[]{"ID", "Pedido", "Repartidor", "Fecha", "Hora"}, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Cargar combos y tabla
        cargarPedidos();
        cargarRepartidores();
        cargarTabla();

        // Acciones
        btnCrear.addActionListener(e -> crearEntrega());
        btnEditar.addActionListener(e -> editarEntrega());
        btnEliminar.addActionListener(e -> eliminarEntrega());
    }

    // -----------------------------
    // Conversión de fecha
    // -----------------------------

    private LocalDate convertirFecha(String texto) throws Exception {
        String fechaTexto = texto.trim();

        fechaTexto = fechaTexto.replace("/", "-");

        String[] partes = fechaTexto.split("-");

        if (partes.length != 3) {
            throw new Exception("Formato inválido. Usa DD-MM-YYYY o DD/MM/YYYY");
        }

        String dia = partes[0];
        String mes = partes[1];
        String anio = partes[2];

        String fechaFormateada = anio + "-" + mes + "-" + dia;

        return LocalDate.parse(fechaFormateada);
    }

    // -----------------------------
    // CRUD
    // -----------------------------

    private void crearEntrega() {
        try {
            int idPedido = Integer.parseInt(cbPedido.getSelectedItem().toString().split(" - ")[0]);
            int idRepartidor = Integer.parseInt(cbRepartidor.getSelectedItem().toString().split(" - ")[0]);

            LocalDate fecha = convertirFecha(txtFecha.getText());
            LocalTime hora = LocalTime.parse(cbHora.getSelectedItem().toString());

            Entrega entrega = new Entrega(0, idPedido, idRepartidor, fecha, hora);

            EntregaDAO dao = new EntregaDAO();

            if (dao.create(entrega)) {
                JOptionPane.showMessageDialog(this, "Entrega registrada correctamente");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar entrega");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Datos inválidos: " + ex.getMessage());
        }
    }

    private void editarEntrega() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una entrega para editar");
            return;
        }

        try {
            int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
            int idPedido = Integer.parseInt(cbPedido.getSelectedItem().toString().split(" - ")[0]);
            int idRepartidor = Integer.parseInt(cbRepartidor.getSelectedItem().toString().split(" - ")[0]);

            LocalDate fecha = convertirFecha(txtFecha.getText());
            LocalTime hora = LocalTime.parse(cbHora.getSelectedItem().toString());

            Entrega entrega = new Entrega(id, idPedido, idRepartidor, fecha, hora);

            EntregaDAO dao = new EntregaDAO();

            if (dao.update(entrega)) {
                JOptionPane.showMessageDialog(this, "Entrega actualizada correctamente");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar entrega");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Datos inválidos: " + ex.getMessage());
        }
    }

    private void eliminarEntrega() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una entrega para eliminar");
            return;
        }

        int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());

        EntregaDAO dao = new EntregaDAO();

        if (dao.delete(id)) {
            JOptionPane.showMessageDialog(this, "Entrega eliminada correctamente");
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar entrega");
        }
    }

    // -----------------------------
    // AUXILIARES
    // -----------------------------

    private void cargarPedidos() {
        PedidoDAO dao = new PedidoDAO();
        List<Pedido> lista = dao.readAll();

        cbPedido.removeAllItems();
        for (Pedido p : lista) {
            cbPedido.addItem(p.getId() + " - " + p.getDireccion());
        }
    }

    private void cargarRepartidores() {
        RepartidorDAO dao = new RepartidorDAO();
        List<Repartidor> lista = dao.readAll();

        cbRepartidor.removeAllItems();
        for (Repartidor r : lista) {
            cbRepartidor.addItem(r.getId() + " - " + r.getNombre());
        }
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);

        EntregaDAO dao = new EntregaDAO();
        List<Entrega> lista = dao.readAll();

        for (Entrega e : lista) {
            modeloTabla.addRow(new Object[]{
                    e.getId(),
                    e.getIdPedido(),
                    e.getIdRepartidor(),
                    e.getFecha(),
                    e.getHora()
            });
        }
    }
}
