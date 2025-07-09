package com.juegos.tictactoe;

import com.juegos.common.GameConstants;

/**
 * Inteligencia Artificial para el juego Tic-Tac-Toe.
 * Implementa el algoritmo Minimax con poda alfa-beta para jugar de manera óptima.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
public class TicTacToeAI {
    
    private final char aiSymbol;     // Símbolo de la IA (O)
    private final char humanSymbol; // Símbolo del humano (X)
    private final TicTacToeGame game;
    
    /**
     * Constructor de la IA.
     * @param game Referencia al juego
     * @param aiSymbol Símbolo que usará la IA
     */
    public TicTacToeAI(TicTacToeGame game, char aiSymbol) {
        this.game = game;
        this.aiSymbol = aiSymbol;
        this.humanSymbol = (aiSymbol == GameConstants.TICTACTOE_X) ? 
                          GameConstants.TICTACTOE_O : GameConstants.TICTACTOE_X;
    }
    
    /**
     * Calcula el mejor movimiento para la IA usando Minimax.
     * @return String con el mejor movimiento en formato "row,col"
     */
    public String getBestMove() {
        char[][] board = game.getBoardCopy();
        int bestScore = Integer.MIN_VALUE;
        String bestMove = null;
        
        // Evaluar todos los movimientos posibles
        for (int i = 0; i < GameConstants.TICTACTOE_BOARD_SIZE; i++) {
            for (int j = 0; j < GameConstants.TICTACTOE_BOARD_SIZE; j++) {
                if (board[i][j] == GameConstants.TICTACTOE_EMPTY) {
                    // Simular movimiento
                    board[i][j] = aiSymbol;
                    
                    // Calcular puntuación con Minimax
                    int score = minimax(board, 0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    
                    // Deshacer movimiento
                    board[i][j] = GameConstants.TICTACTOE_EMPTY;
                    
                    // Si este movimiento es mejor, guardarlo
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = i + "," + j;
                    }
                }
            }
        }
        
        return bestMove;
    }
    
    /**
     * Algoritmo Minimax con poda alfa-beta.
     * @param board Estado actual del tablero
     * @param depth Profundidad de búsqueda
     * @param isMaximizing true si es turno de maximizar (IA)
     * @param alpha Valor alfa para poda
     * @param beta Valor beta para poda
     * @return Puntuación del estado del tablero
     */
    private int minimax(char[][] board, int depth, boolean isMaximizing, int alpha, int beta) {
        // Verificar estado terminal
        int score = evaluateBoard(board);
        
        // Si hay ganador o empate, retornar puntuación
        if (score != 0 || isBoardFull(board)) {
            return score - depth; // Preferir victorias más rápidas
        }
        
        if (isMaximizing) {
            // Turno de la IA (maximizar)
            int maxEval = Integer.MIN_VALUE;
            
            for (int i = 0; i < GameConstants.TICTACTOE_BOARD_SIZE; i++) {
                for (int j = 0; j < GameConstants.TICTACTOE_BOARD_SIZE; j++) {
                    if (board[i][j] == GameConstants.TICTACTOE_EMPTY) {
                        board[i][j] = aiSymbol;
                        int eval = minimax(board, depth + 1, false, alpha, beta);
                        board[i][j] = GameConstants.TICTACTOE_EMPTY;
                        
                        maxEval = Math.max(maxEval, eval);
                        alpha = Math.max(alpha, eval);
                        
                        // Poda beta
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
                // Poda beta en bucle exterior
                if (beta <= alpha) {
                    break;
                }
            }
            return maxEval;
            
        } else {
            // Turno del humano (minimizar)
            int minEval = Integer.MAX_VALUE;
            
            for (int i = 0; i < GameConstants.TICTACTOE_BOARD_SIZE; i++) {
                for (int j = 0; j < GameConstants.TICTACTOE_BOARD_SIZE; j++) {
                    if (board[i][j] == GameConstants.TICTACTOE_EMPTY) {
                        board[i][j] = humanSymbol;
                        int eval = minimax(board, depth + 1, true, alpha, beta);
                        board[i][j] = GameConstants.TICTACTOE_EMPTY;
                        
                        minEval = Math.min(minEval, eval);
                        beta = Math.min(beta, eval);
                        
                        // Poda alfa
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
                // Poda alfa en bucle exterior
                if (beta <= alpha) {
                    break;
                }
            }
            return minEval;
        }
    }
    
    /**
     * Evalúa el estado actual del tablero.
     * @param board Estado del tablero
     * @return Puntuación: +10 si gana IA, -10 si gana humano, 0 si empate/continúa
     */
    private int evaluateBoard(char[][] board) {
        // Verificar si la IA gana
        if (game.checkWinnerInBoard(board, aiSymbol)) {
            return 10;
        }
        
        // Verificar si el humano gana
        if (game.checkWinnerInBoard(board, humanSymbol)) {
            return -10;
        }
        
        // No hay ganador aún
        return 0;
    }
    
    /**
     * Verifica si el tablero está lleno.
     * @param board Estado del tablero
     * @return true si está lleno
     */
    private boolean isBoardFull(char[][] board) {
        for (int i = 0; i < GameConstants.TICTACTOE_BOARD_SIZE; i++) {
            for (int j = 0; j < GameConstants.TICTACTOE_BOARD_SIZE; j++) {
                if (board[i][j] == GameConstants.TICTACTOE_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Obtiene un movimiento aleatorio válido (para modo fácil).
     * @return String con movimiento aleatorio
     */
    public String getRandomMove() {
        String[] emptyPositions = game.getEmptyPositions();
        if (emptyPositions.length > 0) {
            int randomIndex = (int) (Math.random() * emptyPositions.length);
            return emptyPositions[randomIndex];
        }
        return null;
    }
    
    /**
     * Obtiene un movimiento estratégico pero no perfecto (modo medio).
     * Combina estrategia básica con algunas decisiones aleatorias.
     * @return String con movimiento estratégico
     */
    public String getStrategicMove() {
        char[][] board = game.getBoardCopy();
        
        // 1. Verificar si puede ganar en el siguiente movimiento
        String winningMove = findWinningMove(board, aiSymbol);
        if (winningMove != null) {
            return winningMove;
        }
        
        // 2. Verificar si debe bloquear al oponente
        String blockingMove = findWinningMove(board, humanSymbol);
        if (blockingMove != null) {
            return blockingMove;
        }
        
        // 3. Tomar el centro si está disponible
        if (board[1][1] == GameConstants.TICTACTOE_EMPTY) {
            return "1,1";
        }
        
        // 4. Tomar una esquina si está disponible
        int[][] corners = {{0,0}, {0,2}, {2,0}, {2,2}};
        for (int[] corner : corners) {
            if (board[corner[0]][corner[1]] == GameConstants.TICTACTOE_EMPTY) {
                return corner[0] + "," + corner[1];
            }
        }
        
        // 5. Movimiento aleatorio
        return getRandomMove();
    }
    
    /**
     * Busca un movimiento que resulte en victoria inmediata.
     * @param board Estado del tablero
     * @param symbol Símbolo a verificar
     * @return Movimiento ganador o null si no existe
     */
    private String findWinningMove(char[][] board, char symbol) {
        for (int i = 0; i < GameConstants.TICTACTOE_BOARD_SIZE; i++) {
            for (int j = 0; j < GameConstants.TICTACTOE_BOARD_SIZE; j++) {
                if (board[i][j] == GameConstants.TICTACTOE_EMPTY) {
                    // Simular movimiento
                    board[i][j] = symbol;
                    
                    // Verificar si gana
                    if (game.checkWinnerInBoard(board, symbol)) {
                        board[i][j] = GameConstants.TICTACTOE_EMPTY; // Deshacer
                        return i + "," + j;
                    }
                    
                    // Deshacer movimiento
                    board[i][j] = GameConstants.TICTACTOE_EMPTY;
                }
            }
        }
        return null;
    }
    
    /**
     * Obtiene un movimiento según el nivel de dificultad.
     * @param difficulty Nivel de dificultad (1=fácil, 2=medio, 3=difícil)
     * @return String con el movimiento
     */
    public String getMove(int difficulty) {
        switch (difficulty) {
            case 1:
                return getRandomMove();
            case 2:
                return getStrategicMove();
            case 3:
            default:
                return getBestMove();
        }
    }
    
    /**
     * Simula el pensamiento de la IA (delay para realismo).
     * @param callback Callback que recibe el movimiento
     */
    public void getMoveAsync(java.util.function.Consumer<String> callback) {
        new Thread(() -> {
            try {
                // Simular tiempo de pensamiento
                Thread.sleep(GameConstants.AI_THINKING_DELAY);
                String move = getBestMove();
                callback.accept(move);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
