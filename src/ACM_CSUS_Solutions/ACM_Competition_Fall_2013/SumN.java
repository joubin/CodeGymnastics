import java.util.Scanner;


public class SumN 
{
	private static int num;
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		num = scanner.nextInt();
		
		for(int i = 1; i < num/2; i++)
		{
			recursiveCall(i + "", i + 1, i);
		}
		
		System.out.println(num);
	}
	
	private static void recursiveCall(String curString, int curNum, int currentVal)
	{
		if(currentVal == num)
		{
			System.out.println(curString);
			return;
		}
		
		for(int i = curNum; i < num; i++)
		{
			String nextString = curString + " + " + i;
			int val = currentVal + i;
			if(val > num)
			{
				break;
			}
			recursiveCall(nextString, (i + 1), val);
		}
	}
}
