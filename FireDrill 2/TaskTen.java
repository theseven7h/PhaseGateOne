import java.util.Scanner;

public class TaskTen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int scoresSum = 0;
		int validCount = 0;
		for(int i = 0; i < 10; i++) {
			System.out.print("Enter a score between 1-100: ");
			int score = sc.nextInt();
			if(!(score < 0 || score > 100)) {
				scoresSum += score;
				validCount++;
			}
		}	
		System.out.println("Average of valid scores is " + (double)scoresSum / validCount);
	}
}