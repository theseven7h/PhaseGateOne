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

def get_subtotal(all_details):
	subtotal = 0
	for detail in range(len(all_details)):
		total = float(all_details[detail].get("total"))
		subtotal += total;
	return subtotal

def get_discount_amount(subtotal):
	discount = 0;
	while True: 
		entry = input("How much discount will they get(%): ")
		try:
			discount = float(entry)
			if discount <= 0:
				print("Discount cannot be less than one")
				continue
			break
		except ValueError:
			print("Invalid discount! Try again")
	return subtotal * (discount / 100)

def get_vat(subtotal):
	VAT = 7.5;
	return subtotal * (VAT / 100);

def get_bill_total(subtotal, discount, vat):
	return subtotal - discount + vat;
	
def get_amount_paid(bill_total):
	amount_paid = 0;
	while True: 
		entry = input("How much did the customer give to you: ")
		try:
			amount_paid = float(entry)
			if amount_paid <= bill_total:
				print("Amount insufficient! Try again")
				continue
			break
		except ValueError:
			print("Invalid amount! Try again")
	return amount_paid

def get_balance(amount_paid, bill_total):
	return amount_paid - bill_total








		
def main():
	details = {}
	all_details = []
	
	
	quantity = get_quantity()
	price = get_price()
	print(get_item_total(quantity, price))
	
#main()