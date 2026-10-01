package com.sfempresa.dao;

import com.sfempresa.modelo.*;
import java.sql.*;
import java.util.*;

/**
 * DAO encargado de gestionar la tabla "repartidor".
 */
public class RepartidorDAO {

    /**
     * Inserta un repartidor en la base de datos.
     *
     * @param r objeto Repartidor
     */
    public void guardar(Repartidor r) {
        String sql = "INSERT INTO repartidor (nombre) VALUES (?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, r.getNombre());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar repartidor");
            e.printStackTrace();
        }
    }

    /**
     * Lista todos los repartidores registrados.
     *
     * @return lista de repartidores
     */
    public List<Repartidor> listarTodos() {
        List<Repartidor> lista = new ArrayList<>();
        String sql = "SELECT * FROM repartidor";

        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Repartidor(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar repartidores");
            e.printStackTrace();
        }

        return lista;
    }
}
