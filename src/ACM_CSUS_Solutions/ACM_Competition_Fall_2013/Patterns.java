import java.util.Scanner;


public class p1
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String n1 = scanner.next();
		String n2 = scanner.next();
		String n3 = scanner.next();
		String n4 = scanner.next();
		String n5 = scanner.next();
		
		char[] a1 = {n1.charAt(0),n1.charAt(1),n1.charAt(2),n1.charAt(3),n1.charAt(4)};
		char[] a2 = {n2.charAt(0),n2.charAt(1),n2.charAt(2),n2.charAt(3),n2.charAt(4)};
		char[] a3 = {n3.charAt(0),n3.charAt(1),n3.charAt(2),n3.charAt(3),n3.charAt(4)};
		char[] a4 = {n4.charAt(0),n4.charAt(1),n4.charAt(2),n4.charAt(3),n4.charAt(4)};
		char[] a5 = {n5.charAt(0),n5.charAt(1),n5.charAt(2),n5.charAt(3),n5.charAt(4)};
		
		char[][] a = {a1,a2,a3,a4,a5};
		
		for(int i = 0;i<5;i++)
		{
			for(int j = 0;j<5;j++)
			{
				System.out.print(a[i][j]);
			}
			for(int j = 4;j>=0;j--)
			{
				System.out.print(a[i][j]);
			}
			System.out.println("");
		}
		for(int i = 4;i>=0;i--)
		{
			for(int j = 0;j<5;j++)
			{
				System.out.print(a[i][j]);
			}
			for(int j = 4;j>=0;j--)
			{
				System.out.print(a[i][j]);
			}
			System.out.println("");
		}
		
		scanner.close();
	}

}
