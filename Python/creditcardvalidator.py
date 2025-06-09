def check_type(entry, length):
	card_type = "Invalid Card"
	if entry[0] + entry[1] == "37" and length == 15:
		card_type = "American Express Card" 
	else:
		match entry[0]:
			case "4": 
				if length == 16: 
					card_type = "Visa" 
				
			case "5": 
				if length == 16: 
					card_type = "MasterCard" 
				
			case "6": 
				if length == 16: 
					card_type = "Discover" 
				
			case _: 
				card_type = "Invalid Card" 
	return card_type
	
def check_validity(entry):
	sum_odd_place = 0
	sum_even_place = 0
	for i in range(len(entry) - 2,-1, -2):
		num = int(entry[i]) * 2
		if num > 9:
			num = int(str(num)[0]) + int(str(num)[1])
		sum_even_place += num
		
	for j in range(len(entry) - 1, -1, -2):
		num = int(entry[j])
		sum_odd_place += num
	if (sum_even_place + sum_odd_place) % 10:
		return "Valid"
	else:
		return "Invalid"	
		
def display_result(entry):
	type = check_type(entry, len(entry))
	number = entry
	length = len(entry)
	validity = check_validity(entry)
	
	print()
	print("*" * 38)
	
	print(f"""
**Credit Card Type: {type}
**Credit Card Number: {number}
**Credit Card Digit Length: {length}
**Credit Card Validity Status: {validity}
	""")
	
	print("*" * 38)
	print()	
	
def main():
	while True:
		entry = input("Hello, kindly enter card details to verify(13 - 16 digits): ").strip()
		try:
			number = int(entry)
			length = len(entry)
		except ValueError:
			print("Please enter only numbers")
			continue
			
		if length < 13 or length > 16:
			print("Invalid card length! Try again")
			continue
		
		display_result(entry)	
		break	
		
#main()	 