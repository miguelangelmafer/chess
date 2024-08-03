package com.birdshoe.chess.model;

public class Knight extends ChessPiece {

    public Knight(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return getColor().equals("white") ? "N": "n";
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

        // El movimiento del caballo es en "L": dos en una dirección y uno en la perpendicular
        if ((deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2)) {
            ChessPiece targetPiece = board.getPieceAt(endX, endY);

            // Si la casilla de destino está vacía o contiene una pieza del oponente, el movimiento es válido
            if (targetPiece == null || !targetPiece.getColor().equals(this.getColor())) {
                return true;
            }
        }

        return false;
    }
}
