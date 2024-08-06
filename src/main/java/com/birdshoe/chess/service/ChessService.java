package com.birdshoe.chess.service;

import com.birdshoe.chess.model.ChessBoard;
import com.birdshoe.chess.model.ChessPiece;
import com.birdshoe.chess.model.King;
import com.birdshoe.chess.model.Pawn;
import com.birdshoe.chess.model.Rook;
import org.springframework.stereotype.Service;

@Service
public class ChessService {
    private ChessBoard board;
    private String currentPlayer;

    public ChessService() {
        board = new ChessBoard();
        currentPlayer = "white";
    }

    public ChessBoard getBoard() {
        return board;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        ChessPiece piece = board.getPieceAt(startX, startY);
        if (piece != null && piece.getColor().equals(currentPlayer)) {
            if (piece.isValidMove(startX, startY, endX, endY, board)) {
                if (piece instanceof King && Math.abs(endY - startY) == 2) {
                    performCastling((King) piece, startX, startY, endX, endY);
                } else {
                    piece = piece instanceof Pawn ? ((Pawn) piece).promoteIfEligible(endX, endY) : piece;
                    board.setPieceAt(endX, endY, piece);
                    board.setPieceAt(startX, startY, null);
                }

                if (piece instanceof King) {
                    ((King) piece).setHasMoved(true);
                } else if (piece instanceof Rook) {
                    ((Rook) piece).setHasMoved(true);
                }

                switchPlayer();
                return true;
            }
        }
        return false;
    }

    private void performCastling(King king, int startX, int startY, int endX, int endY) {
        int rookStartY = endY == 6 ? 7 : 0;
        int rookEndY = endY == 6 ? 5 : 3;

        Rook rook = (Rook) board.getPieceAt(startX, rookStartY);
        board.setPieceAt(endX, endY, king);
        board.setPieceAt(startX, startY, null);
        board.setPieceAt(startX, rookStartY, null);
        board.setPieceAt(startX, rookEndY, rook);

        king.setHasMoved(true);
        rook.setHasMoved(true);
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer.equals("white") ? "black" : "white";
    }

    public String printBoard() {
        return board.printBoard();
    }

    public void printBoardConsole() {
        board.printBoardConsole();
    }
}
