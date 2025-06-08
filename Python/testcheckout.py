import checkout

from unittest import TestCase

class TestCheckOut(TestCase):
	def test_get_customer_name_function_exists(self):
		self.assertIsNotNone(checkout.get_customer_name())
		
	def test_get_customer_name_function(self):
		actual = checkout.get_customer_name()
		expected = "James Tauri"
		self.assertEqual(actual, expected)
		
	def test_get_item_bought_function_exists(self):
		self.assertIsNotNone(checkout.get_item_bought())
		
	def test_get_item_bought_function(self):
		actual = checkout.get_item_bought()
		expected = "Rice"
		self.assertEqual(actual, expected)
		
	def test_get_quantity_function_exists(self):
		self.assertIsNotNone(checkout.get_quantity())
		
	def test_get_get_quantity_function(self):
		actual = checkout.get_quantity()
		expected = 7
		self.assertEqual(actual, expected)
	
	def test_get_price_function_exists(self):
		self.assertIsNotNone(checkout.get_price())
		
	def test_get_get_price_function(self):
		actual = checkout.get_price()
		expected = 1500
		self.assertEqual(actual, expected)

	def test_get_item_total_function_exists(self):
		self.assertIsNotNone(checkout.get_item_total(3, 1500))
		
	def test_get_get_price_function(self):
		actual = checkout.get_item_total(3, 1500)
		expected = 4500
		self.assertEqual(actual, expected)
	
	def test_get_cashier_name_function_exists(self):
		self.assertIsNotNone(checkout.get_cashier_name())
		
	def test_get_cashier_name_function(self):
		actual = checkout.get_cashier_name()
		expected = "Priscilla"
		self.assertEqual(actual, expected)
	
	
	
	
	
	
	
	
	
	
	
	
	
	