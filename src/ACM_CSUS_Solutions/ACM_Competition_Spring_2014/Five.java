import java.util.Scanner;


public class Five {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int celVal[][] = new int[size][size];
		int maxVal[][] = new int[size][size];
		for(int i = 0; i<size*size; i++ ){
			int col = i%size;
			int row = i/size;
			celVal[row][col] = s.nextInt();
		}
		for(int i = 0; i<size*size; i++ ){
			int col = i%size;
			int row = i/size;
			maxVal[row][col] = 0;
		}
		int left = 0;
		int top = 0;
		maxVal[0][0] = celVal[0][0];
		for(int i = 1; i<size*size; i++ ){
			int col = i%size;
			int row = i/size;
			
			if(col!=0) left = maxVal[row][col-1];
			else left = 0;
			
			if(row!=0) top = maxVal[row-1][col];
			else top = 0;
			

			if(celVal[row][col] == -1){
				maxVal[row][col] = -1;
			}else {
				if(maxVal[row][col] <= celVal[row][col] + left)
					maxVal[row][col] = celVal[row][col] + left;
				
				if(maxVal[row][col] <= celVal[row][col] + top)
					maxVal[row][col] = celVal[row][col] + top;
			}
		}
		
		System.out.println(maxVal[size-1][size-1]);
	}

}
