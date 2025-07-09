# 📊 Diagramas UML - Juegos Cliente-Servidor

> **Nota Importante**: Este proyecto incluye diagramas UML profesionales creados con PlantUML y Mermaid siguiendo estándares académicos formales.
> Para visualizar correctamente todos los diagramas, asegúrese de tener instaladas las extensiones:
> - PlantUML (jebbs.plantuml)
> - Mermaid Chart (mermaidchart.vscode-mermaid-chart)

---

## 🎨 **DIAGRAMAS UML FORMALES (ESTILO ACADÉMICO)**

### 📋 **Diagrama de Casos de Uso (Formal UML)**
> **🏆 VERSIÓN ACADÉMICA OFICIAL** - Sigue estándares UML 2.5

1. **📐 [Diagrama Formal PlantUML](diagrama-casos-uso-formal.puml)**
   - ✅ **Actores como figuras humanas** (estándar UML)
   - ✅ **Casos de uso como elipses** (estándar UML)
   - ✅ **Relaciones include/extend** correctamente definidas
   - ✅ **Frontera del sistema** profesional
   - ✅ **Notas explicativas** y documentación completa
   - **Listo para exportar a PNG para entrega académica**

2. **🌐 [Diagrama Interactivo HTML](casos-uso-diagram.html)**
   - Versión web interactiva del diagrama formal
   - Leyenda explicativa completa
   - Estilo visual profesional
   - **Abrir directamente en navegador**

### 🎯 **Instrucciones de Exportación Académica**

#### **Para Exportar a PNG (Entrega Académica):**
```bash
# Opción 1: VS Code con PlantUML
1. Abrir diagrama-casos-uso-formal.puml
2. Ctrl+Shift+P → "PlantUML: Preview Current Diagram"
3. Ctrl+Shift+P → "PlantUML: Export Current Diagram"
4. Seleccionar formato PNG

# Opción 2: Online PlantUML
1. Visitar: http://www.plantuml.com/plantuml/
2. Copiar contenido de diagrama-casos-uso-formal.puml
3. Generar y descargar PNG
```

---

## 🔧 **DIAGRAMAS COMPLEMENTARIOS**

### 📊 **Diagramas Mermaid (Visualización Directa)**

1. **📋 [Diagrama de Clases](diagrama-clases-mermaid.md)** 
   - Estructura completa del sistema con todas las clases
   - Relaciones y dependencias claramente definidas
   - **¡Haz clic para ver el diagrama visual!**

2. **🔄 [Diagrama de Secuencia](diagrama-secuencia-mermaid.md)**
   - Flujo completo de Tic-Tac-Toe vs IA
   - Interacciones paso a paso
   - **¡Haz clic para ver el diagrama visual!**

3. **🎯 [Diagrama de Casos de Uso Mermaid](diagrama-casos-uso-mermaid.md)**
   - Versión alternativa en Mermaid
   - Funcionalidades del sistema
   - **¡Haz clic para ver el diagrama visual!**

---

## 📈 **BENEFICIOS DE LOS DIAGRAMAS MERMAID**

✅ **Visualización Inmediata**: Los diagramas se renderizan automáticamente  
✅ **Interactivos**: Puedes hacer zoom y navegar  
✅ **Editables**: Código fuente modificable fácilmente  
✅ **Exportables**: Se pueden exportar a PNG, SVG, PDF  
✅ **Versionables**: Al ser texto, se pueden versionar con Git  
✅ **Profesionales**: Apariencia moderna y limpia  

---

## 📋 Índice de Diagramas

