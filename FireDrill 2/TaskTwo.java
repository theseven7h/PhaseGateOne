import java.util.Scanner;

public class TaskTwo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			System.out.print("Enter number " + i + ": ");
			sum += sc.nextInt();
		} 
		System.out.println("Average is " + sum / 10);
	}
}