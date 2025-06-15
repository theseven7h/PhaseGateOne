import studentgrade
from unittest import TestCase

class TestStudentGrade(TestCase):
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
		
	
	