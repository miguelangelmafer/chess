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
        // Agrega inicialización de otras piezas aquí
    }

    public ChessPiece getPieceAt(int x, int y) {
        return board[x][y];
    }

    public void setPieceAt(int x, int y, ChessPiece piece) {
        board[x][y] = piece;
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        ChessPiece piece = getPieceAt(startX, startY);
        if (piece != null && piece.isValidMove(startX, startY, endX, endY)) {
            setPieceAt(endX, endY, piece);
            setPieceAt(startX, startY, null);
            return true;
        }
        return false;
    }
}
