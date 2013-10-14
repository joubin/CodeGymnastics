package testset;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: joubin
 * Date: 10/13/13
 * Time: 3:46 PM
 */
public class f {
    public f() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> mainArray = new ArrayList<String>();
        int numSquares = 4 ;//scanner.nextInt();
        int numSpaces = 2 ;//scanner.nextInt();
        int totalWidth = (((numSquares-1)*(numSpaces+1))*2)+1;
        String mainString = "";
        for (int i = 0; i <= totalWidth; ++i){
            mainString += ' ';
        }
        System.out.println("|"+mainString+"|");
        StringBuilder mainStringB = new StringBuilder(mainString);
        for (int i = 0; i < totalWidth; i=i+2){
            System.out.println(mainStringB);
            mainStringB.setCharAt(i, '*');
        }
    }
}
