import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class p3 
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<String[]> vals = new ArrayList<String[]>();
		String name = "";
		int year = scanner.nextInt();
		
		while(year != 0)
		{
			String[] sArr = new String[2];
			name = scanner.next();
			
			sArr[0] = year + "";
			sArr[1] = name;
			
			vals.add(sArr);
			
			year = scanner.nextInt();
		}
		
		Collections.sort(vals, new Comparator<String[]>()
		{

			@Override
			public int compare(String[] arg0, String[] arg1)
			{
				int i1 = Integer.parseInt(arg0[0]);
				int i2 = Integer.parseInt(arg1[0]);
				return Integer.compare(i1, i2);
			}
		});
		
		String[] cur = vals.get(0);
		int startYear = Integer.parseInt(cur[0]);
		int endYear = startYear;
		int curCount = 1;
		String curName = cur[1];
		int maxYear = startYear;
		int maxCount = curCount;
		String maxName = curName;
		int maxEYear = startYear;
		
		for(int i = 1; i < vals.size(); i++)
		{
			cur = vals.get(i);
			
			if(curName.equals(cur[1]))
			{
				curCount++;
				if(curCount >= maxCount)
				{
					maxYear = startYear;
					maxCount = curCount;
					maxName = curName;
					maxEYear = Integer.parseInt(cur[0]);
				}
			}
			else
			{
				
				
				startYear = Integer.parseInt(cur[0]);
				curCount = 1;
				curName = cur[1];
			}
		}
		
		System.out.println(maxCount + " " + maxYear + " " + maxEYear + " " + maxName);
	}
}
