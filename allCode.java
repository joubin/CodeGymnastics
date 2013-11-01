./cheat_sheets/CodeSnippets.java
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;


public class CodeSnippets 
{
	private static void arraySorting()
	{
		// sort 2d array on second column
		int[][] testing = {{1, 5}, {2, 3}, {2, 4}, {3, 5}, {5, 5}};
		Arrays.sort(testing, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] o1, int[] o2) 
			{
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		// reverse order of sort, by default lowest to highest
		Integer[] intArr = new Integer[]{1, 2, 5, 12, 9};
		Arrays.sort(intArr, new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2) 
			{
				return -Integer.compare(o1, o2);
			}	
		});
	}
	
	private static void arrayListSorting()
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		
		// make it into an array, then sort
		Integer[] intArr = ints.toArray(new Integer[ints.size()]);
		Arrays.sort(intArr, new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2) 
			{
				return Integer.compare(o1, o2);
			}
		});
		
		// sort it as a collection
		Collections.sort(ints, new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2)
			{
				return Integer.compare(o1, o2);
			}
		});
	}
	
	private static void readFile()
	{	
		// read text file with scanner
		File file = new File("file_path");
		Scanner scanner = null;
		try 
		{
			scanner = new Scanner(file);
			// can specify the encoding of file
			// scanner = new Scanner(file, StandardCharsets.US_ASCII.name());
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("cannot find file.");
			System.exit(0);
		}
		
		// read text file with BufferedReader
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader("file_path"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("cannot find file.");
			System.exit(0);
		}
		
		// read binary file
		BufferedInputStream bis = null;
		try 
		{
			bis = new BufferedInputStream(new FileInputStream(file));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("cannot find file.");
			System.exit(0);
		}
		byte[] bArr = new byte[(int)file.length()];
		try 
		{
			// byteArray, offset, numberOfBytes
			bis.read(bArr, 0, bArr.length);
		} 
		catch (IOException e) 
		{
			System.out.println("Failed to read file.");
			System.exit(0);
		}
	}
	
	private static void scannerAndStringMethods()
	{
		//SCANNER STUFF
		Scanner scanner = new Scanner("car ds.insh");
		// change delimiters
		scanner.useDelimiter(Pattern.compile("\\p{Space}"));
		
		// TOKENIZER
		StringTokenizer tokenizer = new StringTokenizer("string", "delims");
		
		// STRING STUFF
		String s = scanner.next();
		// boolean contains
		s.contains("charSequence");
		// first index of a, from char at 0 inclusive
		s.indexOf('a', 0);
		s.lastIndexOf('a', 0);
		// find and replace all
		s.replace("oldChar", "newChar");
		s.replaceFirst("regex", "replacement");
		// boolean if it matches the regular expression
		s.matches("regex");
		// parse int from string
		Integer.parseInt(s);
	}
	
	private static void manipulatingNumbers()
	{
		//format
		/*
		 * 0 = digit
		 * # = digit, ignore 0
		 * E = scientific notation, "#0.##E0" -> 12345 = 12.3E3 
		 * % = mult by 100, prefix %
		 * ' =  "'#'#" | "# o''clock"
		 */
		float f = 23.9013f;
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		String numberFormatted = df.format(f); // 23.90
		
		//round
		int i = 12897;
		i = (i*1000)/1000;
		
		//scale number from one range to another
		float targetMax = 1;
		float targetMin = 0;
		float origMax = 255;
		float origMin = 0;
		float value = 178;
		float answer = (value/(origMax - origMin) * (targetMax - targetMin)) + targetMin;
		
		// reverse a number (1892 -> 2981)
		int number = 1892;
		int reverse = 0;
		int temp = number;
		int rem = 0;
		while(temp > 0)
		{
			rem = temp%10;
			temp -= rem;
			temp /= 10;
			reverse *= 10;
			reverse += rem;
		}
		
		// number of digits
		int num = 12354521;
		int temp1 = num;
		int digits = 0;
		while(temp1 >= 1)
		{
			temp1 /= 10;
			digits++;
		}
		
		// concatenate two numbers (24 + 45 -> 2445)
		int num1 = 24;
		int num2 = 45;
		int answer1 = num1;
		int numDigits2 = 2;
		answer1 *= Math.pow(10, numDigits2);
		answer1 += num2;
	}
}
./cheat_sheets/UsefulMethods.java
import java.util.ArrayList;


