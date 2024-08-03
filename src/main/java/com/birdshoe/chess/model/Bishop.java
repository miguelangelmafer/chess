package com.birdshoe.chess.model;

public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return getColor().equals("white") ? "B" : "b";
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        // Verifica que el movimiento sea diagonal
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

        if (deltaX != deltaY) {
            return false;
        }

        // Verifica si hay piezas en el camino
        int stepX = (endX > startX) ? 1 : -1;
        int stepY = (endY > startY) ? 1 : -1;

        int x = startX + stepX;
        int y = startY + stepY;

        while (x != endX && y != endY) {
            if (board.getPieceAt(x, y) != null) {
                return false;
            }
            x += stepX;
            y += stepY;
        }

        // Verifica la casilla de destino
        ChessPiece targetPiece = board.getPieceAt(endX, endY);
        if (targetPiece != null && targetPiece.getColor().equals(this.getColor())) {
            return false;
        }

        return true;
    }
}
