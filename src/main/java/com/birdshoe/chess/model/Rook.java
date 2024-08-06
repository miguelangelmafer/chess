package com.birdshoe.chess.model;

public class Rook extends ChessPiece {
    private boolean hasMoved;

    public Rook(String color) {
        super(color);
        this.hasMoved = false;
    }

    @Override
    public String getSymbol() {
        return getColor().equals("white") ? "R" : "r";
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        if (startX != endX && startY != endY) {
            return false;
        }

        if (startX == endX) {
            int minY = Math.min(startY, endY);
            int maxY = Math.max(startY, endY);
            for (int y = minY + 1; y < maxY; y++) {
                if (board.getPieceAt(startX, y) != null) {
                    return false;
                }
            }
        } else {
            int minX = Math.min(startX, endX);
            int maxX = Math.max(startX, endX);
            for (int x = minX + 1; x < maxX; x++) {
                if (board.getPieceAt(x, startY) != null) {
                    return false;
                }
            }
        }

        ChessPiece targetPiece = board.getPieceAt(endX, endY);
        if (targetPiece != null && targetPiece.getColor().equals(this.getColor())) {
            return false;
        }

        return true;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public boolean hasMoved() {
        return hasMoved;
    }
}
