import studentgrade
from unittest import TestCase

class TestStudentGrade(TestCase):
	student_scores = [[67,21,49],[98,62,56],[93,34,27],[78,83,66]]

	def test_get_total_exists(self):
		self.assertIsNotNone(studentgrade.get_total([33,65,32]))
		
	def test_get_total(self):
		actual = studentgrade.get_total([33,65,32])
		expected = 130
		self.assertEqual(actual, expected)
		
	def test_get_average_exists(self):
		self.assertIsNotNone(studentgrade.get_average([33,65,32]))
		
	def test_get_average(self):
		actual = f"{studentgrade.get_average([33,65,32]):.2f}"
		expected = "43.33"
		self.assertEqual(actual, expected)
		
	def test_get_positions_exists(self):
		self.assertIsNotNone(studentgrade.get_positions([33.4,65.3,32.9]))
		
	def test_get_positions(self):
		actual = studentgrade.get_positions([33.4,65.3,32.9])
		expected = [2,1,3]
		self.assertEqual(actual, expected)
		
	def test_get_highest_scores_exists(self):
		self.assertIsNotNone(studentgrade.get_highest_scores(self.student_scores))
		
	def test_get_highest_scores(self):
		actual = studentgrade.get_highest_scores(self.student_scores)
		expected = [[98,83,66],[2,4,4]]
		self.assertEqual(actual, expected)
		
	def test_get_lowest_scores_exists(self):
		self.assertIsNotNone(studentgrade.get_lowest_scores(self.student_scores))
		
	def test_get_lowest_scores(self):
		actual = studentgrade.get_lowest_scores(self.student_scores)
		expected = [[67,21,27],[1,1,3]]
		self.assertEqual(actual, expected)
	
	def test_get_subject_total_exists(self):
		self.assertIsNotNone(studentgrade.get_subject_total(self.student_scores))
		
	def test_get_subject_total(self):
		actual = studentgrade.get_subject_total(self.student_scores)
		expected = [336,200,198]
		self.assertEqual(actual, expected)
	
	def test_get_subject_average_exists(self):
		self.assertIsNotNone(studentgrade.get_subject_average(self.student_scores))
		
	def test_get_subject_average(self):
		actual = studentgrade.get_subject_average(self.student_scores)
		expected = [84,50,49.5]
		self.assertEqual(actual, expected)
		
	def test_get_passes_and_fails_exists(self):
		self.assertIsNotNone(studentgrade.get_passes_and_fails(self.student_scores))
		
	def test_get_passes_and_fails(self):
		actual = studentgrade.get_passes_and_fails(self.student_scores)
		expected = [[4,2,2],[0,2,2]]
		self.assertEqual(actual, expected)
	
	def test_get_hardest_and_easiest_exists(self):
		self.assertIsNotNone(studentgrade.get_hardest_and_easiest(self.student_scores))
		
	def test_get_hardest_and_easiest(self):
		actual = studentgrade.get_hardest_and_easiest(self.student_scores)
		expected = [[2,2],[1,4]]
		self.assertEqual(actual, expected)
		
	def test_get_overall_highest_and_lowest_exists(self):
		self.assertIsNotNone(studentgrade.get_overall_highest_and_lowest(self.student_scores))
		
	def test_get_overall_highest_and_lowest(self):
		actual = studentgrade.get_overall_highest_and_lowest(self.student_scores)
		expected = [[98,2,1],[21,1,2]]
		self.assertEqual(actual, expected)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	