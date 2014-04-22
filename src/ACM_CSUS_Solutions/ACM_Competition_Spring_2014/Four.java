import java.util.Scanner;


public class Four {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int gamecount = s.nextInt();
		int finalnumb = 0;
		
		for(int a = 0; a < gamecount; a++){
			int pos = 0;
			int n = s.nextInt();
			int k = s.nextInt();
			
			int[] list = new int[n];
			for(int i = n; i != 0; i--){
				int x = 0;
				
				while(x != k){
					if(list[pos] == 0){
						x++;
					}
					pos++;
					if(pos == n)
						pos = 0;
				}
				if(i != 1){
				if(pos != 0){
					list [pos-1] = 1;
				}
				else
					list[n-1] = 1;
				}
			}
			for(int l = 0; l<n; l++){
				if(list[l] == 0){
					finalnumb = l+1;
					l = n;
				}
			}
			System.out.println("Go to position " + finalnumb);
		}
		

	}

}
