package com.sfempresa.entregas;

public abstract class Pedido {

    // Atributos comunes para los pedidos:
    private String idPedido;
    private String direccionEntrega;
    private double distanciaKm;
    protected String repartidorAsignado; // Para asignación automática o manuak

    // Constructor con todos los atributos:
    public Pedido(String idPedido, String direccionEntrega,
                  double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    // Getters para atributos idPedido y distanciaKm:
    public String getIdPedido() {
        return idPedido;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    // Método para mostrar resumen de los pedidos:
    public void mostrarResumen() {
        System.out.println("Pedido #" + idPedido);
        System.out.println("Dirección de entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Repartidor asignado: " + repartidorAsignado);
    }

    //Método para calcular tiempo de entrega según tipo de pedido:
    public abstract int calcularTiempoEntrega();

    // Método sobrecargado para asignación manual de repartidor:
    public void asignarRepartidor(String repartidor) {
        this.repartidorAsignado = repartidor;
    }

    // Método por sobreescritura para asignación automática de repartidor:
    public abstract void asignarRepartidor();
}