package multithreading;

public class Movie {
	
	private String movieName;
	private int[] availableSeats = new int[100];
	
	public Movie(String movieName)
	{
		this.movieName = movieName;
	}
	
	
	public String getMovieName() {
		return movieName;
	}

	public int[] getAvailableSeats() {
		return availableSeats;
	}


	public synchronized boolean bookTicket(int noOfTickets, int startingSeat)
	{
		if(this.availableSeats[startingSeat] == 1)
		{
			return false;
		}
		else
		{
			for(int i=startingSeat; i<noOfTickets && i<this.availableSeats.length;i++)
			{
				if(this.availableSeats[i] == 0)
				{
					this.availableSeats[i] =1;
				}
				else
				{
					return false;
				}
				
			}
			return true;
		}
	}
	
	public synchronized boolean cancelTicket(int noOfTickets, int startingSeat)
	{
		if(this.availableSeats[startingSeat] == 0)
		{
			return false;
		}
		else
		{
			for(int i=startingSeat; i<noOfTickets && i<availableSeats.length;i++)
			{
				if(this.availableSeats[i] == 1)
				{
					this.availableSeats[i] = 0;
				}
				else
				{
					return false;
				}
				
			}
			return true;
		}
	}

}
