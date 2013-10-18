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
