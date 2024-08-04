package com.birdshoe.chess.model;

public class ChessBoard {
    private ChessPiece[][] board;

    public ChessBoard() {
        board = new ChessPiece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Inicializa las torres en sus posiciones iniciales
        String[] colors = {"white", "black"};
        int[] backRow = {0, 7};
        int[] frontRow = {1, 6};

        for (int i = 0; i < 2; i++) {
            String color = colors[i];
            int back = backRow[i];
            int front = frontRow[i];

            // Peones
           for (int j = 0; j < 8; j++) {
                board[front][j] = new Pawn(color);
            }

            // Torres
            board[back][0] = new Rook(color);
            board[back][7] = new Rook(color);

            // Caballos
            board[back][1] = new Knight(color);
            board[back][6] = new Knight(color);

            // Alfiles
            board[back][2] = new Bishop(color);
            board[back][5] = new Bishop(color);

            // Rey y Reina
            board[back][4] = new Queen(color);
            board[back][3] = new King(color);
        }

        board[6][1] = new Pawn("white");
    }

    public ChessPiece getPieceAt(int x, int y) {
        if (x < 0 || x >= 8 || y < 0 || y >= 8) {
            return null;
        }
        return board[x][y];
    }

    public void setPieceAt(int x, int y, ChessPiece piece) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            board[x][y] = piece;
        }
    }

    public String printBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("  a b c d e f g h\n");
        for (int i = 7; i >= 0; i--) {
            sb.append(1 + i).append(" ");
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board[i][j];
                if (piece == null) {
                    sb.append(". ");
                } else {
                    sb.append(piece.getSymbol()).append(" ");
                }
            }
            sb.append(1 + i).append("\n");
        }
        sb.append("  a b c d e f g h\n");
        return sb.toString();
    }

    public void printBoardConsole() {
        System.out.println(printBoard());
    }
}
