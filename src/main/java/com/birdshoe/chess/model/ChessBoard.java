package com.birdshoe.chess.model;

public class ChessBoard {
    private ChessPiece[][] board;

    public ChessBoard() {
        board = new ChessPiece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Inicializa las torres en sus posiciones iniciales
        board[0][0] = new Rook("white");
        board[0][7] = new Rook("white");
        board[7][0] = new Rook("black");
        board[7][7] = new Rook("black");

        // Inicializa los caballos en sus posiciones iniciales
        board[0][1] = new Knight("white");
        board[0][6] = new Knight("white");
        board[7][1] = new Knight("black");
        board[7][6] = new Knight("black");

        // Inicializa los alfiles en sus posiciones iniciales
        board[0][2] = new Bishop("white");
        board[0][5] = new Bishop("white");
        board[7][2] = new Bishop("black");
        board[7][5] = new Bishop("black");

        // Inicializa rey y reina en sus posiciones iniciales
        board[0][3] = new Queen("white");
        board[0][4] = new King("white");
        board[7][3] = new Queen("black");
        board[7][4] = new King("black");

        // Inicializa peones en sus posiciones iniciales
        board[1][0] = new Pawn("white");
        board[1][1] = new Pawn("white");
        board[1][2] = new Pawn("white");
        board[1][3] = new Pawn("white");
        board[1][4] = new Pawn("white");
        board[1][5] = new Pawn("white");
        board[1][6] = new Pawn("white");
        board[1][7] = new Pawn("white");
        board[6][0] = new Pawn("black");
        board[6][1] = new Pawn("black");
        board[6][2] = new Pawn("black");
        board[6][3] = new Pawn("black");
        board[6][4] = new Pawn("black");
        board[6][5] = new Pawn("black");
        board[6][6] = new Pawn("black");
        board[6][7] = new Pawn("black");
    }

    public ChessPiece getPieceAt(int x, int y) {
        return board[x][y];
    }

    public void setPieceAt(int x, int y, ChessPiece piece) {
        board[x][y] = piece;
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        ChessPiece piece = getPieceAt(startX, startY);
        if (piece != null && piece.isValidMove(startX, startY, endX, endY,this)) {
            setPieceAt(endX, endY, piece);
            setPieceAt(startX, startY, null);
            return true;
        }
        return false;
    }

    public String printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board[i][j];
                if (piece == null) {
                    sb.append(" . ");
                } else {
                    sb.append(" ").append(piece.getSymbol()).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void printBoardConsole() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board[i][j];
                if (piece == null) {
                    System.out.print(" . ");
                } else {
                    System.out.print(" " + piece.getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }
}
