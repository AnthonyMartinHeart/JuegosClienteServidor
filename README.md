# 🎮 Sistema de Juegos Cliente-Servidor

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![JavaFX](https://img.shields.io/badge/JavaFX-17.0.2-blue.svg)](https://openjfx.io/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-red.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

> **Proyecto académico de desarrollo de juegos en arquitectura cliente-servidor**
> 
> Implementación completa de **Tic-Tac-Toe** y **Batalla Naval** con inteligencia artificial avanzada, desarrollado en Java con JavaFX.

---

## 📋 Tabla de Contenidos

- [🎯 Características Principales](#-características-principales)
- [🏗️ Arquitectura](#️-arquitectura)
- [🚀 Instalación y Ejecución](#-instalación-y-ejecución)
- [🎮 Guía de Uso](#-guía-de-uso)
- [🧠 Inteligencia Artificial](#-inteligencia-artificial)
- [📊 Documentación Técnica](#-documentación-técnica)
- [🔧 Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [👥 Equipo de Desarrollo](#-equipo-de-desarrollo)

---

## 🎯 Características Principales

### ✨ **Juegos Incluidos**
- 🎯 **Tic-Tac-Toe (Gato)**: Juego clásico 3x3 con IA avanzada
- ⚓ **Batalla Naval**: Estrategia naval con tableros 10x10

### 🌐 **Modos de Juego**
- 👥 **Multijugador**: Dos jugadores en máquinas diferentes
- 🤖 **vs Inteligencia Artificial**: Oponentes inteligentes
- 🏠 **Local**: Juego en la misma máquina

### 🎨 **Interfaz Moderna**
- 🖥️ **JavaFX**: Interfaces gráficas modernas y responsivas
- 🎯 **UX Intuitiva**: Controles fáciles de usar
- 📱 **Responsive**: Adaptable a diferentes tamaños de pantalla

---

## 🚀 Instalación y Ejecución

### 📋 **Requisitos Previos**
- ☕ **Java 17** o superior
- 📦 **Maven 3.6+**
- 🖥️ **JavaFX 17.0.2**

### ⚡ **Ejecución Rápida**

#### 🖥️ **Opción 1: Scripts de Ejecución (Recomendado)**

**En Windows:**
```bash
# Iniciar servidor
run_server.bat

# Iniciar cliente (en otra terminal)
run_client.bat
```

**En Linux/Mac:**
```bash
# Iniciar servidor
./run_server.sh

# Iniciar cliente (en otra terminal)
./run_client.sh
```

#### 🔧 **Opción 2: Maven Manual**

```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar servidor
mvn exec:java -Dexec.mainClass="com.juegos.servidor.GameServer"

# Ejecutar cliente (en otra terminal)
mvn javafx:run
```

### Pasos de Instalación

1. **Clonar/Descargar el proyecto**
   ```bash
   git clone [url-del-proyecto]
   cd JuegosClienteServidor
   ```

2. **Configurar JavaFX**
   - Descargar JavaFX SDK desde: https://openjfx.io/
   - Extraer en una carpeta (ej: `C:\javafx-sdk-17`)

3. **Compilar el proyecto**
   ```bash
   # Windows PowerShell
   javac -cp "C:\javafx-sdk-17\lib\*" --module-path "C:\javafx-sdk-17\lib" src/main/java/com/juegos/**/*.java -d out
   ```

### 🎯 Ejecutar los Juegos

#### Opción A: Ejecutar desde IDE (Recomendado)
1. Abrir el proyecto en IntelliJ IDEA o Eclipse
2. Configurar JavaFX en el classpath
3. Ejecutar `MainApplication.java`

#### Opción B: Ejecutar desde línea de comandos

**1. Servidor (ejecutar primero)**
```powershell
java --module-path "C:\javafx-sdk-17\lib" --add-modules javafx.controls,javafx.fxml -cp "out;C:\javafx-sdk-17\lib\*" com.juegos.servidor.GameServer
```

**2. Cliente (ejecutar después)**
```powershell
java --module-path "C:\javafx-sdk-17\lib" --add-modules javafx.controls,javafx.fxml -cp "out;C:\javafx-sdk-17\lib\*" com.juegos.MainApplication
```

### 🎮 Cómo Jugar

#### Tic-Tac-Toe (Gato)
1. Seleccionar modo: **vs IA** o **vs Humano (Red)**
2. Si es vs Humano: Un jugador inicia el servidor, otro se conecta como cliente
3. Hacer clic en las casillas para colocar X u O
4. Ganar: 3 en línea (horizontal, vertical o diagonal)

#### Batalla Naval
1. **Fase de preparación**: Colocar barcos en el tablero
   - Portaaviones (5 casillas)
   - Acorazado (4 casillas)  
   - Crucero (3 casillas)
   - Submarino (3 casillas)
   - Destructor (2 casillas)
2. **Fase de batalla**: Hacer clic para disparar al tablero enemigo
3. **Ganar**: Hundir todos los barcos enemigos

## 📁 Estructura del Proyecto

```
JuegosClienteServidor/
├── src/main/java/com/juegos/
│   ├── MainApplication.java           # Aplicación principal
│   ├── common/                        # Clases comunes
│   │   ├── GameMessage.java          # Protocolo de comunicación
│   │   ├── Player.java               # Clase jugador
│   │   └── GameConstants.java        # Constantes del juego
│   ├── servidor/                      # Servidor de juegos
│   │   ├── GameServer.java           # Servidor principal
│   │   ├── ClientHandler.java        # Manejo de clientes
│   │   └── GameRoom.java             # Sala de juego
│   ├── cliente/                       # Cliente de juegos
│   │   ├── GameClient.java           # Cliente principal
│   │   └── NetworkManager.java       # Gestor de red
│   ├── tictactoe/                     # Juego Tic-Tac-Toe
│   │   ├── TicTacToeGame.java        # Lógica del juego
│   │   ├── TicTacToeController.java  # Controlador JavaFX
│   │   ├── TicTacToeAI.java          # IA con Minimax
│   │   └── TicTacToeView.fxml        # Interfaz FXML
│   ├── battleship/                    # Juego Batalla Naval
│   │   ├── BattleshipGame.java       # Lógica del juego
│   │   ├── BattleshipController.java # Controlador JavaFX
│   │   ├── BattleshipAI.java         # IA estratégica con backtracking
│   │   ├── Ship.java                 # Clase barco
│   │   ├── Board.java                # Tablero de juego
│   │   └── BattleshipView.fxml       # Interfaz FXML
│   └── ui/                           # Interfaz común
│       ├── MenuController.java       # Menú principal
│       ├── MenuView.fxml            # Vista del menú
│       └── GameStylesheet.css       # Estilos CSS
├── docs/                            # Documentación
│   ├── analisis-requisitos.md      # Análisis y requisitos
│   ├── casos-de-uso.md             # Casos de uso
│   ├── diagramas-uml/              # Diagramas UML
│   └── manual-usuario.md           # Manual de usuario
├── # 🎮 JUEGOS CLIENTE-SERVIDOR

Sistema de juegos multijugador con arquitectura cliente-servidor desarrollado en Java con interfaz gráfica Swing.

## 🎯 JUEGOS INCLUIDOS

### 🎲 Tic Tac Toe
- Tablero 3x3 interactivo
- Jugador vs IA
- Detección automática de ganador/empate
- Interfaz gráfica intuitiva

### ⚓ Battleship (Batalla Naval)
- Tableros 8x8 (jugador y enemigo)
- Sistema de ataques con retroalimentación visual
- IA enemiga inteligente
- Estadísticas de aciertos y fallos

## 🚀 INSTRUCCIONES DE USO

### 1️⃣ Iniciar el Servidor
```
EJECUTAR_SERVIDOR.bat
```
- Compila automáticamente el proyecto
- Inicia el servidor en puerto 12345
- Espera conexiones de clientes

### 2️⃣ Iniciar el Cliente
```
EJECUTAR_CLIENTE.bat
```
- Abre la interfaz gráfica del cliente
- Se conecta automáticamente al servidor local
- Permite seleccionar entre los juegos disponibles

### 3️⃣ Jugar
1. Haz clic en "Conectar" en la ventana del cliente
2. Selecciona "Tic Tac Toe" o "Battleship"
3. Se abre una nueva ventana con el juego
4. ¡Disfruta jugando!

## 🛠️ REQUISITOS TÉCNICOS

- **Java 8 o superior**
- **Sistema Operativo:** Windows
- **Interfaz Gráfica:** Swing (incluido en Java)
- **Red:** Localhost (127.0.0.1:12345)

## 📁 ESTRUCTURA DEL PROYECTO

```
JuegosClienteServidor/
├── 🚀 EJECUTAR_SERVIDOR.bat    # Script principal del servidor
├── 🖥️ EJECUTAR_CLIENTE.bat     # Script principal del cliente  
├── 📖 README.md                # Este archivo
├── 📋 PROYECTO_COMPLETADO.md   # Estado del proyecto
├── 📦 pom.xml                  # Configuración Maven (opcional)
├── 📂 src/main/java/com/juegos/
│   ├── 🎮 SwingMainApplication.java    # Aplicación principal
│   ├── 📂 ui/
│   │   ├── 🎲 TicTacToeWindow.java     # Ventana Tic Tac Toe
│   │   └── ⚓ BattleshipWindow.java    # Ventana Battleship
│   ├── 📂 servidor/
│   │   ├── 🖥️ GameServer.java          # Servidor principal
│   │   ├── 👤 ClientHandler.java      # Manejo de clientes
│   │   └── 🏠 GameRoom.java           # Salas de juego
│   ├── 📂 common/
│   │   ├── 📨 GameMessage.java        # Mensajes del juego
│   │   ├── 👤 Player.java             # Datos del jugador
│   │   └── ⚙️ GameConstants.java      # Constantes
│   ├── 📂 tictactoe/
│   │   ├── 🎲 TicTacToeGame.java      # Lógica del juego
│   │   └── 🤖 TicTacToeAI.java        # Inteligencia artificial
│   └── 📂 battleship/
│       ├── ⚓ BattleshipGame.java     # Lógica del juego
│       ├── 🗃️ Board.java              # Tablero
│       └── 🚢 Ship.java               # Barcos
└── 📂 documentacion/
    ├── 📋 INFORME_TECNICO_COMPLETO.md
    ├── ✅ VERIFICACION_PROYECTO.md
    └── 📂 docs/                       # Diagramas UML y documentación
```

## ✨ CARACTERÍSTICAS DESTACADAS

- ✅ **Interfaz Gráfica Moderna:** Desarrollada con Swing
- ✅ **Arquitectura Cliente-Servidor:** Comunicación por red
- ✅ **Multijugador:** Soporte para múltiples clientes
- ✅ **IA Implementada:** Juego contra la computadora
- ✅ **Manejo de Errores:** Sistema robusto de excepciones
- ✅ **Logging:** Sistema de logs detallado
- ✅ **Fácil de Usar:** Scripts de ejecución automatizados

## 🎯 ESTADO DEL PROYECTO

**✅ COMPLETADO** - El proyecto está 100% funcional y listo para uso.

Todos los componentes han sido implementados y probados:
- Servidor multijugador ✅
- Cliente con interfaz gráfica ✅
- Juegos completamente funcionales ✅
- Comunicación cliente-servidor ✅

## 👨‍💻 DESARROLLO

Proyecto desarrollado como parte del curso de Programación Orientada a Objetos.

**Tecnologías utilizadas:**
- Java 8
- Swing (GUI)
- Sockets (Networking)
- Arquitectura MVC                       # Este archivo
└── pom.xml                        # Configuración Maven
```

## 🔧 Configuración de Desarrollo

### IntelliJ IDEA
1. File → Project Structure → Libraries
2. Agregar JavaFX lib folder
3. Run Configuration → VM Options:
   ```
   --module-path "C:\javafx-sdk-17\lib" --add-modules javafx.controls,javafx.fxml
   ```

### Eclipse
1. Right-click project → Properties → Java Build Path
2. Add External JARs → Seleccionar todos los JARs de JavaFX lib
3. Run Configuration → Arguments → VM arguments:
   ```
   --module-path "C:\javafx-sdk-17\lib" --add-modules javafx.controls,javafx.fxml
   ```

## 🎯 Características Técnicas

### Arquitectura
- **Patrón MVC** para separación de responsabilidades
- **Cliente-Servidor** con sockets TCP
- **Observer Pattern** para eventos de juego
- **Strategy Pattern** para diferentes tipos de IA

### IA Implementada
- **Tic-Tac-Toe**: Algoritmo Minimax con poda alfa-beta
- **Batalla Naval**: IA estratégica con patrones de búsqueda

### Red
- **Protocolo**: TCP/IP con mensajes JSON
- **Puerto por defecto**: 12345
- **Multiples salas**: Soporte para múltiples partidas simultáneas

## 🏆 Evaluación del Proyecto

### Primera Entrega (40% del total)
- ✅ Análisis y diseño orientado a objetos
- ✅ Casos de uso
- ✅ Requisitos funcionales y no funcionales
- ✅ Diagramas de secuencia
- ✅ Diagramas de clases
- ✅ Diagramas de colaboración

### Segunda Entrega (20% del total)
- ✅ Implementación del 50% del proyecto
- ✅ Funcionalidad básica de ambos juegos
- ✅ Comunicación cliente-servidor básica

### Entrega Final (40% del total)
- ✅ Proyecto completo funcional
- ✅ IA implementada para ambos juegos
- ✅ Interfaz gráfica pulida
- ✅ Documentación completa

## 👥 Autores
- Valter Lineros
- Jorge Martinez

## 📄 Licencia
Este proyecto es para fines académicos - Universidad [Nombre Universidad]

---
📅 **Fecha de entrega**: 04 de Agosto, 2025
