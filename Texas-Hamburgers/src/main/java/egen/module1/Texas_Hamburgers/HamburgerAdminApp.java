package egen.module1.Texas_Hamburgers;

import java.util.Scanner;

import egen.module1.Texas_Hamburgers.info.Contact;
import egen.module1.Texas_Hamburgers.info.Info;
import egen.module1.Texas_Hamburgers.info.Location;
import egen.module1.Texas_Hamburgers.menu.Beverages;
import egen.module1.Texas_Hamburgers.menu.Desserts;
import egen.module1.Texas_Hamburgers.menu.MainCourse;
import egen.module1.Texas_Hamburgers.menu.Menu;
import egen.module1.Texas_Hamburgers.menu.Special;

public class HamburgerAdminApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("*** Welcome to Texas Hambuger Admin Portal ***");
		loop : while(true)
		{
			System.out.println("--- Select from following options --- : \nLocation(1) / Contact(2) / Menu(3) / Search close by location(4) / Exit(5) : ");
			int option = scan.nextInt();
			switch(option)
			{
			case 1: Info infoLocation = new Location();
					infoLocation.func();
					break;
					
			case 2: Info infoContact = new Contact();
					infoContact.func();
					break;
					
			case 3: System.out.println("*** Menu ***\n1. Main Course\n2. Desserts\n3. Beverages\n4. Daily Specail\nEnter your choice of menu :");
					int choice = scan.nextInt();
					if(choice == 1)
					{
						Menu main = new MainCourse();
						main.func();
					}
					else if(choice == 2)
					{
						Menu dessert = new Desserts();
						dessert.func();
					}
					else if(choice == 3)
					{
						Menu beverage = new Beverages();
						beverage.func();
					}
					else
					{
						Menu special = new Special();
						special.func();
					}
					break;
					
			case 4: Location loc = new Location();
					System.out.println(loc.search());
					break;
					
			case 5: System.out.println("Thank you!!"); 
					break loop;
					
			default : System.out.println("Enter the valid option");
						
			
			}
			//scan.close();
		}//while end
		scan.close();
	}
	
}
