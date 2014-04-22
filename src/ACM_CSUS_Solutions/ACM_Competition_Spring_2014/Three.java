import java.util.ArrayList;
import java.util.Scanner;


public class Three {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int feet = s.nextInt();
		int teams = s.nextInt();
		int members = s.nextInt();
		ArrayList something = new ArrayList();
		for(int j = 0; j<teams; j++){
			for(int i = 0; i<members; i++){
				int[] str = {s.nextInt(), s.nextInt()};
				something.add(str);
			}
		}
		ArrayList cycles = new ArrayList();
		for(int i = 0; i<teams; i++){
			cycles.add(s.nextInt());
		}
		int second = 0;
		int[] teamDist = new int[teams];
		for(int i = 0; i<teams; i++){
			teamDist[i] = 0;
		}
		boolean notDone = true;
		while(notDone){
			second++;

			for(int j = 0; j<teams; j++){
				for(int i = 0; i<members; i++){
					if(second % (int)cycles.get(j) == 0){
						int[] array = (int[]) something.get(j*members+i);
						int str = array[0];
						
//						int str = (String[])something.get(j)[i];
						int bio = array[1];
						int rat = second % bio;
						if(rat == 0){
							teamDist[j] += str;
						}else{
							teamDist[j] += (rat * str) / bio;
						}
						if(teamDist[j] >= feet){
							notDone = false;
							int a = j+1;
							System.out.println("Team " + a + " wins! After " + second + " seconds.");
							return;
						}
					}
				}
			}
		}
	}

}
