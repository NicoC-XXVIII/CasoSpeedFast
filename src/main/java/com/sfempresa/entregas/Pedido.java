package com.sfempresa.entregas;

public abstract class Pedido {

    // Atributos comunes para los pedidos:
    private String idPedido;
    private String direccionEntrega;
    private double distanciaKm;

    // Constructor con todos los atributos:
    public Pedido(String idPedido, String direccionEntrega,
                  double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    // Método para imprimir resumen por defecto del pedido:
    public void mostrarResumen() {
        System.out.println("Dirección de entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
    }

    // Getter para que las subclases puedan calcular la distancia:
    public double getDistanciaKm() {
        return distanciaKm;
    }

    /** Método abstracto para calcular el tiempo de entrega:
     * Cada clase implementa su propia fórmula.
     */
    public abstract int calcularTiempoEntrega();

    /* Utilización de Template Method:
     * Las subclases no lo pueden modificar al ser "final"
     */
    public final void procesarPedido() {
        mostrarResumen(); // Paso concreto
        int tiempo = calcularTiempoEntrega(); // Paso variable implementado por las subclases
        System.out.println("Tiempo estimado de entrega: " + tiempo + " minutos");
    }
}



