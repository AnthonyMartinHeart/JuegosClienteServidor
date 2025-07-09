# 🎯 Casos de Uso - Juegos Cliente-Servidor

## 1. Diagrama de Casos de Uso General

```
                    Sistema Juegos Cliente-Servidor
    
    Actor: Jugador                                Actor: Servidor
         |                                              |
         |                                              |
    +----v----+                                   +----v----+
    |         |                                   |         |
    | Jugador |                                   | Servidor|
    |         |                                   |         |
    +----+----+                                   +----+----+
         |                                              |
         |                                              |
         +-- Conectar al Servidor ----+                 |
         |                           |                 |
         +-- Seleccionar Juego ------+                 |
         |                           |                 |
         +-- Jugar Tic-Tac-Toe ------+                 |
         |                           |                 |
         +-- Jugar Batalla Naval ----+-- Gestionar --> |
         |                           |   Partidas      |
         +-- Realizar Movimiento ----+                 |
         |                           |                 |
         +-- Ver Estado del Juego ---+                 |
         |                           |                 |
         +-- Desconectarse ----------+                 |

    Actor: IA
         |
    +----v----+
    |         |
    |   IA    |
    |         |
    +----+----+
         |
         +-- Calcular Movimiento
         |
         +-- Ejecutar Estrategia
```

## 2. Especificación Detallada de Casos de Uso

### CU01: Conectar al Servidor

**Actor Principal**: Jugador  
**Nivel**: Usuario  
**Propósito**: Establecer conexión entre cliente y servidor para poder jugar

#### Flujo Principal
1. El jugador inicia la aplicación cliente
2. El sistema muestra la pantalla de conexión
3. El jugador ingresa la dirección IP del servidor (opcional, default: localhost)
4. El jugador presiona "Conectar"
5. El cliente intenta establecer conexión con el servidor
6. El servidor acepta la conexión
7. El sistema muestra el menú principal de juegos

#### Flujos Alternativos
**3a. Usar configuración por defecto**
- 3a.1. El jugador no modifica la IP (usa localhost por defecto)
- 3a.2. Continúa en paso 4

**6a. Error de conexión**
- 6a.1. El servidor no está disponible
- 6a.2. El sistema muestra mensaje de error
- 6a.3. Retorna al paso 3

#### Precondiciones
- El servidor debe estar ejecutándose
- El puerto de comunicación debe estar disponible

#### Postcondiciones
- El cliente está conectado al servidor
- El cliente puede seleccionar juegos

---

### CU02: Seleccionar Juego

**Actor Principal**: Jugador  
**Nivel**: Usuario  
**Propósito**: Permitir al jugador elegir entre Tic-Tac-Toe y Batalla Naval

#### Flujo Principal
1. El sistema muestra el menú principal con opciones de juego
2. El jugador selecciona "Tic-Tac-Toe" o "Batalla Naval"
3. El sistema muestra las opciones de modo (vs Humano / vs IA)
4. El jugador selecciona el modo deseado
5. El sistema configura el juego según la selección
6. El sistema inicia la interfaz del juego correspondiente

#### Flujos Alternativos
**2a. Seleccionar Tic-Tac-Toe**
- 2a.1. El sistema prepara la lógica de Tic-Tac-Toe
- 2a.2. Continúa en paso 3

**2b. Seleccionar Batalla Naval**
- 2b.1. El sistema prepara la lógica de Batalla Naval
- 2b.2. Continúa en paso 3

**4a. Modo vs Humano**
- 4a.1. El sistema busca otro jugador o crea sala de espera
- 4a.2. Continúa en paso 5

**4b. Modo vs IA**
- 4b.1. El sistema inicializa la IA correspondiente
- 4b.2. Continúa en paso 5

#### Precondiciones
- Cliente conectado al servidor
- Servidor funcionando correctamente

#### Postcondiciones
- Juego seleccionado y configurado
- Interfaz de juego cargada

---

