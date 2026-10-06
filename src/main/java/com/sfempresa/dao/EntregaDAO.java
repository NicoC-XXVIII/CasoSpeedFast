package com.sfempresa.dao;

import com.sfempresa.modelo.*;
import java.sql.*;
import java.time.*;
import java.util.*;

public class EntregaDAO {

    // Crear una nueva entrega:
    public boolean create(Entrega e) {
        String sql = "INSERT INTO entregas(id_pedido, id_repartidor, fecha, hora) VALUES(?,?,?,?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getIdPedido());
            ps.setInt(2, e.getIdRepartidor());
            ps.setDate(3, java.sql.Date.valueOf(e.getFecha()));
            ps.setTime(4, java.sql.Time.valueOf(e.getHora()));

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error al crear entrega: " + ex.getMessage());
            return false;
        }
    }

    // Listar todas las entregas:
    public List<Entrega> readAll() {
        List<Entrega> lista = new ArrayList<>();
        String sql = "SELECT * FROM entregas";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Entrega e = new Entrega(
                        rs.getInt("id"),
                        rs.getInt("id_pedido"),
                        rs.getInt("id_repartidor"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getTime("hora").toLocalTime()
                );
                lista.add(e);
            }

        } catch (SQLException ex) {
            System.out.println("Error al listar entregas: " + ex.getMessage());
        }

        return lista;
    }

    // Actualizar una entrega existente:
    public boolean update(Entrega e) {
        String sql = "UPDATE entregas SET id_pedido = ?, id_repartidor = ?, fecha = ?, hora = ? WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getIdPedido());
            ps.setInt(2, e.getIdRepartidor());
            ps.setDate(3, java.sql.Date.valueOf(e.getFecha()));
            ps.setTime(4, java.sql.Time.valueOf(e.getHora()));
            ps.setInt(5, e.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error al actualizar entrega: " + ex.getMessage());
            return false;
        }
    }

    // Eliminar una entrega por su ID:
    public boolean delete(int id) {
        String sql = "DELETE FROM entregas WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error al eliminar entrega: " + ex.getMessage());
            return false;
        }
    }
}
