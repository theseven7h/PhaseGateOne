import creditcardvalidator

from unittest import TestCase

class TestCreditCardValidator(TestCase):

	def test_check_type_function_exists(self):
		entry = "4388576018410707"
		length = len(entry)
		self.assertIsNotNone(creditcardvalidator.check_type(entry, length))
		
	def test_check_type_function_american_express(self):
		entry = "373233232323432"
		length = len(entry)
		actual = creditcardvalidator.check_type(entry, length)
		expected = "American Express Card" 
		self.assertEqual(actual, expected)	
		
	def test_check_type_function_visa(self):
		entry = "4388576018402626"
		length = len(entry)
		actual = creditcardvalidator.check_type(entry, length)
		expected = "Visa" 
		self.assertEqual(actual, expected)	
		
	def test_check_type_function_mastercard(self):
		entry = "5388586018702826"
		length = len(entry)
		actual = creditcardvalidator.check_type(entry, length)
		expected = "MasterCard" 
		self.assertEqual(actual, expected)	
		
	def test_check_type_function_discover(self):
		entry = "6388676018402628"
		length = len(entry)
		actual = creditcardvalidator.check_type(entry, length)
		expected = "Discover" 
		self.assertEqual(actual, expected)	
		
	def test_check_type_function_visa(self):
		entry = "2388576018402626"
		length = len(entry)
		actual = creditcardvalidator.check_type(entry, length)
		expected = "Invalid Card" 
		self.assertEqual(actual, expected)
		
	def test_check_validity_function_exists(self):
		entry = "4388576018410707"
		self.assertIsNotNone(creditcardvalidator.check_validity(entry))
		
	def test_check_validity_function_for_valid(self):
		entry = "4388576018402626"
		actual = creditcardvalidator.check_validity(entry)
		expected = "Valid"
		self.assertEqual(actual, expected)
		
	def test_check_validity_function_for_invalid(self):
		entry = "4388576018410707"
		actual = creditcardvalidator.check_validity(entry)
		expected = "Invalid"
		self.assertEqual(actual, expected)
		