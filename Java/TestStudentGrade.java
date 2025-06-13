import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestStudentGrade {
	StudentGrade grade = new StudentGrade();
	
	@Test
	public void testGetTotalExists() {
		assertNotNull(grade.getTotal(new int[]{33,65,32}));
	}
	
	@Test
	public void testGetTotalReturnsTotal() {
		int actual = grade.getTotal(new int[]{33,65,32});
		int expected = 130;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetAverageExists() {
		assertNotNull(grade.getAverage(new int[]{33,65,32}));
	}
	
	@Test
	public void testGetAverageReturnsTotal() {
		double actual = grade.getAverage(new int[]{33,65,32});
		double expected = 43.333333333333333333333333333333;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetPositionExists() {
		assertNotNull(grade.getPositions(new double[]{33.4,65.3,32.9}));
	}
	
	@Test
	public void testGetPositionReturnsRightPositions() {
		int[] actual = grade.getPositions(new double[]{33.4,65.3,32.9});
		int[] expected = new int[]{2,1,3};
		assertArrayEquals(actual, expected);
	}
	
	@Test
	public void testGetHighestScoresExists() {
		assertNotNull(grade.getHighestScores(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}}));
	}
	
	@Test
	public void testGetHighestScoresReturnsCorrect() {
		int[] actual = grade.getHighestScores(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}});
		int[] expected = new int[]{98,83,66};
		assertArrayEquals(actual, expected);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}