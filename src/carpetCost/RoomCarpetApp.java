package carpetCost;

import java.util.Scanner;

public class RoomCarpetApp {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the dimensions of room!");
		System.out.println("Width : ");
		double width = scan.nextDouble();
		System.out.println("Length : ");
		double length =scan.nextDouble();
		RoomDimension room = new RoomDimension(width, length);
		System.out.println("Enter cost per sqft :");
		double price = scan.nextDouble();
		scan.close();
		RoomCarpet roomCarpet = new RoomCarpet(room, price);
		System.out.println("The total cost for carpeting for the room is :"+ roomCarpet.totalCost());
	}
	
	

}
