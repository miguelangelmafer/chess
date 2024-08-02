package com.birdshoe.chess.controller;

import com.birdshoe.chess.model.ChessBoard;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chess")
public class ChessController {
    private ChessBoard chessBoard;

    public ChessController() {
        this.chessBoard = new ChessBoard();
    }

    @PostMapping("/move")
    public String movePiece(@RequestParam int startX, @RequestParam int startY, @RequestParam int endX, @RequestParam int endY) {
        boolean success = chessBoard.movePiece(startX, startY, endX, endY);
        return success ? "Movimiento exitoso" : "Movimiento inválido";
    }
}