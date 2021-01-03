package egen.module1.Texas_Hamburgers.info;

import java.util.HashMap;
import java.util.Scanner;

public class Location extends Contact{
	
	private double latitude;
	private double longitude;
	private Scanner scan = new Scanner(System.in);
	
	public static HashMap<String, Location> locationMap;
	static
	{
		locationMap= new HashMap<>();
		Contact contact = new Contact("9010 Huebner Rd, San Antonio, TX 78240", "+12106991189");
		Contact.contactMap.put("San Antonio", contact);
		locationMap.put("San Antonio", new Location(29.526, -98.596, contact));
	}
	
	
	
	public Location() {
		super();
	}



	public Location(double latitude, double longitude, Contact contact) {
		super(contact);
		this.latitude = latitude;
		this.longitude = longitude;
				
	}

	

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	

	@Override
	public String toString() {
		return "Location [latitude=" + latitude + ", longitude=" + longitude + "]";
	}



	@Override
	public void add() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter new latitude : ");
		double lat = scan.nextDouble();
		System.out.println("Enter new longitude : ");
		double lon =  scan.nextDouble();
		System.out.println("Enter location name : ");
		String name = scan.next();
		if(scan.hasNext())
		{
			name += scan.nextLine();
		}
		System.out.println("Enter location address : ");
		
		String addr = scan.next();
		if(scan.hasNext())
		{
			addr += scan.nextLine();
		}
		System.out.println("Enter location phone number : ");
		String phone = scan.next();
	
		Contact contact = new Contact(addr, phone);
		Contact.contactMap.put(name, contact);
		locationMap.put(name, new Location(lat, lon, contact));
		System.out.println("Location added!");
				
	}

	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Available locations : "+locationMap.keySet().toString());
		
		System.out.println("Enter location name : ");
		String name = scan.next();
		if(scan.hasNext())
		{
			name += scan.nextLine();
		}
		
		System.out.println("Enter new latitude : ");
		double lat = scan.nextDouble();
		System.out.println("Enter new longitude : ");
		double lon =  scan.nextDouble();
		
		Location loc = locationMap.get(name);
		loc.setLongitude(lon);
		loc.setLatitude(lat);
		locationMap.put(name, loc);
		System.out.println("Location updated!");
				
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Available locations : "+locationMap.keySet().toString());
		
		System.out.println("Enter location name : ");
		String name = scan.next();
		
		Contact.contactMap.remove(name);
		locationMap.remove(name);
		System.out.println("Location removed!");
		
	}
	
	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		
		System.out.println(locationMap.toString());
	}
	
	@Override
	public void func() {
		// TODO Auto-generated method stub
		
		while(true)
		{
		
			System.out.println("Select from following options : \nAdd(1) / Update(2) / Delete(3) / Show(4) / Exit(5)");
			int choice = scan.nextInt();
			Info info = new Location();
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
	
	public String search() {

		System.out.println("Enter the latitude :");
		double lat1 = scan.nextDouble();
		System.out.println("Enter the longitude :");
		double lng1 = scan.nextDouble();
	    double earthRadius = 3958.75; // in miles, change to 6371 for kilometer output

	    for(Location loc : locationMap.values())
	    {
		    double dLat = Math.toRadians(loc.getLatitude()-lat1);
		    double dLng = Math.toRadians(loc.getLongitude()-lng1);
	
		    double sindLat = Math.sin(dLat / 2);
		    double sindLng = Math.sin(dLng / 2);
	
		    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
		        * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(loc.getLatitude()));
	
		    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	
		    double dist = earthRadius * c;
		    if(dist <= 0.1)
		    {
		    	return loc.toString();
		    }
		    
	    }
	    return "No location found!"; 
	}

}
