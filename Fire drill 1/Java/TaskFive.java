public class TaskFive {
	public static void main(String[] args) {
		for(int num = 1; num <= 10; num++) {
			if(num % 4 == 0) {
				for(int count = 1; count <= 5; count++) {
					System.out.print(num);
				}
				System.out.print(" ");
			}
		}
	}
}
