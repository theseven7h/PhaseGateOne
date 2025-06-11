import personalitytest

from unittest import TestCase

class TestPersonalityTestApp(TestCase):
	def test_get_name_function_exists(self):
		self.assertIsNotNone(personalitytest.get_name())
		
	def test_get_name_function_returns_name(self):
		actual = personalitytest.get_name()
		expected = "JAMES TAURI"
		self.assertEqual(actual, expected)