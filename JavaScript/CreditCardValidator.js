const prompt = require("prompt-sync")();

const checkType = (entry, length) => {
	let cardType = "Invalid Card";
	if(entry.charAt(0) + entry.charAt(1) === "37" && length == 15) 	
		cardType = "American Express Card";
	else {
		switch(entry.charAt(0)) {
			case "4": if(length == 16) cardType = "Visa"; break;
			case "5": if(length == 16) cardType = "MasterCard"; break;
			case "6": if(length == 16) cardType = "Discover"; break;
			default: cardType = "Invalid Card"; break;
		}
	}
	return cardType;	
}

const checkValidity = (entry) => {
	let sumOddPlace = 0; 
	let sumEvenPlace = 0;
	for(let i = entry.length - 2; i >= 0; i -= 2) {
		let num = Number(entry.charAt(i)) * 2;
		if(num > 9) {
			num = Number(String(num).charAt(0)) + Number(String(num).charAt(1));
		}
		sumEvenPlace += Number(num); 
	}
	
	for(let j = entry.length - 1; j >= 0; j -= 2) {
		let num = Number(entry.charAt(j));
		sumOddPlace += num; 
	}
	if ((sumEvenPlace + sumOddPlace) % 10 == 0)
		return "Valid";
	else
		return "Invalid";
}

const displayResult = (entry) => {
	
	let type = checkType(entry, entry.length);
	let number = entry;
	let length = entry.length;
	let validity = checkValidity(entry);
	
	let stars = "";
	for(let i = 0; i < 38; i++) {
		stars += "*";
	}
	console.log();
	console.log(stars);
	
	console.log(`
**Credit Card Type: ${type}
**Credit Card Number: ${number}
**Credit Card Digit Length: ${length}
**Credit Card Validity Status: ${validity}
	`);
	
	console.log(stars);
	console.log();
}

const main = () => {
	while(true) {
		let entry = prompt("Hello, kindly enter card details to verify(13 - 16 digits): ").trim();
		let number = Number(entry);
		let length = entry.length;
		
		if(isNaN(number) || !Number.isInteger(number)) {
			console.log("Please enter only numbers");
			continue;
		}
		if(length < 13 || length > 16) {
			console.log("Invalid card length! Try again");
			continue;
		}
		
		displayResult(entry);		
		break;
	}
}

main();