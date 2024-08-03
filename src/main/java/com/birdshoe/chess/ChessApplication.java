package com.birdshoe.chess;

import com.birdshoe.chess.model.ChessBoard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessApplication.class, args);
		ChessBoard board =  new ChessBoard();
		board.printBoardConsole();
	}
}
