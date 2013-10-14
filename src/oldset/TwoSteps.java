/*
CSUS Spring 2013 programming competition
Problem: #3
The problem set can be found on my github page
@Author: Joubin Jabbari
@myPage: github.com/joubin
 */
import java.util.Scanner;
import java.util.ArrayList; 
import static java.lang.Math.*;

public class TwoSteps {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String str = in.nextLine();
		//System.out.println(str);

		stepCounter(str);

	}
	public static void stepCounter(String str){
		String[] parts = str.split(" ");
		//System.out.println(parts.length);   
		int a[];
		ArrayList<Integer> myArr = new ArrayList<Integer>();
		for (int i = 0; i < parts.length; ++i) {
			if (i%2==0) {
				if(parts[i].startsWith("+")){
					parts[i] = parts[i].replace("+", "0");
				}
				myArr.add(abs(Integer.parseInt(parts[i])));

			}else{
				if(parts[i].startsWith("+")){
					parts[i] = parts[i].replace("+", "0");
				}
				myArr.add(abs(Integer.parseInt(parts[i]))*-1);
				
			}
			
		}
		int total = 0;
		int i= 0;
		for( int n: myArr){
			// System.out.println(n);
			total += n;
		}
		System.out.println("Total is " +total);

	}

}