import checkout

from unittest import TestCase

class TestCheckOut(TestCase):
	details = {}
	all_details = []
	'''
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
		
	def test_get_get_item_total_function(self):
		actual = checkout.get_item_total(3, 1500)
		expected = 4500
		self.assertEqual(actual, expected)
	
	def test_get_cashier_name_function_exists(self):
		self.assertIsNotNone(checkout.get_cashier_name())
		
	def test_get_cashier_name_function(self):
		actual = checkout.get_cashier_name()
		expected = "Priscilla"
		self.assertEqual(actual, expected)
	
	def test_get_subtotal_function_exists(self):
		self.details["total"] = "4500"
		self.all_details.append(self.details)
		self.assertIsNotNone(checkout.get_subtotal(self.all_details))
	
	def test_get_subtotal_function(self):
		self.details.clear()
		self.all_details.clear()
		
		self.details["total"] = "4500"
		self.all_details.append(self.details)
		actual = checkout.get_subtotal(self.all_details)
		expected = 4500
		self.assertEqual(actual, expected)
	
	def test_get_subtotal_function(self):
		self.details = {}
		self.all_details.clear()
		
		self.details["total"] = "4500"
		self.all_details.append(self.details)
		self.details = {}
		self.details["total"] = "1000"
		self.all_details.append(self.details)
		
		actual = checkout.get_subtotal(self.all_details)
		expected = 5500
		self.assertEqual(actual, expected)
	
	def test_get_discount_amount_function_exists(self):
		self.assertIsNotNone(checkout.get_discount_amount(1000))
		
	def test_get_get_discount_amount_function(self):
		actual = checkout.get_discount_amount(1000)
		expected = 100
		self.assertEqual(actual, expected)
	'''
	
	
	
	
	
	
	