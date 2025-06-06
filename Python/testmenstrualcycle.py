import menstrualcycle

from unittest import TestCase

output = "%d/%m/%Y"

class TestMenstrualCycle(TestCase):
	def test_get_next_cycle_date_function_exists(self):
		menstrualcycle.get_next_cycle_date("25/05/2025", 28)
	
	def test_get_next_cycle_date_function_returns_correct_date(self):
		next = menstrualcycle.get_next_cycle_date("25/05/2025", 28)
		actual = next.strftime(output)
		expected = "22/06/2025"
		self.assertEqual(actual, expected)

	def test_get_ovulation_date_function_exists(self):
		menstrualcycle.get_ovulation_date("25/05/2025", 28);
	
	def test_get_ovulation_date_function_returns_correct_date(self):
		od = menstrualcycle.get_ovulation_date("25/05/2025", 28)
		actual = od.strftime(output);
		expected = "08/06/2025";
		self.assertEqual(actual, expected)
	
	def test_get_ovulation_date_function_exists(self):
		menstrualcycle.get_fertile_window("25/05/2025", 28)
	
	def test_get_fertile_window_function_returns_correct_date(self):
		fw = menstrualcycle.get_fertile_window("25/05/2025", 28)
		actual = [fw[0].strftime(output), fw[1].strftime(output)]
		expected = ["03/06/2025", "09/06/2025"]
		self.assertEqual(actual, expected)
	
	def test_get_safe_period_function_exists(self):
		menstrualcycle.get_safe_period("25/05/2025", 28)
	
	def test_get_safe_period_function_returns_correct_date(self):
		sp = menstrualcycle.get_safe_period("25/05/2025", 28)
		actual = [[sp[0][0].strftime(output), sp[0][1].strftime(output)], [sp[1][0].strftime(output), sp[1][1].strftime(output)]]
		expected = [["25/05/2025", "02/06/2025"], ["10/06/2025", "22/06/2025"]]
		self.assertEqual(actual, expected)