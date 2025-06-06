import menstrualcycle

from unittest import TestCase

class TestMenstrualCycle(TestCase):
	def test_get_next_cycle_date_function_exists(self):
		menstrualcycle.get_next_cycle_date("25/05/2025", 28)
	
