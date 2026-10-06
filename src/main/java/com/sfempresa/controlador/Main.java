package com.sfempresa.controlador;

import com.sfempresa.dao.ConexionBD;
import com.sfempresa.vista.VentanaPrincipal;

import java.sql.Connection;

/**
 * Punto de entrada de la aplicación SpeedFast.
 */
public class Main {
    public static void main(String[] args) {
        new VentanaPrincipal().setVisible(true);

        try {
            Connection conn = ConexionBD.conectar();
            System.out.println("\nConectando a la base de datos...\n");
            System.out.println("Conexión exitosa.");
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al conectar.");
            e.printStackTrace();
        }
    }
}




