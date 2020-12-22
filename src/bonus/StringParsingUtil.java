package bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParsingUtil {
	
	public static void parse(String str)
	{
		List<String> strList = new ArrayList<>();
		List<Integer> numList = new ArrayList<>();
		Pattern digit = Pattern.compile("\\d+");
		Matcher match;
		String[] arr = str.split(",");
		for(String s : arr)
		{
			match = digit.matcher(s);
			if(match.matches())
			{
				numList.add(Integer.parseInt(s));
			}
			else
			{
				strList.add(s);
			}
		}
		
		System.out.println("The string list is : "+strList +" \nThe numerical list is : "+numList);
	}

}
