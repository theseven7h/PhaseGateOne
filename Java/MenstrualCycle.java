import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenstrualCycle {
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static LocalDate getNextCycleDate(String date, int days) {
		LocalDate next = LocalDate.parse(date, fmt).plusDays(days);
		return next;
	}
	
	public static LocalDate getOvulationDate(String date, int days) {
		LocalDate od = getNextCycleDate("25/05/2025", 28).minusDays(14);
		return od;
	}
	
	public static void main(String[] args) {
		DateTimeFormatter output = DateTimeFormatter.ofPattern("d MMMM, y");
		String date = "25/05/2025";
		LocalDate lcd = LocalDate.parse(date, fmt);
		
		System.out.println("Last cycle started on: " + lcd.format(output));
		System.out.println("Expect next period on: " + getNextCycleDate("25/05/2025", 28).format(output));
		System.out.println("Expected ovulation: " + getOvulationDate("25/05/2025", 28).format(output));
	}
}