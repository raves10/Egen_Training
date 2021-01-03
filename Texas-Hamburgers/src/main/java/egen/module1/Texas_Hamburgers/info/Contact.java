package egen.module1.Texas_Hamburgers.info;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Contact  implements Info{
	
	private String addr;
	private String phone;
	private Scanner scan;
	public static Map<String, Contact> contactMap = new LinkedHashMap<>();
	
	public Contact(String addr, String phone) {
		
		this.addr = addr;
		this.phone = phone;
	}

	public Contact()
	{
		
	}
	public Contact(Contact contact) {
		// TODO Auto-generated constructor stub
		setAddr(contact.addr);
		setPhone(contact.phone);
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Contact [addr=" + addr + ", phone=" + phone + "]";
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		System.out.println("Enter new address : ");
		String addr = scan.next();
		if(scan.hasNext())
		{
			addr += scan.nextLine();
		}
		System.out.println("Enter new phone number : ");
		String phone =  scan.next();
		System.out.println("Enter name of contact : ");
		String name =  scan.next();
		if(scan.hasNext())
		{
			name += scan.nextLine();
		}
		
		Contact contact = new Contact(addr, phone);
		Contact.contactMap.put(name, contact);
		
		System.out.println("Contact added!");
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Available contacts : "+contactMap.keySet().toString());
		scan = new Scanner(System.in);
		System.out.println("Enter name of contact : ");
		String name = scan.next();
		if(scan.hasNext())
		{
			name += scan.nextLine();
		}
		System.out.println("Enter new address : ");
		String addr = scan.next();
		if(scan.hasNext())
		{
			addr += scan.nextLine();
		}
		System.out.println("Enter new phone : ");
		String phone =  scan.next();
		
		Contact contact = contactMap.get(name);
		contact.setAddr(addr);
		contact.setPhone(phone);
		contactMap.put(name, contact);
		System.out.println("Contact updated!");
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Available contacts : "+contactMap.keySet().toString());
		scan = new Scanner(System.in);
		System.out.println("Enter name of contact : ");
		String name = scan.next();
		contactMap.remove(name);
		System.out.println("Contact removed!");
		
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		System.out.println(contactMap.toString());
	}

	@Override
	public void func() {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		while(true)
		{
			System.out.println("Select from following options : \nAdd(1) / Update(2) / Delete(3) / Show(4) / Exit(5)");
			int choice = scan.nextInt();
			Info info = new Contact();
			if(choice == 1)
			{
				info.add();
			}
			else if(choice == 2)
			{
				info.update();
			}
			else if(choice == 3)
			{
				info.delete();
			}
			else if(choice == 4)
			{
				info.showAll();
			}
			else
			{
				break;
			}
		}
		
		
	}
	
	

}
