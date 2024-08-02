package com.birdshoe.chess.model;

public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        return false;
    }
}