public class UsefulMethods 
{	
	private static boolean isPalindrome(int number)
	{
		int reverse = 0;
		int temp = number;
		int rem = 0;
		
		while(temp > 0)
		{
			rem = temp%10;
			temp -= rem;
			temp /= 10;
			reverse *= 10;
			reverse += rem;
		}
		
		return reverse == number;
	}
	
	/**
	 * returns an ArrayList containing all of the prime numbers up
	 * to and including n.
	 */
	private static ArrayList<Integer> primeNumbers(int n)
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		boolean[] arr = new boolean[n + 1];
		if(n > 1)
		{
			for(int i = 2; i <= n; i++)
			{
				arr[i] = true;
			}
			
			for(int i = 2; i <= Math.sqrt(n); i++)
			{
				for(int j = (int) Math.pow(i, 2); j <= n; j += i)
				{
					arr[j] = false;
				}
			}
		}
		
		for(int i = 2; i <= n; i++)
		{
			if(arr[i] == true)
			{
				al.add(i);
			}
		}
		
		return al;
	}
	
	private static boolean isPrime(int n)
	{		
		if(n%2 == 0 && n != 2)
		{
			return false;
		}
		for(int i = 3; i <= Math.sqrt(n); i += 2)
		{
			if(n%i == 0)
			{
				return false;
			}
		}
		
		return true;
	}
}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2012/CardCounter.java
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
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2012/ChangeForADollar.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ChangeForADollar 
{
	private static int combos;
	private static int[] vals;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		File file = new File("change.in");
		Scanner scanner = null;
		try 
		{
			scanner = new Scanner(file);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("cannot find file.");
			System.exit(0);
		}
		
		int n = scanner.nextInt();
		int[] res = new int[n];
		
		for(; n > 0; n--)
		{
			combos = 0;
			int change = scanner.nextInt();
			int nVals = scanner.nextInt();
			vals = new int[nVals];
			
			for(int i = 0; i < vals.length; i++)
			{
				vals[i] = scanner.nextInt();
			}
			
			recursiveCall(change, nVals - 1);
			
			res[res.length - n] = combos;
		}
		
		for(int i : res)
		{
			System.out.println(i);
		}
	}
	
	private static void recursiveCall(int curChange, int valIndex)
	{
		if(curChange == 0)
		{
			combos++;
		}
		
		if(valIndex > -1 && curChange > 0)
		{
			int num = curChange/vals[valIndex];
			
			for(int i = num; i >= 0; i--)
			{
				recursiveCall(curChange - (i * vals[valIndex]), valIndex - 1);
			}
		}
	}
}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2012/InIt.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class InIt
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		HashMap<Character, Integer> points = new HashMap<Character, Integer>();
		points.put('A', 1);
		points.put('B', 3);
		points.put('C', 3);
		points.put('D', 2);
		points.put('E', 1);
		points.put('F', 4);
		points.put('G', 2);
		points.put('H', 4);
		points.put('I', 1);
		points.put('J', 8);
		points.put('K', 5);
		points.put('L', 1);
		points.put('M', 3);
		points.put('N', 1);
		points.put('O', 1);
		points.put('P', 3);
		points.put('Q', 10);
		points.put('R', 1);
		points.put('S', 1);
		points.put('T', 1);
		points.put('U', 1);
		points.put('V', 4);
		points.put('W', 4);
		points.put('X', 8);
		points.put('Y', 4);
		points.put('Z', 10);
		points.put('_', 0);
		
		File file = new File("init.in");
		Scanner scanner = null;
		try 
		{
			scanner = new Scanner(file);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("cannot find file.");
			System.exit(0);
		}
		
		int n = scanner.nextInt();
		int[] res = new int[n];
		for(; n > 0; n--)
		{
			String letters = scanner.next();
			String append = "";
			while(letters.contains("_"))
			{
				letters = letters.replaceFirst("_", "");
				append += "_";
			}
			letters += append;
			
			String word = scanner.next();
			ArrayList<Integer> charUsed = new ArrayList<Integer>();
			
			for(int i = 0; i < word.length(); i++)
			{
				char c = word.charAt(i);
				boolean init = false;
				
				for(int j = 0; j < letters.length(); j++)
				{
					if(!charUsed.contains(j))
					{
						if(letters.charAt(j) == c || letters.charAt(j) == '_')
						{
							charUsed.add(j);
							init = true;
							res[res.length - n] += points.get(letters.charAt(j));
							break;
						}
					}
				}
				
				if(!init)
				{
					res[res.length - n] = 0;
					break;
				}
			}
		}
		
		for(int i : res)
		{
			System.out.println(i);
		}
	}
}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2012/LetsGetCritical.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




