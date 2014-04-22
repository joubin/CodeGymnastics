import java.util.Scanner;


public class Test { 

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()){
			int a = s.nextInt();
			int c = a;
			int orginal = a;
			int b = 0;
			if(c == 0)
				System.exit(0);
			while (a !=1){
				if(a <= 1){
					b += a;
					a++;
				}
				else{
					b += a;
					a--;
				}
				
			}
			b+=1;
			
			System.out.println("N = "+ c+"\tSum = " + b );
			System.out.println();
			
			
		}

	}

}
