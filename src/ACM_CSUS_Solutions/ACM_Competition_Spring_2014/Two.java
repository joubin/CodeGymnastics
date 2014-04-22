import java.util.ArrayList;
import java.util.Scanner;


public class Two {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int runs = Integer.parseInt(s.next());
		
		ArrayList inputList = new ArrayList();
		int max = 0;
		for (int i =0; i < runs; i++){
			String string;
			int number;
			number = s.nextInt();
			string = s.next();
			
			ArrayList temp = new ArrayList();
			temp.add(number);
			temp.add(string);
			
			if(max < number)
				max = number;
			inputList.add(temp);
		
		}
		for(int i = 0; i<runs; i++){
			int num = (int) ((ArrayList) inputList.get(i)).get(0);
			for(int j = 0; j<max - num; j++){
				System.out.print(" ");
			}
			
			for(int m = 0; m<num;m++){
				System.out.print("*");
			}
			String name = (String) ((ArrayList) inputList.get(i)).get(1);
			System.out.print(" " + name + "\n");
		}
	}

}
