# CasoSpeedFast

Entrega Formativa — Semana 2 (Asignatura: DOO2)

## Descripción

CasoSpeedFast es un sistema de gestión de entregas que demuestra principios clave de **Programación Orientada a Objetos** en Java. El proyecto implementa un servicio de entregas rápidas con diferentes tipos de pedidos, cada uno con características y tiempos de entrega particulares.

Este ejercicio educativo ilustra:
- **Herencia**: Estructura de clases especializadas
- **Polimorfismo**: Comportamientos específicos por tipo de pedido
- **Interfaces**: Contratos claros para operaciones comunes
- **Abstracción**: Clase base que define el comportamiento general

## Características principales

- ✅ **Diseño orientado a objetos claro y educativo**
- ✅ **Clase abstracta base (`Pedido`)** que define la estructura común
- ✅ **Interfaces especializadas** (`Despachable`, `Cancelable`) para operaciones
- ✅ **Herencia polimórfica**: Tres tipos de pedidos con lógica diferenciada
- ✅ **Cálculo automático de tiempos de entrega** según tipo de pedido
- ✅ **Asignación de repartidores** (automática y manual)
- ✅ **Gestor de entregas** (`ControladorDeEnvios`) para historial
- ✅ **Ejecución por consola** que ilustra el flujo completo

### Tipos de pedidos

| Tipo | Fórmula de tiempo | Requisitos especiales |
|------|------|------|
| **PedidoComida** | 15 min + 2 min/km | Repartidor con mochila térmica |
| **PedidoEncomienda** | 20 min + 1.5 min/km | Validación de peso y embalaje |
| **PedidoExpress** | Base + variable | Entrega urgente |

## Estructura del proyecto

```
src/main/java/com/sfempresa/
├── app/
│   └── Main.java                   (punto de entrada principal)
├── entregas/
│   ├── Pedido.java                 (clase abstracta base)
│   ├── PedidoComida.java           (entrega de comida)
│   ├── PedidoEncomienda.java       (envíos de paquetes)
│   └── PedidoExpress.java          (entregas urgentes)
├── interfaces/
│   ├── Despachable.java            (interfaz para despachar)
│   ├── Cancelable.java             (interfaz para cancelar)
│   └── ...
└── gestordatos/
    └── ControladorDeEnvios.java    (gestor de historial)
```

## Tecnologías

- **Java 8+**
- Estructura compatible con compilación manual o herramientas de build (Maven/Gradle)

## Compilación y ejecución

### Opción A — Compilación con javac (Linux/macOS)

```bash
# Compilar todo el código
find src/main/java -name "*.java" > sources.txt
javac -d out @sources.txt

# Ejecutar
java -cp out com.sfempresa.app.Main
```

### Opción A — Compilación con javac (Windows PowerShell)

```powershell
# Compilar
Get-ChildItem -Recurse -Filter *.java src\main\java | ForEach-Object { $_.FullName } > sources.txt
javac -d out @sources.txt

# Ejecutar
java -cp out com.sfempresa.app.Main
```

### Opción B — Con Maven

```bash
# Compilar
mvn clean compile

# Ejecutar
mvn exec:java -Dexec.mainClass="com.sfempresa.app.Main"
```

### Opción C — IDE

Importa el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, VS Code) y ejecuta `Main.java`.

## Ejemplo de salida esperada

```
===SERVICIO DE ENTREGAS SPEEDFAST===

---Gestión de entregas---

Pedido de comida:
Pedido #01313
Dirección de entrega: Av. Matta 321
Distancia: 6.0 km
Repartidor asignado: Nicolás K
Tiempo estimado de entrega: 27 minutos

Pedido de encomienda:
Pedido #06767
Dirección de entrega: Av. La Paz 987
Distancia: 9.0 km
Repartidor asignado: Javier C
Tiempo estimado de entrega: 33 minutos

Pedido express:
Pedido #04321
Dirección de entrega: Av. Las Condes 8000
Distancia: 12.0 km
Repartidor asignado: Daniela A
Tiempo estimado de entrega: 25 minutos

Cancelando pedido de comida #01313...
Pedido Comida #01313 cancelado exitosamente.

Historial de entregas:
- Pedido de comida #01313 despachado por Nicolás
- Pedido de encomienda #06767 despachado por Javier
- Pedido express #04321 despachado por Daniela

Gracias por usar nuestro servicio.
```

## Conceptos aplicados

### Herencia
Las subclases (`PedidoComida`, `PedidoEncomienda`, `PedidoExpress`) heredan los atributos y métodos base de la clase abstracta `Pedido`.

### Polimorfismo
Cada subclase sobrescribe `calcularTiempoEntrega()` con su propia lógica específica.

### Abstracción
`Pedido` es una clase abstracta que define:
- Atributos comunes: `idPedido`, `direccionEntrega`, `distanciaKm`, `repartidorAsignado`
- Métodos abstractos: `calcularTiempoEntrega()`, `asignarRepartidor()`
- Métodos concretos: `mostrarResumen()`, `asignarRepartidor(String)`

### Interfaces
- **`Despachable`**: Define el método `despachar()`
- **`Cancelable`**: Define el método `cancelar()`

Cada tipo de pedido implementa ambas interfaces para proporcionar funcionalidad completa.

### Sobrecarga de métodos
El método `asignarRepartidor()` existe en dos versiones:
- **Sin parámetros**: Asignación automática (implementada en cada subclase)
- **Con parámetro String**: Asignación manual (implementada en la clase base)

## Flujo de operación

1. **Creación de pedidos**: Se instancian objetos de cada tipo de pedido
2. **Asignación automática**: Cada pedido asigna un repartidor predeterminado
3. **Asignación manual**: Se sobrescribe el repartidor con uno específico
4. **Cálculo de tiempo**: Se calcula el tiempo estimado según el tipo
5. **Registro**: Se registra en el historial del gestor
6. **Cancelación**: Se cancela el pedido (si aplica)
7. **Historial**: Se visualiza el registro completo de entregas

## Mejoras futuras

- 🔲 Agregar validaciones de entrada (direcciones vacías, distancias negativas, IDs duplicados)
- 🔲 Implementar pruebas unitarias con JUnit
- 🔲 Añadir persistencia de datos (archivos, base de datos)
- 🔲 Extender con más tipos de pedidos (PedidoMedicina, PedidoDocumentos, etc.)
- 🔲 Implementar patrones adicionales (Factory, Strategy, Observer)
- 🔲 Interfaz gráfica de usuario (GUI)
- 🔲 API REST para integración con otros sistemas
- 🔲 Manejo de excepciones personalizado

## Contribuir

1. Haz un fork del repositorio
2. Crea una rama para tu mejora: `git checkout -b feat/mi-mejora`
3. Haz commits descriptivos
4. Abre un Pull Request con la descripción de tus cambios
5. Añade pruebas cuando sea relevante

## Licencia

Sin licencia especificada. Considera añadir una licencia (MIT, Apache 2.0, GPL, etc.) si planeas compartir abiertamente.

## Contacto

**Autor/Mantenedor**: NicoC-XXVIII  
**Asignatura**: DOO2 (Diseño Orientado a Objetos)  
**Descripción**: Entrega Formativa Semana 2
