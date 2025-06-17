public class TaskEight {
	public static void main(String[] args) {
		int sum = 0;
		for(int num = 1; num <= 10; num++) {
			if(num % 4 == 0) {
				
				for(int count = 1; count <= 5; count++) {
					sum += (int)Math.pow(num, count);
				}
				
			}
		}
		System.out.print(sum + " ");
	}
}

