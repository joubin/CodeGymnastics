import java.util.Scanner;


public class G 
{
	public G()
	{
		starter();
	}
	
	public void starter()
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] res = new String[n];
		
		float y;
		float l;
		float p;
		for(; n > 0; n--)
		{
			y = scanner.nextFloat();
			l = scanner.nextFloat();
			p = scanner.nextFloat();
			
			res[res.length - n] = expCDF(y, l) + " ";
			res[res.length - n] += geomCDF(y, p);
		}
		
		for(String s : res)
		{
			System.out.println(s);
		}
	}
	
	private static float expCDF(float y, float l)
	{
		return (float) (Math.log(-y + 1)/(-l));
	}
	
	private static int geomCDF(float y, float p)
	{
		return (int) Math.max(Math.ceil((Math.log(-y + 1)/Math.log(1 - p) - 1)), 0);
	}
}
