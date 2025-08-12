import java.util.Scanner;

public class TaskSix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int evenSum = 0;
		int evenCount = 0;
		for(int i = 1; i <= 10; i++) {
			System.out.print("Enter number " + i + ": ");
			int number = sc.nextInt();
			if(number % 2 == 0) {
				evenSum += number;
				evenCount++;
			}
		}
		System.out.println("Average of even scores is " + (double)evenSum / evenCount);
	}
}