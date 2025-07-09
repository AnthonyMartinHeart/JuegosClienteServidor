package com.juegos.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana del juego Tic Tac Toe con interfaz Swing
 */
public class TicTacToeWindow extends JFrame {
    
    private JButton[][] buttons;
    private JLabel statusLabel;
    private JLabel playerLabel;
    private boolean isPlayerTurn;
    private char playerSymbol;
    private char[][] board;
    
    public TicTacToeWindow() {
        this.isPlayerTurn = true;
        this.playerSymbol = 'X';
        this.board = new char[3][3];
        
        initializeBoard();
        initializeGUI();
    }
    
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    
    private void initializeGUI() {
        setTitle("Tic Tac Toe - Jugador " + playerSymbol);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Panel de información
        JPanel infoPanel = createInfoPanel();
        mainPanel.add(infoPanel, BorderLayout.NORTH);
        
        // Panel del tablero
        JPanel gamePanel = createGamePanel();
        mainPanel.add(gamePanel, BorderLayout.CENTER);
        
        // Panel de controles
        JPanel controlPanel = createControlPanel();
        mainPanel.add(controlPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBorder(BorderFactory.createTitledBorder("Estado del Juego"));
        
        playerLabel = new JLabel("Eres: " + playerSymbol, JLabel.CENTER);
        playerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(playerLabel);
        
        statusLabel = new JLabel("Tu turno - Haz clic en una casilla", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(statusLabel);
        
        return panel;
    }
    
    private JPanel createGamePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 3, 2, 2));
        panel.setBorder(BorderFactory.createLoweredBevelBorder());
        panel.setBackground(Color.BLACK);
        
        buttons = new JButton[3][3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int row = i;
                final int col = j;
                
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].setPreferredSize(new Dimension(100, 100));
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].setFocusPainted(false);
                
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        makeMove(row, col);
                    }
                });
                
                panel.add(buttons[i][j]);
            }
        }
        
        return panel;
    }
    
    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        
        JButton newGameButton = new JButton("Nuevo Juego");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        
        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        panel.add(newGameButton);
        panel.add(exitButton);
        
        return panel;
    }
    
    private void makeMove(int row, int col) {
        if (!isPlayerTurn) {
            statusLabel.setText("¡Espera tu turno!");
            return;
        }
        
        if (board[row][col] != ' ') {
            statusLabel.setText("¡Esa casilla ya está ocupada!");
            return;
        }
        
        // Hacer el movimiento
        board[row][col] = playerSymbol;
        buttons[row][col].setText(String.valueOf(playerSymbol));
        buttons[row][col].setEnabled(false);
        
        if (playerSymbol == 'X') {
            buttons[row][col].setForeground(Color.BLUE);
        } else {
            buttons[row][col].setForeground(Color.RED);
        }
        
        // Verificar si ganó
        if (checkWinner()) {
            statusLabel.setText("¡Felicidades! ¡Has ganado!");
            disableAllButtons();
            return;
        }
        
        // Verificar empate
        if (isBoardFull()) {
            statusLabel.setText("¡Empate! El tablero está lleno.");
            return;
        }
        
        // Cambiar turno
        isPlayerTurn = false;
        statusLabel.setText("Turno del oponente...");
        
        // En un juego real, aquí enviarías el movimiento al servidor
        // Por ahora, simularemos el movimiento del oponente
        Timer timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeOpponentMove();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    private void makeOpponentMove() {
        // Simular movimiento del oponente (IA simple)
        char opponentSymbol = (playerSymbol == 'X') ? 'O' : 'X';
        
        // Buscar una casilla vacía
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = opponentSymbol;
                    buttons[i][j].setText(String.valueOf(opponentSymbol));
                    buttons[i][j].setEnabled(false);
                    
                    if (opponentSymbol == 'X') {
                        buttons[i][j].setForeground(Color.BLUE);
                    } else {
                        buttons[i][j].setForeground(Color.RED);
                    }
                    
                    // Verificar si el oponente ganó
                    if (checkWinner(opponentSymbol)) {
                        statusLabel.setText("El oponente ha ganado. ¡Mejor suerte la próxima vez!");
                        disableAllButtons();
                        return;
                    }
                    
                    // Verificar empate
                    if (isBoardFull()) {
                        statusLabel.setText("¡Empate! El tablero está lleno.");
                        return;
                    }
                    
                    // Devolver el turno al jugador
                    isPlayerTurn = true;
                    statusLabel.setText("Tu turno - Haz clic en una casilla");
                    return;
                }
            }
        }
    }
    
    private boolean checkWinner() {
        return checkWinner(playerSymbol);
    }
    
    private boolean checkWinner(char symbol) {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }
        
        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) {
                return true;
            }
        }
        
        // Verificar diagonales
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        
        return false;
    }
    
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void disableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
    
    private void resetGame() {
        // Reiniciar el tablero
        initializeBoard();
        
        // Reiniciar botones
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackground(Color.WHITE);
            }
        }
        
        // Reiniciar estado
        isPlayerTurn = true;
        statusLabel.setText("Tu turno - Haz clic en una casilla");
    }
}