### CU03: Jugar Tic-Tac-Toe vs Humano

**Actor Principal**: Jugador  
**Actores Secundarios**: Servidor, Otro Jugador  
**Nivel**: Usuario  
**Propósito**: Permitir una partida de Tic-Tac-Toe entre dos jugadores humanos

#### Flujo Principal
1. El servidor asigna X y O a los jugadores
2. El sistema muestra el tablero 3x3 vacío
3. El jugador con X (primer turno) hace clic en una casilla libre
4. El sistema valida el movimiento
5. El servidor actualiza el estado del juego
6. El sistema actualiza la vista de ambos clientes
7. El sistema verifica si hay ganador o empate
8. Si no hay ganador, cambia el turno al otro jugador
9. Repite desde paso 3 hasta que termine el juego
10. El sistema muestra el resultado final

#### Flujos Alternativos
**3a. Casilla ocupada**
- 3a.1. El sistema muestra mensaje de error
- 3a.2. El jugador debe seleccionar otra casilla
- 3a.3. Retorna al paso 3

**7a. Hay ganador**
- 7a.1. El sistema detecta 3 en línea
- 7a.2. El sistema anuncia al ganador
- 7a.3. La partida termina

**7b. Empate**
- 7b.1. Todas las casillas están llenas sin ganador
- 7b.2. El sistema anuncia empate
- 7b.3. La partida termina

**6a. Desconexión de jugador**
- 6a.1. Un jugador se desconecta
- 6a.2. El sistema notifica al otro jugador
- 6a.3. La partida se cancela

#### Precondiciones
- Dos jugadores conectados
- Juego Tic-Tac-Toe seleccionado
- Modo vs Humano activo

#### Postcondiciones
- Partida completada con resultado
- Jugadores pueden iniciar nueva partida

---

### CU04: Jugar Tic-Tac-Toe vs IA

**Actor Principal**: Jugador  
**Actores Secundarios**: IA del sistema  
**Nivel**: Usuario  
**Propósito**: Permitir una partida de Tic-Tac-Toe contra la IA

#### Flujo Principal
1. El sistema asigna X al jugador y O a la IA
2. El sistema muestra el tablero 3x3 vacío
3. El jugador hace clic en una casilla libre
4. El sistema valida el movimiento del jugador
5. El sistema actualiza el tablero
6. El sistema verifica si hay ganador
7. Si no hay ganador, la IA calcula su movimiento usando Minimax
8. La IA ejecuta su movimiento
9. El sistema actualiza el tablero
10. El sistema verifica si hay ganador
11. Si no hay ganador, retorna al paso 3
12. El sistema muestra el resultado final

#### Flujos Alternativos
**3a. Casilla ocupada**
- 3a.1. El sistema muestra mensaje de error
- 3a.2. El jugador debe seleccionar otra casilla
- 3a.3. Retorna al paso 3

**6a. Jugador gana**
- 6a.1. El sistema detecta victoria del jugador
- 6a.2. El sistema anuncia al ganador
- 6a.3. La partida termina

**10a. IA gana**
- 10a.1. El sistema detecta victoria de la IA
- 10a.2. El sistema anuncia a la IA ganadora
- 10a.3. La partida termina

**11a. Empate**
- 11a.1. Tablero lleno sin ganador
- 11a.2. El sistema anuncia empate
- 11a.3. La partida termina

#### Precondiciones
- Jugador conectado
- Juego Tic-Tac-Toe seleccionado
- Modo vs IA activo
- IA inicializada

#### Postcondiciones
- Partida completada con resultado
- Jugador puede iniciar nueva partida

---

### CU05: Jugar Batalla Naval vs Humano

**Actor Principal**: Jugador  
**Actores Secundarios**: Servidor, Otro Jugador  
**Nivel**: Usuario  
**Propósito**: Permitir una partida de Batalla Naval entre dos jugadores

#### Flujo Principal

