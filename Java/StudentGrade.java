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
	
	public static int[][] getHighestScores(int[][] studentScores) {
		int[] highestScores = new int[studentScores[0].length];
		int[] index = new int[studentScores[0].length];
		for(int i = 0; i < studentScores[0].length; i++) {
			highestScores[i] = studentScores[0][i];
			index[i] = 1;
			for(int j = 0; j < studentScores.length; j++) {
				if(studentScores[j][i] > highestScores[i]) {
					highestScores[i] = studentScores[j][i];
					index[i] = j + 1;
				}
			}
		}
		return new int[][]{highestScores,index};	
	}
	
	public static int[][] getLowestScores(int[][] studentScores) {
		int[] lowestScores = new int[studentScores[0].length];
		int[] index = new int[studentScores[0].length];
		for(int i = 0; i < studentScores[0].length; i++) {
			lowestScores[i] = studentScores[0][i];
			index[i] = 1;
			for(int j = 0; j < studentScores.length; j++) {
				if(studentScores[j][i] < lowestScores[i]) {
					lowestScores[i] = studentScores[j][i];
					index[i] = j + 1;
				}
			}
		}
		return new int[][]{lowestScores,index};	
	}
	
	public static int[] getSubjectTotal(int[][] studentScores) {
		int[] totals = new int[studentScores[0].length];
		for(int i = 0; i < studentScores[0].length; i++) {
			for(int j = 0; j < studentScores.length; j++) {
				totals[i] += studentScores[j][i];
			}
		}
		return totals;
	}
	
	public static double[] getSubjectAverage(int[][] studentScores) {
		int[] totals = getSubjectTotal(studentScores);
		double[] averages = new double[studentScores[0].length];
		for(int i = 0; i < studentScores[0].length; i++) {
			averages[i] = (double)totals[i] / studentScores.length;
		}
		return averages;
	}
	
	public static int[][] getPassesAndFails(int[][] studentScores) {
		int[] passes = new int[studentScores[0].length];
		int[] fails = new int[studentScores[0].length];
		for(int i = 0; i < studentScores[0].length; i++) {
			for(int j = 0; j < studentScores.length; j++) {
				if(studentScores[j][i] >= 50) passes[i]++;
				else fails[i]++;
			}
		}
		return new int[][]{passes, fails};
	}
	
	public static int[][] getHardestAndEasiest(int[][] studentScores) { 
		int[][] passesAndFails = getPassesAndFails(studentScores);
		int failures = passesAndFails[1][0];
		int hardest = 1;
		
		int passes = passesAndFails[0][0];
		int easiest = 1;
		for(int i = 1; i < passesAndFails.length; i++) {
			if(passesAndFails[1][i] > failures) {
				failures = passesAndFails[1][i]; 
				hardest = i + 1;
			}
			
			if(passesAndFails[0][i] < easiest) {
				passes = passesAndFails[0][i]; 
				easiest = i + 1;
			}
		}
		return new int[][]{{hardest, failures},{easiest, passes}};
	}
	
	public static int[][] getOverallHighestAndLowest(int[][] studentScores) {
		int overallHighest = studentScores[0][0];
		int highestStudent = 1;
		int highestSubject = 1;
		
		int overallLowest = studentScores[0][0];
		int lowestStudent = 1;
		int lowestSubject = 1;
		
		for(int i = 0; i < studentScores.length; i++) {
			for(int j = 0; j < studentScores[i].length; j++) {
				if(studentScores[i][j] > overallHighest) {
					overallHighest = studentScores[i][j];
					highestStudent = i + 1;
					highestSubject = j + 1;
				}
				
				if(studentScores[i][j] < overallLowest) {
					overallLowest = studentScores[i][j];
					lowestStudent = i + 1;
					lowestSubject = j + 1;
				}
			}
		}
		return new int[][]{{overallHighest, highestStudent, highestSubject}, {overallLowest, lowestStudent, lowestSubject}};
	}
	
	public static void displaySubjectSummary(int[][] studentScores) {
		int[][] highestScores = getHighestScores(studentScores);
		int[][] lowestScores = getLowestScores(studentScores);
		int[] subjectTotal = getSubjectTotal(studentScores);
		double[] subjectAverage = getSubjectAverage(studentScores);
		int[][] passesAndFails = getPassesAndFails(studentScores);
		
		String border = "";
		for(int i = 0; i <= 33; i++) border += "=";
		
		System.out.println(border);
		System.out.println("SUBJECT SUMMARY");
		
		for(int i = 0; i < studentScores[0].length; i++) {
			System.out.println(border);
			System.out.printf("Subject %d%n", i + 1);
			System.out.println(border);
			System.out.printf("Highest Scoring Student: Student %d%nScore: %d%n%n", highestScores[1][i], highestScores[0][i]);
			System.out.printf("Lowest Scoring Student: Student %d%nScore: %d%n%n", lowestScores[1][i], lowestScores[0][i]);
			System.out.printf("Total Score: %d%n", subjectTotal[i]);
			System.out.printf("Average Score: %.2f%n", subjectAverage[i]);
			System.out.printf("Number of Passes: %d%n", passesAndFails[0][i]);
			System.out.printf("Number of Fails: %d%n", passesAndFails[1][i]);
			System.out.println(border);
			System.out.println();
		}
		
		int[] hardest = getHardestAndEasiest(studentScores)[0];
		int[] easiest = getHardestAndEasiest(studentScores)[1];
		int[] overallHighest = getOverallHighestAndLowest(studentScores)[0];
		int[] overallLowest = getOverallHighestAndLowest(studentScores)[1];
		
		border = "";
		for(int i = 0; i <= 33; i++) border += "*";
		System.out.println(border);
		System.out.printf("Hardest Subject: Subject %d%nFailures: %d%n%n", hardest[0], hardest[1]);
		
		System.out.printf("Easiest Subject: Subject %d%nPasses: %d%n%n", easiest[0], easiest[1]);
		
		System.out.printf("Overall Highest Score: %d%nScored by Student: %d%nIn Subject %d%n%n", overallHighest[0], overallHighest[1], overallHighest[2]);
		System.out.printf("Overall Lowest Score: %d%nScored by Student: %d%nIn Subject: %d%n", overallLowest[0], overallLowest[1], overallLowest[2]);	
		System.out.println(border);
	}
	
	public static int[][] getBestAndWorstStudent(int[][] studentScores) {
		int bestStudentTotal = Integer.MIN_VALUE;
		int bestStudent = 1;
		
		int worstStudentTotal = Integer.MAX_VALUE;
		int worstStudent = 1;
		
		for(int i = 0; i < studentScores.length; i++) {
			int sum = 0;
			for(int j = 0; j < studentScores[i].length; j++) {
				sum += studentScores[i][j];
			}
			if(sum > bestStudentTotal) {
				bestStudentTotal = sum;
				bestStudent = i + 1;
			}
			
			if(sum < worstStudentTotal) {
				worstStudentTotal = sum;
				worstStudent = i + 1;
			}
		}
		return new int[][]{{bestStudent, bestStudentTotal}, {worstStudent, worstStudentTotal}};
	}
	
	public static int getClassTotal(int[][] studentScores) {
		int classTotal = 0;
		for(int i = 0; i < studentScores.length; i++) {
			classTotal += getTotal(studentScores[i]);
		}
		return classTotal;
	}
	
	public static double getClassAverage(int[][] studentScores) {
		return (double)getClassTotal(studentScores) / studentScores.length;
	}
	
	public static void displayClassSummary(int[][] studentScores) {
		int[] bestStudent = getBestAndWorstStudent(studentScores)[0];
		int[] worstStudent = getBestAndWorstStudent(studentScores)[1];
		int classTotal = getClassTotal(studentScores);
		double classAverage = getClassAverage(studentScores);
		
		String border = "";
		for(int i = 0; i <= 35; i++) border += "=";
		
		System.out.println(border);
		System.out.println("CLASS SUMMARY");
		System.out.println(border);

		
		System.out.printf("Best Graduating Student: Student %d%nScore: %d%n", bestStudent[0], bestStudent[1]);
		System.out.println(border);
		
		System.out.printf("Worst Graduating Student: Student %d%nScore: %d%n", worstStudent[0], worstStudent[1]);
		System.out.println(border);
		
		System.out.printf("Class Total Score: %d%n", classTotal);	
		System.out.printf("Class Average Score: %.2f%n", classAverage);	
		System.out.println(border);
	}

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
					System.out.print("1. Scores table\n2. Subject Summary\n3. Class SUmmary\n0.Exit\n--> ");
				
					int ready = sc.nextInt();
					System.out.println();
					switch(ready) {
						case 1: 
							displayDetails(total, average, positions, studentScores);
							while(true) {
								System.out.print("\n0. Back\n--> ");
								String back = sc.next().trim();
								try {
									if(Integer.parseInt(back) == 0) break;
									else System.out.println("Invalid...");
									continue;
								} catch(Exception e) {
									System.out.println("Invalid...");
								}
							} 
							break;
							
						case 2: 
							displaySubjectSummary(studentScores); 
							while(true) {
								System.out.print("\n0. Back\n--> ");
								String back = sc.next().trim();
								try {
									if(Integer.parseInt(back) == 0) break;
									else System.out.println("Invalid...");
									continue;
								} catch(Exception e) {
									System.out.println("Invalid...");
								}
							}
							break;
							
						case 3: 
							displayClassSummary(studentScores);
							while(true) {
								System.out.print("\n0. Back\n--> ");
								String back = sc.next().trim();
								try {
									if(Integer.parseInt(back) == 0) break;
									else System.out.println("Invalid...");
									continue;
								} catch(Exception e) {
									System.out.println("Invalid...");
								}
							}
							break;
							
						case 0: 
							System.out.println();
							System.out.println("Exiting...");
							System.exit(0);
							
						default: 
							System.out.println("Invalid! Check options...");
							System.out.println();
							continue;
					}
					System.out.println();
					
				} catch(Exception e) {
					System.out.println("Invalid! Check options...");
					System.out.println();
					sc.nextLine();
				}
			}			
		}
	}
}