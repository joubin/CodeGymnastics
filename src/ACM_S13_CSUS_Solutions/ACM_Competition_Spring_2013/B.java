package ACM_Competition_Spring_2013.ACM_Competition_Spring_2013;

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
