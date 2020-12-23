package second_day.gamerps;

import java.util.Scanner;

public class RPSGameApp {
	
	public static void main(String[] args)
	{
		RPSGameMoves game = new RPSGameMoves();
		Scanner scan = new Scanner(System.in);
		System.out.println("** Welcome to Rock, Paper, Scissors Game **");
		while(true)
		{
			System.out.println("Enter your move(rock/paper/scissors/quit) : ");
			String move = scan.nextLine();
			if(game.validMove(move))
			{
				String[] output = game.evaluate(move);
				System.out.println("The Opponent's move is : "+ output[0]+"\nThe result of the game is : ** "+output[1]+" **");
			}
			else if(move.equalsIgnoreCase("quit"))
			{
				scan.close();
				break;
			}
			else
			{
				System.out.println("Please enter a valid move");
			}
		}
	}

}
