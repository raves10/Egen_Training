package multithreading;

public class MovieTransaction extends Thread{
	public static enum TransactionType {
		BOOK_TICKET(1), CANCEL_TICKET(2);
 
		private TransactionType(int value) {
		}
	};
 
	private TransactionType transactionType;
	private Movie movie;
	private int noOfTickets;
	private int startingSeat;
	
 
	/*
	 * If transactionType == 1, depositAmount() else if transactionType == 2 withdrawAmount()
	 */
	public MovieTransaction(Movie movie, TransactionType transactionType,int noOfTickets,int startingSeat) {
		this.transactionType = transactionType;
		this.movie = movie;
		this.noOfTickets = noOfTickets;
		this.startingSeat = startingSeat;
	}
 
	public void run() {
		switch (this.transactionType) {
		case BOOK_TICKET:
			bookTicket();
			printAvailableSeats();
			break;
		case CANCEL_TICKET:
			cancelTicket();
			printAvailableSeats();
			break;
		default:
			System.out.println("NOT A VALID TRANSACTION");
		}
	}
 
	public void bookTicket() {
		this.movie.bookTicket(this.noOfTickets, this.startingSeat);
	}
 
	public void cancelTicket() {
		this.movie.cancelTicket(this.noOfTickets, this.startingSeat);
	}
 
	public void printAvailableSeats() {
		int count=0;
		System.out.println(Thread.currentThread().getName() + " : TransactionType: " + this.transactionType + ", Movie: " + this.movie.getMovieName());
		System.out.println("Available Seats: ");
		for(int i = 0; i < 100; i ++)
        { 
           if(this.movie.getAvailableSeats()[i] == 0)
           {
        	   count++;
           }
        }
		System.out.println(count);
	}

}
