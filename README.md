# CasoSpeedFast

Entrega Sumativa 2 — Semana 5 (Asignatura: DOO2)

## Descripción

CasoSpeedFast es un sistema de gestión de entregas que demuestra principios clave de **Programación Orientada a Objetos** y **Programación Concurrente** en Java. El proyecto implementa un servicio de entregas rápidas mediante un modelo productor-consumidor con múltiples repartidores procesando pedidos simultáneamente.

Este ejercicio educativo ilustra:
- **Concurrencia**: Múltiples hilos (repartidores) procesando entregas en paralelo
- **Thread-Safety**: Sincronización segura en operaciones compartidas
- **Interfaces**: Implementación de `Runnable` para comportamiento concurrente
- **Gestión de estado**: Estados de pedidos (PENDIENTE, EN_REPARTO, ENTREGADO)
- **Patrones de diseño**: Patrón productor-consumidor

## Características principales

- ✅ **Modelo concurrente** con múltiples repartidores
- ✅ **Gestión sincronizada de pedidos** mediante `ZonaDeCarga`
- ✅ **Clase de dominio `Pedido`** con estados bien definidos
- ✅ **Repartidores como hilos** (`Repartidor implements Runnable`)
- ✅ **Enum `EstadoPedido`** para transiciones de estado consistentes
- ✅ **ExecutorService** para administración de hilos
- ✅ **Simulación de entregas** con delays realistas
- ✅ **Salida por consola** que muestra el flujo concurrente

## Estructura del proyecto

```
src/main/java/com/sfempresa/
├── app/
│   └── Main.java                   (punto de entrada y orquestación)
└── entregas/
    ├── Pedido.java                 (modelo de dato con estado)
    ├── EstadoPedido.java           (enum de estados)
    ├── ZonaDeCarga.java            (gestor sincronizado de cola)
    └── Repartidor.java             (implementa Runnable para entregas)
```

## Tecnologías

- **Java 23** (según pom.xml)
- **Maven** para build y gestión de dependencias
- **java.util.concurrent** para gestión de hilos

## Compilación y ejecución

### Opción A — Maven (Recomendado)

```bash
# Compilar
mvn clean compile

# Ejecutar
mvn exec:java -Dexec.mainClass="com.sfempresa.app.Main"
```

### Opción B — Compilación con javac (Linux/macOS)

```bash
# Compilar
find src/main/java -name "*.java" > sources.txt
javac -d out @sources.txt

# Ejecutar
java -cp out com.sfempresa.app.Main
```

### Opción C — Compilación con javac (Windows PowerShell)

```powershell
# Compilar
Get-ChildItem -Recurse -Filter *.java src\main\java | ForEach-Object { $_.FullName } | Out-File sources.txt
javac -d out @sources.txt

# Ejecutar
java -cp out com.sfempresa.app.Main
```

### Opción D — IDE

Importa el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, VS Code) y ejecuta `Main.java`.

## Ejemplo de salida esperada

```
==SERVICIO DE ENTREGAS SPEEDFAST==

[Zona de carga inicializada]

[Repartidor - Juan] Retirando pedido #1...

[Repartidor - Juan] Estado: EN_REPARTO

[Repartidor - Juan] Entregando pedido #1...

[Repartidor - Camila] Retirando pedido #2...

[Repartidor - Camila] Estado: EN_REPARTO

[Repartidor - Camila] Entregando pedido #2...

[Repartidor - Pedro] Retirando pedido #3...

[Repartidor - Pedro] Estado: EN_REPARTO

[Repartidor - Pedro] Entregando pedido #3...

[Repartidor - Juan] Estado: ENTREGADO

[Repartidor - Juan] Retirando pedido #4...

...

---Zona de carga vacía---

Todos los pedidos han sido entregados exitosamente.
```

## Componentes principales

### Pedido.java
Modelo de datos que representa una entrega individual:
- `id`: identificador único del pedido
- `direccionEntrega`: destino de la entrega
- `estado`: estado actual (PENDIENTE, EN_REPARTO, ENTREGADO)

### EstadoPedido.java
Enumeración que define los estados posibles:
- `PENDIENTE`: Pedido en la zona de carga
- `EN_REPARTO`: Repartidor entregando el pedido
- `ENTREGADO`: Entrega completada

### ZonaDeCarga.java
Gestor sincronizado que implementa el patrón productor-consumidor:
- Almacena pedidos en una estructura sincronizada (típicamente `BlockingQueue` o similar)
- `agregarPedido()`: añade un nuevo pedido (productor)
- `retirarPedido()`: obtiene el siguiente pedido (consumidor)
- Thread-safe para acceso concurrente

### Repartidor.java
Implementa `Runnable` para ejecutar en un hilo:
- Lee pedidos de la `ZonaDeCarga`
- Actualiza el estado a `EN_REPARTO`
- Simula la entrega con `Thread.sleep(2000)`
- Marca como `ENTREGADO`
- Continúa hasta que no hay más pedidos

### Main.java
Orquestación del sistema:
1. Crea una `ZonaDeCarga`
2. Agrega 5 pedidos iniciales
3. Crea 3 repartidores
4. Ejecuta los repartidores en un `ExecutorService` con 3 hilos
5. Espera a que terminen todas las entregas

## Conceptos aplicados

### Concurrencia
Multiple `Repartidor` instancias se ejecutan simultáneamente como hilos diferentes, compartiendo la misma `ZonaDeCarga` de forma segura.

### Thread-Safety
`ZonaDeCarga` usa mecanismos de sincronización (probablemente `BlockingQueue`) para evitar condiciones de carrera cuando múltiples repartidores acceden simultáneamente.

### Patrón Productor-Consumidor
- **Productor**: `Main` agrega pedidos a `ZonaDeCarga`
- **Consumidores**: `Repartidor` hilos que retiran y procesan pedidos

### Estados
`EstadoPedido` enum asegura que las transiciones son válidas y consistentes:
```
PENDIENTE → EN_REPARTO → ENTREGADO
```

### ExecutorService
Gestiona eficientemente un pool de 3 hilos, evitando la creación/destrucción innecesaria de threads.

## Flujo de ejecución

```
1. Main inicia
2. ZonaDeCarga se inicializa (vacía)
3. 5 pedidos se agregan a ZonaDeCarga
4. 3 Repartidores comienzan a ejecutarse en paralelo
5. Cada repartidor:
   - Retira un pedido de la zona
   - Cambia estado a EN_REPARTO
   - Simula entrega (2 segundos)
   - Cambia estado a ENTREGADO
   - Repite hasta no haya pedidos
6. ExecutorService espera a que terminen todos
7. Programa finaliza
```

## Mejoras futuras

- 🔲 Implementar persistencia de datos (archivos, base de datos)
- 🔲 Agregar métodos de consulta del estado (historial de entregas)
- 🔲 Extender con tipos de pedidos especializados (comida, paquete, documentos)
- 🔲 Implementar prioridades en la cola de pedidos
- 🔲 Agregar validaciones de entrada
- 🔲 Implementar pruebas unitarias con JUnit
- 🔲 Interfaz gráfica de usuario (GUI)
- 🔲 API REST para integración
- 🔲 Manejo de excepciones personalizado
- 🔲 Estadísticas de desempeño (tiempo promedio de entrega, etc.)

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
**Descripción**: Entrega Sumativa 2 Semana 5
