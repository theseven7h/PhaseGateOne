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

def get_response():
	response = ""
	while True:
		response = input("Add more items (yes/no): ").strip().lower()
		if(response in ["yes", "no"]):			
			break
	return response == "yes"






		
def main():
	details = {}
	all_details = []

	customer_name = get_customer_name()
	item_bought = ""
	quantity = 0
	price_per_unit = 0
	item_total = 0
	
	while True:
		details = {}
	
		item_bought = get_item_bought()
		details["item"] = item_bought
		
		quantity = get_quantity()
		details["qty"] = str(quantity)
		
		price_per_unit = get_price()
		details["price"] = str(price_per_unit)
		
		item_total = get_item_total(quantity, price_per_unit)
		details["total"] = str(item_total)
					
		all_details.append(details)
		
		response = get_response()
		if response == False:
			break 

	cashier_name = get_cashier_name()
	subtotal = get_subtotal(all_details)
	discount = get_discount_amount(subtotal)
	vat = get_vat(subtotal)
	bill_total = get_bill_total(subtotal, discount, vat)
	amount_paid = get_amount_paid(bill_total)
	balance = get_balance(amount_paid, bill_total)

	date = datetime.today()
	print();
	print("""
SEMICOLON STORES
MAIN BRANCH
LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
TEL: 03293828343
""")
	
	print("Date: " + datetime.strftime(date, "%d-%b-%y %I:%M:%S %p"));
	print("Cashier: " + cashier_name);
	print("Customer Name: " + customer_name);

	sym = ""
	for i in range(54): 
		sym += "="
	print()
	print(sym)

	print(f'{"ITEM":>20}{"QTY":>6}{"PRICE":>14}{"TOTAL(NGN)":>14}')
	sym2 = ""
	for i in range(54): 
		sym2 += "="
	print(sym2)
	
	for j in range(len(all_details)):
		item = all_details[j]["item"]
		qty = int(all_details[j]["qty"])
		ttu = float(all_details[j]["price"])
		itm_total = float(all_details[j]["total"])
		
		print(f'{item:>20}{qty:>6}{ttu:>14}{itm_total:>14}')
		
	print(sym2)
	print(f'{"Sub Total":>40}{subtotal:14.2f}')
	print(f'{"Discount":>40}{discount:14.2f}')
	print(f'{"VAT @ 7.50%:":>40}{vat:14.2f}')

	print(sym)

	print(f'{"Bill Total:":>40}{bill_total:14.2f}')
	print(f'{"Amount Paid:":>40}{amount_paid:14.2f}')
	print(f'{"Balance:":>40}{balance:14.2f}')

	print(sym)
	print(f'             {"THANK YOU FOR YOUR PATRONAGE":>28}')

	print(sym)

	
main()