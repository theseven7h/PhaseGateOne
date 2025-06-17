const prompt = require("prompt-sync")();

contactList = [];

function addContact(firstName, lastName, phoneNumber) {
	contactInfo = [firstName, lastName, phoneNumber]
	contactList.push(contactInfo);
}

function checkContactListContainsContact() {
	if(contactList.length < 1)
		return false;
	return true;
}

function checkPhoneNumber(phoneNumber) {
	for(let i = 0; i < contactList.length; i++) {
		if(contactList[i][2] == phoneNumber) {
			return false;
		}
	}
	return true;
}

function displayContacts() {
	for(let i = 0; i < contactList.length; i++) {
			console.log(`${(i + 1)}. \nFirst name: ${contactList[i][0]}\nLast name: ${contactList[i][1]}\nPhone number: ${contactList[i][2]}`);
			console.log();
	}
}

function removeContact(remove) {
	contactList.splice(parseInt(remove) - 1, 1);
	console.log("...deleted successfully");
}

function findContactByPhoneNumber(phoneNumber) {
	for(let i = 0; i < contactList.length; i++) {
		if(contactList[i][2] == phoneNumber) {
			return `First name: ${contactList[i][0]}\nLast name: ${contactList[i][1]}\nPhone number: ${contactList[i][2]}\n`;
		}
	}
	return "Phone number does not exist!";
}

function findContactByFirstName(firstName) {
	for(let i = 0; i < contactList.length; i++) {
		if(contactList[i][0] == firstName) {
			return `First name: ${contactList[i][0]}\nLast name: ${contactList[i][1]}\nPhone number: ${contactList[i][2]}\n`;
		}
	}
	return "Name does not exist!";
}

function findContactByLasttName(lastName) {
	for(let i = 0; i < contactList.length; i++) {
		if(contactList[i][1] == firstName) {
			return `First name: ${contactList[i][0]}\nLast name: ${contactList[i][1]}\nPhone number: ${contactList[i][2]}\n`;
		}
	}
	return "Name does not exist!";
}

function editContact(edit, editChoice, entry) {
	contactList[parseInt(edit) - 1][parseInt(editChoice) - 1] = entry;
}
	
