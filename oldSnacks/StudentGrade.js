const prompt = require("prompt-sync")();

const getTotal = (studentScores) => {
	let total = 0;
	for(let i = 0; i < studentScores.length; i++) {
		total += studentScores[i];
	}
	return total;	
}

const getAverage = (studentScores) => {
	return getTotal(studentScores) / studentScores.length;
}	

const getPositions = (average) => {
	let positions = [];
	for(let i = average.length - 1; i >= 0; i--) {
		let count = 0;
		for(let j = average.length - 1; j >= 0; j--) {
			if(average[j] > average[i] || ((average[j] == average[i]) && positions[j] == positions[i]))
				count++;
		}
		positions[i] = count;
	}
	return positions;
}

const displayDetails = (total, average, positions, studentScores) => {
	let border = "";
	for(let bdr = 1; bdr <= (36 + (studentScores[0].length * 10)); bdr++) border += "=";
	
	console.log(border);
	
	
	process.stdout.write(`${"STUDENT".padStart(9)}`);
	for(let i = 0; i < studentScores[0].length; i++) {
		process.stdout.write(`${"SUB".padStart(9)}${String(i + 1)}`);
	}
	
	console.log(`${"TOT".padStart(10)}${"AVE".padStart(11)}${"POS".padStart(6)}`);
	console.log(border);
	
	for(let j = 0; j < studentScores.length; j++) {
		process.stdout.write(`${"Student".padStart(7)} ${String(j + 1)}`);
		for(let k = 0; k < studentScores[0].length; k++) {
			process.stdout.write(`${String(studentScores[j][k]).padStart(10)}`);
		}
		process.stdout.write(`${String(total[j]).padStart(10)}${average[j].toFixed(2).padStart(11)}${String(positions[j]).padStart(6)}`);
		console.log();
	}
	console.log(border);
}

const getHighestScores = (studentScores) => {
	let highestScores = [];
	let index = [];
	for(let i = 0; i < studentScores[0].length; i++) {
		highestScores[i] = studentScores[0][i];
		index[i] = 1;
		for(let j = 0; j < studentScores.length; j++) {
			if(studentScores[j][i] > highestScores[i]) {
				highestScores[i] = studentScores[j][i];
				index[i] = j + 1;
			}
		}
	}
	return [highestScores,index];	
}

const getLowestScores = (studentScores) => {
	let lowestScores = [];
	let index = [];
	for(let i = 0; i < studentScores[0].length; i++) {
		lowestScores[i] = studentScores[0][i];
		index[i] = 1;
		for(let j = 0; j < studentScores.length; j++) {
			if(studentScores[j][i] < lowestScores[i]) {
				lowestScores[i] = studentScores[j][i];
				index[i] = j + 1;
			}
		}
	}
	return [lowestScores,index];	
}

const getSubjectTotal = (studentScores) => {
	let totals = []; 
	for(let i = 0; i < studentScores[0].length; i++) {
		totals.push(0)
		for(let j = 0; j < studentScores.length; j++) {
			totals[i] += studentScores[j][i];
		}
		
	}
	return totals;
}

const getSubjectAverage = (studentScores) => {
	let totals = getSubjectTotal(studentScores);
	let averages = [];
	for(let i = 0; i < studentScores[0].length; i++) {
		averages[i] = totals[i] / studentScores.length;
	}
	return averages;
}

const getPassesAndFails = (studentScores) => {
	let passes = [];
	let fails = [];
	for(let i in studentScores[0]) {
		passes.push([0]);
		fails.push([0]);
	}
	for(let i = 0; i < studentScores[0].length; i++) {
		for(let j = 0; j < studentScores.length; j++) {
			if(studentScores[j][i] >= 50) passes[i]++;
			else fails[i]++;
		}
	}
	return [passes, fails];
}

const getHardestAndEasiest = (studentScores) => { 
	let passesAndFails = getPassesAndFails(studentScores);
	let failures = passesAndFails[1][0];
	let hardest = 1;
	
	let passes = passesAndFails[0][0];
	let easiest = 1;
	for(let i = 1; i < passesAndFails.length; i++) {
		if(passesAndFails[1][i] > failures) {
			failures = passesAndFails[1][i]; 
			hardest = i + 1;
		}
		
		if(passesAndFails[0][i] < easiest) {
			passes = passesAndFails[0][i]; 
			easiest = i + 1;
		}
	}
	return [[hardest, failures],[easiest, passes]];
}

