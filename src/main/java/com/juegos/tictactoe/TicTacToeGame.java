package com.juegos.tictactoe;

import com.juegos.common.GameConstants;
import com.juegos.common.Player;

/**
 * Implementa la lógica del juego Tic-Tac-Toe (Gato).
 * Maneja el estado del tablero, validación de movimientos y detección de victoria.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
public class TicTacToeGame {
    
    private char[][] board;
    private Player player1;    // Jugador X
    private Player player2;    // Jugador O (puede ser IA)
    private Player currentPlayer;
    private boolean gameEnded;
    private String winner;
    private int movesCount;
    
    /**
     * Constructor del juego Tic-Tac-Toe.
     */
    public TicTacToeGame() {
        initializeBoard();
        this.gameEnded = false;
        this.winner = null;
        this.movesCount = 0;
    }
    
    /**
     * Inicializa el tablero vacío.
     */
    private void initializeBoard() {
        board = new char[GameConstants.TICTACTOE_BOARD_SIZE][GameConstants.TICTACTOE_BOARD_SIZE];
        for (int i = 0; i < GameConstants.TICTACTOE_BOARD_SIZE; i++) {
            for (int j = 0; j < GameConstants.TICTACTOE_BOARD_SIZE; j++) {
                board[i][j] = GameConstants.TICTACTOE_EMPTY;
            }
        }
    }
    
    /**
     * Configura los jugadores del juego.
     * @param player1 Primer jugador (X)
     * @param player2 Segundo jugador (O)
     */
    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        
        // Asignar símbolos
        player1.setSymbol(String.valueOf(GameConstants.TICTACTOE_X));
        player2.setSymbol(String.valueOf(GameConstants.TICTACTOE_O));
        
        // El jugador X siempre comienza
        this.currentPlayer = player1;
    }
    
    /**
     * Realiza un movimiento en el tablero.
     * @param playerId ID del jugador
     * @param moveData Datos del movimiento (formato: "row,col")
     * @return true si el movimiento es válido
     */
    public boolean makeMove(String playerId, String moveData) {
        if (gameEnded) {
            return false;
        }
        
        // Verificar que es el turno del jugador correcto
        if (!currentPlayer.getId().equals(playerId)) {
            return false;
        }
        
        try {
            // Parsear coordenadas del movimiento
            String[] coords = moveData.split(",");
            int row = Integer.parseInt(coords[0]);
            int col = Integer.parseInt(coords[1]);
            
            // Validar coordenadas
            if (!isValidPosition(row, col)) {
                return false;
            }
            
            // Verificar que la casilla esté vacía
            if (board[row][col] != GameConstants.TICTACTOE_EMPTY) {
                return false;
            }
            
            // Realizar el movimiento
            char symbol = currentPlayer.getSymbol().charAt(0);
            board[row][col] = symbol;
            movesCount++;
            
            // Verificar si hay ganador
            if (checkWinner()) {
                gameEnded = true;
                winner = currentPlayer.getId();
                currentPlayer.incrementWins();
                getOtherPlayer().incrementLosses();
            } else if (movesCount == 9) {
                // Empate
                gameEnded = true;
                winner = "DRAW";
                player1.incrementDraws();
                player2.incrementDraws();
            } else {
                // Cambiar turno
                switchPlayer();
            }
            
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Realiza un movimiento simple en el tablero (para modo local).
     * @param row Fila del movimiento
     * @param col Columna del movimiento
     * @return true si el movimiento es válido
     */
    public boolean makeMove(int row, int col) {
        if (gameEnded) {
            return false;
        }
        
        // Validar coordenadas
        if (!isValidPosition(row, col)) {
            return false;
        }
        
        // Verificar que la casilla esté vacía
        if (board[row][col] != GameConstants.TICTACTOE_EMPTY) {
            return false;
        }
        
        // Determinar el símbolo basado en el número de movimientos
        char symbol = (movesCount % 2 == 0) ? GameConstants.TICTACTOE_X : GameConstants.TICTACTOE_O;
        
        // Realizar el movimiento
        board[row][col] = symbol;
        movesCount++;
        
        // Verificar si hay ganador
        if (checkWinner()) {
            gameEnded = true;
            winner = String.valueOf(symbol);
        } else if (movesCount >= 9) {
            // Tablero lleno, empate
            gameEnded = true;
            winner = "DRAW";
        }
        
        return true;
    }

    /**
     * Valida si una posición está dentro del tablero.
     * @param row Fila
     * @param col Columna
     * @return true si es válida
     */
    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < GameConstants.TICTACTOE_BOARD_SIZE && 
               col >= 0 && col < GameConstants.TICTACTOE_BOARD_SIZE;
    }
    
    /**
     * Cambia al siguiente jugador.
     */
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
    
    /**
     * Obtiene el otro jugador (no el actual).
     * @return El otro jugador
     */
    private Player getOtherPlayer() {
        return (currentPlayer == player1) ? player2 : player1;
    }
    
    /**
     * Verifica si hay un ganador.
     * @return true si hay ganador
     */
    private boolean checkWinner() {
        char symbol = currentPlayer.getSymbol().charAt(0);
        
        // Verificar filas
        for (int i = 0; i < GameConstants.TICTACTOE_BOARD_SIZE; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }
        
        // Verificar columnas
        for (int j = 0; j < GameConstants.TICTACTOE_BOARD_SIZE; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) {
                return true;
            }
        }
        
        // Verificar diagonal principal
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        
        // Verificar diagonal secundaria
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Verifica el estado final del juego.
     * @return Estado del juego o null si continúa
     */
    public String checkGameEnd() {
        if (gameEnded) {
            if ("DRAW".equals(winner)) {
                return GameConstants.RESULT_DRAW;
            } else {
                return GameConstants.RESULT_WIN + ":" + winner;
            }
        }
        return null;
    }
    
    /**
     * Obtiene una copia del tablero actual.
     * @return Copia del tablero
     */
    public char[][] getBoardCopy() {
        char[][] copy = new char[GameConstants.TICTACTOE_BOARD_SIZE][GameConstants.TICTACTOE_BOARD_SIZE];
        for (int i = 0; i < GameConstants.TICTACTOE_BOARD_SIZE; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, GameConstants.TICTACTOE_BOARD_SIZE);
        }
        return copy;
    }
    
    /**
     * Obtiene el valor de una casilla específica.
     * @param row Fila
     * @param col Columna
     * @return Carácter en la posición
     */
    public char getCellValue(int row, int col) {
        if (isValidPosition(row, col)) {
            return board[row][col];
        }
        return GameConstants.TICTACTOE_EMPTY;
    }
    
    /**
     * Verifica si una casilla está vacía.
     * @param row Fila
     * @param col Columna
     * @return true si está vacía
     */
    public boolean isCellEmpty(int row, int col) {
        return isValidPosition(row, col) && board[row][col] == GameConstants.TICTACTOE_EMPTY;
    }
    
    /**
     * Obtiene todas las posiciones vacías del tablero.
     * @return Array de posiciones vacías como strings "row,col"
     */
    public String[] getEmptyPositions() {
        java.util.List<String> empty = new java.util.ArrayList<>();
        for (int i = 0; i < GameConstants.TICTACTOE_BOARD_SIZE; i++) {
            for (int j = 0; j < GameConstants.TICTACTOE_BOARD_SIZE; j++) {
                if (board[i][j] == GameConstants.TICTACTOE_EMPTY) {
                    empty.add(i + "," + j);
                }
            }
        }
        return empty.toArray(new String[0]);
    }
    
    /**
     * Reinicia el juego para una nueva partida.
     */
    public void resetGame() {
        initializeBoard();
        gameEnded = false;
        winner = null;
        movesCount = 0;
        currentPlayer = player1; // X siempre comienza
    }
    
    /**
     * Simula un movimiento sin modificar el tablero (para IA).
     * @param row Fila
     * @param col Columna
     * @param symbol Símbolo a colocar
     * @return Tablero después del movimiento simulado
     */
    public char[][] simulateMove(int row, int col, char symbol) {
        char[][] simulated = getBoardCopy();
        if (isValidPosition(row, col) && simulated[row][col] == GameConstants.TICTACTOE_EMPTY) {
            simulated[row][col] = symbol;
        }
        return simulated;
    }
    
    /**
     * Verifica ganador en un tablero dado.
     * @param testBoard Tablero a verificar
     * @param symbol Símbolo a verificar
     * @return true si el símbolo gana en ese tablero
     */
    public boolean checkWinnerInBoard(char[][] testBoard, char symbol) {
        // Verificar filas
        for (int i = 0; i < GameConstants.TICTACTOE_BOARD_SIZE; i++) {
            if (testBoard[i][0] == symbol && testBoard[i][1] == symbol && testBoard[i][2] == symbol) {
                return true;
            }
        }
        
        // Verificar columnas
        for (int j = 0; j < GameConstants.TICTACTOE_BOARD_SIZE; j++) {
            if (testBoard[0][j] == symbol && testBoard[1][j] == symbol && testBoard[2][j] == symbol) {
                return true;
            }
        }
        
        // Verificar diagonales
        if (testBoard[0][0] == symbol && testBoard[1][1] == symbol && testBoard[2][2] == symbol) {
            return true;
        }
        
        if (testBoard[0][2] == symbol && testBoard[1][1] == symbol && testBoard[2][0] == symbol) {
            return true;
        }
        
        return false;
    }
    
    // Getters
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public Player getPlayer1() {
        return player1;
    }
    
    public Player getPlayer2() {
        return player2;
    }
    
    public boolean isGameEnded() {
        return gameEnded;
    }
    
    public String getWinner() {
        return winner;
    }
    
    public int getMovesCount() {
        return movesCount;
    }
    
    public char[][] getBoard() {
        return board;
    }
    
    /**
     * Representa el tablero como string para debugging.
     * @return Representación string del tablero
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TicTacToe Board:\n");
        for (int i = 0; i < GameConstants.TICTACTOE_BOARD_SIZE; i++) {
            for (int j = 0; j < GameConstants.TICTACTOE_BOARD_SIZE; j++) {
                char cell = board[i][j];
                sb.append(cell == GameConstants.TICTACTOE_EMPTY ? "." : cell);
                if (j < GameConstants.TICTACTOE_BOARD_SIZE - 1) sb.append("|");
            }
            sb.append("\n");
            if (i < GameConstants.TICTACTOE_BOARD_SIZE - 1) sb.append("-----\n");
        }
        return sb.toString();
    }
    
    /**
     * Obtiene el símbolo del jugador actual para modo local.
     * @return Símbolo del jugador ('X' o 'O')
     */
    public char getCurrentPlayerSymbol() {
        return (movesCount % 2 == 0) ? GameConstants.TICTACTOE_X : GameConstants.TICTACTOE_O;
    }
    
    /**
     * Verifica si el juego ha terminado.
     * @return true si el juego terminó
     */
    public boolean isGameOver() {
        return gameEnded;
    }
}
