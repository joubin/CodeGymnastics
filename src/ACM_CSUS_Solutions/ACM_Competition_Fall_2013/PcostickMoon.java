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

