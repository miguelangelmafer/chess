package com.birdshoe.chess.controller;

import com.birdshoe.chess.model.ChessBoard;
import org.springframework.web.bind.annotation.*;

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
        if(success){
            chessBoard.printBoardConsole();
            return "Movimiento exitoso";
        }
        return "Movimiento inválido";
    }

    @GetMapping("/board")
    public String getBoard() {
        return chessBoard.printBoard();
    }
}