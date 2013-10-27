import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class StopTheAliens 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		File file = new File("stopthealiens.in");
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
		scanner.nextLine();
		int[] res = new int[n];
		
		for(; n > 0; n--)
		{
			String line = scanner.nextLine();
			Scanner scan = new Scanner(line);
			String num = scan.next();
			
			int index1 = scan.nextInt();
			int value = Integer.parseInt(num.charAt(num.length() - index1) + "");
			while(scan.hasNext())
			{
				char operation = scan.next().charAt(0);
				int index2 = scan.nextInt();
				
				switch(operation)
				{
					case '+': value += Integer.parseInt(num.charAt(num.length() - index2) + "");
						break;
					case '-': value -= Integer.parseInt(num.charAt(num.length() - index2) + "");
						break;
					case '*': value *= Integer.parseInt(num.charAt(num.length() - index2) + "");
						break;
					case '/': value /= Integer.parseInt(num.charAt(num.length() - index2) + "");
						break;
					case '^': value = (int) Math.pow(value, Integer.parseInt(num.charAt(num.length() - index2) + ""));					
						break;
				}
			}
			
			res[res.length - n] = value;
		}
		
		for(int i : res)
		{
			System.out.println(i);
		}
	}
}
