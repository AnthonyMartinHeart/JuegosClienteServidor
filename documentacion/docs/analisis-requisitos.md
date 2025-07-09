# 📋 Análisis de Requisitos - Juegos Cliente-Servidor

## 1. Introducción

Este documento presenta el análisis de requisitos para el desarrollo de dos juegos cliente-servidor: Tic-Tac-Toe (Gato) y Batalla Naval, implementados en Java con JavaFX.

## 2. Objetivos del Sistema

### 2.1 Objetivo General
Desarrollar una aplicación de juegos cliente-servidor que permita a los usuarios jugar Tic-Tac-Toe y Batalla Naval tanto contra otros jugadores humanos a través de la red como contra oponentes controlados por inteligencia artificial.

### 2.2 Objetivos Específicos
- Implementar una arquitectura cliente-servidor robusta para comunicación en red
- Desarrollar interfaces gráficas atractivas y funcionales usando JavaFX
- Crear algoritmos de IA inteligentes para ambos juegos
- Garantizar la sincronización de estados entre cliente y servidor
- Proporcionar una experiencia de usuario fluida y responsive

## 3. Alcance del Sistema

### 3.1 Funcionalidades Incluidas
- ✅ Juego Tic-Tac-Toe multijugador y vs IA
- ✅ Juego Batalla Naval multijugador y vs IA
- ✅ Servidor de juegos multicliente
- ✅ Cliente con interfaz gráfica JavaFX
- ✅ Sistema de salas de juego
- ✅ IA con diferentes niveles de dificultad

### 3.2 Funcionalidades No Incluidas
- ❌ Persistencia de datos (base de datos)
- ❌ Sistema de ranking o puntuaciones
- ❌ Chat entre jugadores
- ❌ Autenticación de usuarios
- ❌ Configuración de servidores remotos

## 4. Requisitos Funcionales

### RF01 - Gestión de Conexiones
**Descripción**: El sistema debe permitir que múltiples clientes se conecten al servidor de forma simultánea.
- **Prioridad**: Alta
- **Entrada**: Solicitud de conexión del cliente
- **Salida**: Confirmación de conexión exitosa
- **Precondiciones**: Servidor activo y puerto disponible
- **Postcondiciones**: Cliente conectado y listo para jugar

### RF02 - Selección de Juego
**Descripción**: El cliente debe permitir al usuario seleccionar entre Tic-Tac-Toe y Batalla Naval.
- **Prioridad**: Alta
- **Entrada**: Selección del usuario en el menú
- **Salida**: Interfaz del juego seleccionado
- **Precondiciones**: Cliente conectado al servidor
- **Postcondiciones**: Juego iniciado

### RF03 - Modo de Juego
**Descripción**: Cada juego debe ofrecer dos modos: vs Humano (red) y vs IA.
- **Prioridad**: Alta
- **Entrada**: Selección de modo por el usuario
- **Salida**: Configuración del oponente correspondiente
- **Precondiciones**: Juego seleccionado
- **Postcondiciones**: Partida configurada según el modo

### RF04 - Juego Tic-Tac-Toe
**Descripción**: Implementar la lógica completa del juego Tic-Tac-Toe.
- **Prioridad**: Alta
- **Entrada**: Movimientos de los jugadores
- **Salida**: Estado actualizado del tablero
- **Precondiciones**: Partida iniciada
- **Postcondiciones**: Juego finalizado con resultado

### RF05 - Juego Batalla Naval
**Descripción**: Implementar la lógica completa del juego Batalla Naval.
- **Prioridad**: Alta
- **Entrada**: Colocación de barcos y disparos
- **Salida**: Estado de los tableros y resultados
- **Precondiciones**: Partida iniciada
- **Postcondiciones**: Todos los barcos hundidos

### RF06 - IA para Tic-Tac-Toe
**Descripción**: Implementar un algoritmo de IA inteligente usando Minimax.
- **Prioridad**: Alta
- **Entrada**: Estado actual del tablero
- **Salida**: Movimiento óptimo de la IA
- **Precondiciones**: Turno de la IA
- **Postcondiciones**: Movimiento ejecutado

### RF07 - IA para Batalla Naval
**Descripción**: Implementar un algoritmo de IA estratégico para Batalla Naval.
- **Prioridad**: Alta
- **Entrada**: Historial de disparos y resultados
- **Salida**: Coordenadas de disparo estratégico
- **Precondiciones**: Turno de la IA
- **Postcondiciones**: Disparo ejecutado

### RF08 - Sincronización de Estados
**Descripción**: Mantener sincronizados los estados del juego entre cliente y servidor.
- **Prioridad**: Alta
- **Entrada**: Cambios de estado del juego
- **Salida**: Actualización en todos los clientes
- **Precondiciones**: Clientes conectados
- **Postcondiciones**: Estados sincronizados

### RF09 - Gestión de Turnos
**Descripción**: Controlar y alternar los turnos entre jugadores.
- **Prioridad**: Alta
- **Entrada**: Fin de movimiento del jugador actual
- **Salida**: Activación del turno del siguiente jugador
- **Precondiciones**: Partida en curso
- **Postcondiciones**: Turno correctamente asignado

