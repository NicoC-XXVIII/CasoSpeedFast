package com.sfempresa.dao;

import com.sfempresa.modelo.*;
import java.sql.*;
import java.util.*;

/**
 * DAO encargado de realizar operaciones JDBC sobre la tabla "pedido".
 */
public class PedidoDAO {

    /**
     * Guarda un pedido en la base de datos usando PreparedStatement.
     *
     * @param pedido objeto Pedido a insertar
     */
    public void guardar(Pedido pedido) {
        String sql = "INSERT INTO pedido (direccion, tipo, estado) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pedido.getDireccion());
            stmt.setString(2, pedido.getTipo());
            stmt.setString(3, "PENDIENTE"); // estado inicial

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar pedido");
            e.printStackTrace();
        }
    }

    /**
     * Lista todos los pedidos almacenados en la base de datos.
     *
     * @return lista de objetos Pedido
     */
    public List<Pedido> listarTodos() {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM pedido";

        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pedido p = new Pedido(
                        rs.getInt("id"),
                        rs.getString("direccion"),
                        rs.getString("tipo")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar pedidos");
            e.printStackTrace();
        }

        return lista;
    }
}
