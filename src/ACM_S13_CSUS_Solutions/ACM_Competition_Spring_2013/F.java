package ACM_Competition_Spring_2013.ACM_Competition_Spring_2013;

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
