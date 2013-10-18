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

