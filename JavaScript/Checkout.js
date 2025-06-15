const input = require("prompt-sync");
const prompt = input();

const getCustomerName = () => {
	let customerName = prompt("What is the customer's name: ");
	return customerName;
}

const getItemBought = () => {
	let itemBought = prompt("What did the customer buy: ");
	return itemBought;	
}

const getQuantity = () => {
	let quantity = 0;
	
	while(true) {
		let input = prompt("How many pieces: ");
		quantity = parseInt(input);
		if (isNaN(quantity)) {
			console.log("Invalid quantity! Try again");
			continue;
		}
		if (quantity <= 0) {
			console.log("Quantity cannot be less than one");
			continue;
		}
		break;	
	}
	return quantity;	
}

const getPrice = () => {
	let pricePerUnit = 0;
	
	while(true) {
		let input = prompt("How much per unit: ");
		pricePerUnit = parseFloat(input);
		if (isNaN(pricePerUnit)) {
			console.log("Invalid price! Try again");
			continue;
		}
		if (pricePerUnit <= 0) {
			console.log("Price cannot be less than one");
			continue;
		}
		break;	
	}
	return pricePerUnit;	
}

const getItemTotal = (quantity, pricePerUnit) => {
	return quantity * pricePerUnit;
}

const getCashierName = () => {
	let cashierName = prompt("What is your name: ");
	return cashierName;
}

const getSubtotal = (allDetails) => {
	subtotal = 0;
	for(let det = 0; det < allDetails.length; det++) {
		total = parseFloat(allDetails[det]["total"]);
		subtotal += total;
	}
	return subtotal;
}

const getDiscountAmount = () => {
	let discount = 0;
	while(true) {
		let input = prompt("How much discount will they get(%): ");
		discount = parseFloat(input);
		if (isNaN(discount)) {
			console.log("Invalid discount! Try again");
			continue;
		}
		if (discount < 0 || discount > 100) {
			console.log("Discount cannot be less than one or more than hundred");
			continue;
		}
		break;	
	}
	return subtotal * (discount / 100);	
}

const getVat = (subtotal) => {
	const VAT = 7.5;
	return subtotal * (VAT / 100);
}

const getBillTotal = (subtotal, discount, vat) => {
	return subtotal - discount + vat;
}

const getAmountPaid = (billTotal) => {
	let amountPaid = 0;
	while(true) {
		let input = prompt("How much did the customer give to you: ");
		amountPaid = parseFloat(input);
		if (isNaN(amountPaid)) {
			console.log("Invalid amount! Try again");
			continue;
		}
		if (amountPaid < billTotal) {
			console.log("Amount insufficient! Try again");
			continue;
		}
		break;	
	}
	return amountPaid;	
}	

const getBalance = (amountPaid, billTotal) => {
	return amountPaid - billTotal;
}

const getResponse = () => {
	response = "";
	while(true) {
		response = prompt("Add more items (yes/no): ").trim().toLowerCase();
		if(response === "yes" || response === "no") {
			break;
		}
	}
	return response === "yes";
}

const main = () => {
	details = {};
	allDetails = [];

	customerName = getCustomerName();
	itemBought = "";
	quantity = 0;
	pricePerUnit = 0;
	itemTotal = 0;

	while(true) {
		details = {};
	
		itemBought = getItemBought();
		details["item"] = itemBought;
		
		quantity = getQuantity();
		details["qty"] = quantity.toString();
		
		pricePerUnit = getPrice();
		details["price"] = pricePerUnit.toString();
		
		itemTotal = getItemTotal(quantity, pricePerUnit);
		details["total"] = itemTotal.toString();
					
		allDetails.push(details);
		
		response = getResponse();
		if(response === false) break;
	}
	
	let cashierName = getCashierName();
	let subtotal = getSubtotal(allDetails);
	let discount = getDiscountAmount(subtotal);
	let vat = getVat(subtotal);
	let billTotal = getBillTotal(subtotal, discount, vat);
	let amountPaid = getAmountPaid(billTotal);
	let balance = getBalance(amountPaid, billTotal);
	
	console.log();
	console.log(`
SEMICOLON STORES
MAIN BRANCH
LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
TEL: 03293828343
`);	

	console.log("Date: ");
	console.log("Cashier: " + cashierName);
	console.log("Customer Name: " + customerName);
	
	let sym = "";
	for(let i = 0; i < 54; i++) sym += "=";
	console.log();
	console.log(sym);
	
	console.log(`${"ITEM".padStart(20)}${"QTY".padStart(6)}${"PRICE".padStart(14)}${"TOTAL(NGN)".padStart(14)}`);
	let sym2 = "";
	for(let i = 0; i < 54; i++) sym2 += "-";
	console.log(sym2);

	for(let i = 0; i < allDetails.length; i++) {
		let item = allDetails[i]["item"];
		let qty = parseInt(allDetails[i]["qty"]);
		let ttu = parseFloat(allDetails[i]["price"]);
		let itmTotal = parseFloat(allDetails[i]["total"]);
		
		console.log(`${item.padStart(20)}${qty.toFixed(2).padStart(6)}${ttu.toFixed(2).padStart(14)}${itmTotal.toFixed(2).padStart(14)}`);	
	}	
		
	console.log(sym2);
	console.log(`${"Sub Total:".padStart(40)}${subtotal.toFixed(2).padStart(14)}`);
	console.log(`${"Discount:".padStart(40)}${discount.toFixed(2).padStart(14)}`);
	console.log(`${"VAT @ 7.50%:".padStart(40)}${vat.toFixed(2).padStart(14)}`);
	
	console.log(sym);
	
	console.log(`${"Bill Total:".padStart(40)}${billTotal.toFixed(2).padStart(14)}`);
	console.log(`${"Amount Paid:".padStart(40)}${amountPaid.toFixed(2).padStart(14)}`);
	console.log(`${"Balance:".padStart(40)}${balance.toFixed(2).padStart(14)}`);
	
	console.log(sym);
	console.log(`${"             THANK YOU FOR YOUR PATRONAGE".padEnd(28)}`);	
	console.log(sym);
}

main();