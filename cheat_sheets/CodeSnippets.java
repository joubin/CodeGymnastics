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
