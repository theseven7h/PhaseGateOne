import java.util.Scanner;

public class TaskEight {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int validNumberCount = 0;
		int scoresSum = 0;
		
		while(true) {
			System.out.print("Enter a score between 1-100: ");
			int score = sc.nextInt();
			if(score < 0 || score > 100) {
				System.out.println("Invalid score! Try again");
				continue;
			}
			scoresSum += score;
			if(++validNumberCount == 10) break;	
		}	
		System.out.println("Sum of the ten valid scores is " + scoresSum);
	}
}