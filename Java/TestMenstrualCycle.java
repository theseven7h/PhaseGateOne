import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TestMenstrualCycle {

	MenstrualCycle mc = new MenstrualCycle();	
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Test
	public void testGetNextCycleDateFunctionExists() {
		assertNotNull(mc.getNextCycleDate("25/05/2025", 28));
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
		assertNotNull(mc.getOvulationDate("25/05/2025", 28));
	}
	
	@Test
	public void testGetOvulationDateFunctionReturnsCorrectDate() {
		LocalDate od = mc.getOvulationDate("25/05/2025", 28);
		String actual = od.format(fmt);
		String expected = "08/06/2025";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetFertileWindowFunctionExists() {
		assertNotNull(mc.getFertileWindow("25/05/2025", 28));
	}
	
	@Test
	public void testGetFertileWindowFunctionReturnsCorrectDates() {
		LocalDate[] fw = mc.getFertileWindow("25/05/2025", 28);
		String[] actual = new String[]{fw[0].format(fmt), fw[1].format(fmt)};
		String[] expected = {"03/06/2025", "09/06/2025"};
		assertArrayEquals(actual, expected);
	}	
	
	@Test
	public void testGetSafePeriodFunctionExists() {
		assertNotNull(mc.getSafePeriod("25/05/2025", 28));
	}
	
	@Test
	public void testGetSafePeriodFunctionReturnsCorrectDates() {
		LocalDate[][] sp = mc.getSafePeriod("25/05/2025", 28);
		String[][] actual = new String[][]{{sp[0][0].format(fmt), sp[0][1].format(fmt)}, {sp[1][0].format(fmt), sp[1][1].format(fmt)}};
		String[][] expected = new String[][]{{"25/05/2025", "02/06/2025"}, {"10/06/2025", "22/06/2025"}};
		assertArrayEquals(actual, expected);
	}
}