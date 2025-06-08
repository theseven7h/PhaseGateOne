from datetime import datetime

def get_customer_name():
	customer_name = input("What is the customer's name: ")
	return customer_name
	
def get_item_bought():
	item_bought = input("What did the customer buy: ")
	return item_bought
	
def get_quantity():
	quantity = 0;
	
	while True: 
		entry = input("How many pieces: ")
		try:
			quantity = int(entry)
			if quantity <= 0:
				print("Quantity cannot be less than one")
				continue
			break
		except ValueError:
			print("Invalid quantity! Try again")
	return quantity
	
def get_price():
	pricePerUnit = 0;
	
	while True: 
		entry = input("How much per unit: ")
		try:
			pricePerUnit = float(entry)
			if pricePerUnit <= 0:
				print("Price cannot be less than one")
				continue
			break
		except ValueError:
			print("Invalid price! Try again")
	return pricePerUnit

def get_item_total(quantity, pricePerUnit):
	return quantity * pricePerUnit

def get_cashier_name():
	cashier_name = input("What is your name: ")
	return cashier_name







	
		
def main():
	quantity = get_quantity()
	price = get_price()
	print(get_item_total(quantity, price))
	
#main()