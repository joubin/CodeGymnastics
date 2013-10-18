package ACM_Competitions.ACM_Competition_Spring_2013;

import java.util.Scanner;


public class E 
{
	public E()
	{
		starter();
	}
	
	public void starter() 
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String res = "";
		
		for(; n > 0; n--)
		{
			res += scanner.next() + " ";
			int speed = scanner.nextInt();
			int spin = scanner.nextInt();
			
			int dist = speed + spin;
			int distTemp = 0;
			int time = 0;
			do
			{
				dist += distTemp;
				distTemp = 0;
				speed -= 3;
				if(spin != 0)
				{
					spin += ((spin * -1)/Math.abs(spin));
				}
				distTemp += Math.max(speed, 0) + spin;
				time++;
			}
			while(distTemp > 0);
			
			res += dist + " ";
			res += time + " ";
			
			int lag;
			if(dist > 10)
			{
				lag = dist%20;
			}
			else
			{
				lag = 10 + (10 - dist);
			}
			
			res += lag;			
			
			res += "\n";
		}
		
		System.out.println(res);
	}
}
