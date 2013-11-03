import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class H 
{
	private static int path1 = 0;
	private static int path2 = 0;
	private static int totalBest = Integer.MAX_VALUE;
	private static int curBest = Integer.MAX_VALUE;
	private static ArrayList<Integer> pathTaken = new ArrayList<Integer>();
	private static ArrayList<Integer> pathTaken2 = new ArrayList<Integer>();
	private static HashMap<Integer, ArrayList<int[]>> hm = new HashMap<Integer, ArrayList<int[]>>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int nodes = scanner.nextInt();
		int routes = scanner.nextInt();
		
		int curKey = scanner.nextInt();
		ArrayList<int[]> dests = new ArrayList<int[]>();
		int[] dest = {scanner.nextInt(), scanner.nextInt()};
		dests.add(dest.clone());
		
		int tempKey = 0;
		for(int i = 1; i < routes; i++)
		{
			tempKey = scanner.nextInt();
			
			if(tempKey != curKey)
			{
				hm.put(curKey, dests);
				dests = new ArrayList<int[]>();
				
				curKey = tempKey;
				
				if(hm.containsKey(curKey))
				{
					dests = hm.get(curKey);
				}
			}
			
			dest[0] = scanner.nextInt();
			dest[1] = scanner.nextInt();
			
			dests.add(dest.clone());
		}
		hm.put(curKey, dests);
		
		findNextNode(nodes, 1);
		
		System.out.println(totalBest);
	}
	
	private static void findNextNode(int nodes, int curPos)
	{
		ArrayList<int[]>  posDest =  hm.get(curPos);
		for(int[] i : posDest)
		{
			if(!pathTaken.contains(i[0]))
			{
				curPos = i[0];
				path1 += i[1];
				pathTaken.add(curPos);
				
				if(curPos != nodes)
				{
					if(!(path1 >= totalBest))
					{
						findNextNode(nodes, curPos);
					}
				}
				else
				{
					findNextNode2(nodes, 1);
				}
				
				pathTaken.clear();
				path1 = 0;
			}
		}
	}
	
	private static void findNextNode2(int nodes, int curPos)
	{		
		ArrayList<int[]>  posDest =  hm.get(curPos);
		
		for(int[] i : posDest)
		{
			if(i[0] == nodes || (!pathTaken.contains(i[0]) && !pathTaken2.contains(i[0])))
			{
				curPos = i[0];
				pathTaken2.add(i[0]);
				path2 += i[1];			
				
				if(curPos != nodes)
				{
					if(!(path1 + path2 >= totalBest))
					{
						findNextNode2(nodes, curPos);
					}
				}
				else
				{
					if((path1 + path2) < curBest)
					{
						curBest = path1 + path2;
					}
					path2 = 0;
				}
			}
		}
		
		if(curBest < totalBest)
		{
			totalBest = curBest;
		}
		curBest = Integer.MAX_VALUE;
	}
}
