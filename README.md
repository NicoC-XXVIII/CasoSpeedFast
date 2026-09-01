# CasoSpeedFast

Entrega Formativa — Semana 2 (Asignatura: DOO2)

## Descripción

CasoSpeedFast es un ejercicio educativo en Java que demuestra principios de **Programación Orientada a Objetos**: herencia, polimorfismo y el patrón **Template Method**. El ejemplo modela un sistema de cálculo de tiempos de entrega para diferentes tipos de pedidos en una empresa de entregas rápidas.

## Características principales

- **Diseño orientado a objetos claro y educativo**
- **Clase abstracta base (`Pedido`)** que define la estructura común
- **Patrón Template Method**: método `procesarPedido()` final que define el flujo de proceso
- **Herencia**: Tres subclases especializadas (`PedidoComida`, `PedidoEncomienda`, `PedidoExpress`)
- **Polimorfismo**: cada subclase implementa su propio cálculo de tiempo de entrega
- **Ejecución por consola** que ilustra el comportamiento de cada tipo de pedido

### Tipos de pedidos

1. **PedidoComida**: Tiempo = 15 min + 2 min por km
2. **PedidoEncomienda**: Tiempo = 20 min + 1.5 min por km
3. **PedidoExpress**: Tiempo = 10 min base + 5 min extra si distancia > 5 km

## Estructura del proyecto

```
src/main/java/com/sfempresa/
├── entregas/
│   ├── Pedido.java              (clase abstracta base)
│   ├── PedidoComida.java        (entrega de comida)
│   ├── PedidoEncomienda.java    (envíos de paquetes)
│   └── PedidoExpress.java       (entregas urgentes)
└── main/
    └── Main.java                (punto de entrada)
```

## Tecnologías

- **Java 8+**
- Estructura compatible con Maven/Gradle

## Compilación y ejecución

### Opción A — Compilación con javac (Linux/macOS)

```bash
# Compilar todo el código
find src/main/java -name "*.java" > sources.txt
javac -d out @sources.txt

# Ejecutar
java -cp out com.sfempresa.main.Main
```

### Opción A — Compilación con javac (Windows PowerShell)

```powershell
# Compilar
Get-ChildItem -Recurse -Filter *.java src\main\java | ForEach-Object { $_.FullName } > sources.txt
javac -d out @sources.txt

# Ejecutar
java -cp out com.sfempresa.main.Main
```

### Opción B — Con Maven (si está configurado)

```bash
# Compilar
mvn compile

# Ejecutar
mvn exec:java -Dexec.mainClass="com.sfempresa.main.Main"
```

### Opción C — IDE

Importa el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, VS Code) y ejecuta `Main.java`.

## Ejemplo de salida esperada

```
===SERVICIO DE ENTREGAS SPEEDFAST===

Pedido Comida #00123
Dirección de entrega: Av. Italia 456
Distancia: 4.0 km
Tiempo estimado de entrega: 23 minutos

Pedido Encomienda #00234
Dirección de entrega: Av. Independencia 567
Distancia: 6.0 km
Tiempo estimado de entrega: 29 minutos

Pedido Express #00321
Dirección de entrega: Av. Apoquindo 4050
Distancia: 7.0 km
Tiempo estimado de entrega: 15 minutos
```

## Conceptos aplicados

- **Herencia**: Las subclases heredan los atributos y métodos de `Pedido`
- **Polimorfismo**: Cada subclase sobrescribe `calcularTiempoEntrega()` con su propia lógica
- **Abstracción**: `Pedido` es una clase abstracta que define el contrato a cumplir
- **Métodos finales**: `procesarPedido()` es `final` para evitar que las subclases lo modifiquen
- **Métodos abstractos**: `calcularTiempoEntrega()` debe ser implementado por cada subclase

## Mejoras futuras

- Agregar validaciones de entrada (direcciones vacías, distancias negativas, IDs duplicados)
- Implementar pruebas unitarias con JUnit
- Añadir persistencia de datos (archivos, base de datos)
- Extender con más tipos de pedidos
- Implementar patrones adicionales (Factory, Strategy)

## Contribuir

1. Haz un fork del repositorio
2. Crea una rama para tu mejora: `git checkout -b feat/mi-mejora`
3. Haz commits descriptivos
4. Abre un Pull Request con la descripción de tus cambios
5. Añade pruebas cuando sea relevante

## Licencia

Sin licencia especificada. Considera añadir una licencia (MIT, Apache 2.0, etc.) si planeas compartir abiertamente.

## Contacto

**Autor/Mantenedor**: NicoC-XXVIII  
**Descripción**: Entrega Formativa Semana 2, asignatura DOO2