public class LetsGetCritical
{
	private static ArrayList<ArrayList<Integer>> map;
	private static ArrayList<Integer> path;
	private static boolean pathFound;
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{		
		File file = new File("critical.in");
		Scanner scanner = null;
		try 
		{
			scanner = new Scanner(file);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("cannot find file.");
			System.exit(0);
		}
		
		int n = scanner.nextInt();
		
		for(; n > 0; n--)
		{ 
			int offices = scanner.nextInt();
			int connections = scanner.nextInt();
			map = new ArrayList<ArrayList<Integer>>(offices + 1);
			pathFound = false;
			
			for(int i = 0; i < offices + 1; i++)
			{
				map.add(new ArrayList<Integer>());
			}
			
			for(int i = 0; i < connections; i++)
			{
				int office1 = scanner.nextInt();
				int office2 = scanner.nextInt();
				
				map.get(office1).add(office2);
				map.get(office2).add(office1);
			}
			
			i:
			for(int i = 1; i <= offices; i++)
			{
				for(int j = 1; j <= offices; j++)
				{
					if(i != j)
					{
						pathFound = false;
						path = new ArrayList<Integer>();
						findPath(0, i, j);
						if(!pathFound)
						{
							break i;
						}
					}
				}
			}
			
			if(pathFound)
			{
				ArrayList<Integer> crits = new ArrayList<Integer>();
				for(int i = 1; i <= offices; i++)
				{
					j:
					for(int j = 1; j <= offices; j++)
					{
						if(j != i)
						{
							for(int k = 1; k <= offices; k++)
							{
								if(k != i && k != j)
								{
									pathFound = false;
									path = new ArrayList<Integer>();
									findPath(i, j, k);
									if(!pathFound)
									{
										crits.add(i);
										break j;
									}
								}
							}
						}
					}
				}
				
				if(crits.size() == 0)
				{
					System.out.println(0);
				}
				else
				{
					for(Integer i : crits)
					{
						System.out.print(i + " ");
					}
					System.out.print("\n");
				}
			}
			else
			{
				System.out.println(-1);
			}
		}
	}
	