1. **[Diagrama de Clases](#diagrama-de-clases)** - Estructura completa del sistema
2. **[Diagramas de Secuencia](#diagramas-de-secuencia)** - Flujos de ejecución
3. **[Diagrama de Colaboración](#diagrama-de-colaboración)** - Interacciones entre objetos
4. **[Diagrama de Casos de Uso](#diagrama-de-casos-de-uso)** - Funcionalidades del sistema
5. **[Diagramas de Arquitectura](#diagramas-de-arquitectura)** - Vista general del sistema

---

## 1. Diagrama de Clases

### 📁 Archivo: `diagrama-clases.puml`

El diagrama de clases muestra la estructura completa del sistema, incluyendo todas las clases, sus atributos, métodos y relaciones. Este diagrama ha sido creado utilizando PlantUML para garantizar un diseño profesional y fácil mantenimiento.

**Características principales:**
- ✅ Separación por paquetes (packages)
- ✅ Todos los atributos y métodos documentados
- ✅ Relaciones claramente definidas
- ✅ Uso de estereotipos y colores para mayor claridad

**Para visualizar**: Abra el archivo `docs/diagrama-clases.puml` en VS Code con la extensión PlantUML instalada.

---

## 2. Diagramas de Secuencia

### 📁 Archivos incluidos:

#### 2.1 Conexión y Selección (`diagrama-secuencia-conexion.puml`)
Muestra el proceso completo desde que el jugador inicia la aplicación hasta que se une a una sala de juego.

#### 2.2 Jugada Tic-Tac-Toe (`diagrama-secuencia-tictactoe.puml`)
Detalla el flujo de una jugada completa en Tic-Tac-Toe, incluyendo la interacción con la IA.

#### 2.3 Batalla Naval (`diagrama-secuencia-battleship.puml`)
Cubre tanto la fase de configuración como la fase de combate en el juego de Batalla Naval.

**Características:**
- ✅ Flujos alternativos claramente definidos
- ✅ Manejo de errores documentado
- ✅ Interacciones con IA detalladas
- ✅ Activación y desactivación de objetos

---

## 3. Diagrama de Colaboración

### 📁 Archivo: `diagrama-colaboracion.puml`

Muestra las responsabilidades de cada objeto y cómo colaboran para lograr los objetivos del sistema.

**Incluye:**
- ✅ Responsabilidades de cada clase
- ✅ Secuencia numerada de colaboraciones
- ✅ Patrones de diseño identificados
- ✅ Notas explicativas sobre algoritmos

---

## 4. Diagrama de Casos de Uso

### 📁 Archivo: `diagrama-casos-uso-visual.puml`

Presenta una vista completa de todas las funcionalidades del sistema desde la perspectiva de los usuarios.

**Características avanzadas:**
- ✅ Agrupación por subsistemas
- ✅ Relaciones include, extend y generalización
- ✅ Tres tipos de actores: Jugador, IA y Servidor
- ✅ Notas explicativas sobre algoritmos complejos

---

## 5. Diagramas de Arquitectura

### 📁 Archivos Mermaid:

#### 5.1 Arquitectura General (`arquitectura-sistema.md`)
Diagrama de arquitectura usando Mermaid que muestra la estructura general del sistema.

#### 5.2 Flujo Tic-Tac-Toe (`flujo-tictactoe.md`)
Diagrama de secuencia en Mermaid para el flujo específico de Tic-Tac-Toe.

---

## 🎨 Estándares de Diseño Aplicados

### Colores y Estilos:
- **Verde claro**: Componentes de conexión
- **Azul claro**: Componentes de interfaz
- **Naranja**: Lógica de Tic-Tac-Toe
- **Púrpura**: Lógica de Batalla Naval
- **Amarillo**: Componentes del servidor
- **Rosa**: Inteligencia Artificial

### Convenciones:
- Uso de iconos Unicode para mejor legibilidad
- Notas explicativas en puntos críticos
- Separación clara de responsabilidades
- Documentación de patrones de diseño utilizados

---

## 📖 Cómo Usar los Diagramas

1. **Instalación de extensiones**: Asegúrese de tener instaladas las extensiones mencionadas
2. **Visualización**: Abra cualquier archivo `.puml` y use Ctrl+Shift+P > "PlantUML: Preview Current Diagram"
3. **Exportación**: Los diagramas pueden exportarse a PNG, SVG o PDF
4. **Edición**: Modifique los archivos `.puml` para actualizar los diagramas automáticamente

---

## 🔄 Mantenimiento

Los diagramas están diseñados para ser fácilmente mantenibles:
- Código fuente en texto plano (versionable)
- Regeneración automática al cambiar el código
- Separación por archivos para mejor organización
- Comentarios en el código PlantUML para facilitar ediciones

---

## Diagrama de Clases (Versión Anterior - Referencia)

```
                    GameConstants
                   <<static class>>
+--------------------------------------------------+
| - DEFAULT_SERVER_HOST: String                   |
| - DEFAULT_SERVER_PORT: int                      |
| - GAME_TICTACTOE: String                        |
| - GAME_BATTLESHIP: String                       |
| - MSG_CONNECT: String                           |
| - MSG_MOVE: String                              |
| - TICTACTOE_BOARD_SIZE: int                     |
| - BATTLESHIP_BOARD_SIZE: int                    |
| - SHIP_SIZES: int[]                             |
+--------------------------------------------------+

    GameMessage                          Player
+------------------+                +------------------+
| - type: String   |                | - id: String     |
| - gameType: String|               | - name: String   |
| - playerId: String|               | - symbol: String |
| - data: Object   |                | - isHuman: bool  |
| - timestamp: String|              | - isConnected: bool|
+------------------+                | - gamesWon: int  |
| + createConnectMessage()          | - gamesLost: int |
| + createMoveMessage()             | - gamesDrawn: int|
| + createErrorMessage()            +------------------+
+------------------+                | + incrementWins()|
                                   | + incrementLosses()|
                                   | + getTotalGames()|
                                   | + getWinPercentage()|
                                   | + createAI(): Player|
                                   +------------------+

           GameServer                        ClientHandler
    +----------------------+           +----------------------+
    | - serverSocket: ServerSocket |   | - clientSocket: Socket|
    | - threadPool: ExecutorService|   | - server: GameServer  |
    | - clients: Map<String,       |   | - clientId: String    |
    |   ClientHandler>             |   | - player: Player      |
    | - gameRooms: Map<String,     |   | - reader: BufferedReader|
    |   GameRoom>                  |   | - writer: PrintWriter |
    | - isRunning: boolean         |   | - isConnected: boolean|
    +----------------------+           +----------------------+
    | + start()            |           | + run()               |
    | + stop()             |           | + sendMessage()       |
    | + registerClient()   |           | + disconnect()        |
    | + createGameRoom()   |           | + processMessage()    |
    | + findOrCreateRoom() |           | + handleConnect()     |
    +----------------------+           | + handleGameSelect()  |
                                      | + handleMove()        |
                                      +----------------------+

           GameRoom                         TicTacToeGame
    +----------------------+           +----------------------+
    | - roomId: String     |           | - board: char[][]     |
    | - gameType: String   |           | - player1: Player     |
    | - mode: String       |           | - player2: Player     |
    | - players: List<     |           | - currentPlayer: Player|
    |   ClientHandler>     |           | - gameEnded: boolean  |
    | - gameInstance: Object|          | - winner: String      |
    | - currentPlayerId: String|       | - movesCount: int     |
    | - gameStarted: boolean|          +----------------------+
    | - gameFinished: boolean|         | + setPlayers()        |
    +----------------------+           | + makeMove()          |
    | + addPlayer()        |           | + checkWinner()       |
    | + removePlayer()     |           | + getBoardCopy()      |
    | + initializeGame()   |           | + resetGame()         |
    | + processMove()      |           | + simulateMove()      |
    | + broadcastToAll()   |           +----------------------+
    +----------------------+

         TicTacToeAI                       BattleshipGame
    +----------------------+           +----------------------+
    | - aiSymbol: char     |           | - playerBoard: Board  |
    | - humanSymbol: char  |           | - opponentBoard: Board|
    | - game: TicTacToeGame|           | - player1: Player     |
    +----------------------+           | - player2: Player     |
    | + getBestMove(): String|         | - currentPlayer: Player|
    | + minimax(): int     |           | - gamePhase: String   |
    | + evaluateBoard(): int|          | - gameEnded: boolean  |
    | + getRandomMove(): String|       | - totalTurns: int     |
    | + getStrategicMove(): String|    +----------------------+
    | + findWinningMove(): String|     | + setPlayers()        |
    +----------------------+           | + makeMove()          |
                                      | + startBattlePhase()  |
                                      | + autoSetupShips()    |
                                      | + resetGame()         |
                                      +----------------------+

              Ship                           Board
    +----------------------+           +----------------------+
    | - size: int          |           | - grid: char[][]      |
    | - name: String       |           | - enemyView: char[][] |
    | - startRow: int      |           | - ships: Ship[]       |
    | - startCol: int      |           | - shots: List<String> |
    | - isHorizontal: boolean|         | - hits: List<String>  |
    | - isPlaced: boolean  |           | - misses: List<String>|
    +----------------------+           +----------------------+
    | + place()            |           | + placeShip()         |
    | + occupiesPosition() |           | + removeShip()        |
    | + hit()              |           | + receiveShot()       |
    | + isSunk()           |           | + recordShot()        |
    | + getPositions()     |           | + allShipsSunk()      |
    | + overlapsWith()     |           | + autoPlaceShips()    |
    | + rotate()           |           | + getValidTargets()   |
    | + createStandardFleet()|         | + reset()             |
    +----------------------+           +----------------------+

        MainApplication                    MenuController
    +----------------------+           +----------------------+
    | - primaryStage: Stage|           | - serverAddressField: TextField|
    +----------------------+           | - playerNameField: TextField|
    | + start()            |           | - connectButton: Button|
    | + changeScene()      |           | - connectionStatusLabel: Label|
    | + showErrorAlert()   |           | - isConnected: boolean |
    | + showInfoAlert()    |           +----------------------+
    | + main()             |           | + connectToServer()   |
    +----------------------+           | + playTicTacToeVsAI() |
                                      | + playTicTacToeVsHuman()|
                                      | + playBattleshipVsAI() |
                                      | + playBattleshipVsHuman()|
                                      | + exitApplication()   |
                                      +----------------------+
```

## 2. Diagrama de Secuencia - Conexión de Cliente

```
Cliente          MainApplication    MenuController    GameServer    ClientHandler
  |                     |                |              |              |
  |--start app--------->|                |              |              |
  |                     |--load FXML---->|              |              |
  |                     |                |--initialize->|              |
  |                     |                |              |              |
  |--click "Conectar"-->|                |              |              |
  |                     |                |--connectToServer()          |
  |                     |                |              |              |
  |                     |                |--TCP connect------------>    |
  |                     |                |              |--accept----->|
  |                     |                |              |              |--new thread
  |                     |                |              |<-register----|
  |                     |                |<-confirmation message-------|
  |                     |                |              |              |
  |                     |                |--update UI---|              |
  |<--"Conectado"-------|                |              |              |
```

## 3. Diagrama de Secuencia - Juego Tic-Tac-Toe vs IA

```
Cliente     MenuController    TicTacToeGame    TicTacToeAI    UI
  |              |                 |              |         |
  |--select "vs IA"->              |              |         |
  |              |--create game--->|              |         |
  |              |                 |--setPlayers->|         |
  |              |                 |              |         |
  |              |--load UI-------------------------->      |
  |<--show board-|                 |              |         |
  |              |                 |              |         |
  |--click cell->|                 |              |         |
  |              |--makeMove()---->|              |         |
  |              |                 |--validate--->|         |
  |              |                 |--update board|         |
  |              |                 |--checkWinner->|        |
  |              |                 |              |         |
  |              |                 |--getBestMove()-------->|
  |              |                 |              |--minimax
  |              |                 |<-return move-|         |
  |              |                 |--makeMove()->|         |
  |              |                 |--update board|         |
  |              |<--update UI-----|              |         |
  |<--refresh----|                 |              |         |
```

## 4. Diagrama de Secuencia - Batalla Naval Multijugador

```
Cliente1    Cliente2    GameServer    GameRoom    BattleshipGame
   |          |            |           |             |
   |--join game->          |           |             |
   |          |--join game->           |             |
   |          |            |--createRoom()           |
   |          |            |           |--new game-->|
   |          |            |<-room created-          |
   |<-room joined-         |           |             |
   |          |<-room joined-          |             |
   |          |            |           |             |
   |--place ships--------->|           |             |
   |          |            |--processMove()--------->|
   |          |--place ships---------->|             |
   |          |            |--processMove()--------->|
   |          |            |           |--startBattle()
   |          |            |           |             |
   |--shoot-->|            |           |             |
   |          |            |--processMove()--------->|
   |          |            |           |--receiveShot()
   |          |            |<-result---|             |
   |          |<-shot result-          |             |
   |<-opponent shot result-            |             |
```

## 5. Diagrama de Colaboración - Sistema Completo

```
        [1: start()]
     MainApplication ----------------> MenuController
            |                              |
            | [2: changeScene()]            | [3: connectToServer()]
            |                              |
            v                              v
       JavaFX Stage                   GameServer
            |                              |
            | [4: load FXML]               | [5: registerClient()]
            |                              |
            v                              v
     TicTacToeController              ClientHandler
            |                              |
            | [6: createGame()]            | [7: processMessage()]
            |                              |
            v                              v
      TicTacToeGame -----------------> GameRoom
            |                              |
            | [8: makeMove()]              | [9: broadcastToAll()]
            |                              |
            v                              |
       TicTacToeAI                        |
            |                              |
            | [10: getBestMove()]          |
            |                              |
            +<-----------------------------+
```

## 6. Diagrama de Estados - Flujo del Juego

```
                    [Aplicación Iniciada]
                           |
                           v
                    ┌─────────────┐
                    │   MENÚ      │
                    │ PRINCIPAL   │
                    └─────────────┘
                           |
                    [Seleccionar Juego]
                           |
                           v
                    ┌─────────────┐      [Configurar]
                    │ CONFIGURAR  │<────────────────┐
                    │  CONEXIÓN   │                 │
                    └─────────────┘                 │
                           |                        │
                    [Conectar OK]                   │
                           |                        │
                           v                        │
                    ┌─────────────┐      [Error]   │
                    │ SELECCIONAR │─────────────────┘
                    │    JUEGO    │
                    └─────────────┘
                           |
              ┌────────────┼────────────┐
              │            │            │
              v            v            v
      ┌─────────────┐ ┌─────────────┐ ┌─────────────┐
      │ TIC-TAC-TOE │ │   BATALLA   │ │   SALIR     │
      │    vs IA    │ │ NAVAL vs IA │ │             │
      └─────────────┘ └─────────────┘ └─────────────┘
              |            │                   │
              v            v                   v
      ┌─────────────┐ ┌─────────────┐    [Terminar]
      │   JUGAR     │ │   COLOCAR   │
      │ TIC-TAC-TOE │ │   BARCOS    │
      └─────────────┘ └─────────────┘
              |            │
              │            v
              │    ┌─────────────┐
              │    │   BATALLA   │
              │    │   NAVAL     │
              │    └─────────────┘
              │            │
              v            v
      ┌─────────────────────────────┐
      │      RESULTADO FINAL        │
      │   [Ganar/Perder/Empate]     │
      └─────────────────────────────┘
                     |
              [Nueva Partida/Menú]
                     |
                     v
              ┌─────────────┐
              │    MENÚ     │
              │ PRINCIPAL   │
              └─────────────┘
```

---

**Nota**: Estos diagramas UML representan la estructura y flujo del sistema de juegos cliente-servidor. Los diagramas están simplificados para mayor claridad, pero incluyen los componentes y relaciones más importantes del sistema.
