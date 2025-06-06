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

console.log("Expected next cycle:", getNextCycleDate("25/05/2025", 28).toFormat(output));

console.log("Expected ovulation:", getOvulationDate("25/05/2025", 28).toFormat(output));