function main() {
	while(true) {
		console.log(`
1. Add contact
2. View contacts
3. Remove contact
4. Find contact by phone number
5. Find contact by first name
6. Find contact by last name
7. Edit contact
0. Quit
`);

		let option = prompt("--> ").trim();
		console.log(); 
		if(isNaN(Number(option)) || !Number.isInteger(Number(option))) {
			console.log("Invalid... Enter a number");
			continue;
		}
		
		if(option > 7 || option < 0) {
			console.log("Invalid... choose between 0 - 6");
			console.log();
			continue;
		}
		option = Number(option);
		
		switch(option) {
			case 1: 
				console.log("First Name");
				let firstName = prompt("--> ").trim();
				console.log("Last Name");
				let lastName =prompt("--> ").trim();
				while(true) {
					console.log("Enter phone number");
					let phoneNumber = prompt("--> ").trim();
					console.log();
					
					if(isNaN(Number(phoneNumber)) || !Number.isInteger(Number(phoneNumber))) {
						console.log("Invalid. Phone number must contain only digits");
						continue;
					}
					
					if(phoneNumber.length != 11) {
						console.log("Invalid. Phone number must be 11 digits\n");
						continue;
					}
					
					if(!checkPhoneNumber(phoneNumber)) {
						console.log("Phone number already exists!");
						continue;
					}
					addContact(firstName, lastName, phoneNumber);
					//console.log(contactList);
					break;
				}
				
				while(true) {
					console.log("...added successfully\n0. Back");
					let back = prompt("--> ").trim();
					if(back == "0")
						break;	
					console.log("Invalid! Try again\n");
				}
				break;
				
			case 2:
				if(!checkContactListContainsContact()) {
					console.log("Contact list is empty");
					console.log();
					continue;
				}
				displayContacts();
				console.log();
				while(true) {
					console.log("...added successfully\n0. Back");
					let back = prompt("--> ").trim();
					if(back == "0")
						break;	
					console.log("Invalid! Try again\n");
				}
				break;
				
			case 3: 
				if(!checkContactListContainsContact()) {
					console.log("Contact list is empty");
					console.log();
					continue;
				}
				displayContacts();
				while(true) {
					console.log("Which contact do you want to remove");
					let remove = prompt("--> ").trim();
					
					if(isNaN(Number(remove)) || !Number.isInteger(Number(remove))) {
						console.log("Invalid. Input must be a digit");
						console.log();
						continue;
					}
					
					if(parseInt(remove) < 1 || parseInt(remove) > contactList.length) {
						console.log("Invalid. Check again...");
						continue;
					}
		
					//console.log(contactList.length);
					//console.log(Arrays.toString(contactList.get(0)));
					removeContact(remove);
					break;
				}
				while(true) {
					console.log("...added successfully\n0. Back");
					let back = prompt("--> ").trim();
					if(back == "0")
						break;	
					console.log("Invalid! Try again\n");
				}
				break;
				
			case 4:
				if(!checkContactListContainsContact()) {
					console.log("Contact list is empty");
					continue;
				}
				while(true) {
					console.log("Enter the phone number");
					let phoneNum = sc.next("--> ").trim();
					console.log();
					console.log(findContactByPhoneNumber(phoneNum));
					console.log();

					if(findContactByPhoneNumber(phoneNum) !== "Phone number does not exist!")
						break;
				}
				console.log();
				while(true) {
					console.log("...added successfully\n0. Back");
					let back = prompt("--> ").trim();
					if(back == "0")
						break;	
					console.log("Invalid! Try again\n");
				}
				break;
				
			case 5:
				if(!checkContactListContainsContact()) {
					console.log("Contact list is empty");
					continue;
				}
				while(true) {
					console.log("Enter the first name");
					let name = sc.next("--> ").trim();
					console.log();
					console.log(findContactByFirstName(name));
					console.log();
					if(findContactByFirstName(name) !== "Name does not exist!")
						break;
				}
				console.log();
				while(true) {
					console.log("...added successfully\n0. Back");
					let back = prompt("--> ").trim();
					if(back == "0")
						break;	
					console.log("Invalid! Try again\n");
				}
				break;
				
			case 6:
				if(!checkContactListContainsContact()) {
					console.log("Contact list is empty");
					continue;
				}
				while(true) {
					console.log("Enter the last name");
					let name = proompt("--> ").trim();
					console.log();
					console.log(findContactByLastName(name));
					console.log();
					if(findContactByLastName(name) !== "Name does not exist!")
						break;
				}
				console.log();
				while(true) {
					console.log("...added successfully\n0. Back");
					let back = prompt("--> ").trim();
					if(back == "0")
						break;	
					console.log("Invalid! Try again\n");
				}
				break;
			
			case 7:
				if(!checkContactListContainsContact()) {
					console.log("Contact list is empty");
					continue;
				}
				displayContacts();
				while(true) {
					console.log("Which contact do you want to edit?");
					let edit = prompt("--> ").trim();
					if(isNaN(Number(edit)) || !Number.isInteger(Number(edit))) {
						console.log("Invalid. Input must be a digit");
						console.log();
						continue;
					}
					
					if(parseInt(edit) < 1 || parseInt(edit) > contactList.length) {
						console.log("Invalid. Check again...");
						continue;
					}
					
					while(true) {
						console.log("1. Edit first name\n2. Edit last name\n3. Edit phone number\n0. Back");
						let editChoice = prompt("--> ").trim();
						console.log();
						switch(editChoice) {
							case "1": 
								console.log("Enter first name");
								let fName = prompt("--> ").trim();
								editContact(edit, editChoice, fName);
								break;
								
							case "2": 
								console.log("Enter last name");
								let lName = prompt("--> ").trim();
								editContact(edit, editChoice, lName);
								break;
								
							case "3": 
								while(true) {
									console.log("Enter phone number");
									let number = prompt("--> ").trim();
									console.log();
									if(isNaN(Number(number)) || !Number.isInteger(Number(number))) {
										console.log("Invalid. Phone number must be 11 digits\n");
										console.log();
										continue;
									}
									
									if(number.length != 11) {
										console.log("Invalid. Phone number must be 11 digits\n");
										continue;
									}
									
									if(!checkPhoneNumber(number)) {
										console.log("Phone number already exists!");
										continue;
									}
									editContact(edit, editChoice, number);
									break;
								}
								break;
							
							case "0":
								break;
								
							default:
								console.log("Invalid... Try again");
						}
						break;
					}
					break;						
				}
				break;
				
			case 0:
				process.exit(0);
		}
		
	}
}











main()