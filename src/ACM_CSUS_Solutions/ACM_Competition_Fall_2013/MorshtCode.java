import java.util.ArrayList;
import java.util.Scanner;


public class p2 {
	public static void main(String[] args){

	ArrayList<Character> array = new ArrayList<Character>();
	array.add(null);
	array.add('A');
	array.add('B');
	array.add('C');
	array.add('D');
	array.add('E');
	array.add('F');
	array.add('G');
	array.add('H');
	array.add('I');
	array.add('J');
	array.add('K');
	array.add('L');
	array.add('M');
	array.add('N');
	array.add('O');
	array.add('P');
	array.add('Q');
	array.add('R');
	array.add('S');
	array.add('T');
	array.add('U');
	array.add('V');
	array.add('W');
	array.add('X');
	array.add('Y');
	array.add('Z');
	Scanner s = new Scanner(System.in);
	char test = s.next().charAt(0);
	while(test != '$'){
		int t = array.indexOf(test);
		for(int i = 0; i < t; i++){
			System.out.print('*');
		}
		System.out.print('\n');
		test = s.next().charAt(0);
}
	
}
}
