package com.birdshoe.chess.model;

public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return getColor().equals("white") ? "Q" : "q";
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

        // Verifica si el movimiento es horizontal, vertical o diagonal
        boolean isHorizontal = startX == endX;
        boolean isVertical = startY == endY;
        boolean isDiagonal = deltaX == deltaY;

        if (!(isHorizontal || isVertical || isDiagonal)) {
            return false;
        }

        // Determina el incremento de pasos para la dirección del movimiento
        int stepX = Integer.compare(endX, startX);
        int stepY = Integer.compare(endY, startY);

        // Verifica si hay piezas en el camino
        int x = startX + stepX;
        int y = startY + stepY;

        while (x != endX || y != endY) {
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