	private static void findPath(int ignore, int from, int to)
	{
		if(from == to)
		{
			pathFound = true;
			return;
		}
		
		ArrayList<Integer> dest = map.get(from);
		path.add(from);
		for(Integer i : dest)
		{
			if(i != ignore && !path.contains(i))
			{
				path.add(i);
				findPath(ignore, i, to);
			}
		}
	}
}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2012/Main.java
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
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2012/ParallelPlotting.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ParallelPlotting 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		File file = new File("pplot.in");
		Scanner scanner = null;
		try 
		{
			scanner = new Scanner(file);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("cannot find file.");
			System.exit(0);
		}
		
		int n = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 0; i < n; i++)
		{
			String line = scanner.nextLine();
			Scanner scan = new Scanner(line);
			
			ArrayList<Integer> ints = new ArrayList<Integer>();
			while(scan.hasNext())
			{
				ints.add(scan.nextInt());
			}
			
			int max = 0;
			int length = 0;
			for(Integer integer : ints)
			{
				if(integer > max)
				{
					max = integer;
				}
				
				length += integer;
			}
			
			length += ints.size() - 1;
			max += max - 1;
			
			char[][] array = new char[max][length];
			for(int j = 0; j < array.length; j++)
			{
				for(int k = 0; k < array[0].length; k++)
				{
					array[j][k] = ' ';
				}
			}
			
			int hIndex = max - 1;
			int lIndex = 0;
			for(Integer integer : ints)
			{
				if(integer%2 == 0)
				{
					for(int j = integer; j > 0; j--)
					{
						for(int k = 0; k < integer; k++)
						{
							array[hIndex][lIndex + k] = '*';
						}
						
						hIndex -= 2;
					}
				}
				else
				{
					for(int j = integer; j > 0; j--)
					{
						for(int k = 0; k < j; k++)
						{
							array[hIndex][lIndex + k] = '*';
						}
						
						hIndex -= 2;
					}
				}
				
				lIndex += integer + 1;
				hIndex = max - 1;
			}
			
			for(int j = 0; j < array.length; j++)
			{
				for(int k = 0; k < array[0].length; k++)
				{
					System.out.print(array[j][k]);
				}
				System.out.print("\n");
			}
			
			System.out.println("\n");
		}
	}
}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2012/PlaceHolder.java
package ACM_Competitions.ACM_Competition_Fall_2012;

/**
 * Created with IntelliJ IDEA.
 * User: joubin
 * Date: 10/17/13
 * Time: 1:04 PM
 */
public class PlaceHolder {
}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2012/StopTheAliens.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class StopTheAliens 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		File file = new File("stopthealiens.in");
		Scanner scanner = null;
		try 
		{
			scanner = new Scanner(file);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("cannot find file.");
			System.exit(0);
		}
		
		int n = scanner.nextInt();
		scanner.nextLine();
		int[] res = new int[n];
		
		for(; n > 0; n--)
		{
			String line = scanner.nextLine();
			Scanner scan = new Scanner(line);
			String num = scan.next();
			
			int index1 = scan.nextInt();
			int value = Integer.parseInt(num.charAt(num.length() - index1) + "");
			while(scan.hasNext())
			{
				char operation = scan.next().charAt(0);
				int index2 = scan.nextInt();
				
				switch(operation)
				{
					case '+': value += Integer.parseInt(num.charAt(num.length() - index2) + "");
						break;
					case '-': value -= Integer.parseInt(num.charAt(num.length() - index2) + "");
						break;
					case '*': value *= Integer.parseInt(num.charAt(num.length() - index2) + "");
						break;
					case '/': value /= Integer.parseInt(num.charAt(num.length() - index2) + "");
						break;
					case '^': value = (int) Math.pow(value, Integer.parseInt(num.charAt(num.length() - index2) + ""));					
						break;
				}
			}
			
			res[res.length - n] = value;
		}
		
		for(int i : res)
		{
			System.out.println(i);
		}
	}
}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2012/TWOlympics.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;


