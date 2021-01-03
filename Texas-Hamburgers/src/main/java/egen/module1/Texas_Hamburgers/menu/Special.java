package egen.module1.Texas_Hamburgers.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;





public class Special implements Menu{
	
	public Scanner scan = new Scanner(System.in);
	public static HashMap<String, List<String>> specialMap;
	public final String PRICE_TAG = "Price $";


	public Special()
	{
		specialMap= new LinkedHashMap<>();
		
		specialMap.put("MONDAY", new ArrayList<String>(Arrays.asList("Chicken Fried Plate", "Price $10.50")));
		specialMap.put("TUESDAY", new ArrayList<String>(Arrays.asList("Angus Plate", "Price $10.50")));
		specialMap.put("WEDNESDAY", new ArrayList<String>(Arrays.asList("Philly Cheese Steak or Chicken Sandwich (side salad excluded)", "Price $9.50")));
		specialMap.put("THURSDAY", new ArrayList<String>(Arrays.asList("2 Piece Cat Fish Plate", "Price $10.50")));
		specialMap.put("FRIDAY", new ArrayList<String>(Arrays.asList("Grilled Chicken Breast Plate", "Price $9.25")));
		specialMap.put("SATURDAY", new ArrayList<String>(Arrays.asList("Chicken Fried Steak Plate", "Price $10.50")));
		specialMap.put("SUNDAY", new ArrayList<String>(Arrays.asList("All Specials Available")));
	}


	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Available special menus : \n"+specialMap.toString());
		System.out.println("Enter the day on which you wish to delete special menu : ");
		String day = scan.next();
		specialMap.remove(day.toUpperCase());
		System.out.println("Special menu deleted!");
		
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Available special menus : \n"+specialMap.toString()+"\n");
		System.out.println("Enter the day on which you wish to delete special menu : ");
		String day = scan.next();
		List<String> spcl = specialMap.get(day.toUpperCase());
		System.out.println("What do you wish update? Dish(1) / Price(2) : ");
		int choice = scan.nextInt();
		if(choice == 1)
		{
			System.out.println("Enter new special dish : ");
			String newSpcl = scan.next();
			if(scan.hasNext())
			{
				newSpcl += scan.nextLine();
				spcl.remove(0);
				spcl.add(0, newSpcl); 
				
			}
			
			
		}
		else
		{
			System.out.println("Enter new price : ");
			Double price = scan.nextDouble();
			spcl.remove(1);
			spcl.add(1, PRICE_TAG.concat(price.toString()));
		}
		//scan.nextLine();
		System.out.println("Special menu updated!");
		
		
	}


	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		System.out.println(specialMap.toString());
	}


	@Override
	public void func() {
		// TODO Auto-generated method stub
		while(true)
		{
		
			System.out.println("Select from following options : \nUpdate(1) / Delete(2) / Show(3) / Exit(4)");
			int choice = scan.nextInt();
			
			if(choice == 1)
			{
				update();
			}
			else if(choice == 2)
			{
				delete();
			}
			else if(choice == 3)
			{
				showAll();
			}
			else
			{
				break;
			}
		}
		
	}

}




















