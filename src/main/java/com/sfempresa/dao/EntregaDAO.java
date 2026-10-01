package com.sfempresa.dao;

import com.sfempresa.modelo.*;
import java.sql.*;
import java.time.*;

/**
 * DAO encargado de registrar entregas en la tabla "entrega".
 */
public class EntregaDAO {

    /**
     * Guarda una entrega asociada a un pedido y un repartidor.
     *
     * @param e objeto Entrega
     */
    public void guardar(Entrega e) {
        String sql = "INSERT INTO entrega (id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, e.getIdPedido());
            stmt.setInt(2, e.getIdRepartidor());
            stmt.setDate(3, Date.valueOf(LocalDate.now()));
            stmt.setTime(4, Time.valueOf(LocalTime.now()));

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al guardar entrega");
            ex.printStackTrace();
        }
    }
}
