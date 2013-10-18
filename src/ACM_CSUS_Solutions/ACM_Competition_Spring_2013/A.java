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
