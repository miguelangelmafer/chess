package com.birdshoe.chess.controller;

import com.birdshoe.chess.service.ChessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chess")
public class ChessController {

    @Autowired
    private ChessService chessService;

    @PostMapping("/move")
    public String movePiece(@RequestParam int startX, @RequestParam int startY, @RequestParam int endX, @RequestParam int endY) {
        boolean success = chessService.movePiece(startX, startY, endX, endY);
        if (success) {
            chessService.printBoardConsole();
            String currentPlayer = chessService.getCurrentPlayer();
            System.out.println(currentPlayer);
            return "Movimiento exitoso, turno del jugador: " + currentPlayer + "\n" +
                    chessService.printBoard();
        }
        return "Movimiento inválido";
    }
}
