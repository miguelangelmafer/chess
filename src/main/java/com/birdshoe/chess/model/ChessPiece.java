package com.birdshoe.chess.model;

public abstract class ChessPiece {
    private String color;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract String getSymbol();

    public abstract boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board);
}