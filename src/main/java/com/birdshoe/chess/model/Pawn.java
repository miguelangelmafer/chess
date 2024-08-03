package com.birdshoe.chess.model;

public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return getColor().equals("white") ? "P" : "p";
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        int direction = getColor().equals("white") ? 1 : -1; // Blancos avanzan, negros retroceden
        int startRow = getColor().equals("white") ? 1 : 6; // Fila inicial de peones

        // Movimiento simple hacia adelante
        if (startX + direction == endX && startY == endY && board.getPieceAt(endX, endY) == null) {
            return true;
        }

        // Primer movimiento doble hacia adelante
        if (startX == startRow && startX + 2 * direction == endX && startY == endY &&
                board.getPieceAt(endX, endY) == null && board.getPieceAt(startX + direction, startY) == null) {
            return true;
        }

        // Captura en diagonal
        if (startX + direction == endX && Math.abs(startY - endY) == 1 && board.getPieceAt(endX, endY) != null &&
                !board.getPieceAt(endX, endY).getColor().equals(this.getColor())) {
            return true;
        }

        return false;
    }
}
