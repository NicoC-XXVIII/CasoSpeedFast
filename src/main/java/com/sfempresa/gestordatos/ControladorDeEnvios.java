package com.sfempresa.gestordatos;

import java.util.ArrayList;
import com.sfempresa.interfaces.Rastreable;


public class ControladorDeEnvios implements Rastreable {

    private ArrayList<String> historialEntregas = new ArrayList<>();

    // Agregar un registro al historial:
    public void registrarEntrega(String detalle) {
        historialEntregas.add(detalle);
    }

    // Método para ver el historial de registros
    @Override
    public void verHistorial() {
        System.out.println("Historial de entregas: ");
        for (String registro : historialEntregas) {
            System.out.println(" | " + registro);
        }
    }
}