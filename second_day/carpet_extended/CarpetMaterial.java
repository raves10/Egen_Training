package second_day.carpet_extended;

import java.util.HashMap;
import java.util.concurrent.CyclicBarrier;

public class CarpetMaterial {
	
	public String material;
	public int cleaningCycle;
	
	HashMap<String, Double> mlist = new HashMap<String, Double>();
	HashMap<Integer, Double> cycleList = new HashMap<Integer, Double>();
	
	public CarpetMaterial(String material, int cleaningCycle) {
		
		this.material = material;
		this.cleaningCycle = cleaningCycle;
		mlist.put("Nylon", 12.5);
		mlist.put("Polyster", 13.3);
		mlist.put("Recyclable", 15.0);
		
		cycleList.put(1, 20.5);
		cycleList.put(2, 35.5);
		
	}
	
	public double getMaterialPrice()
	{
		return mlist.get(material);
	}
	
	public double getCleaningPrice()
	{
		return cycleList.get(cleaningCycle);
	}

}