public class TWOlympics 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		HashMap<Integer, String> intCountries = new HashMap<Integer, String>();
		intCountries.put(1, "Leafland");
		intCountries.put(2, "Manchewia");
		intCountries.put(3, "Branchia");
		intCountries.put(4, "Greenland");
		intCountries.put(5, "Pulpica");
		
		File file = new File("worms.in");
		Scanner scanner = null;
		try 
		{
			scanner = new Scanner(file);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("cannot find file.");
			System.exit(0);
		}
		
		int i;
		ArrayList<int[]> wInfo = new ArrayList<int[]>();
		int[][] cInfo = new int[5][2];
		for(int j = 0; j < cInfo.length; j++)
		{
			cInfo[j][0] = j + 1;
		}
		
		while(scanner.hasNext())
		{
			i = scanner.nextInt();
			
			if(i < 0)
			{
				if(i == -999)
				{
					break;
				}
			}
			else
			{
				int wNum = scanner.nextInt();
				int oz = scanner.nextInt();
				boolean old = false;
				for(int j = 0; j < wInfo.size(); j++)
				{
					if(wInfo.get(j)[0] == wNum)
					{
						wInfo.get(j)[1] += oz;
						old = true;
						break;
					}
				}
				if(!old)
				{
					wInfo.add(new int[]{wNum, oz});
				}
				
				cInfo[i - 1][1] += oz;
			}
		}
		
		Arrays.sort(cInfo, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] arg0, int[] arg1) 
			{
				return -Integer.compare(arg0[1], arg1[1]);
			}	
		});
		
		System.out.println("Team Green medal: " + cInfo[0][0] + " " +
				intCountries.get(cInfo[0][0]) + " " + 
				cInfo[0][1] + " oz");
		System.out.println("Team Red medal:   " + cInfo[1][0] + " " +
				intCountries.get(cInfo[1][0]) + " " + 
				cInfo[1][1] + " oz");
		System.out.println("Team Brown medal: " + cInfo[2][0] + " " +
				intCountries.get(cInfo[2][0]) + " " + 
				cInfo[2][1] + " oz");
		
		int[][] wArr = new int[wInfo.size()][];
		wInfo.toArray(wArr);
		Arrays.sort(wArr, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] arg0, int[] arg1) 
			{
				return -Integer.compare(arg0[1], arg1[1]);
			}	
		});
		
		System.out.println("Worm Green medal: " + wArr[0][0] + " " + 
				wArr[0][1] + " oz");
		System.out.println("Worm Red medal:   " + wArr[1][0] + " " + 
				wArr[1][1] + " oz");
		System.out.println("Worm Brown medal: " + wArr[2][0] + " " + 
				wArr[2][1] + " oz");
	}
}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2013/Darts.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class p3 
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<String[]> vals = new ArrayList<String[]>();
		String name = "";
		int year = scanner.nextInt();
		
		while(year != 0)
		{
			String[] sArr = new String[2];
			name = scanner.next();
			
			sArr[0] = year + "";
			sArr[1] = name;
			
			vals.add(sArr);
			
			year = scanner.nextInt();
		}
		
		Collections.sort(vals, new Comparator<String[]>()
		{

			@Override
			public int compare(String[] arg0, String[] arg1)
			{
				int i1 = Integer.parseInt(arg0[0]);
				int i2 = Integer.parseInt(arg1[0]);
				return Integer.compare(i1, i2);
			}
		});
		
		String[] cur = vals.get(0);
		int startYear = Integer.parseInt(cur[0]);
		int endYear = startYear;
		int curCount = 1;
		String curName = cur[1];
		int maxYear = startYear;
		int maxCount = curCount;
		String maxName = curName;
		int maxEYear = startYear;
		
		for(int i = 1; i < vals.size(); i++)
		{
			cur = vals.get(i);
			
			if(curName.equals(cur[1]))
			{
				curCount++;
				if(curCount >= maxCount)
				{
					maxYear = startYear;
					maxCount = curCount;
					maxName = curName;
					maxEYear = Integer.parseInt(cur[0]);
				}
			}
			else
			{
				
				
				startYear = Integer.parseInt(cur[0]);
				curCount = 1;
				curName = cur[1];
			}
		}
		
		System.out.println(maxCount + " " + maxYear + " " + maxEYear + " " + maxName);
	}
}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2013/Genome.java
import java.util.Scanner;


public class p4 {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String n = scanner.next();
		int lengh = n.length();
		
