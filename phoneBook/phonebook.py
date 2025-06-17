contact_list = [];

def add_contact(first_name, last_name, phone_number):
	contact_info = [first_name, last_name, phone_number]
	contact_list.append(contact_info)

def check_contact_list_contains_contact():
	if len(contact_list) < 1:
		return False
	return True

def check_phone_number(phone_number):
	for i in range(len(contact_list)):
		if contact_list[i][2] == phone_number:
			return False
	return True

def display_contacts():
	for i in range(len(contact_list)):
		print(f"{(i + 1)}. \nFirst name: {contact_list[i][0]}\nLast name: {contact_list[i][1]}\nPhone number: {contact_list[i][2]}")
		print()

def remove_contact(remove):
	contact_list.pop(int(remove) - 1)
	print("...deleted successfully")
	
def find_contact_by_phone_number(phone_number):
	for i in range(len(contact_list)):
		if contact_list[i][2] == phone_number:
			return f"First name: {contact_list[i][0]}\nLast name: {contact_list[i][1]}\nPhone number: {contact_list[i][2]}\n"
	return "Phone number does not exist!"

def find_contact_by_first_name(first_name):
	for i in range(len(contact_list)):
		if contact_list[i][0] == first_name:
			return f"First name: {contact_list[i][0]}\nLast name: {contact_list[i][1]}\nPhone number: {contact_list[i][2]}\n"
	return "Name does not exist!"

def find_contact_by_last_name(last_name):
	for i in range(len(contact_list)):
		if contact_list[i][1] == last_name:
			return f"First name: {contact_list[i][0]}\nLast name: {contact_list[i][1]}\nPhone number: {contact_list[i][2]}\n"
	return "Name does not exist!"

def edit_contact(edit, edit_choice, entry):
	contact_list[int(edit) - 1][int(edit_choice) - 1] = entry;

def main():
	while True:
		print("""
1. Add contact
2. View contacts
3. Remove contact
4. Find contact by phone number
5. Find contact by first name
6. Find contact by last name
7. Edit contact
0. Quit
""")

		option = 0;
		try:
			option = int(input("--> "))
			print()
			if option > 7 or option < 0:
				print("Invalid... choose between 0 - 6")
				print()
				continue
		except(ValueError):
			print("Invalid... Enter a number")
			print()
			continue
			
		match(option):
			case 1: 
				print("First Name")
				first_name = input("--> ").strip()
				print("Last Name")
				last_name = input("--> ").strip()
				while True:
					print("Enter phone number")
					phone_number = input("--> ").strip()
					print()
					try:
						if len(phone_number) != 11:
							print("Invalid. Phone number must be 11 digits\n")
							continue
						int(phone_number)
					except ValueError:
						print("Invalid. Phone number must contain only digits")
						print()
						continue
					if not check_phone_number(phone_number):
						print("Phone number already exists!")
						continue
					
					add_contact(first_name, last_name, phone_number)
					break
					
				while True:
					print("...added successfully\n0. Back")
					back = input("--> ").strip()
					if back == "0":
						break	
					print("Invalid! Try again\n")
					
			case 2:
				if not check_contact_list_contains_contact():
					print("Contact list is empty")
					print()
					continue
				display_contacts()
				print()
				while True:
					print("0. Back")
					back = input("--> ").strip()
					if back == "0":
						break	
					print("Invalid! Try again\n")	
					
			case 3: 
				if not check_contact_list_contains_contact():
					print("Contact list is empty")
					print()
					continue
				display_contacts()
				while True:
					print("Which contact do you want to remove?")
					remove = input("--> ").strip()
					try:
						if int(remove) < 1 or int(remove) > len(contact_list):
							print("Invalid. Check again...")
							continue
					except ValueError:
						print("Invalid. Input must be a digit")
						print()
						continue
					
					remove_contact(remove)
					break
				while True:
					print("0. Back")
					back = input("--> ").strip()
					if back == "0":
						break	
					print("Invalid! Try again\n")
					
			case 4:
				if not check_contact_list_contains_contact():
					print("Contact list is empty")
					continue
				while True:
					print("Enter the phone number")
					phone_num = input("--> ").strip();
					print()
					print(find_contact_by_phone_number(phone_num))
					print()

					if find_contact_by_phone_number(phone_num) != "Phone number does not exist!":
						break
				print()
				while True:
					print("0. Back")
					back = input("--> ").strip()
					if back == "0":
						break	
					print("Invalid! Try again\n")
				
			case 5:
				if not check_contact_list_contains_contact():
					print("Contact list is empty")
					continue
				while True:
					print("Enter the first name")
					name = input("--> ").strip()
					print()
					print(find_contact_by_first_name(name))
					print()
					if find_contact_by_first_name(name) != "Name does not exist!":
						break
				print()		
				while True:
					print("0. Back")
					back = input("--> ").strip()
					if back == "0":
						break	
					print("Invalid! Try again\n")
					
			case 6:
				if not check_contact_list_contains_contact():
					print("Contact list is empty")
					continue
				while True:
					print("Enter the last name")
					name = input("--> ").strip()
					print()
					print(find_contact_by_last_name(name))
					print()
					if find_contact_by_last_name(name) != "Name does not exist!":
						break
				print()
				while True:
					print("0. Back")
					back = input("--> ").strip()
					if back == "0":
						break	
					print("Invalid! Try again\n")
					
			case 7:
				if not check_contact_list_contains_contact():
					print("Contact list is empty")
					continue
				display_contacts()
				while True:
					print("Which contact do you want to edit?")
					edit = input("--> ").strip()
					try:
						if int(edit) < 1 or int(edit) > len(contact_list):
							print("Invalid. Check again...")
							continue
					except ValueError:
						print("Invalid. Input must be a digit")
						print()
						continue
					
					while True:
						print()
						print("1. Edit first name\n2. Edit last name\n3. Edit phone number\n0. Back");
						edit_choice = input("--> ").strip()
						print()
						match(edit_choice):
							case "1": 
								print("Enter first name")
								f_name = input("--> ").strip()
								edit_contact(edit, edit_choice, f_name)
								
							case "2": 
								print("Enter last name")
								l_name = input("--> ").strip()
								edit_contact(edit, edit_choice, l_name)
								
							case "3": 
								while True:
									print("Enter phone number")
									number = input("--> ").strip()
									print()
									try:
										if len(number) != 11:
											print("Invalid. Phone number must be 11 digits\n")
											continue
										int(number)
									except ValueError:
										print("Invalid. Phone number must contain only digits")
										print()
										continue
									if not_check_phone_number(number):
										print("Phone number already exists!")
										continue
									edit_contact(edit, edit_choice, number)
									break
								
							case "0":
								break
								
						break		
					break	
				
			
			case 0:
				import sys
				sys.exit(0)
		print()
									



















main()

