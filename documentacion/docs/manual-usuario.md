# 🛠️ Manual de Usuario - Juegos Cliente-Servidor

## 📋 Tabla de Contenidos
1. [Introducción](#introducción)
2. [Instalación](#instalación)
3. [Ejecución del Sistema](#ejecución-del-sistema)
4. [Guía de Juego](#guía-de-juego)
5. [Solución de Problemas](#solución-de-problemas)
6. [Características Técnicas](#características-técnicas)

---

## 1. Introducción

### ¿Qué es el Sistema de Juegos Cliente-Servidor?

Es una aplicación desarrollada en Java que permite jugar **Tic-Tac-Toe** y **Batalla Naval** tanto contra otros jugadores humanos a través de la red como contra inteligencia artificial avanzada.

### Características Principales
- ✅ **Dos juegos completos**: Tic-Tac-Toe y Batalla Naval
- ✅ **Modo multijugador**: Juega contra otros usuarios en la red
- ✅ **Inteligencia artificial**: Oponentes IA con diferentes niveles
- ✅ **Interfaz moderna**: Desarrollada con JavaFX
- ✅ **Arquitectura robusta**: Cliente-servidor con comunicación TCP/IP

---

## 2. Instalación

### 2.1 Requisitos del Sistema

#### Hardware Mínimo
- **Procesador**: Intel i3 o equivalente
- **RAM**: 4 GB mínimo (8 GB recomendado)
- **Espacio en disco**: 500 MB libres
- **Red**: Conexión de red local o internet (para modo multijugador)

#### Software Requerido
- **Java**: JDK 17 o superior
- **JavaFX**: SDK 17 o superior
- **Sistema operativo**: Windows 10/11, Linux, o macOS

### 2.2 Instalación de Java

1. **Descargar Java JDK 17+**
   - Visitar: https://www.oracle.com/java/technologies/downloads/
   - Descargar la versión para tu sistema operativo
   - Instalar siguiendo las instrucciones del instalador

2. **Verificar instalación**
   ```bash
   java -version
   ```
   Debe mostrar Java 17 o superior

### 2.3 Instalación de JavaFX

1. **Descargar JavaFX SDK**
   - Visitar: https://openjfx.io/
   - Descargar JavaFX SDK 17 para tu sistema
   - Extraer en una carpeta (ejemplo: `C:\javafx-sdk-17`)

2. **Configurar variable de entorno** (Opcional)
   ```bash
   # Windows
   set JAVAFX_HOME=C:\javafx-sdk-17
   
   # Linux/macOS
   export JAVAFX_HOME=/path/to/javafx-sdk-17
   ```

### 2.4 Instalación del Proyecto

1. **Descargar el proyecto**
   - Extraer el archivo ZIP en una carpeta
   - O clonar desde el repositorio de Git

2. **Editar archivos de ejecución**
   - Abrir `run_server.bat` y `run_client.bat`
   - Modificar la línea `JAVAFX_PATH` con la ruta correcta:
   ```batch
   set JAVAFX_PATH=C:\tu-ruta-a\javafx-sdk-17\lib
   ```

---

## 3. Ejecución del Sistema

### 3.1 Iniciar el Servidor

**En Windows:**
```bash
# Hacer doble clic en:
run_server.bat

# O desde línea de comandos:
cd JuegosClienteServidor
run_server.bat
```

**En Linux/macOS:**
```bash
cd JuegosClienteServidor
chmod +x run_server.sh
./run_server.sh
```

**Resultado esperado:**
```
🟢 Servidor de Juegos iniciado en puerto 12345
📡 Esperando conexiones de clientes...
```

### 3.2 Iniciar el Cliente

**En Windows:**
```bash
# Hacer doble clic en:
run_client.bat

# O desde línea de comandos:
run_client.bat
```

**En Linux/macOS:**
```bash
./run_client.sh
```

### 3.3 Conexión Manual (Avanzado)

Si prefieres compilar y ejecutar manualmente:

```bash
# Compilar
javac -cp "javafx-sdk-17/lib/*" --module-path "javafx-sdk-17/lib" 
      --add-modules javafx.controls,javafx.fxml 
      src/main/java/com/juegos/**/*.java -d out

# Ejecutar servidor
java --module-path "javafx-sdk-17/lib" 
     --add-modules javafx.controls,javafx.fxml 
     -cp "out;javafx-sdk-17/lib/*" 
     com.juegos.servidor.GameServer

# Ejecutar cliente
java --module-path "javafx-sdk-17/lib" 
     --add-modules javafx.controls,javafx.fxml 
     -cp "out;javafx-sdk-17/lib/*" 
     com.juegos.MainApplication
```

---

## 4. Guía de Juego

### 4.1 Primera Conexión

1. **Abrir la aplicación cliente**
   - Se mostrará la pantalla principal con opciones de conexión

2. **Configurar conexión**
   - **Servidor**: `localhost` (si juegas en la misma PC) o IP del servidor
   - **Puerto**: `12345` (por defecto)
   - **Tu nombre**: Ingresa un nombre único (máximo 20 caracteres)

3. **Conectar al servidor**
   - Hacer clic en "🔗 Conectar al Servidor"
   - Esperar confirmación: "✅ Conectado como: [tu nombre]"

### 4.2 Selección de Juego

Una vez conectado, puedes elegir entre:

#### 🎯 Tic-Tac-Toe (Gato)
- **🤖 vs IA**: Juego inmediato contra inteligencia artificial
- **👥 vs Humano**: Espera o busca otro jugador humano

#### 🚢 Batalla Naval
- **🤖 vs IA**: Juego inmediato contra inteligencia artificial  
- **👥 vs Humano**: Espera o busca otro jugador humano

### 4.3 Jugando Tic-Tac-Toe

#### Reglas del Juego
- Tablero 3x3
- Objetivo: Conseguir 3 símbolos en línea (horizontal, vertical o diagonal)
- X siempre juega primero

#### Controles
1. **Tu turno**: Hacer clic en una casilla vacía
2. **Esperar**: El oponente (IA o humano) hace su movimiento
3. **Resultado**: El juego anuncia ganador, perdedor o empate

#### Estrategias vs IA
- La IA usa algoritmo **Minimax**: juega de forma perfecta
- Intenta ocupar el centro primero
- Bloquea movimientos ganadores del oponente
- Busca oportunidades de victoria

### 4.4 Jugando Batalla Naval

#### Reglas del Juego
- Tablero 10x10 para cada jugador
- **5 barcos** por jugador:
  - 🚢 Portaaviones (5 casillas)
  - 🚢 Acorazado (4 casillas)
  - 🚢 Crucero (3 casillas)
  - 🚢 Submarino (3 casillas)
  - 🚢 Destructor (2 casillas)

#### Fase 1: Configuración de Barcos
1. **Colocación manual**:
   - Arrastrar barcos al tablero
   - Hacer clic derecho para rotar
   - Los barcos no pueden superponerse

2. **Colocación automática**:
   - Botón "Auto-colocar" para colocación aleatoria
   - Útil para comenzar rápidamente

#### Fase 2: Batalla
1. **Tu turno de disparo**:
   - Hacer clic en el tablero enemigo
   - Resultados posibles:
     - 💧 **Agua**: Fallaste
     - 💥 **Tocado**: Diste a un barco
     - ⚰️ **Hundido**: Destruiste un barco completo

2. **Turno del oponente**:
   - Esperar a que dispare
   - Ver el resultado en tu tablero

3. **Victoria**:
   - Primer jugador en hundir todos los barcos enemigos gana

#### Estrategias vs IA
- La IA usa **estrategia de búsqueda inteligente**
- Después de un impacto, busca sistemáticamente alrededor
- Adapta su estrategia según los patrones encontrados

### 4.5 Multijugador

#### Crear/Unirse a Partidas
- **Modo vs Humano**: El sistema busca automáticamente oponentes disponibles
- Si no hay oponentes, crea una nueva sala y espera
- Cuando otro jugador se une, la partida comienza

#### Chat y Comunicación
- El sistema sincroniza automáticamente los movimientos
- Los turnos se alternan automáticamente
- Mensajes informativos aparecen durante el juego

---

## 5. Solución de Problemas

### 5.1 Problemas de Instalación

#### Error: "java no reconocido como comando"
**Solución:**
1. Verificar que Java está instalado: `java -version`
2. Agregar Java al PATH del sistema
3. Reiniciar la terminal/símbolo del sistema

#### Error: "JavaFX no encontrado"
**Solución:**
1. Verificar que JavaFX está descargado y extraído
2. Actualizar la ruta en `run_server.bat` y `run_client.bat`
3. Asegurar que la ruta no contiene espacios o caracteres especiales

### 5.2 Problemas de Conexión

#### "Error al conectar con el servidor"
**Posibles soluciones:**
1. **Verificar que el servidor está ejecutándose**
   - Debe mostrar "Servidor iniciado en puerto 12345"
   
2. **Verificar la dirección IP**
   - Para juego local: usar `localhost` o `127.0.0.1`
   - Para red: usar la IP real del servidor (`ipconfig` en Windows)
   
3. **Verificar el puerto**
   - Puerto por defecto: `12345`
   - Asegurar que no está bloqueado por firewall
   
4. **Firewall/Antivirus**
   - Permitir Java en el firewall
   - Permitir comunicación en puerto 12345

#### "Conexión perdida durante el juego"
**Soluciones:**
1. Reconectar al servidor
2. Verificar estabilidad de la red
3. Reiniciar cliente y servidor si es necesario

### 5.3 Problemas de Juego

#### "El juego no responde"
**Soluciones:**
1. Verificar que es tu turno
2. Hacer clic en casillas válidas únicamente
3. Esperar a que termine el turno del oponente

#### "Los barcos no se colocan en Batalla Naval"
**Soluciones:**
1. Verificar que el barco cabe en el tablero
2. Verificar que no se superpone con otros barcos
3. Intentar colocación automática como alternativa

### 5.4 Problemas de Rendimiento

#### "La aplicación va lenta"
**Soluciones:**
1. Cerrar otras aplicaciones que consuman memoria
2. Verificar que tienes al menos 4GB RAM disponible
3. Usar Java con más memoria: agregar `-Xmx2g` al comando de ejecución

#### "La IA tarda mucho en mover"
**Normal:**
- La IA de Tic-Tac-Toe puede tardar 1-2 segundos (es normal)
- La IA de Batalla Naval puede tardar 2-3 segundos en turnos complejos

---

## 6. Características Técnicas

### 6.1 Arquitectura del Sistema

#### Lado Servidor
- **Multihilo**: Maneja múltiples clientes simultáneamente
- **Pool de conexiones**: Optimiza el uso de recursos
- **Gestión de salas**: Organiza partidas por tipo de juego

#### Lado Cliente
- **Interfaz JavaFX**: Moderna y responsive
- **Comunicación asíncrona**: No bloquea la interfaz
- **Manejo de errores**: Recuperación automática de conexiones

#### Comunicación
- **Protocolo**: TCP/IP para confiabilidad
- **Formato**: Mensajes de texto estructurados
- **Puerto**: 12345 (configurable)

### 6.2 Inteligencia Artificial

#### Tic-Tac-Toe
- **Algoritmo**: Minimax con poda alfa-beta
- **Profundidad**: Búsqueda completa (9 niveles máximo)
- **Rendimiento**: Juego perfecto, nunca pierde

#### Batalla Naval
- **Estrategia**: Búsqueda inteligente con patrones
- **Adaptación**: Ajusta táctica según impactos previos
- **Eficiencia**: Optimiza disparos para minimizar turnos

### 6.3 Persistencia y Configuración

#### Configuración
- Archivos `.bat` para Windows
- Archivos `.sh` para Linux/macOS
- Configuración de red en tiempo de ejecución

#### Estadísticas
- Conteo de victorias/derrotas por sesión
- Estadísticas básicas de precisión en Batalla Naval
- Tiempo de partida y número de turnos

---

## 🔧 Soporte Técnico

### Información del Sistema
- **Desarrollado por**: [Nombre del Equipo]
- **Versión**: 1.0
- **Fecha**: Agosto 2025
- **Java**: Requiere JDK 17+
- **JavaFX**: Requiere SDK 17+

### Reportar Problemas
Para reportar bugs o solicitar características:
1. Documenta el problema paso a paso
2. Incluye capturas de pantalla si es posible
3. Indica tu sistema operativo y versión de Java
4. Contacta al equipo de desarrollo

---

**¡Disfruta jugando! 🎮**