		for(int r = 1;r<5;r++)
		{
			for(int l = 1;l<=lengh;l++)
			{
				if(l==1)
				{
					if(r==1);
					else
					{
						if(n.charAt(0) != 'T' || r==2)System.out.print("|");
						else System.out.print(" ");
					}
				}
				row(r,n.charAt(l-1));
				if(l<lengh)
				{
					if(r==1);else
					if((n.charAt(l-1)!='T' && n.charAt(l)!='T') || (n.charAt(l-1)=='T' && n.charAt(l)=='T' && r==2) || (n.charAt(l-1)!='T' || n.charAt(l)!='T'))
					{
						System.out.print("|");
					}else System.out.print(" ");
				}
				if(l==lengh)
				{
					if(r==1);
					else
					{
						if(n.charAt(0) != 'T' || r==2)System.out.print("|");
					}
				}
			}
			System.out.println("");
		}
		
		
		
		
		scanner.close();
	}
	
	private static void row(int row, char c)
	{
		switch(row)
		{
		case 1:
			System.out.print(" _____");
			break;
		case 2:
			switch(c)
			{
			case 'A':
				System.out.print("  _  ");
				break;
			case 'C':
				System.out.print("     ");
				break;
			case 'G':
				System.out.print("   __");
				break;
			case 'T':
				System.out.print("_   _");
				break;
			}
			break;
		case 3:
			switch(c)
			{
			case 'A':
				System.out.print("     ");
				break;
			case 'C':
				System.out.print("   --");
				break;
			case 'G':
				System.out.print("  |  ");
				break;
			case 'T':
				System.out.print(" | | ");
				break;
			}
			break;
		case 4:
			switch(c)
			{
			case 'A':
				System.out.print("__|__");
				break;
			case 'C':
				System.out.print("_____");
				break;
			case 'G':
				System.out.print("_____");
				break;
			case 'T':
				System.out.print(" |_| ");
				break;
			}
			break;
		}
	}
}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2013/KnightMove.java
import java.util.ArrayList;
import java.util.Scanner;


public class p6 {

	public static void main(String[] args) 
	{
		ArrayList<int[]> arr0 = new ArrayList<int[]>();
		ArrayList<int[]> arr1 = new ArrayList<int[]>();
		ArrayList<int[]> arr2 = new ArrayList<int[]>();
		
		Scanner scanner = new Scanner(System.in);
		
		int[][] board = new int[8][8];
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[0].length; j++)
			{
				board[i][j] = 0;
			}
		}
		
		int col = scanner.nextInt() - 1;
		int row = scanner.nextInt() - 1;
		board[row][col] = 1;
		findMoves(arr0, row, col);
		
		for(int i = 0; i < arr0.size(); i++)
		{
			int[] newPos = arr0.get(i);
			board[newPos[1]][newPos[0]] = 1;
			findMoves(arr1, newPos[1], newPos[0]);
			
			for(int j = 0; j < arr1.size(); j++)
			{
				int[] newPos1 = arr1.get(j);
				board[newPos1[1]][newPos1[0]] = 1;
				findMoves(arr2, newPos1[1], newPos1[0]);
				
				for(int k = 0; k < arr2.size(); k++)
				{
					int[] newPos2 = arr2.get(k);
					board[newPos2[1]][newPos2[0]] = 1;
				}
			}
		}
		
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[0].length; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	private static void findMoves(ArrayList<int[]> al, int row, int col)
	{
		al.clear();
		if(col - 2 >= 0)
		{
			if(row - 1 >= 0)
			{
				int[] pos = {col - 2, row - 1};// h 2 v 11
				al.add(pos);
			}
			
			if(row + 1 <= 7)
			{
				int[] pos = {col - 2, row + 1};
				al.add(pos);
			}
		}
		
		if(col + 2 <= 7)
		{
			if(row - 1 >= 0)
			{
				int[] pos = {col + 2, row - 1};
				al.add(pos);
			}
			
			if(row + 1 <= 7)
			{
				int[] pos = {col + 2, row + 1};
				al.add(pos);
			}
		}
		
		if(row - 2 >= 0)
		{
			if(col - 1 >= 0)
			{
				int[] pos = {col - 1, row - 2};
				al.add(pos);
			}
			
			if(col + 1 <= 7)
			{
				int[] pos = {col + 1, row - 2};
				al.add(pos);
			}
		}
		
		if(row + 2 <= 7)
		{
			if(col - 1 >= 0)
			{
				int[] pos = {col - 1, row + 2};
				al.add(pos);
			}
			
			if(col + 1 <= 7)
			{
				int[] pos = {col + 1, row + 2};
				al.add(pos);
			}
		}
	}
}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2013/MorshtCode.java
import java.util.ArrayList;
import java.util.Scanner;


