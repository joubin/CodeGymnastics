import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ChangeForADollar 
{
	private static int combos;
	private static int[] vals;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		File file = new File("change.in");
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
			combos = 0;
			int change = scanner.nextInt();
			int nVals = scanner.nextInt();
			vals = new int[nVals];
			
			for(int i = 0; i < vals.length; i++)
			{
				vals[i] = scanner.nextInt();
			}
			
			recursiveCall(change, nVals - 1);
			
			res[res.length - n] = combos;
		}
		
		for(int i : res)
		{
			System.out.println(i);
		}
	}
	
	private static void recursiveCall(int curChange, int valIndex)
	{
		if(curChange == 0)
		{
			combos++;
		}
		
		if(valIndex > -1 && curChange > 0)
		{
			int num = curChange/vals[valIndex];
			
			for(int i = num; i >= 0; i--)
			{
				recursiveCall(curChange - (i * vals[valIndex]), valIndex - 1);
			}
		}
	}
}