**Fase de Preparación:**
1. El sistema muestra el tablero 10x10 para colocación de barcos
2. El jugador coloca sus 5 barcos en el tablero:
   - Portaaviones (5 casillas)
   - Acorazado (4 casillas)
   - Crucero (3 casillas)
   - Submarino (3 casillas)
   - Destructor (2 casillas)
3. El sistema valida que los barcos no se superpongan
4. El jugador confirma la configuración
5. El sistema espera a que ambos jugadores terminen la preparación

**Fase de Batalla:**
6. El sistema determina quién inicia (aleatorio)
7. El jugador activo hace clic en una casilla del tablero enemigo
8. El sistema procesa el disparo:
   - "Agua" si no hay barco
   - "Tocado" si hay barco pero no está hundido
   - "Hundido" si el barco está completamente destruido
9. El sistema actualiza ambos tableros
10. El sistema verifica si todos los barcos enemigos están hundidos
11. Si no hay ganador, cambia el turno
12. Repite desde paso 7 hasta que termine el juego
13. El sistema anuncia al ganador

#### Flujos Alternativos
**2a. Colocación inválida de barco**
- 2a.1. El barco se superpone con otro o sale del tablero
- 2a.2. El sistema muestra mensaje de error
- 2a.3. El jugador debe recolocar el barco
- 2a.4. Retorna al paso 2

**7a. Disparo a casilla ya atacada**
- 7a.1. El sistema muestra mensaje de error
- 7a.2. El jugador debe seleccionar otra casilla
- 7a.3. Retorna al paso 7

**10a. Todos los barcos hundidos**
- 10a.1. El sistema detecta victoria
- 10a.2. El sistema anuncia al ganador
- 10a.3. La partida termina

#### Precondiciones
- Dos jugadores conectados
- Juego Batalla Naval seleccionado
- Modo vs Humano activo

#### Postcondiciones
- Partida completada con ganador
- Ambos jugadores informados del resultado

---

### CU06: Jugar Batalla Naval vs IA

**Actor Principal**: Jugador  
**Actores Secundarios**: IA del sistema  
**Nivel**: Usuario  
**Propósito**: Permitir una partida de Batalla Naval contra la IA

#### Flujo Principal

**Fase de Preparación:**
1. El sistema muestra el tablero 10x10 para colocación de barcos
2. El jugador coloca sus 5 barcos manualmente
3. El sistema valida la colocación
4. La IA coloca automáticamente sus barcos de forma aleatoria válida
5. El sistema confirma que ambos están listos

**Fase de Batalla:**
6. El jugador inicia el primer turno
7. El jugador hace clic en una casilla del tablero de la IA
8. El sistema procesa el disparo y muestra resultado
9. El sistema actualiza el tablero
10. El sistema verifica si todos los barcos de la IA están hundidos
11. Si no hay ganador, la IA calcula su disparo estratégico
12. La IA ejecuta su disparo en el tablero del jugador
13. El sistema procesa el disparo de la IA
14. El sistema verifica si todos los barcos del jugador están hundidos
15. Si no hay ganador, retorna al paso 7
16. El sistema anuncia al ganador

#### Flujos Alternativos
**2a. Colocación inválida**
- 2a.1. Similar a CU05:2a
- 2a.2. Retorna al paso 2

**10a. Jugador gana**
- 10a.1. Todos los barcos de la IA hundidos
- 10a.2. El sistema anuncia victoria del jugador
- 10a.3. La partida termina

**14a. IA gana**
- 14a.1. Todos los barcos del jugador hundidos
- 14a.2. El sistema anuncia victoria de la IA
- 14a.3. La partida termina

#### Precondiciones
- Jugador conectado
- Juego Batalla Naval seleccionado
- Modo vs IA activo
- IA inicializada

#### Postcondiciones
- Partida completada con resultado
- Jugador puede iniciar nueva partida

---

### CU07: Gestionar Turnos

**Actor Principal**: Servidor  
**Nivel**: Sistema  
**Propósito**: Controlar y alternar correctamente los turnos entre jugadores

