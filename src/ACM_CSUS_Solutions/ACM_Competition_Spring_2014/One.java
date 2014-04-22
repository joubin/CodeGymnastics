import java.util.ArrayList;
import java.util.Scanner;


public class One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int runs = Integer.parseInt(s.next());
		ArrayList<String> inputList = new ArrayList();
		for (int i =0; i < runs; i++){
			inputList.add(s.next());
		}
		int even = 0;
		int odd = 0;
		for(Object o : inputList){
			Integer myYear = Integer.parseInt(o.toString());
			if (myYear % 2 ==0){
				even++;
			}else{
				odd++;
			}
		}
		System.out.println("Number of odds: "+odd);
		System.out.println("Number of evens: "+even);
		if(even> odd)
			System.out.println("The winner is Joe.");
		else
			System.out.println("The winner is Sarah.");

	}
}
