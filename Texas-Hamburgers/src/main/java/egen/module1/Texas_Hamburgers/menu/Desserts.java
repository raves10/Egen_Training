package egen.module1.Texas_Hamburgers.menu;

import java.util.HashMap;
import java.util.Scanner;

public class Desserts extends Categories {
	
	private Scanner scan = new Scanner(System.in);
	private static int dessertCounter = 1;
	public static HashMap<Integer, Desserts> dessertMap;
	static
	{
		dessertMap= new HashMap<>();
		
		dessertMap.put(dessertCounter++, new Desserts("Oatmeal Cookies","2.25 "));
		dessertMap.put(dessertCounter++, new Desserts("Reese's Peanut butter Cup Cookies","2.25"));
		dessertMap.put(dessertCounter++, new Desserts("Mangonada Drink","5.25 "));
		dessertMap.put(dessertCounter++, new Desserts("Fresanada Drink","5.25"));
		dessertMap.put(dessertCounter++, new Desserts("Chocolate Shake","3.50 "));
		dessertMap.put(dessertCounter++, new Desserts("Strawberry Shake","3.50 "));
	}
	
	
	
	public Desserts() {
		// TODO Auto-generated constructor stub
	}
	
	public Desserts(String itemName, String itemPrice) {
		// TODO Auto-generated constructor stub
		this.itemName =  itemName;
		this.itemPrice = this.PRICE_TAG.concat(itemPrice);
	}
	
	

	@Override
	public String toString() {
		return "Desserts [itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Enter the new item name :");
		String itemName = scan.next();
		if(scan.hasNext())
		{
			itemName += scan.nextLine();
		}
		System.out.println("Enter thr new item price :");
		Double itemPrice = scan.nextDouble();
		dessertMap.put(dessertCounter++, new Desserts(itemName,itemPrice.toString()));
		System.out.println("Dessert added!");
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Available Desserts : "+dessertMap.toString()+"\nEnter the No. key of dessert to be deleted :");
		int itemNo = scan.nextInt();
		dessertMap.remove(itemNo);
		System.out.println("Dessert deleted!");
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Available Desserts : "+dessertMap.toString()+"\nEnter the No. key of dessert to be updated :");
		int itemNo = scan.nextInt();
		Desserts dessert = dessertMap.get(itemNo);
		System.out.println("What do want to update? Item Name(1) / Item Price(2) :");
		int choice = scan.nextInt();
		if(choice == 1)
		{
			System.out.println("Enter the new name : ");
			String name = scan.next();
			if(scan.hasNext())
			{
				 name += scan.nextLine();
				 dessert.setItemName(name);
			}
			
		}
		else
		{
			System.out.println("Enter the new price");
			Double price = scan.nextDouble();
			dessert.setItemPrice(this.PRICE_TAG.concat(price.toString()));
		}
		dessertMap.put(itemNo, dessert);
		System.out.println("Dessert updated!");
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		System.out.println(dessertMap.toString());
		
	}

	@Override
	public void showAlacarteMenu() {
		// TODO Auto-generated method stub
		showAll();
		
	}

	@Override
	public void showComboMenu() {
		// TODO Auto-generated method stub
		System.out.println("There are combos for desserts");
		
	}

	@Override
	public void func() {
		// TODO Auto-generated method stub
		while(true)
		{
		
			System.out.println("Select from following options : \nAdd(1) / Update(2) / Delete(3) / Show(4) / Show Combos(5) / Show Alacarte(6) / Exit(7)");
			int choice = scan.nextInt();
			
			if(choice == 1)
			{
				add();
			}
			else if(choice == 2)
			{
				update();
			}
			else if(choice == 3)
			{
				delete();
			}
			else if(choice == 4)
			{
				showAll();
			}
			else if(choice == 5)
			{
				showComboMenu();
			}
			else if(choice == 6)
			{
				showAlacarteMenu();
			}
			else
			{
				break;
			}
		}
		
	}

}
