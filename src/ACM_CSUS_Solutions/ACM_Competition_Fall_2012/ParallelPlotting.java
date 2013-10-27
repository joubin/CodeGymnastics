import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ParallelPlotting 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		File file = new File("pplot.in");
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
		
		for(int i = 0; i < n; i++)
		{
			String line = scanner.nextLine();
			Scanner scan = new Scanner(line);
			
			ArrayList<Integer> ints = new ArrayList<Integer>();
			while(scan.hasNext())
			{
				ints.add(scan.nextInt());
			}
			
			int max = 0;
			int length = 0;
			for(Integer integer : ints)
			{
				if(integer > max)
				{
					max = integer;
				}
				
				length += integer;
			}
			
			length += ints.size() - 1;
			max += max - 1;
			
			char[][] array = new char[max][length];
			for(int j = 0; j < array.length; j++)
			{
				for(int k = 0; k < array[0].length; k++)
				{
					array[j][k] = ' ';
				}
			}
			
			int hIndex = max - 1;
			int lIndex = 0;
			for(Integer integer : ints)
			{
				if(integer%2 == 0)
				{
					for(int j = integer; j > 0; j--)
					{
						for(int k = 0; k < integer; k++)
						{
							array[hIndex][lIndex + k] = '*';
						}
						
						hIndex -= 2;
					}
				}
				else
				{
					for(int j = integer; j > 0; j--)
					{
						for(int k = 0; k < j; k++)
						{
							array[hIndex][lIndex + k] = '*';
						}
						
						hIndex -= 2;
					}
				}
				
				lIndex += integer + 1;
				hIndex = max - 1;
			}
			
			for(int j = 0; j < array.length; j++)
			{
				for(int k = 0; k < array[0].length; k++)
				{
					System.out.print(array[j][k]);
				}
				System.out.print("\n");
			}
			
			System.out.println("\n");
		}
	}
}
