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
	
	/*public static LocalDate getSafePeriodStart(String date, int days) {
		LocalDate sps = getFertileWindowBefore(date, days).minusDays(1);
		return sps;
	}
	
	public static LocalDate getSafePeriodEnd(String date, int days) {
		LocalDate spe = getFertileWindowAfter(date, days).plusDays(1);
		return spe;
	}*/
	
	
	
	
	
	
	
	public static void main(String[] args) {
		DateTimeFormatter output = DateTimeFormatter.ofPattern("d MMMM, y");
		String date = "25/05/2025";
		LocalDate lcd = LocalDate.parse(date, fmt);
		
		
		
		System.out.println("Last cycle date: " + lcd.format(output));
		System.out.println("Expected next cycle: " + getNextCycleDate("25/05/2025", 28).format(output));
		System.out.println("Expected ovulation: " + getOvulationDate("25/05/2025", 28).format(output));
		
		
		System.out.println("Expected fertile window: " + getFertileWindow("25/05/2025", 28)[0].format(output) + " to " + getFertileWindow("25/05/2025", 28)[1].format(output));
	}
}