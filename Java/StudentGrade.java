import java.util.Scanner;
import java.util.Arrays;

public class StudentGrade {
	public static int getTotal(int[] studentScores) {
		int total = 0;
		for(int i = 0; i < studentScores.length; i++) {
			total += studentScores[i];
		}
		return total;	
	}
	
	public static double getAverage(int[] studentScores) {
		return (double)getTotal(studentScores) / studentScores.length;
	}	
	
	public static int[] getPositions(double[] average) {
		int[] positions = new int[average.length];
		for(int i = average.length - 1; i >= 0; i--) {
			int count = 0;
			for(int j = average.length - 1; j >= 0; j--) {
				if(average[j] > average[i] || ((average[j] == average[i]) && positions[j] == positions[i]))
					count++;
			}
			positions[i] = count;
		}
		return positions;
	}
	
	public static void displayDetails(int[] total, double[] average, int[] positions, int[][] studentScores) {
		String border = "";
		for(int bdr = 1; bdr <= (36 + (studentScores[0].length * 10)); bdr++) border += "=";
		
		System.out.println(border);
		
		
		System.out.printf("%9s","STUDENT");
		for(int i = 0; i < studentScores[0].length; i++) {
			System.out.printf("%9s%d", "SUB", i + 1);
		}
		
		System.out.printf("%10s%11s%6s%n", "TOT", "AVE", "POS");
		System.out.println(border);
		
		for(int j = 0; j < studentScores.length; j++) {
			System.out.printf("%7s %d",  "Student", j + 1);
			for(int k = 0; k < studentScores[0].length; k++) {
				System.out.printf("%10d", studentScores[j][k]);
			}
			System.out.printf("%10d%11.2f%6d", total[j], average[j], positions[j]);
			System.out.println();
		}
		System.out.println(border);
	}
	
	public static int[] getHighestScores(int[][] studentScores) {
		int[] highestScores = new int[studentScores[0].length];
		for(int i = 0; i < studentScores[0].length; i++) {
			highestScores[i] = studentScores[0][i];
			for(int j = 1; j < studentScores.length; j++) {
				if(studentScores[j][i] > highestScores[i]) highestScores[i] = studentScores[j][i];
			}
		}
		return highestScores;	
	}
	
	public static int[] getLowestScores(int[][] studentScores) {
		int[] lowestScores = new int[studentScores[0].length];
		for(int i = 0; i < studentScores[0].length; i++) {
			lowestScores[i] = studentScores[0][i];
			for(int j = 1; j < studentScores.length; j++) {
				if(studentScores[j][i] < lowestScores[i]) lowestScores[i] = studentScores[j][i];
			}
		}
		return lowestScores;	
	}
	
	public static int[] getSubjectTotal(int[][] studentScores) {
		int totals[] = new int[studentScores[0].length];
		for(int i = 0; i < studentScores[0].length; i++) {
			for(int j = 0; j < studentScores.length; j++) {
				totals[i] += studentScores[j][i];
			}
		}
		return totals;
	}
	
	//public static void displaySubjectSummary() {}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int [][] studentScores;
	
		while(true) {
			while(true) {
				System.out.print("Enter number of students\n--> ");
				String studentsEntry = sc.next().trim();
				System.out.println();
				
				System.out.print("Enter number of subjects\n--> ");
				String subjectsEntry = sc.next().trim();
				System.out.println();
				 
				try {
					int students = Integer.parseInt(studentsEntry);
					int subjects = Integer.parseInt(subjectsEntry);
					studentScores = new int[students][subjects];
					break;
				} catch(Exception e) {
					System.out.println("Wrong inputs, try again!");
					System.out.println();
				}
			}
				
			String border = "";
			for(int bdr = 0; bdr <= 35; bdr++) border += "=";
						
			for(int stu = 0; stu < studentScores.length; stu++) {
				for(int sub = 0; sub < studentScores[0].length; sub++) {
					System.out.println();
					while(true) {
						System.out.println(border);
						System.out.println("Entering score for student " + (stu + 1) + "...");
						System.out.print("Enter score for subject " + (sub + 1) + ", (0 - 100)" + "\n--> ");
						String scoreEntry = sc.next().trim();
						try {
							if(Integer.parseInt(scoreEntry) < 0 || Integer.parseInt(scoreEntry) > 100) {
								System.out.println("Invalid... between 0 - 100 only!");
								System.out.println(border);
								System.out.println();
								continue;
							}
							studentScores[stu][sub] = Integer.parseInt(scoreEntry);
							System.out.println("...saved successfully.");
							System.out.println(border);
							break;
						} catch(Exception e) {
							System.out.println("Wrong input, enter a number!");
							System.out.println(border);
							System.out.println();
						}
					}
					
				}
			}
			
			int[] total = new int[studentScores.length];
			double[] average = new double[studentScores.length];
			for(int i = 0; i < studentScores.length; i++) {
				total[i] = getTotal(studentScores[i]);
				average[i] = getAverage(studentScores[i]);
			}
			int[] positions = getPositions(average);
			System.out.println();
			
			while(true) {
				try {
					System.out.print("Enter 1 to see scores table\n--> ");
					int ready = sc.nextInt();
					if(ready != 1) {
						System.out.println("Invalid! Enter 1...");
						continue;
					}
					System.out.println();
					break;
				} catch(Exception e) {
					System.out.println("Invalid! Enter 1...");
					System.out.println();
					sc.nextLine();
				}
			}
			displayDetails(total, average, positions, studentScores);
			
			break;
		}
	}
}