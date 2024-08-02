package com.birdshoe.chess.model;

public class King extends ChessPiece{
    public King(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        return false;
    }
}
