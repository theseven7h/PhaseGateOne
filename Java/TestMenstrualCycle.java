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
	}
	
	@Test
	public void testGetNextCycleDateFunctionReturnsCorrectDate() {
		LocalDate next = mc.getNextCycleDate("25/05/2025", 28);
		String actual = next.format(fmt);
		String expected = "22/06/2025";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetOvulationDateFunctionExists() {
		LocalDate od = mc.getOvulationDate("25/05/2025", 28);
	}
	
	@Test
	public void testGetOvulationDateFunctionReturnsCorrectDate() {
		LocalDate next = mc.getOvulationDate("25/05/2025", 28);
		String actual = next.format(fmt);
		String expected = "08/06/2025";
		assertEquals(actual, expected);
	}
	
}