const getOverallHighestAndLowest = (studentScores) => {
	let overallHighest = studentScores[0][0];
	let highestStudent = 1;
	let highestSubject = 1;
	
	let overallLowest = studentScores[0][0];
	let lowestStudent = 1;
	let lowestSubject = 1;
	
	for(let i = 0; i < studentScores.length; i++) {
		for(let j = 0; j < studentScores[i].length; j++) {
			if(studentScores[i][j] > overallHighest) {
				overallHighest = studentScores[i][j];
				highestStudent = i + 1;
				highestSubject = j + 1;
			}
			
			if(studentScores[i][j] < overallLowest) {
				overallLowest = studentScores[i][j];
				lowestStudent = i + 1;
				lowestSubject = j + 1;
			}
		}
	}
	return [[overallHighest, highestStudent, highestSubject], [overallLowest, lowestStudent, lowestSubject]];
}

const displaySubjectSummary = (studentScores) => {
	let highestScores = getHighestScores(studentScores);
	let lowestScores = getLowestScores(studentScores);
	let subjectTotal = getSubjectTotal(studentScores);
	let subjectAverage = getSubjectAverage(studentScores);
	let passesAndFails = getPassesAndFails(studentScores);
	
	let border = "";
	for(let i = 0; i <= 33; i++) border += "=";
	
	console.log(border);
	console.log("SUBJECT SUMMARY");
	
	for(let i = 0; i < studentScores[0].length; i++) {
		console.log(border);
		console.log(`Subject ${String(i + 1)}`);
		console.log(border);
		console.log(`Highest Scoring Student: Student ${highestScores[1][i]}\nScore: ${highestScores[0][i]}\n`);
		console.log(`Lowest Scoring Student: Student ${lowestScores[1][i]}\nScore: ${lowestScores[0][i]}\n`);
		console.log(`Total Score: ${subjectTotal[i]}`);
		console.log(`Average Score: ${subjectAverage[i].toFixed(2)}\n`);
		console.log(`Number of Passes: ${passesAndFails[0][i]}`);
		console.log(`Number of Fails: ${passesAndFails[1][i]}`);
		console.log(border);
		console.log();
	}
	
	let hardest = getHardestAndEasiest(studentScores)[0];
	let easiest = getHardestAndEasiest(studentScores)[1];
	let overallHighest = getOverallHighestAndLowest(studentScores)[0];
	let overallLowest = getOverallHighestAndLowest(studentScores)[1];
	
	border = "";
	for(let i = 0; i <= 33; i++) border += "*";
	console.log(border);
	console.log(`Hardest Subject: Subject ${hardest[0]}\nFailures: ${hardest[1]}\n`);
	console.log(`Easiest Subject: Subject ${easiest[0]}\nPasses: ${easiest[1]}\n`);
	console.log(`Overall Highest Score: ${overallHighest[0]}\nScored by Student:${overallHighest[1]}\nIn Subject: ${overallHighest[2]}\n`);
	console.log(`Overall Lowest Score: ${overallLowest[0]}\nScored by Student:${overallLowest[1]}\nIn Subject: ${overallLowest[2]}\n`);	
	console.log(border);
}

const getBestAndWorstStudent = (studentScores) => {
	let bestStudentTotal = -2000000000000000;
	let bestStudent = 1;
	
	let worstStudentTotal = 2000000000000000;
	let worstStudent = 1;
	
	for(let i = 0; i < studentScores.length; i++) {
		let sum = 0;
		for(let j = 0; j < studentScores[i].length; j++) {
			sum += studentScores[i][j];
		}
		if(sum > bestStudentTotal) {
			bestStudentTotal = sum;
			bestStudent = i + 1;
		}
		
		if(sum < worstStudentTotal) {
			worstStudentTotal = sum;
			worstStudent = i + 1;
		}
	}
	return [[bestStudent, bestStudentTotal], [worstStudent, worstStudentTotal]];
}

const getClassTotal = (studentScores) => {
	let classTotal = 0;
	for(let i = 0; i < studentScores.length; i++) {
		classTotal += getTotal(studentScores[i]);
	}
	return classTotal;
}

const getClassAverage = (studentScores) => {
	return getClassTotal(studentScores) / studentScores.length;
}

