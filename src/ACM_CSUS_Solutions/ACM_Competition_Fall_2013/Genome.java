import java.util.Scanner;


public class p4 {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String n = scanner.next();
		int lengh = n.length();
		
		for(int r = 1;r<5;r++)
		{
			for(int l = 1;l<=lengh;l++)
			{
				if(l==1)
				{
					if(r==1);
					else
					{
						if(n.charAt(0) != 'T' || r==2)System.out.print("|");
						else System.out.print(" ");
					}
				}
				row(r,n.charAt(l-1));
				if(l<lengh)
				{
					if(r==1);else
					if((n.charAt(l-1)!='T' && n.charAt(l)!='T') || (n.charAt(l-1)=='T' && n.charAt(l)=='T' && r==2) || (n.charAt(l-1)!='T' || n.charAt(l)!='T'))
					{
						System.out.print("|");
					}else System.out.print(" ");
				}
				if(l==lengh)
				{
					if(r==1);
					else
					{
						if(n.charAt(0) != 'T' || r==2)System.out.print("|");
					}
				}
			}
			System.out.println("");
		}
		
		
		
		
		scanner.close();
	}
	
	private static void row(int row, char c)
	{
		switch(row)
		{
		case 1:
			System.out.print(" _____");
			break;
		case 2:
			switch(c)
			{
			case 'A':
				System.out.print("  _  ");
				break;
			case 'C':
				System.out.print("     ");
				break;
			case 'G':
				System.out.print("   __");
				break;
			case 'T':
				System.out.print("_   _");
				break;
			}
			break;
		case 3:
			switch(c)
			{
			case 'A':
				System.out.print("     ");
				break;
			case 'C':
				System.out.print("   --");
				break;
			case 'G':
				System.out.print("  |  ");
				break;
			case 'T':
				System.out.print(" | | ");
				break;
			}
			break;
		case 4:
			switch(c)
			{
			case 'A':
				System.out.print("__|__");
				break;
			case 'C':
				System.out.print("_____");
				break;
			case 'G':
				System.out.print("_____");
				break;
			case 'T':
				System.out.print(" |_| ");
				break;
			}
			break;
		}
	}
}