public class p2 {
	public static void main(String[] args){

	ArrayList<Character> array = new ArrayList<Character>();
	array.add(null);
	array.add('A');
	array.add('B');
	array.add('C');
	array.add('D');
	array.add('E');
	array.add('F');
	array.add('G');
	array.add('H');
	array.add('I');
	array.add('J');
	array.add('K');
	array.add('L');
	array.add('M');
	array.add('N');
	array.add('O');
	array.add('P');
	array.add('Q');
	array.add('R');
	array.add('S');
	array.add('T');
	array.add('U');
	array.add('V');
	array.add('W');
	array.add('X');
	array.add('Y');
	array.add('Z');
	Scanner s = new Scanner(System.in);
	char test = s.next().charAt(0);
	while(test != '$'){
		int t = array.indexOf(test);
		for(int i = 0; i < t; i++){
			System.out.print('*');
		}
		System.out.print('\n');
		test = s.next().charAt(0);
}
	
}
}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2013/Patterns.java
import java.util.Scanner;


public class p1
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String n1 = scanner.next();
		String n2 = scanner.next();
		String n3 = scanner.next();
		String n4 = scanner.next();
		String n5 = scanner.next();
		
		char[] a1 = {n1.charAt(0),n1.charAt(1),n1.charAt(2),n1.charAt(3),n1.charAt(4)};
		char[] a2 = {n2.charAt(0),n2.charAt(1),n2.charAt(2),n2.charAt(3),n2.charAt(4)};
		char[] a3 = {n3.charAt(0),n3.charAt(1),n3.charAt(2),n3.charAt(3),n3.charAt(4)};
		char[] a4 = {n4.charAt(0),n4.charAt(1),n4.charAt(2),n4.charAt(3),n4.charAt(4)};
		char[] a5 = {n5.charAt(0),n5.charAt(1),n5.charAt(2),n5.charAt(3),n5.charAt(4)};
		
		char[][] a = {a1,a2,a3,a4,a5};
		
		for(int i = 0;i<5;i++)
		{
			for(int j = 0;j<5;j++)
			{
				System.out.print(a[i][j]);
			}
			for(int j = 4;j>=0;j--)
			{
				System.out.print(a[i][j]);
			}
			System.out.println("");
		}
		for(int i = 4;i>=0;i--)
		{
			for(int j = 0;j<5;j++)
			{
				System.out.print(a[i][j]);
			}
			for(int j = 4;j>=0;j--)
			{
				System.out.print(a[i][j]);
			}
			System.out.println("");
		}
		
		scanner.close();
	}

}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2013/PcostickMoon.java
import java.util.ArrayList;
import java.util.Scanner;


public class p5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int distance = s.nextInt() + 1;
		int numRobots = s.nextInt();
		int[][] robots = new int[numRobots][2];
		int[] distances = new int[distance];
		for(int i = 0; i < numRobots; i++){
			robots[i][0] = s.nextInt();
			robots[i][1] = s.nextInt();
		}
		for(int i = 0; i < distance; i++ ){
			distances[i] = 0;
		}
		
		
		for(int i = 0; i < numRobots; i++){
			//go
			for(int j =0; j < distance; j= j + robots[i][0]){
				distances[j] += 1* robots[i][1];
			}
			// come back
			for(int j =distance - 1; j >= 0; j= j - robots[i][0]){
				distances[j] += 1* robots[i][1];
			}
			
		}
		
		distances[0] = 0;
		distances[distance - 1] = 0;
		
		//get max distance and number of times
		ArrayList<Integer> distancesArrayList = new ArrayList<Integer>();
		for(int i = 0; i < distances.length; i++){
			distancesArrayList.add(distances[i]);
		}
		int max = 0;
		for(int i = 0; i < distances.length; i++){
			if (distances[i] >= max){
				max = distances[i];
			}
		}	
		
		int first = distancesArrayList.indexOf(max);
		
		int count = 0;
		for(int i = 0; i < distances.length; i++){
			if(distances[i] == max){
				count++;
			}
		}
		if(max == 0){
			System.out.print("None.");
		}else
		if(count == 1){
			System.out.print("Weak spot at "+first+" feet, landed "+max+" times.");
		}else
		System.out.print("Weak spot at "+first+" feet, landed "+max+" times, "+ (count - 1)+" more place(s).");
		

	}

}

