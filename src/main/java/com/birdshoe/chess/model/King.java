package com.birdshoe.chess.model;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return getColor().equals("white") ? "K" : "k";
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        // Movimiento básico del rey: un cuadrado en cualquier dirección
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

        // El rey solo puede moverse un cuadrado en cualquier dirección
        if (deltaX <= 1 && deltaY <= 1) {
            ChessPiece targetPiece = board.getPieceAt(endX, endY);

            // Si la casilla de destino está vacía o contiene una pieza del oponente, el movimiento es válido
            if (targetPiece == null || !targetPiece.getColor().equals(this.getColor())) {
                return true;
            }
        }

        return false;
    }
}
