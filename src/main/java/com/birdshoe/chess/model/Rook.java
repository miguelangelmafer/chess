package com.birdshoe.chess.model;

public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        // Implementar la lógica de movimiento de la torre
        return (startX == endX || startY == endY);
    }
}