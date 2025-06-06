import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenstrualCycle {
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static LocalDate getNextCycleDate(String input, int days) {
		LocalDate od = LocalDate.parse(input, fmt).plusDays(days);
		return od;
	}
	
	public static void main(String[] args) {
		DateTimeFormatter output = DateTimeFormatter.ofPattern("d MMMM, y");
		System.out.print(getNextCycleDate("25/05/2025", 28).format(output));
	}
}