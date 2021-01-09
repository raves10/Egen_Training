package multithreading;

public class App {
	public static void main(String[] args) {
		Movie movie = new Movie("Iron Man");
		int[] startingSeats = new int[] {1,45,20,15,5};
		int[] steps =new int[]{6,2,5,6,1};
 
		
		for (int i = 0; i < 5; i++) {
			
			MovieTransaction t = new MovieTransaction(movie, MovieTransaction.TransactionType.BOOK_TICKET, steps[i],startingSeats[i]);
			t.start();
		}
 
		
		for (int i = 1; i < 5; i++) {
			MovieTransaction t = new MovieTransaction(movie, MovieTransaction.TransactionType.CANCEL_TICKET, steps[i],startingSeats[i]);
			t.start();
 
		}
 
		// Let's just wait for a second to make sure all thread execution completes.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);
			Thread.currentThread().interrupt(); // restore the interrupted state
		}
 
		
	}

}
