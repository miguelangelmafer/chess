package com.birdshoe.chess.service;

import com.birdshoe.chess.model.ChessBoard;
import com.birdshoe.chess.model.ChessPiece;
import com.birdshoe.chess.model.Pawn;
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
                piece = piece instanceof Pawn ? ((Pawn) piece).promoteIfEligible(endX, endY) : piece;
                board.setPieceAt(endX, endY, piece);
                board.setPieceAt(startX, startY, null);

                switchPlayer();
                return true;
            }
        }
        return false;
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
