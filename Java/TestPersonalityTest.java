import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestPersonalityTest {
	PersonalityTest person = new PersonalityTest();
	
	@Test
	public void testGetNameFunctionExists() {
		assertNotNull(person.getName());
	}
	
	@Test	
	public void testGetNameFunctionReturnsName() {
		String actual = person.getName();
		String expected = "JAMES TAURI";
		assertEquals(actual, expected);
	}
}