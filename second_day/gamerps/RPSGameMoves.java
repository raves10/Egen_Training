package second_day.gamerps;

import java.util.Random;

public class RPSGameMoves {
	
	public enum Moves{
		
		ROCK, PAPER, SCISSORS
	}
	
	
	public boolean validMove(String move)
	{
		if(move.equalsIgnoreCase(Moves.ROCK.toString()) || move.equalsIgnoreCase(Moves.PAPER.toString()) || move.equalsIgnoreCase(Moves.SCISSORS.toString()))
		{
			return true;
		}
		return false;
	}
	
	public String getOpponentsMove()
	{
		Random r = new Random();
        int val = r.nextInt((3 - 1) + 1) + 1;
        return Moves.values()[val-1].toString();
	}
	
	public String[] evaluate(String move)
	{
		String oppMove = getOpponentsMove();
		String[] output = new String[2];
		output[0] = oppMove;
		if(move.equalsIgnoreCase(oppMove))
		{
			output[1] =  "Its a tie!!";
		}
		else if((move.equalsIgnoreCase(Moves.ROCK.toString()) && oppMove.equalsIgnoreCase(Moves.SCISSORS.toString())) ||
				(move.equalsIgnoreCase(Moves.SCISSORS.toString()) && oppMove.equalsIgnoreCase(Moves.PAPER.toString())) ||
				(move.equalsIgnoreCase(Moves.PAPER.toString()) && oppMove.equalsIgnoreCase(Moves.ROCK.toString())))
		{
			output[1] = "You Win!!";
		}
		else {
			output[1] = "Opponent Wins!!";
		}
		
		return output;
	}

}
