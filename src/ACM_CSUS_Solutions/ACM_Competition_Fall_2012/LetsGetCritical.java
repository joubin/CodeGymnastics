import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




public class LetsGetCritical
{
	private static ArrayList<ArrayList<Integer>> map;
	private static ArrayList<Integer> path;
	private static boolean pathFound;
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{		
		File file = new File("critical.in");
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
		
		for(; n > 0; n--)
		{ 
			int offices = scanner.nextInt();
			int connections = scanner.nextInt();
			map = new ArrayList<ArrayList<Integer>>(offices + 1);
			pathFound = false;
			
			for(int i = 0; i < offices + 1; i++)
			{
				map.add(new ArrayList<Integer>());
			}
			
			for(int i = 0; i < connections; i++)
			{
				int office1 = scanner.nextInt();
				int office2 = scanner.nextInt();
				
				map.get(office1).add(office2);
				map.get(office2).add(office1);
			}
			
			i:
			for(int i = 1; i <= offices; i++)
			{
				for(int j = 1; j <= offices; j++)
				{
					if(i != j)
					{
						pathFound = false;
						path = new ArrayList<Integer>();
						findPath(0, i, j);
						if(!pathFound)
						{
							break i;
						}
					}
				}
			}
			
			if(pathFound)
			{
				ArrayList<Integer> crits = new ArrayList<Integer>();
				for(int i = 1; i <= offices; i++)
				{
					j:
					for(int j = 1; j <= offices; j++)
					{
						if(j != i)
						{
							for(int k = 1; k <= offices; k++)
							{
								if(k != i && k != j)
								{
									pathFound = false;
									path = new ArrayList<Integer>();
									findPath(i, j, k);
									if(!pathFound)
									{
										crits.add(i);
										break j;
									}
								}
							}
						}
					}
				}
				
				if(crits.size() == 0)
				{
					System.out.println(0);
				}
				else
				{
					for(Integer i : crits)
					{
						System.out.print(i + " ");
					}
					System.out.print("\n");
				}
			}
			else
			{
				System.out.println(-1);
			}
		}
	}
	
	private static void findPath(int ignore, int from, int to)
	{
		if(from == to)
		{
			pathFound = true;
			return;
		}
		
		ArrayList<Integer> dest = map.get(from);
		path.add(from);
		for(Integer i : dest)
		{
			if(i != ignore && !path.contains(i))
			{
				path.add(i);
				findPath(ignore, i, to);
			}
		}
	}
}
