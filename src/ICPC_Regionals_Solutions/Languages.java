

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Languages 
{
	private static ArrayList<ArrayList> languages = new ArrayList<ArrayList>();
	private static HashMap<String, String> all = new HashMap<String,String>();
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		s.nextLine();
		for(int i = 0; i< N; i++)
		{
			String l = s.nextLine();
			String string[] = l.split(" ");
			String value = string[0];
			for(int x = 1; x < string.length; x++){
				all.put(string[x].toLowerCase(), value);
			}
			

		}
		
		
		s.nextLine();
		String inputString = s.nextLine();
		do{
		
		String testString[] = inputString.split(" ");
		for(String ss: testString){
			ss = ss.replaceAll(",", "");
			ss = ss.replaceAll("\\.", ""); // for reference: \\ escapes the char in a regex
			ss = ss.replaceAll("!", "");
			ss = ss.replaceAll("[(]+", ""); // \\ and []+ works for this problem equally
			ss = ss.replaceAll("[)]+", "");
			ss = ss.replaceAll(";", "");
			ss = ss.replaceAll("[?]+", "");
			String myString =ss.toLowerCase();
			if(all.containsKey(myString)){
				System.out.println(all.get(myString));
				break;
			}	
		}


		try{
			inputString = s.nextLine();
		}catch(Exception e){
			System.exit(0);
		}
//		try
//		{
//		first = inputString.charAt(0) + "";
//		}
//		catch(Exception e)
//		{
//			System.exit(0);
//		}
//				
		}while(true);
	}
}
