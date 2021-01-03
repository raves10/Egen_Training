package egen.module1.Texas_Hamburgers.menu;

import java.util.HashMap;
import java.util.Scanner;

public class Beverages extends Categories{
	
	private Scanner scan = new Scanner(System.in);
	private static int beverageCounter = 1;
	public static HashMap<Integer, Beverages> beverageMap;
	static
	{
		beverageMap= new HashMap<>();
		
		beverageMap.put(beverageCounter++, new Beverages("Root beer","2.15 "));
		beverageMap.put(beverageCounter++, new Beverages("Coke","2.15"));
		beverageMap.put(beverageCounter++, new Beverages("Lemonade","2.15" ));
		beverageMap.put(beverageCounter++, new Beverages("Domestic Beer","2.25"));
		beverageMap.put(beverageCounter++, new Beverages("Imported Beer","2.75 "));
		beverageMap.put(beverageCounter++, new Beverages("Mexican Coke","2.38 "));
		beverageMap.put(beverageCounter++, new Beverages("Fanata Orange","2.38 "));
	}
	
	
	
	 public Beverages() {
		// TODO Auto-generated constructor stub
	}
	
	public Beverages(String itemName, String itemPrice) {
		// TODO Auto-generated constructor stub
		this.itemName =  itemName;
		this.itemPrice = this.PRICE_TAG.concat(itemPrice);
	}

	@Override
	public String toString() {
		return "Beverages [itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
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
		beverageMap.put(beverageCounter++, new Beverages(itemName,itemPrice.toString()));
		System.out.println("Beverage added!");
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Available Beverages : "+beverageMap.toString()+"\nEnter the No. key of beverage to be deleted :");
		int itemNo = scan.nextInt();
		beverageMap.remove(itemNo);
		System.out.println("Beverage deleted!");
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Available Beverage : "+beverageMap.toString()+"\nEnter the No. key of beverage to be updated :");
		int itemNo = scan.nextInt();
		Beverages beverage = beverageMap.get(itemNo);
		System.out.println("What do want to update? Item Name(1) / Item Price(2) :");
		int choice = scan.nextInt();
		if(choice == 1)
		{
			System.out.println("Enter the new name : ");
			String name = scan.next();
			if(scan.hasNext())
			{
				 name += scan.nextLine();
				 beverage.setItemName(name);
			}
			
		}
		else
		{
			System.out.println("Enter the new price");
			Double price = scan.nextDouble();
			beverage.setItemPrice(this.PRICE_TAG.concat(price.toString()));
		}
		beverageMap.put(itemNo, beverage);
		System.out.println("Beverage updated!");
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		System.out.println(beverageMap.toString());
		
	}

	@Override
	public void showAlacarteMenu() {
		// TODO Auto-generated method stub
		showAll();
		
	}

	@Override
	public void showComboMenu() {
		// TODO Auto-generated method stub
		System.out.println("There are combos for beverages");
		
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
