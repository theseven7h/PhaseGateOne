import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TestMenstrualCycle {

	MenstrualCycle mc = new MenstrualCycle();	
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Test
	public void testGetNextCycleDateFunctionExists() {
		mc.getNextCycleDate("25/05/2025", 28);
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
		mc.getOvulationDate("25/05/2025", 28);
	}
	
	@Test
	public void testGetOvulationDateFunctionReturnsCorrectDate() {
		LocalDate next = mc.getOvulationDate("25/05/2025", 28);
		String actual = next.format(fmt);
		String expected = "08/06/2025";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetFertileWindowFunctionExists() {
		mc.getFertileWindow("25/05/2025", 28);
	}
	
	@Test
	public void testGetFertileWindowFunctionReturnsCorrectDates() {
		LocalDate[] next = mc.getFertileWindow("25/05/2025", 28);
		String[] actual = new String[]{next[0].format(fmt), next[1].format(fmt)};
		String[] expected = {"03/06/2025", "09/06/2025"};
		assertArrayEquals(actual, expected);
	}	
}