import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class InIt
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		HashMap<Character, Integer> points = new HashMap<Character, Integer>();
		points.put('A', 1);
		points.put('B', 3);
		points.put('C', 3);
		points.put('D', 2);
		points.put('E', 1);
		points.put('F', 4);
		points.put('G', 2);
		points.put('H', 4);
		points.put('I', 1);
		points.put('J', 8);
		points.put('K', 5);
		points.put('L', 1);
		points.put('M', 3);
		points.put('N', 1);
		points.put('O', 1);
		points.put('P', 3);
		points.put('Q', 10);
		points.put('R', 1);
		points.put('S', 1);
		points.put('T', 1);
		points.put('U', 1);
		points.put('V', 4);
		points.put('W', 4);
		points.put('X', 8);
		points.put('Y', 4);
		points.put('Z', 10);
		points.put('_', 0);
		
		File file = new File("init.in");
		Scanner scanner = null;
		try 
		{
			scanner = new Scanner(file);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("cannot find file.");
			System.exit(0);
		}
		
		int n = scanner.nextInt();
		int[] res = new int[n];
		for(; n > 0; n--)
		{
			String letters = scanner.next();
			String append = "";
			while(letters.contains("_"))
			{
				letters = letters.replaceFirst("_", "");
				append += "_";
			}
			letters += append;
			
			String word = scanner.next();
			ArrayList<Integer> charUsed = new ArrayList<Integer>();
			
			for(int i = 0; i < word.length(); i++)
			{
				char c = word.charAt(i);
				boolean init = false;
				
				for(int j = 0; j < letters.length(); j++)
				{
					if(!charUsed.contains(j))
					{
						if(letters.charAt(j) == c || letters.charAt(j) == '_')
						{
							charUsed.add(j);
							init = true;
							res[res.length - n] += points.get(letters.charAt(j));
							break;
						}
					}
				}
				
				if(!init)
				{
					res[res.length - n] = 0;
					break;
				}
			}
		}
		
		for(int i : res)
		{
			System.out.println(i);
		}
	}
}
