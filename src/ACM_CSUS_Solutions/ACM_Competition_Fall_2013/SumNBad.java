import java.util.ArrayList;
import java.util.Scanner;


public class p8 {

	private static ArrayList<ArrayList<Integer>> master = new ArrayList<ArrayList<Integer>>();
	private static int pointer = 0;
	private static int N;
	
	public static void main(String[] args)
	{
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		
		master.add(new ArrayList<Integer>());
		getTotal(N);
		
		//print out array lists
		
		scanner.close();
	}
	
	private static void getTotal(int n)
	{
		master.get(pointer).add(n);
		if(getSum(master.get(pointer))==N)
		{
			
		}
	}
	
	private static int getSum(ArrayList<Integer> a)
	{
		int total = 0;
		for(int i = 0;i<a.size();i++)
		{
			total += a.get(i);
		}
		return total;
	}
}
