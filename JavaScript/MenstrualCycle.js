const {DateTime} = require("luxon");

const input = "dd/MM/yyyy";
const output = "d MMMM, yyyy";

const getNextCycleDate = function(date, cycleDays) {
	const next = DateTime.fromFormat(date, input).plus({days: cycleDays});
	return next;
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

let lcd = DateTime.fromFormat("25/05/2025", input);
let fertileWindow = getFertileWindow("25/05/2025", 28);
let safePeriod = getSafePeriod("25/05/2025", 28);

console.log("Last cycle date:", lcd.toFormat(output));

console.log("Expected next cycle:", getNextCycleDate("25/05/2025", 28).toFormat(output));

console.log("Expected ovulation:", getOvulationDate("25/05/2025", 28).toFormat(output));

console.log("Expected fertile window:", fertileWindow[0].toFormat(output), "to", fertileWindow[1].toFormat(output));

console.log("Expected safe period: " + safePeriod[0][0].toFormat(output), "to", safePeriod[0][1].toFormat(output), "and", safePeriod[1][0].toFormat(output), "to", safePeriod[1][1].toFormat(output));
