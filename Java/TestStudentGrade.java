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
	
	@Test
	public void testGetLowestScoresExists() {
		assertNotNull(grade.getLowestScores(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}}));
	}
	
	@Test
	public void testGetLowestScoresReturnsCorrect() {
		int[] actual = grade.getLowestScores(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}});
		int[] expected = new int[]{67,21,27};
		assertArrayEquals(actual, expected);
	}
	
	@Test
	public void testGetSubjectTotalExists() {
		assertNotNull(grade.getSubjectTotal(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}}));
	}
	
	@Test
	public void testGetSubjectTotalReturnsCorrect() {
		int[] actual = grade.getSubjectTotal(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}});
		int[] expected = new int[]{336,200,198};
		assertArrayEquals(actual, expected);
	}
	
	@Test
	public void testGetSubjectAverageExists() {
		assertNotNull(grade.getSubjectAverage(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}}));
	}
	
	@Test
	public void testGetSubjectAverageReturnsCorrect() {
		double[] actual = grade.getSubjectAverage(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}});
		double[] expected = new double[]{84,50,49.5};
		assertArrayEquals(actual, expected);
	}
	
	@Test
	public void testGetPassesAndFailsExists() {
		assertNotNull(grade.getPassesAndFails(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}}));
	}
	
	@Test
	public void testGetPassesAndFailsReturnsCorrect() {
		int[][] actual = grade.getPassesAndFails(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}});
		int[][] expected = new int[][]{{4,2,2},{0,2,2}};
		assertArrayEquals(actual, expected);
	}
	
	@Test
	public void testGetHardestAndEasiestExists() {
		assertNotNull(grade.getHardestAndEasiest(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}}));
	}
	
	@Test
	public void testGetHardestAndEasiestReturnsCorrect() {
		int[][] actual = grade.getHardestAndEasiest(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}});
		int[][] expected = new int[][]{{2,2},{1,4}};
		assertArrayEquals(actual, expected);
	}
	
	@Test
	public void testGetOverallHighestExists() {
		assertNotNull(grade.getOverallHighest(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}}));
	}
	
	@Test
	public void testGetOverallHighestReturnsCorrect() {
		int[][] actual = grade.getOverallHighest(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}});
		int[][] expected = new int[][]{{98,2,1},{21,1,2}};
		assertArrayEquals(actual, expected);
	}
	
	@Test
	public void testGetBestStudentExists() {
		assertNotNull(grade.getBestStudent(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}}));
	}
	
	@Test
	public void testGetBestStudentReturnsCorrect() {
		int[][] actual = grade.getBestStudent(new int[][]{{67,21,49},{98,62,56},{93,34,27},{78,83,66}});
		int[][] expected = new int[][]{{4,227},{1,137}};
		assertArrayEquals(actual, expected);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}