package testset;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: joubin
 * Date: 10/13/13
 * Time: 4:34 PM
 */
public class a {
    public a() {
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

        System.out.println("Number of odds: " + odds);
        System.out.println("Number of evens: " + evens);
        System.out.print("The Winner is ");
        if (evens > odds) {
            System.out.print("Joe");
        }else System.out.println("Sarah");

    }
}
