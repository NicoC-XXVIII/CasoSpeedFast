# CasoSpeedFast

Entrega formativa — Semana 1 (Asignatura: DOO2)

## Descripción
CasoSpeedFast es un ejercicio educativo en Java que demuestra principios de Programación Orientada a Objetos: herencia, polimorfismo (sobreescritura) y sobrecarga de métodos. El ejemplo modela distintos tipos de pedidos (Comida, Encomienda, Express) y la lógica de asignación de repartidores con salidas en consola.

## Características principales
- Diseño simple y claro orientado a objetos.
- Clases base y subclases que ejemplifican:
  - Herencia (Pedido → PedidoComida, PedidoEncomienda, PedidoExpress)
  - Polimorfismo: métodos `asignarRepartidor()` sobreescritos.
  - Sobrecarga: `asignarRepartidor()` y `asignarRepartidor(String nombreRepartidor)`.
- Ejecución por consola con salida que ilustra el comportamiento de cada tipo de pedido.

## Estructura del proyecto
Estructura relevante (ruta: `src/main/java/com/sfempresa`):

- com/sfempresa/entregas/
  - Pedido.java
  - PedidoComida.java
  - PedidoEncomienda.java
  - PedidoExpress.java
- com/sfempresa/main/
  - Main.java

Es un layout estándar de proyecto Java (Maven/Gradle-friendly).

## Tecnologías
- Java (versión mínima recomendada: 8+)
- (Opcional) Maven o Gradle si quieres añadir gestión de dependencias y empaquetado.

## Compilación y ejecución

Opción A — Compilación y ejecución con javac (Linux/macOS):
1. Compilar todo el código:
   ```
   find src/main/java -name "*.java" > sources.txt
   javac -d out @sources.txt
   ```
2. Ejecutar la clase principal:
   ```
   java -cp out com.sfempresa.main.Main
   ```

Opción A — Compilación y ejecución con javac (Windows PowerShell):
1. Compilar:
   ```
   Get-ChildItem -Recurse -Filter *.java src\main\java | ForEach-Object { $_.FullName } > sources.txt
   javac -d out @sources.txt
   ```
2. Ejecutar:
   ```
   java -cp out com.sfempresa.main.Main
   ```

Opción B — Si usas Maven (si existe `pom.xml`):
1. Compilar:
   ```
   mvn compile
   ```
2. Ejecutar (usando el plugin exec, si está configurado):
   ```
   mvn exec:java -Dexec.mainClass="com.sfempresa.main.Main"
   ```
Opción C — Importar el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, VS Code) y ejecutar `com.sfempresa.main.Main`.

## Ejemplo de salida esperada
Al ejecutar `Main`, se verá una salida similar a:

===EMPRESA SPEEDFAST===
Iniciando entregas...

[Pedido Comida]
Asignando repartidor...
Verificando mochila térmica... OK

[Pedido Encomienda]
Asignando repartidor...
→ Validando peso y embalaje... OK

[Pedido Express]
Asignando repartidor...
→ Repartidor más cercano con disponibilidad inmediata


[Pedido Comida]
Asignando repartidor...
Verificando mochila térmica... OK
→ Pedido asignado a Juan A.

[Pedido Encomienda]
Asignando repartidor...
→ Validando peso y embalaje... OK
→ Pedido asignado a Katiusca B.

[Pedido Express]
Asignando repartidor...
→ Repartidor más cercano con disponibilidad inmediata
→ Pedido asignado a Luis C.

Entregas finalizadas.

## Buenas prácticas y recomendaciones
- Agregar control de errores y validaciones (por ejemplo, direcciones vacías, IDs duplicados).
- Externalizar la entrada/salida de consola para facilitar pruebas unitarias.
- Añadir pruebas unitarias (JUnit) para verificar comportamiento de cada tipo de pedido.
- Considerar el uso de interfaces o patrones (Factory, Strategy) si el sistema crece.

## Contribuir
1. Haz un fork del repositorio.
2. Crea una rama con tu mejora: `git checkout -b feat/mi-mejora`.
3. Haz commits descriptivos y abre un Pull Request con la descripción de los cambios.
4. Añade pruebas cuando añadas lógica de negocio.

## Licencia
No se incluye una licencia en el repositorio. Si quieres compartirlo abiertamente, considera añadir una licencia como MIT. Puedo añadir una plantilla de LICENSE si lo deseas.

## Contacto
Autor / Mantenedor: NicoC-XXVIII  
Descripción del repositorio: Entrega Formativa Semana 1, asignatura DOO2