const displayClassSummary = (studentScores) => {
	let bestStudent = getBestAndWorstStudent(studentScores)[0];
	let worstStudent = getBestAndWorstStudent(studentScores)[1];
	let classTotal = getClassTotal(studentScores);
	let classAverage = getClassAverage(studentScores);
	
	let border = "";
	for(let i = 0; i <= 35; i++) border += "=";
	
	console.log(border);
	console.log("CLASS SUMMARY");
	console.log(border);

	
	console.log(`Best Graduating Student: Student ${bestStudent[0]}\nScore: ${bestStudent[1]}`);
	console.log(border);
	
	console.log(`Worst Graduating Student: Student ${worstStudent[0]}\nScore: ${worstStudent[1]}`);
	console.log(border);
	
	console.log(`Class Total Score: ${classTotal}`);	
	console.log(`Class Average Score: ${classAverage.toFixed(2)}`);	
	console.log(border);
}

const main = () => {
	let studentScores = [];
	while(true) {
		while(true) {
			console.log("Enter number of students");
			let studentsEntry = prompt("--> ").trim();
			console.log();
			studentsEntry = Number(studentsEntry);
			if(!Number.isInteger(studentsEntry) || studentsEntry < 1 || studentsEntry > 100) {
				console.log("Wrong input, try again!");
				console.log();
				continue;
			}
			
			console.log("Enter number of subjects");
			let subjectsEntry = prompt("--> ").trim();
			subjectsEntry = Number(subjectsEntry);
			if(!Number.isInteger(subjectsEntry) || subjectsEntry < 1 || subjectsEntry > 100) {
				console.log("Wrong input, start again!");
				console.log();
				continue;
			}
			
			
			for(let i = 0; i < studentsEntry; i++) {
				studentScores.push([]);
				studentScores[i] = new Array(Number(subjectsEntry));
			} 
			console.log();
			break;
		}
				
		let border = "";
		for(let bdr = 0; bdr <= 35; bdr++) border += "=";
					
		for(let stu = 0; stu < studentScores.length; stu++) {
			for(let sub = 0; sub < studentScores[0].length; sub++) {
				console.log();
				while(true) {
					console.log(border);
					console.log("Entering score for student " + (stu + 1) + "...");
					console.log("Enter score for subject " + (sub + 1) + ", (0 - 100)");
					let scoreEntry = prompt("--> ").trim();
					scoreEntry = Number(scoreEntry);
									
					if(!Number.isInteger(scoreEntry)) {
						console.log();
						console.log("Wrong input, try again!");
						continue;
					}
					
					if(scoreEntry < 0 || scoreEntry > 100) {
						console.log("Invalid... between 0 - 100 only!");
						console.log(border);
						console.log();
						continue;
					}
					
					studentScores[stu][sub] = scoreEntry;
					console.log("...saved successfully.");
					console.log(border);
					break;
				}
			}
		}
		
		let total = [];
		let average = [];
		for(let i = 0; i < studentScores.length; i++) {
			total[i] = getTotal(studentScores[i]);
			average[i] = getAverage(studentScores[i]);
		}
		
		let positions = getPositions(average);
		console.log();
					
		while(true) {
			console.log("1. Scores table\n2. Subject Summary\n3. Class SUmmary\n0.Exit");
			
			let ready = Number(prompt("--> ").trim());
			if(!Number.isInteger(ready) || ready < 0 || ready > 4) {
				console.log("Invalid! Check options...");
				console.log();
				continue;
			}
			
			console.log();
			switch(ready) {
				case 1: 
					displayDetails(total, average, positions, studentScores);
					while(true) {
						console.log("\n0. Back");
						let back = prompt("--> ").trim();
						
						if(back === "0") break;
						else console.log("Invalid...");
						continue;
					} 
					break;
					
				case 2: 
					displaySubjectSummary(studentScores); 
					while(true) {
						console.log("\n0. Back");
						let back = prompt("--> ").trim();
						
						if(back === "0") break;
						else console.log("Invalid...");
						continue;
					}
					break;
					
				case 3: 
					displayClassSummary(studentScores);
					while(true) {
						console.log("\n0. Back");
						let back = prompt("--> ").trim();
						
						if(back === "0") break;
						else console.log("Invalid...");
						continue;
					}
					break;
					
				case 0: 
					console.log();
					console.log("Exiting...");
					process.exit(0);
					
				default: 
					console.log("Invalid! Check options...");
					console.log();
					continue;
			}
			console.log();
		}				
	}			
}

main();