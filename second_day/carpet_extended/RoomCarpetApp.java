package second_day.carpet_extended;

import java.util.Scanner;

public class RoomCarpetApp {
	
	public static void main(String[] args)
	{
		final double COST = 8.0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the dimensions of room!");
		System.out.println("Width : ");
		double width = scan.nextDouble();
		System.out.println("Length : ");
		double length =scan.nextDouble();
		RoomDimension room = new RoomDimension(width, length);
		System.out.println("Enter cleaning cycle period (Once in 6 months = 1/Twice a year = 2) :");
		int cycle = scan.nextInt();
		System.out.println("Enter choice of material (Nylon/Polyster/Recyclable/Regular) :");
		String material = scan.next();
		scan.close();
		CarpetMaterial choice = new CarpetMaterial(material, cycle);
		RoomCarpet roomCarpet = new RoomCarpet(room, COST);
		System.out.println("The total cost for carpeting for the room is :"+ (material.equalsIgnoreCase("regular") ? roomCarpet.totalCost(choice.getCleaningPrice()):
			roomCarpet.totalCost(choice.getMaterialPrice(), choice.getCleaningPrice())));
	}
	
	

}
