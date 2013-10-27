import java.util.ArrayList;
import java.util.Scanner;


public class pfinal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		ArrayList<String> known = new ArrayList<String>();
		known.add(number+"");
		// twos
		int tmp, numLoops;
		do{
			 tmp = number-1;
			 numLoops = 1;
			if (tmp + numLoops== number){
				known.add(tmp+"+"+numLoops);
			}
			numLoops++;
			tmp--;
		}while(tmp > numLoops);
		for(String string: known){
			System.out.println(string);
		}

	}

}
