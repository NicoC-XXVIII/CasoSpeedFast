# CasoSpeedFast

Entrega sumativa 3 — Semana 8 (Asignatura: DOO2)

## Descripción

CasoSpeedFast es una aplicación de escritorio desarrollada en Java para gestionar pedidos y entregas de una empresa de reparto. La solución utiliza Swing para la interfaz gráfica y JDBC para la persistencia de datos en MySQL.

El proyecto está estructurado siguiendo el patrón MVC, separando la lógica de negocio, acceso a datos y presentación en paquetes distintos.

## Funcionalidades

- Registrar pedidos desde una ventana de Swing.
- Registrar repartidores desde la interfaz principal.
- Listar los pedidos almacenados en la base de datos.
- Conectar con MySQL mediante JDBC.
- Persistir la información en una base de datos relacional.
- Gestionar entregas asociadas a pedidos y repartidores.
- Ejecutar la app desde un único punto de entrada (`Main`).

## Estructura del proyecto

```text
CasoSpeedFast/
├── .gitignore
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── sfempresa/
│   │               ├── controlador/
│   │               │   └── Main.java
│   │               ├── dao/
│   │               │   ├── ConexionBD.java
│   │               │   ├── EntregaDAO.java
│   │               │   ├── PedidoDAO.java
│   │               │   └── RepartidorDAO.java
│   │               ├── modelo/
│   │               │   ├── Entrega.java
│   │               │   ├── Pedido.java
│   │               │   └── Repartidor.java
│   │               └── vista/
│   │                   ├── VentanaListaPedidos.java
│   │                   ├── VentanaPrincipal.java
│   │                   └── VentanaRegistroPedido.java
│   └── script/
│       └── speedfast_db.sql
└── .idea/
```

## Componentes principales

### `com.sfempresa.controlador.Main`
Punto de entrada de la aplicación. Crea la ventana principal y prueba la conexión a la base de datos al iniciar.

### `com.sfempresa.vista.VentanaPrincipal`
Ventana principal con pestañas para acceder a:
- Registro de pedidos
- Registro de repartidores
- Listado de pedidos

### `com.sfempresa.vista.VentanaRegistroPedido`
Formulario para introducir los datos del pedido o del repartidor según el caso de uso.

### `com.sfempresa.vista.VentanaListaPedidos`
Muestra la información de pedidos en una tabla Swing.

### `com.sfempresa.dao.ConexionBD`
Gestiona la conexión JDBC con MySQL leyendo las credenciales desde un archivo de propiedades.

### `com.sfempresa.dao.PedidoDAO`
Encapsula la lógica para guardar y consultar pedidos desde la base de datos.

### `com.sfempresa.dao.RepartidorDAO`
Encapsula la lógica para manejar repartidores en la base de datos.

### `com.sfempresa.dao.EntregaDAO`
Gestiona operaciones relacionadas con entregas y su relación con pedidos y repartidores.

### `com.sfempresa.modelo.Pedido`
Representa un pedido con su dirección y tipo.

### `com.sfempresa.modelo.Repartidor`
Representa a un repartidor del sistema.

### `com.sfempresa.modelo.Entrega`
Representa una entrega asociada a un pedido y un repartidor.

## Base de datos

El script SQL para crear la base de datos y las tablas se encuentra en:

`src/script/speedfast_db.sql`

Estructura principal:
- `repartidor(id, nombre)`
- `pedido(id, direccion, tipo, estado)`
- `entrega(id, id_pedido, id_repartidor, fecha, hora)`

## Configuración de la conexión

La aplicación intenta leer las credenciales desde este archivo:

```text
src/config/db.properties
```

Ejemplo de contenido:

```properties
url=jdbc:mysql://localhost:3306/speedfast_db
user=root
password=tu_contraseña
```

**Importante:**
- El archivo `db.properties` no se incluye en el repositorio para no compartir credenciales locales.
- Debes crearlo manualmente antes de ejecutar la aplicación.

## Tecnologías

- Java 23
- Maven
- Swing
- JDBC
- MySQL Connector/J

## Requisitos

- JDK 23 o superior
- Maven
- MySQL Server
- IDE recomendada: IntelliJ IDEA, Eclipse o VS Code

## Compilación

Desde la raíz del proyecto ejecuta:

```bash
mvn compile
```

## Ejecución

Una vez compilado, puedes arrancar la aplicación con:

```bash
mvn exec:java -Dexec.mainClass=com.sfempresa.controlador.Main
```

O bien, si prefieres ejecutar la clase directamente:

```bash
java -cp target/classes com.sfempresa.controlador.Main
```

## Preparación previa

1. Crea la base de datos ejecutando `src/script/speedfast_db.sql`.
2. Crea el archivo `src/config/db.properties` con tus credenciales de MySQL.
3. Ejecuta la aplicación.

## Observaciones

Este repositorio corresponde a una práctica de diseño orientado a objetos y acceso a datos en Java, con una interfaz gráfica para la gestión de entregas de una empresa de repartos. Es la entrega sumativa 3 de la semana 8 de la asignatura DOO2.

## Autor

NicoC-XXVIII