#### Flujo Principal
1. El servidor determina el orden inicial de jugadores
2. El servidor asigna el turno al primer jugador
3. El servidor envía notificación de turno activo al cliente correspondiente
4. El servidor espera movimiento del jugador activo
5. El servidor recibe y valida el movimiento
6. El servidor actualiza el estado del juego
7. El servidor envía actualización a todos los clientes
8. El servidor verifica si el juego ha terminado
9. Si no ha terminado, cambia el turno al siguiente jugador
10. Retorna al paso 3

#### Flujos Alternativos
**5a. Movimiento inválido**
- 5a.1. El servidor rechaza el movimiento
- 5a.2. El servidor notifica error al cliente
- 5a.3. Retorna al paso 4 (mismo turno)

**8a. Juego terminado**
- 8a.1. El servidor detecta condición de fin
- 8a.2. El servidor calcula resultado
- 8a.3. El servidor notifica resultado a clientes
- 8a.4. Caso de uso termina

**4a. Timeout de turno**
- 4a.1. El jugador no responde en tiempo límite
- 4a.2. El servidor fuerza cambio de turno
- 4a.3. Continúa en paso 9

#### Precondiciones
- Al menos un jugador conectado
- Partida iniciada
- Estado del juego válido

#### Postcondiciones
- Turno correctamente asignado
- Clientes notificados del estado actual

---

### CU08: Finalizar Partida

**Actor Principal**: Sistema  
**Nivel**: Sistema  
**Propósito**: Gestionar correctamente el final de una partida

#### Flujo Principal
1. El sistema detecta condición de fin de juego:
   - Victoria de un jugador
   - Empate
   - Desconexión de jugador
2. El sistema calcula el resultado final
3. El sistema actualiza las estadísticas locales
4. El sistema envía resultado a todos los clientes conectados
5. El sistema muestra pantalla de resultado
6. El sistema ofrece opciones al jugador:
   - Jugar otra partida
   - Cambiar de juego
   - Desconectarse
7. El sistema espera selección del jugador
8. El sistema ejecuta la acción seleccionada

#### Flujos Alternativos
**1a. Victoria por abandono**
- 1a.1. Un jugador se desconecta
- 1a.2. El sistema declara ganador al jugador restante
- 1a.3. Continúa en paso 2

**1b. Empate**
- 1b.1. Se alcanza condición de empate
- 1b.2. El sistema registra empate
- 1b.3. Continúa en paso 2

**6a. Jugar otra partida**
- 6a.1. El sistema reinicia el juego actual
- 6a.2. Retorna a caso de uso del juego correspondiente

**6b. Cambiar de juego**
- 6b.1. El sistema retorna al menú de selección
- 6b.2. Ejecuta CU02: Seleccionar Juego

**6c. Desconectarse**
- 6c.1. El sistema cierra la conexión
- 6c.2. El cliente se cierra

#### Precondiciones
- Partida en curso
- Condición de fin detectada

#### Postcondiciones
- Partida finalizada correctamente
- Resultado comunicado a jugadores
- Sistema listo para nueva acción

---

## 3. Matriz de Trazabilidad

| Caso de Uso | Requisitos Relacionados | Prioridad | Actor Principal |
|-------------|------------------------|-----------|-----------------|
| CU01        | RF01                   | Alta      | Jugador         |
| CU02        | RF02, RF03             | Alta      | Jugador         |
| CU03        | RF04, RF08, RF09       | Alta      | Jugador         |
| CU04        | RF04, RF06             | Alta      | Jugador         |
| CU05        | RF05, RF08, RF09       | Alta      | Jugador         |
| CU06        | RF05, RF07             | Alta      | Jugador         |
| CU07        | RF09, RF08             | Media     | Servidor        |
| CU08        | RF10                   | Media     | Sistema         |

---

**Documento preparado por**: [Nombre del Equipo]  
**Fecha**: 01 de Julio, 2025  
**Versión**: 1.0
