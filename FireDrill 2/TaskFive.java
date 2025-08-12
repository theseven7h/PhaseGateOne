import java.util.Scanner;

public class TaskFive {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int evenSum = 0;
		
		for(int i = 1; i <= 10; i++) {
			System.out.print("Enter number " + i + ": ");
			int number = sc.nextInt();
			if(number % 2 == 0) evenSum += number;
		}
		System.out.println("Sum of even scores is " + evenSum);
	}
}