import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenstrualCycle {
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static LocalDate getNextCycleDate(String date, int days) {
		LocalDate next = LocalDate.parse(date, fmt).plusDays(days);
		return next;
	}
	
	public static LocalDate[] getFlowDates(LocalDate lcd) {
		return new LocalDate[]{lcd, lcd.plusDays(5)};
	}
	
	public static LocalDate getOvulationDate(String date, int days) {
		LocalDate od = getNextCycleDate(date, days).minusDays(14);
		return od;
	}
	
	public static LocalDate[] getFertileWindow(String date, int days) {
		LocalDate fwb = getOvulationDate(date, days).minusDays(5);
		LocalDate fwa = getOvulationDate(date, days).plusDays(1);
		return new LocalDate[]{fwb,fwa};
	}
	
	public static LocalDate[][] getSafePeriod(String date, int days) {
		LocalDate lastCycle = LocalDate.parse(date, fmt);
		LocalDate[] safePeriod = getFertileWindow(date, days);
		LocalDate nextCycle = getNextCycleDate(date, days);
		return new LocalDate[][] {{lastCycle, safePeriod[0].minusDays(1)},{safePeriod[1].plusDays(1), nextCycle}};
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter output = DateTimeFormatter.ofPattern("d MMMM, y");
		while(true) {
			System.out.print("Enter your last period date (dd/mm/yyyy): ");
			String date = sc.next().trim();
			
			try {
				LocalDate lcd = LocalDate.parse(date, fmt);
				if(lcd.isAfter(LocalDate.now()) || lcd.plusMonths(1).isBefore(LocalDate.now())) {
					System.out.println("Date has to be within the last month");
					continue;
				}
				System.out.println();
					
				System.out.println("Last cycle date: " + lcd.format(output));
				System.out.println("Expected next flow dates: " + getFlowDates(lcd)[0].format(output) + " to " + getFlowDates(lcd)[1].format(output));
				System.out.println("Expected ovulation: " + getOvulationDate(date, 28).format(output));
				System.out.println("Expected fertile window: " + getFertileWindow(date, 28)[0].format(output) + " to " + getFertileWindow("25/05/2025", 28)[1].format(output));
				System.out.println("Expected safe period: " + getSafePeriod(date, 28)[0][0].format(output) + " to " + getSafePeriod(date, 28)[0][1].format(output) + " and " + getSafePeriod(date, 28)[1][0].format(output) + " to " + getSafePeriod(date, 28)[1][1].format(output));
				break;
			} catch(Exception e) {
				System.out.println("Invalid date format... Try again!");
				continue;
			}
		}
	}	
}