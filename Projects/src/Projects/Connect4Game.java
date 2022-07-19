package Projects;

import java.util.Random;
import java.util.Scanner;

public class Connect4Game {
	private Board board;
	private String color1;
	private String color2;
	
	// true if player1's turn
	// false if player2's turn
	private boolean is1playing;
	
	public Connect4Game(String color1, String color2) {
		this.board = new Board();
		this.color1 = color1;
		this.color2 = color2;
		
		is1playing = (new Random()).nextBoolean();
	}
	
	public boolean checkForWinner(int column) {
		String winningColor;
		
		if(is1playing) {
			winningColor = color1;
		}else {
			winningColor = color2;
		}
		
		return board.checkForWinner(column, winningColor);
		
	}
	
	public void startGame() {
		boolean running = true;
		
		while(running) {
			board.printBoard();
			String color;
			if(is1playing) {
				color = color1;
				System.out.println("Player 1 turn");
			}else {
				color = color2;
				System.out.println("Player 2 turn");
			}
			
			System.out.println("Please select which column you want to put your piece in.");
			System.out.println("Choose between 1 and " + board.getColumns() + ": ");
			
			Scanner input = new Scanner(System.in);
			int column = input.nextInt() - 1;
			
			boolean success = board.addPiece(column,  color);
			
			
		if(success) {
			if(checkForWinner(column)) {
				board.printBoard();
				running = false;
				if(is1playing) {
					System.out.println("Player 1 won!");
				}else {
					System.out.println("Player 2 won!");				}
			}
				is1playing = !is1playing;
			}
		}
		
	}

}
