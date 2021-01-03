package egen.module1.Texas_Hamburgers.menu;

import java.util.HashMap;
import java.util.Scanner;




public class MainCourse extends Categories{
	
	
	private Scanner scan = new Scanner(System.in);
	private static int burgerCounter = 1;
	public static HashMap<Integer, MainCourse> burgerMap;
	static
	{
		burgerMap= new HashMap<>();
		
		burgerMap.put(burgerCounter++, new MainCourse("Hamburger","6.00 ",true, "8.75"));
		burgerMap.put(burgerCounter++, new MainCourse("Bacon Cheeseburger","7.50",true,"9.50"));
		burgerMap.put(burgerCounter++, new MainCourse("Cheeseburger","$6.00 ",true, "9.50"));
		burgerMap.put(burgerCounter++, new MainCourse("Avocado Cheese Burger","7.25",false));
		burgerMap.put(burgerCounter++, new MainCourse("Bacon Burger","7.25 ",false));
		burgerMap.put(burgerCounter++, new MainCourse("Cheddar Burger","7.00 ",false));
	}
	

	public MainCourse()
	{
		
	}
	
	public MainCourse(String itemName, String price, boolean isCombo)
	{
		this.itemName = itemName;
		this.itemPrice = this.PRICE_TAG.concat(price);
		this.isCombo = isCombo;
	}
	
	public MainCourse(String itemName, String price, boolean isCombo, String comboPrice)
	{
		this.itemName = itemName;
		this.itemPrice = this.PRICE_TAG.concat(price);
		this.isCombo = isCombo;
		this.comboPrice = this.COMBO_PRICE_TAG.concat(comboPrice);
	}
	

	@Override
	public String toString() {
		return "MainCourse [itemName=" + itemName + ", itemPrice="+ itemPrice + ", isCombo=" + isCombo
				+ ", comboPrice="+ comboPrice + "]";
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
		System.out.println("Do you want to add a combo? Yes(1) / No(0) :");
		int combo = scan.nextInt();
		if(combo == 1)
		{
			System.out.println("Enter the new combo price :");
			Double comboPrice = scan.nextDouble();
			burgerMap.put(burgerCounter++, new MainCourse(itemName, itemPrice.toString(), true, this.COMBO_PRICE_TAG.concat(comboPrice.toString())));
		}
		else
		{
			burgerMap.put(burgerCounter++, new MainCourse(itemName, itemPrice.toString(), false));
		}
		
		System.out.println("Main Course added!");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Available Main Course : "+burgerMap.toString()+"\nEnter the No. key of course to be deleted :");
		int itemNo = scan.nextInt();
		burgerMap.remove(itemNo);
		System.out.println("Main course deleted!");
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Available Main Course : "+burgerMap.toString()+"\nEnter the No. key of course to be updated :");
		int itemNo = scan.nextInt();
		MainCourse course = burgerMap.get(itemNo);
		System.out.println("What do want to update? Item Name(1) / Item Price(2) :");
		int choice = scan.nextInt();
		if(choice == 1)
		{
			System.out.println("Enter the new name : ");
			String name = scan.next();
			if(scan.hasNext())
			{
				 name += scan.nextLine();
				 course.setItemName(name);
			}
			
		}
		else
		{
			System.out.println("Enter the new price");
			Double price = scan.nextDouble();
			course.setItemPrice(this.PRICE_TAG.concat(price.toString()));
		}
		if(course.isCombo)
		{
			System.out.println("Do you want to update the combo price? Yes(1) / No(0) :");
			int ch = scan.nextInt();
			if(ch == 1)
			{
				System.out.println(" Enter the new price :");
				Double cPrice = scan.nextDouble();
				course.setComboPrice(this.COMBO_PRICE_TAG.concat(cPrice.toString()));
				
			}
			
		}
		else
		{
			System.out.println("Do you want to make it a combo? Yes(1) / No(0) :");
			int combo = scan.nextInt();
			if(combo == 1)
			{
				System.out.println(" Enter the combo price :");
				Double cPrice = scan.nextDouble();
				course.setComboPrice(this.COMBO_PRICE_TAG.concat(cPrice.toString()));
				course.setCombo(true);
			}
		}
		burgerMap.put(itemNo, course);
		System.out.println("Main course updated!");
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		System.out.println(burgerMap.toString());
		
	}

	@Override
	public void showAlacarteMenu() {
		// TODO Auto-generated method stub
		for(MainCourse item : burgerMap.values())
		{
			if(!item.isCombo)
			{
				System.out.println(item.toString());
			}
		}
		
	}

	@Override
	public void showComboMenu() {
		// TODO Auto-generated method stub
		for(MainCourse item : burgerMap.values())
		{
			if(item.isCombo)
			{
				System.out.println(item.toString());
			}
		}
		
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
