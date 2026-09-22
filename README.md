# CasoSpeedFast

Entrega formativa 4 — Semana 6 (Asignatura: DOO2)

## Descripción

CasoSpeedFast es una aplicación Java para gestionar pedidos de entrega en una empresa de logística. La solución está desarrollada con Swing y sigue una estructura basada en MVC (Modelo, Vista y Controlador), permitiendo registrar pedidos, listarlos y visualizar la información en una interfaz gráfica.

La aplicación es una versión de escritorio del flujo de trabajo de una empresa de repartos, donde cada pedido queda asociado a:

- un identificador (`id`)
- una dirección de entrega (`direccion`)
- un tipo de entrega (`tipo`)

## Funcionalidades

- Registrar nuevos pedidos desde una interfaz gráfica.
- Seleccionar el tipo de entrega: `Comida`, `Encomienda` o `Express`.
- Guardar los pedidos en memoria mediante un controlador.
- Mostrar la lista de pedidos en una tabla.
- Acceder desde una ventana principal con pestañas.

## Estructura del proyecto

```text
src/
├── main/
│   └── java/
│       └── com/
│           └── sfempresa/
│               ├── controlador/
│               │   └── Main.java
│               ├── modelo/
│               │   ├── ControladorPedidos.java
│               │   └── Pedido.java
│               └── vista/
│                   ├── VentanaListaPedidos.java
│                   ├── VentanaPrincipal.java
│                   └── VentanaRegistroPedido.java
├── pom.xml
└── README.md
```

## Componentes principales

### `com.sfempresa.modelo.Pedido`
Representa un pedido del sistema con los atributos:

- `id`
- `direccion`
- `tipo`

### `com.sfempresa.modelo.ControladorPedidos`
Encapsula la colección de pedidos y ofrece métodos para almacenarlos y consultarlos.

### `com.sfempresa.vista.VentanaPrincipal`
Ventana principal de la aplicación con pestañas para:

- registrar pedidos
- listar pedidos
- simular entregas

### `com.sfempresa.vista.VentanaRegistroPedido`
Formulario para ingresar un nuevo pedido con validación básica.

### `com.sfempresa.vista.VentanaListaPedidos`
Muestra los pedidos actuales en una tabla Swing.

### `com.sfempresa.controlador.Main`
Punto de entrada de la aplicación. Crea el controlador y abre la ventana principal.

## Tecnologías

- Java 23
- Maven
- Swing (GUI)
- Programación orientada a objetos

## Requisitos

- Java JDK 23 o superior
- Maven
- IDE recomendado: IntelliJ IDEA, Eclipse o VS Code

## Compilación y ejecución

Desde la raíz del proyecto:

```bash
mvn compile
```

Luego ejecuta la aplicación:

```bash
java -cp target/classes com.sfempresa.controlador.Main
```

## Flujo de uso

1. Se ejecuta `Main`.
2. Se abre la ventana principal.
3. En la pestaña "Registrar Pedido", se introduce el ID, dirección y tipo.
4. El pedido se guarda en `ControladorPedidos`.
5. La pestaña "Listar Pedidos" muestra la información en una tabla.

## Observaciones

Este repositorio corresponde a una aplicación de escritorio de gestión de entregas, con una estructura clara para una práctica de diseño orientado a objetos. El proyecto está orientado a mostrar una separación funcional entre modelo, vista y controlador, sin depender de bases de datos ni servicios externos.

## Autor

NicoC-XXVIII
