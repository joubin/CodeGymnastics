./ACM_Competition_Fall_2012/CardCounter.java
package ACM_Competitions.ACM_Competition_Fall_2012;

import java.io.*;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: joubin
 * Date: 10/17/13
 * Time: 5:09 PM
 */
public class CardCounter {
    String [] cards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "0", "J", "Q", "K"};
    private BufferedReader bufferedReader = null;
    private File file = null;
    private HashMap<String, Integer> cardsDictionary = new HashMap<String, Integer>();
    public CardCounter() throws IOException {
        for (String s: cards){
            cardsDictionary.put(s, 0);
        }

        List<String> list = new ArrayList<String>();
        String path = URLDecoder.decode(CardCounter.class.getResource("cards.in").getPath());

        File file = new File(path);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while (!((text = reader.readLine()).equals("E"))) {
                try{cardsDictionary.put(text, cardsDictionary.get(text)+1);}catch (NullPointerException n){cardsDictionary.put(text, 1);}
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }

        for(String k : cards){
            System.out.println(cardsDictionary.get(k)+" "+ k);

        }

    }
}
./ACM_Competition_Fall_2012/Main.java
package ACM_Competitions.ACM_Competition_Fall_2012;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: joubin
 * Date: 10/17/13
 * Time: 5:30 PM
 */
public class Main {
    public static void main(String[] args) throws IOException {
        CardCounter cc = new CardCounter();
        System.out.println("ASD");


    }
}
./ACM_Competition_Fall_2012/PlaceHolder.java
package ACM_Competitions.ACM_Competition_Fall_2012;

/**
 * Created with IntelliJ IDEA.
 * User: joubin
 * Date: 10/17/13
 * Time: 1:04 PM
 */
public class PlaceHolder {
}
./ACM_Competition_Spring_2013/A.java
package ACM_Competitions.ACM_Competition_Spring_2013;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: joubin
 * Date: 10/13/13
 * Time: 4:34 PM
 */
public class A {
    public A() {
        Scanner s = new Scanner(System.in);
        int numInputs = s.nextInt();
        int odds = 0, evens = 0;
        for (int i = 0; i < numInputs; ++i){
            if((s.nextInt()%2) == 0){
                evens += 1;
            }else {
                odds +=1;
            }
        }

        System.out.println("" + odds);
        System.out.println("" + evens);
        System.out.print("");
        if (evens > odds) {
            System.out.print("");
        }else System.out.println("");

    }
}
./ACM_Competition_Spring_2013/B.java
package ACM_Competitions.ACM_Competition_Spring_2013;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: joubin
 * Date: 10/13/13
 * Time: 4:41 PM
 */
public class B {
    public B() {
        Scanner s = new Scanner(System.in);
        int numInputs = s.nextInt();
        for (int i = 0; i < numInputs; ++i){
            int a = s.nextInt();
            int b = s.nextInt();
            int total = a +b;
            if (isNotPlanadrom(""+total) && isNotPlanadrom(""+a) && isNotPlanadrom(""+b)){
                System.out.println(total);
            }else System.out.println("");

        }
    }

    public boolean isNotPlanadrom(String input){
        int i = 0, j = input.length()-1;
        while (i < j){
            if (input.charAt(i) != input.charAt(j)){
                i += 1;
                j -=1;
            }else{
                return false;
            }
        }
        return true;
    }

}
./ACM_Competition_Spring_2013/C.java
package ACM_Competitions.ACM_Competition_Spring_2013;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: joubin
 * Date: 10/13/13
 * Time: 4:58 PM
 */
public class C {
    public C() {

        int total = 0;

        Scanner s = new Scanner(System.in);
        int numberOfInputs = s.nextInt();
        for(int i = 0; i <numberOfInputs; i++){
            int numOfTimes = s.nextInt();
            int numOfPattern = s.nextInt();
            int []p = new int[numOfPattern];
            for (int k = 0; k < numOfPattern; k++){
                p[k] = s.nextInt();
            }
            for (int x = 0; x < numOfTimes; x++){
                total += p[x%numOfPattern];
            }
        }
        System.out.println(total);
    }
}

./ACM_Competition_Spring_2013/D.java
package ACM_Competitions.ACM_Competition_Spring_2013;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: joubin
 * Date: 10/13/13
 * Time: 3:06 PM
 */
public class D {
    public D() {
        Scanner s = new Scanner(System.in);

        String f = s.nextLine();
        String [] mainArray;

        int numArrays = Integer.parseInt(f);
        mainArray = new String[numArrays];

        for (int i = 0; i < numArrays; ++i){
            String tmp = s.nextLine();
            int matrixSize = tmp.length();
            String [] tmpArray = new String[matrixSize];
            tmpArray[0] = tmp;
            System.out.println(matrixSize);

            for(int x = 1; x < matrixSize; ++x){
                System.out.println(x);
                tmp = s.nextLine();
                tmpArray[x] = tmp;
            }


        }

    }

