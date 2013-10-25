import java.util.ArrayList;


public class UsefulMethods 
{	
	private static boolean isPalindrome(int number)
	{
		int reverse = 0;
		int temp = number;
		int rem = 0;
		
		while(temp > 0)
		{
			rem = temp%10;
			temp -= rem;
			temp /= 10;
			reverse *= 10;
			reverse += rem;
		}
		
		return reverse == number;
	}
	
	/**
	 * returns an ArrayList containing all of the prime numbers up
	 * to and including n.
	 */
	private static ArrayList<Integer> primeNumbers(int n)
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		boolean[] arr = new boolean[n + 1];
		if(n > 1)
		{
			for(int i = 2; i <= n; i++)
			{
				arr[i] = true;
			}
			
			for(int i = 2; i < Math.sqrt(n); i++)
			{
				for(int j = (int) Math.pow(i, 2); j <= n; j += i)
				{
					arr[j] = false;
				}
			}
		}
		
		for(int i = 2; i <= n; i++)
		{
			if(arr[i] == true)
			{
				al.add(i);
			}
		}
		
		return al;
	}
}
