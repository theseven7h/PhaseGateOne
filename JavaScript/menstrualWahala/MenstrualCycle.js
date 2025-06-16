const {DateTime} = require("luxon");
const prompt = require("prompt-sync")();

const input = "dd/MM/yyyy";
const output = "d MMMM, yyyy";

const getNextCycleDate = function(date, cycleDays) {
	const next = DateTime.fromFormat(date, input).plus({days: cycleDays});
	return next;
}

const getNextFlowDates = function(lcd) {
	return [lcd, lcd.plus({days: 5})];
}

const getOvulationDate = function(date, cycleDays) {
	const od = getNextCycleDate(date, cycleDays).minus({days: 14});
	return od;
}

const getFertileWindow = function(date, cycleDays) {
	const fwb = getOvulationDate(date, cycleDays).minus({days: 5});
	const fwa = getOvulationDate(date, cycleDays).plus({days: 1});
	return [fwb,fwa];
}

const getSafePeriod = function(date, cycleDays) {
	let lastCycle = DateTime.fromFormat(date, input);
	let safePeriod = getFertileWindow(date, cycleDays);
	let nextCycle = getNextCycleDate(date, cycleDays);
	return [[lastCycle, safePeriod[0].minus({days: 1})],[safePeriod[1].plus({days: 1}), nextCycle]];
}

const main = function() {
	while(true) {
		let date = prompt("Enter your last period date (dd/mm/yyyy): ");
		let lcd = DateTime.fromFormat(date, input);
		if(lcd > DateTime.now() || lcd.plus({months: 1}) < DateTime.now()) {
			console.log("Date has to be within the last month");
			continue;
		}
		
		if(lcd.invalid !== null) {
			console.log("Invalid date format... Try again!");
			console.log();
			continue;
		}
		console.log();
		let fertileWindow = getFertileWindow(date, 28);
		let safePeriod = getSafePeriod(date, 28);

		let ncd =  getNextCycleDate(date, 28);
		console.log("Last cycle date:", lcd.toFormat(output));
		console.log("Next cycle date:",ncd.toFormat(output));

		console.log("Expected next flow dates:", getNextFlowDates(ncd)[0].toFormat(output), "to", getNextFlowDates(ncd)[1].toFormat(output));
		console.log("Expected ovulation:", getOvulationDate(date, 28).toFormat(output));
		
		console.log("Expected fertile window:", fertileWindow[0].toFormat(output), "to", fertileWindow[1].toFormat(output));
		
		console.log("Expected safe period: " + safePeriod[0][0].toFormat(output), "to", safePeriod[0][1].toFormat(output), "and", safePeriod[1][0].toFormat(output), "to", safePeriod[1][1].toFormat(output));
			
		break;	
	}
}

main()
