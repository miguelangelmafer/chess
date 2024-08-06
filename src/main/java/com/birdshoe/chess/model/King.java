package com.birdshoe.chess.model;

public class King extends ChessPiece {
    private boolean hasMoved;

    public King(String color) {
        super(color);
        this.hasMoved = false;
    }

    @Override
    public String getSymbol() {
        return getColor().equals("white") ? "K" : "k";
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

        // Movimiento básico del rey: un cuadrado en cualquier dirección
        if (deltaX <= 1 && deltaY <= 1) {
            ChessPiece targetPiece = board.getPieceAt(endX, endY);
            if (targetPiece == null || !targetPiece.getColor().equals(this.getColor())) {
                return true;
            }
        }

        // Lógica de enroque
        if (!hasMoved && deltaX == 0 && deltaY == 2) {
            if (isCastlingMove(startX, startY, endX, endY, board)) {
                return true;
            }
        }

        return false;
    }

    private boolean isCastlingMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        if (startY == 4 && (endY == 2 || endY == 6)) {
            // Enroque largo o corto
            int rookY = endY == 2 ? 0 : 7;
            ChessPiece rook = board.getPieceAt(startX, rookY);
            if (rook instanceof Rook && !((Rook) rook).hasMoved()) {
                int direction = endY == 2 ? -1 : 1;
                for (int y = startY + direction; y != rookY; y += direction) {
                    if (board.getPieceAt(startX, y) != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}
