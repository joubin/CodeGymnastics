import java.util.ArrayList;
import java.util.Scanner;


public class p6 {

	public static void main(String[] args) 
	{
		ArrayList<int[]> arr0 = new ArrayList<int[]>();
		ArrayList<int[]> arr1 = new ArrayList<int[]>();
		ArrayList<int[]> arr2 = new ArrayList<int[]>();
		
		Scanner scanner = new Scanner(System.in);
		
		int[][] board = new int[8][8];
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[0].length; j++)
			{
				board[i][j] = 0;
			}
		}
		
		int col = scanner.nextInt() - 1;
		int row = scanner.nextInt() - 1;
		board[row][col] = 1;
		findMoves(arr0, row, col);
		
		for(int i = 0; i < arr0.size(); i++)
		{
			int[] newPos = arr0.get(i);
			board[newPos[1]][newPos[0]] = 1;
			findMoves(arr1, newPos[1], newPos[0]);
			
			for(int j = 0; j < arr1.size(); j++)
			{
				int[] newPos1 = arr1.get(j);
				board[newPos1[1]][newPos1[0]] = 1;
				findMoves(arr2, newPos1[1], newPos1[0]);
				
				for(int k = 0; k < arr2.size(); k++)
				{
					int[] newPos2 = arr2.get(k);
					board[newPos2[1]][newPos2[0]] = 1;
				}
			}
		}
		
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[0].length; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	private static void findMoves(ArrayList<int[]> al, int row, int col)
	{
		al.clear();
		if(col - 2 >= 0)
		{
			if(row - 1 >= 0)
			{
				int[] pos = {col - 2, row - 1};// h 2 v 11
				al.add(pos);
			}
			
			if(row + 1 <= 7)
			{
				int[] pos = {col - 2, row + 1};
				al.add(pos);
			}
		}
		
		if(col + 2 <= 7)
		{
			if(row - 1 >= 0)
			{
				int[] pos = {col + 2, row - 1};
				al.add(pos);
			}
			
			if(row + 1 <= 7)
			{
				int[] pos = {col + 2, row + 1};
				al.add(pos);
			}
		}
		
		if(row - 2 >= 0)
		{
			if(col - 1 >= 0)
			{
				int[] pos = {col - 1, row - 2};
				al.add(pos);
			}
			
			if(col + 1 <= 7)
			{
				int[] pos = {col + 1, row - 2};
				al.add(pos);
			}
		}
		
		if(row + 2 <= 7)
		{
			if(col - 1 >= 0)
			{
				int[] pos = {col - 1, row + 2};
				al.add(pos);
			}
			
			if(col + 1 <= 7)
			{
				int[] pos = {col + 1, row + 2};
				al.add(pos);
			}
		}
	}
}
