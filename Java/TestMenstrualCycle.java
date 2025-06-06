import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestMenstrualCycle {

	MenstrualCycle mc = new MenstrualCycle();	
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Test
	public void testGetNextCycleDateFunctionExists() {
		LocalDate next = mc.getNextCycleDate("25/05/2025", 28);
		String actual = next.format(fmt);
	}
	
	@Test
	public void testGetNextCycleDateFunctionReturnsCorrectDay() {
		LocalDate next = mc.getNextCycleDate("25/05/2025", 28);
		String actual = next.format(fmt);
		String expected = "22/06/2025";
		assertEquals(actual, expected);
	}
	
	
}