./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2013/pfinal.java
import java.util.ArrayList;
import java.util.Scanner;


public class pfinal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		ArrayList<String> known = new ArrayList<String>();
		known.add(number+"");
		// twos
		int tmp, numLoops;
		do{
			 tmp = number-1;
			 numLoops = 1;
			if (tmp + numLoops== number){
				known.add(tmp+"+"+numLoops);
			}
			numLoops++;
			tmp--;
		}while(tmp > numLoops);
		for(String string: known){
			System.out.println(string);
		}

	}

}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2013/SumN.java
import java.util.Scanner;


public class SumN 
{
	private static int num;
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		num = scanner.nextInt();
		
		for(int i = 1; i < num/2; i++)
		{
			recursiveCall(i + "", i + 1, i);
		}
		
		System.out.println(num);
	}
	
	private static void recursiveCall(String curString, int curNum, int currentVal)
	{
		if(currentVal == num)
		{
			System.out.println(curString);
			return;
		}
		
		for(int i = curNum; i < num; i++)
		{
			String nextString = curString + " + " + i;
			int val = currentVal + i;
			if(val > num)
			{
				break;
			}
			recursiveCall(nextString, (i + 1), val);
		}
	}
}
./src/ACM_CSUS_Solutions/ACM_Competition_Fall_2013/SumNBad.java
import java.util.ArrayList;
import java.util.Scanner;


public class p8 {

	private static ArrayList<ArrayList<Integer>> master = new ArrayList<ArrayList<Integer>>();
	private static int pointer = 0;
	private static int N;
	
	public static void main(String[] args)
	{
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		
		master.add(new ArrayList<Integer>());
		getTotal(N);
		
		//print out array lists
		
		scanner.close();
	}
	
	private static void getTotal(int n)
	{
		master.get(pointer).add(n);
		if(getSum(master.get(pointer))==N)
		{
			
		}
	}
	
	private static int getSum(ArrayList<Integer> a)
	{
		int total = 0;
		for(int i = 0;i<a.size();i++)
		{
			total += a.get(i);
		}
		return total;
	}
}
./src/ACM_CSUS_Solutions/ACM_Competition_Spring_2013/A.java
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
./src/ACM_CSUS_Solutions/ACM_Competition_Spring_2013/B.java
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
./src/ACM_CSUS_Solutions/ACM_Competition_Spring_2013/C.java
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

./src/ACM_CSUS_Solutions/ACM_Competition_Spring_2013/D.java
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
./src/ACM_CSUS_Solutions/ACM_Competition_Spring_2013/E.java
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
./src/ACM_CSUS_Solutions/ACM_Competition_Spring_2013/F.java
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
./src/ACM_CSUS_Solutions/ACM_Competition_Spring_2013/G.java
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
./src/ACM_CSUS_Solutions/ACM_Competition_Spring_2013/Main.java
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
./src/Random_Practice/TwoSteps.java
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
				if(parts[i].startsWith("")){
					parts[i] = parts[i].replace("", "0");
				}
				myArr.add(abs(Integer.parseInt(parts[i])));

			}else{
				if(parts[i].startsWith("")){
					parts[i] = parts[i].replace("", "0");
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
		System.out.println("" +total);

	}

}