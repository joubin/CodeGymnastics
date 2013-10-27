import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;


public class TWOlympics 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		HashMap<Integer, String> intCountries = new HashMap<Integer, String>();
		intCountries.put(1, "Leafland");
		intCountries.put(2, "Manchewia");
		intCountries.put(3, "Branchia");
		intCountries.put(4, "Greenland");
		intCountries.put(5, "Pulpica");
		
		File file = new File("worms.in");
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
		
		int i;
		ArrayList<int[]> wInfo = new ArrayList<int[]>();
		int[][] cInfo = new int[5][2];
		for(int j = 0; j < cInfo.length; j++)
		{
			cInfo[j][0] = j + 1;
		}
		
		while(scanner.hasNext())
		{
			i = scanner.nextInt();
			
			if(i < 0)
			{
				if(i == -999)
				{
					break;
				}
			}
			else
			{
				int wNum = scanner.nextInt();
				int oz = scanner.nextInt();
				boolean old = false;
				for(int j = 0; j < wInfo.size(); j++)
				{
					if(wInfo.get(j)[0] == wNum)
					{
						wInfo.get(j)[1] += oz;
						old = true;
						break;
					}
				}
				if(!old)
				{
					wInfo.add(new int[]{wNum, oz});
				}
				
				cInfo[i - 1][1] += oz;
			}
		}
		
		Arrays.sort(cInfo, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] arg0, int[] arg1) 
			{
				return -Integer.compare(arg0[1], arg1[1]);
			}	
		});
		
		System.out.println("Team Green medal: " + cInfo[0][0] + " " +
				intCountries.get(cInfo[0][0]) + " " + 
				cInfo[0][1] + " oz");
		System.out.println("Team Red medal:   " + cInfo[1][0] + " " +
				intCountries.get(cInfo[1][0]) + " " + 
				cInfo[1][1] + " oz");
		System.out.println("Team Brown medal: " + cInfo[2][0] + " " +
				intCountries.get(cInfo[2][0]) + " " + 
				cInfo[2][1] + " oz");
		
		int[][] wArr = new int[wInfo.size()][];
		wInfo.toArray(wArr);
		Arrays.sort(wArr, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] arg0, int[] arg1) 
			{
				return -Integer.compare(arg0[1], arg1[1]);
			}	
		});
		
		System.out.println("Worm Green medal: " + wArr[0][0] + " " + 
				wArr[0][1] + " oz");
		System.out.println("Worm Red medal:   " + wArr[1][0] + " " + 
				wArr[1][1] + " oz");
		System.out.println("Worm Brown medal: " + wArr[2][0] + " " + 
				wArr[2][1] + " oz");
	}
}