### RF10 - Detección de Victoria/Derrota
**Descripción**: Detectar automáticamente las condiciones de victoria para cada juego.
- **Prioridad**: Alta
- **Entrada**: Estado actual del juego
- **Salida**: Resultado de la partida
- **Precondiciones**: Jugada realizada
- **Postcondiciones**: Partida finalizada si hay ganador

## 5. Requisitos No Funcionales

### RNF01 - Rendimiento
**Descripción**: El sistema debe responder a las acciones del usuario en menos de 500ms.
- **Prioridad**: Media
- **Métrica**: Tiempo de respuesta < 500ms

### RNF02 - Usabilidad
**Descripción**: La interfaz debe ser intuitiva y fácil de usar para usuarios de cualquier edad.
- **Prioridad**: Alta
- **Métrica**: Usuario puede aprender el sistema en < 5 minutos

### RNF03 - Confiabilidad
**Descripción**: El sistema debe mantener la integridad de los datos del juego.
- **Prioridad**: Alta
- **Métrica**: 0% de pérdida de datos durante las partidas

### RNF04 - Disponibilidad
**Descripción**: El servidor debe estar disponible 99% del tiempo durante las pruebas.
- **Prioridad**: Media
- **Métrica**: Uptime > 99%

### RNF05 - Escalabilidad
**Descripción**: El servidor debe soportar al menos 10 partidas simultáneas.
- **Prioridad**: Media
- **Métrica**: Soporte para 10+ partidas concurrentes

### RNF06 - Portabilidad
**Descripción**: El sistema debe ejecutarse en Windows, Linux y macOS.
- **Prioridad**: Media
- **Métrica**: Funciona en 3+ sistemas operativos

### RNF07 - Mantenibilidad
**Descripción**: El código debe seguir buenas prácticas y estar bien documentado.
- **Prioridad**: Alta
- **Métrica**: Cobertura de documentación > 80%

### RNF08 - Seguridad
**Descripción**: Las comunicaciones entre cliente y servidor deben ser seguras.
- **Prioridad**: Baja
- **Métrica**: Validación de entrada en 100% de endpoints

## 6. Restricciones

### 6.1 Restricciones Técnicas
- **Lenguaje**: Java 17 o superior
- **Framework GUI**: JavaFX
- **Protocolo de red**: TCP/IP
- **Arquitectura**: Cliente-Servidor

### 6.2 Restricciones de Tiempo
- **Entrega 1**: 09 de Julio, 2025 (Análisis y Diseño)
- **Entrega 2**: 23 de Julio, 2025 (50% Implementación)
- **Entrega Final**: 04 de Agosto, 2025 (100% Implementación)

### 6.3 Restricciones de Recursos
- **Equipo**: Máximo 2 desarrolladores
- **Hardware**: PC estándar para desarrollo
- **Software**: Herramientas gratuitas/open source

## 7. Supuestos y Dependencias

### 7.1 Supuestos
- Los usuarios tienen conocimientos básicos de los juegos
- La red local es estable durante las partidas
- Los usuarios tienen Java instalado en sus sistemas

### 7.2 Dependencias
- JavaFX SDK disponible
- JVM compatible con Java 17+
- Conectividad de red entre cliente y servidor

## 8. Actores del Sistema

### 8.1 Jugador Humano
- **Descripción**: Usuario que utiliza el cliente para jugar
- **Responsabilidades**: 
  - Realizar movimientos en los juegos
  - Seleccionar modos de juego
  - Conectarse al servidor

### 8.2 Servidor de Juegos
- **Descripción**: Sistema que gestiona las partidas y comunicaciones
- **Responsabilidades**:
  - Aceptar conexiones de clientes
  - Gestionar salas de juego
  - Sincronizar estados
  - Validar movimientos

### 8.3 Inteligencia Artificial
- **Descripción**: Oponente virtual para modo single-player
- **Responsabilidades**:
  - Realizar movimientos estratégicos
  - Adaptarse al nivel del jugador
  - Responder en tiempo razonable

## 9. Casos de Uso Principales

1. **CU01**: Conectar al Servidor
2. **CU02**: Seleccionar Juego
3. **CU03**: Jugar Tic-Tac-Toe vs Humano
4. **CU04**: Jugar Tic-Tac-Toe vs IA
5. **CU05**: Jugar Batalla Naval vs Humano
6. **CU06**: Jugar Batalla Naval vs IA
7. **CU07**: Gestionar Turnos
8. **CU08**: Finalizar Partida

## 10. Priorización de Requisitos

### Alta Prioridad (Críticos)
- RF01, RF02, RF03, RF04, RF05
- RNF02, RNF03, RNF07

### Media Prioridad (Importantes)
- RF06, RF07, RF08, RF09
- RNF01, RNF04, RNF05, RNF06

### Baja Prioridad (Deseables)
- RF10
- RNF08

---

**Documento preparado por**: [Nombre del Equipo]  
**Fecha**: 01 de Julio, 2025  
**Versión**: 1.0
