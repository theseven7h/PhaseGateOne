import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class MenstrualCycle {
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static LocalDate getNextCycleDate(String date, int days) {
		LocalDate next = LocalDate.parse(date, fmt).plusDays(days);
		return next;
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
		DateTimeFormatter output = DateTimeFormatter.ofPattern("d MMMM, y");
		String date = "25/05/2025";
		LocalDate lcd = LocalDate.parse(date, fmt);
			
		System.out.println("Last cycle date: " + lcd.format(output));
		System.out.println("Expected next cycle: " + getNextCycleDate("25/05/2025", 28).format(output));
		System.out.println("Expected ovulation: " + getOvulationDate("25/05/2025", 28).format(output));
		
		
		System.out.println("Expected fertile window: " + getFertileWindow("25/05/2025", 28)[0].format(output) + " to " + getFertileWindow("25/05/2025", 28)[1].format(output));
		
		System.out.println("Expected safe period: " + getSafePeriod("25/05/2025", 28)[0][0].format(output) + " to " + getSafePeriod("25/05/2025", 28)[0][1].format(output) + " and " + getSafePeriod("25/05/2025", 28)[1][0].format(output) + " to " + getSafePeriod("25/05/2025", 28)[1][1].format(output));
	}
	
	
}