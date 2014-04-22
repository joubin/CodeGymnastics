import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Plane {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String inputa = s.nextLine();
		String[] input = inputa.split(" ");
		int run = Integer.parseInt(input[1]);
		ArrayList<String[]> pairs = new ArrayList();
		for(int i = 0; i < run; i++){
			pairs.add(s.nextLine().split(" "));
		}
		
		ArrayList<String> possible = new ArrayList();
		
		int pos = 0;
		possible.add(input[0]);
		while(pos != possible.size()){
			String comp = possible.get(pos);
			for(int i = 0; i < run; i++){
				if(comp.compareTo(pairs.get(i)[0])==0){
					boolean in = false;
					for(String l: possible){
						if(l.compareTo(pairs.get(i)[1])==0)
							in = true;
					}
					if(!in){
						possible.add(pairs.get(i)[1]);
					}
				}
				if(comp.compareTo(pairs.get(i)[1])==0){
					boolean in = false;
					for(String l: possible){
						if(l.compareTo(pairs.get(i)[0])==0)
							in = true;
					}
					if(!in){
						possible.add(pairs.get(i)[0]);
					}
				}
			}
			pos++;
		}
		possible.remove(0);
		
		ArrayList<String> sorted = new ArrayList<String>();
		String min;
		while(possible.size()>0)
		
		{
			 min = possible.get(0);

			for(String o : possible){
			if(o.compareTo(min)<0){
				min = o;
			}
		}
		sorted.add(min);
		possible.remove(min);
		}

	
		for(String something: sorted)
			System.out.println(something);

	}

}