    public boolean isTranspose(String [] input){
        for (int i = 0; i < input.length; ++i){
            for (int j = 0; j < input.length; ++j){
                if(input[i].charAt(j) == input[j].charAt(i)){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;

    }
}
./ACM_Competition_Spring_2013/E.java
package ACM_Competitions.ACM_Competition_Spring_2013;

import java.util.Scanner;


public class E 
{
	public E()
	{
		starter();
	}
	
	public void starter() 
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String res = "";
		
		for(; n > 0; n--)
		{
			res += scanner.next() + " ";
			int speed = scanner.nextInt();
			int spin = scanner.nextInt();
			
			int dist = speed + spin;
			int distTemp = 0;
			int time = 0;
			do
			{
				dist += distTemp;
				distTemp = 0;
				speed -= 3;
				if(spin != 0)
				{
					spin += ((spin * -1)/Math.abs(spin));
				}
				distTemp += Math.max(speed, 0) + spin;
				time++;
			}
			while(distTemp > 0);
			
			res += dist + " ";
			res += time + " ";
			
			int lag;
			if(dist > 10)
			{
				lag = dist%20;
			}
			else
			{
				lag = 10 + (10 - dist);
			}
			
			res += lag;			
			
			res += "\n";
		}
		
		System.out.println(res);
	}
}
./ACM_Competition_Spring_2013/F.java
package ACM_Competitions.ACM_Competition_Spring_2013;

import java.util.Scanner;

public class F
{
    private Scanner k = new Scanner(System.in);
    private int numSquares;
    private int numSpaces;

    public F()
    {
        start();
    }

    private void start()
    {
        numSquares = k.nextInt();
        numSpaces = k.nextInt();

        int width = 2*(numSquares-1)*(numSpaces+1)+1;

        for(int j = 1;j<=numSquares-1;j++)
        {
            printBefore(j-1);
            printAsterisks(width-((j-1)*(numSpaces+1)*2));
            printAfter(j-1);
            System.out.println("");
            for(int k = 1;k<=numSpaces;k++)
            {
                printBefore(j);
                printSpaces(width-j*(numSpaces+1)*2);
                printAfter(j);
                System.out.println("");
            }
        }

        printBefore(numSquares-1);
        printAsterisks(1);
        printAfter(numSquares-1);
        System.out.println("");

        for(int j = numSquares-1;j>=1;j--)
        {
            for(int k = 1;k<=numSpaces;k++)
            {
                printBefore(j);
                printSpaces(width-j*(numSpaces+1)*2);
                printAfter(j);
                System.out.println("");
            }
            printBefore(j-1);
            printAsterisks(width-((j-1)*(numSpaces+1)*2));
            printAfter(j-1);
            System.out.println("");
        }

    }

    private void printAsterisks(int x)
    {
        for(int i = 1;i<=x;i++)
        {
            System.out.print("");
        }
    }

    private void printSpaces(int x)
    {
        for(int i = 1;i<=x;i++)
        {
            System.out.print(" ");
        }
    }

    private void printBefore(int x)
    {
        for(int j = 1;j<=x;j++)
        {
            System.out.print("");
            for(int i = 1;i<=numSpaces;i++)
            {
                System.out.print(" ");
            }
        }
    }

    private void printAfter(int x)
    {
        for(int j = 1;j<=x;j++)
        {
            for(int i = 1;i<=numSpaces;i++)
            {
                System.out.print(" ");
            }
            System.out.print("");
        }
    }
}
./ACM_Competition_Spring_2013/G.java
package ACM_Competitions.ACM_Competition_Spring_2013;

import java.util.Scanner;


public class G 
{
	public G()
	{
		starter();
	}
	
	public void starter()
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] res = new String[n];
		
		float y;
		float l;
		float p;
		for(; n > 0; n--)
		{
			y = scanner.nextFloat();
			l = scanner.nextFloat();
			p = scanner.nextFloat();
			
			res[res.length - n] = expCDF(y, l) + " ";
			res[res.length - n] += geomCDF(y, p);
		}
		
		for(String s : res)
		{
			System.out.println(s);
		}
	}
	
	private static float expCDF(float y, float l)
	{
		return (float) (Math.log(-y + 1)/(-l));
	}
	
	private static int geomCDF(float y, float p)
	{
		return (int) Math.max(Math.ceil((Math.log(-y + 1)/Math.log(1 - p) - 1)), 0);
	}
}
./ACM_Competition_Spring_2013/Main.java
package ACM_Competitions.ACM_Competition_Spring_2013;

/**
 * Created with IntelliJ IDEA.
 * User: joubin
 * Date: 10/13/13
 * Time: 2:44 PM
 */
public class Main {
    public static void main(String[] args) {
        A aDemo = new A();
//        B bDemo = new B();
//        C cDemo = new C();
//        D dDemo = new D();
//        f fDemo = new f();
    }
}
