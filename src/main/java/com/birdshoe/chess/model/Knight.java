package com.birdshoe.chess.model;

public class Knight extends ChessPiece{
    public Knight(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        return (startX == endX || startY == endY);
    }
}
