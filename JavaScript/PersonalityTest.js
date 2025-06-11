const prompt = require("prompt-sync")();

const welcomeUser = () => {
	let welcomeMessage = `
----------------------------WELCOME TO THE MIRROR----------------------------
A space where your thoughts, patterns, 
and inner voice are gently reflected back to you.
This isn’t just a personality test. It’s a moment with yourself 
To understand why you are the way you are — without judgment, without noise.
Take a breath. Look inward`;
	
	console.log(welcomeMessage);
}

const getName = () => {
	let name = "";
	while(true) {
		console.log("---------------------------------NAME---------------------------------\nBefore we begin, take a moment to look into the mirror.\nLet’s begin with your name, the one you recognize when you look inward");
	
		name = prompt("--> ").trim().toUpperCase();
		console.log();
		let confirmName = "";
		while(true) {
			console.log("---------------------------CONFIRM---------------------------\nIs " + name + " the name that feels true to the person you see within?\n1. It is\n2. No, I'll change it\n");
			confirmName = prompt("--> ");
			
			
			if (["1", "2"].includes(confirmName)) 
				break;
			console.log("You chose wrong! Try again.");
		}
		if(confirmName == "1")
			break;
		else if(confirmName == "2")
			console.log("\nTry again\n");
	}
	return name;	
}


const navigateMenu = (name) => {
	while(true) {
		console.log(`
-------------------BEFORE YOU BEGIN-------------------
${name}, I can walk you through why this matters, 
or you can step into The Mirror and find out as you go.
Either way, the reflection will meet you where you are.

1. Tell Me Why It Matters
2. I’m Ready to Begin
	`);
	
		let menuChoice =  prompt("--> ");
		
		switch(menuChoice) {
			case "1": 
				while(true) {
					console.log(`
-----------------------THE MIRROR REVEALS-----------------------
The Mirror isn’t here to label you... it’s here to reveal you...
...patterns beneath your thoughts, choices, and emotions.
Not for perfection. 
Just for truth, the kind that brings clarity and self-trust.

If you’ve ever wondered, “Why am I like this?”;
You're about to start finding out.

0. Back
					`);
					
					let choice = prompt("--> ");
					
					if(choice == "0") 
						break;
					else 
						console.log("You chose wrong! Try again.");
					console.log();
					
				} 
				break;
	
			case "2": 
				console.log();
				console.log("Look into The Mirror... honestly");
				break;
			
			default: 
				console.log("You chose wrong! Try again.");
				console.log(); 
				continue;
		}
		if(menuChoice == 2)
			break;	
	}	
}


const getQuestions = (name) => {
	let xtics = [[], [], [], []];
	let countAB = [[], [], [], []];
	let personality = []

	let questionsA = 
	[
  "A: expend energy, enjoy groups",
  "A: interpret literally",
  "A: logical, thinking, questioning",
  "A: organized, orderly",
  "A: energizing, think out loud",
  "A: concrete, literal, experiential",
  "A: candid, straight forward, frank",
  "A: plan, schedule",
  "A: seek many tasks, public activities, interaction with others",
  "A: standard, usual, conventional",
  "A: firm, tend to criticize, hold the line",
  "A: regulated, structured",
  "A: external, communicative, express yourself",
  "A: focus on here-and-now",
  "A: tough-minded, just",
  "A: preparation, plan ahead",
  "A: active, initiate",
  "A: facts, things, what is",
  "A: matter of fact, issue-oriented",
  "A: control, govern"
	];
	
	let questionsB = 
	[
  "B: conserve energy, enjoy one-on-one",
  "B: look for meaning and possibilities",
  "B: empathetic, feeling, accommodating",
  "B: flexible, adaptable",
  "B: more reserved, think to yourself",
  "B: imaginative, innovative, theoretical",
  "B: tactful, kind, encouraging",
  "B: unplanned, spontaneous",
  "B: seek private, solitary activities with quiet to concentrate",
  "B: different, novel, unique",
  "B: gentle, tend to appreciate, conciliate",
  "B: easy-going, live and let live",
  "B: internal, reticent, keep to yourself",
  "B: look to the future, global perspective, big picture",
  "B: tender-hearted, merciful",
  "B: go with the flow, adapt as you go",
  "B: reflective, deliberate",
  "B: ideas, dreams, what could be, philosophical",
  "B: sensitive, people-oriented, compassionate",
  "B: latitude, freedom"
	];
	
	
	for(let i = 0; i < 20; i++) {
		console.log(questionsA[i]);
		console.log(questionsB[i]);
		console.log();
		
		let choice = "";
		while(true) {
			choice = prompt("--> ").trim().toUpperCase();
			if(["A", "B"].includes(choice))
				break;
			else
				console.log("Wrong input! Try again.");
		}
		let rem = i % 4;
		
		if(choice == "A") {
			xtics[rem].push(questionsA[i]);				
		} else {
			xtics[rem].push(questionsB[i]);
		}
		countAB[rem].push(choice.toUpperCase());
	}
	
	console.log(`Hello ${name}, your selections:`);	
	
	for(let j = 0; j < xtics.length; j++) {
		let count = 0;
		for(let k = 0; k < xtics[j].length; k++) {
			console.log(`
${xtics[j][k]}		
			`);			
		}
		
		let countA = 0;
		let countB = 0;
		for(l of countAB[j]) {
			if(l == "A") countA++;
			else if(l == "B") countB++;
		}
		
		if(countA > countB) personality.push("A");
		else personality.push("B");
		
		console.log(`
Number of selected As: ${countA}		
Number of selected Bs: ${countB}		
		`);
		console.log();
	}
	
	if(personality[0] == "A") personality[0] = "E";
	else personality[0] = "I";
	
	if(personality[1] == "A") personality[1] = "S";
	else personality[1] = "N";
	
	if(personality[2] == "A") personality[2] = "T";
	else personality[2] = "F";
	
	if(personality[3] == "A") personality[3] = "J";
	else personality[3] = "P";
	
	return personality;	
}

const showResult = (personality) => {
	let message = "";
	switch(personality.join("")) {
		case "ISTJ": 
			message = `
ISTJ – The Grounded Archivist (The Inspector)
You are the one who keeps the plans when others forget them.
Like the friend who always remembers the group trip itinerary,
you thrive in structure, value loyalty, and lead by quiet example.
The Mirror reflects your strength in responsibility — steady, enduring, and true.	
			`; 
			break;
		
		case "ISFJ": 
			message = `
ISFJ – The Gentle Steward (The Protector)
You're the one who notices when someone’s hurting — even before they say a word.
Like the friend who brings soup when no one asked,
you protect peace in the smallest, most meaningful ways.
In the Mirror, we see a heart that heals through presence.	
			`; 
			break;
		
		case "INFJ": 
			message = `
INFJ – The Insightful Pathmaker (The Advocate)
You’ve often felt like an old soul in a loud world.
Like the writer who weaves purpose into every word,
you seek meaning, not attention — and quietly guide others toward their own light.
The Mirror sees a deep current beneath your calm surface.	
			`; 
			break;
		
		case "INTJ": 
			message = `
INTJ – The Strategic Visionary (The Architect)
You're the one who’s already five moves ahead in a room still deciding what to do.
Like an architect with blueprints the world hasn't caught up to yet,
you think in systems and see the future before it arrives.
The Mirror reflects your gift for vision, direction, and calculated transformation.	
			`; 
			break;
		
		
		case "ISTP": 
			message = `
ISTP – The Independent Solver (The Virtuoso)
You’re the one who fixes things when others panic.
Like the person who silently disassembles a broken chair and reassembles it better,
you trust your hands, your instincts, your facts.
In the Mirror, we see quiet capability — practical, calm, and ready for anything.	
			`; 
			break;
		
		case "ISFP": 
			message = `
ISFP – The Quiet Creator (The Adventurer)
You feel the world like music.
Like the artist who paints their silence into color,
you express what can’t be spoken, creating beauty through experience.
The Mirror sees a soul that heals through presence, not performance.	
			`; 
			break;
		
		case "INFP": 
			message = `
INFP – The Idealistic Dreamer (The Mediator)
You’re the one who remembers small kindnesses long after they happened.
Like the person who stays up wondering how they made someone feel,
you carry a quiet flame of hope and honesty.
In the Mirror, your heart is revealed — tender, true, and deeply human.	
			`; 
			break;
		
		case "INTP": 
			message = `
INTP – The Inner Theorist (The Logician)
You've always questioned what others accept.
Like the person who rewrites the rules just to understand why they exist,
you explore ideas like caves — always curious, always deeper.
The Mirror reflects your mind: independent, brilliant, and never idle.	
			`; 
			break;
		
		case "ESTP": 
			message = `
ESTP – The Bold Instinctive (The Entrepreneur)
You’re the one who jumps into the unknown while others hesitate.
Like the first friend on the dance floor,
you live in action and thrive where energy moves fast.
The Mirror reflects your fearless spirit — sharp, daring, and alive.	
			`; 
			break;
		
		case "ESFP": 
			message = `
ESFP – The Expressive Spirit (The Entertainer)
You light up a room without even trying.
Like the person who turns an ordinary day into a spontaneous adventure,
you live fully, laugh freely, and love openly.
The Mirror sees your joy — a gift that makes others feel alive too.	
			`; 
			break;
		
		case "ENFP": 
			message = `
ENFP – The Curious Flame (The Campaigner)
"You’re the one who believes life is still full of undiscovered wonder.
Like the friend who turns deep conversations into new beginnings,
you chase ideas and people with fierce optimism.
The Mirror reflects your fire — wild, warm, and unafraid to feel everything."						`; 
			break;
		
		case "ENTP": 
			message = `
ENTP – The Possibility Weaver (The Debater)
You see connections where others see chaos.
Like the person who can debate for fun — and mean it —
you challenge assumptions, spark innovation, and stir every room you enter.
The Mirror reflects your brilliance: untamed, inventive, unstoppable.	
			`; 
			break;
		
		
		case "ESTJ": 
			message = `
ESTJ – The Reliable Anchor (The Executive)
You’re the one people turn to when plans fall apart.
Like the person who organizes the chaos and makes it look effortless,
you lead with logic, protect tradition, and move with integrity.
In the Mirror, your clarity becomes others’ stability.	
			`; 
			break;
		
		case "ESFJ": 
			message = `
ESFJ – The Nurturing Organizer (The Consul)
You remember birthdays, forgotten chores, and how everyone likes their tea.
Like the host who makes everyone feel seen and safe,
you bring order and care in equal measure.
The Mirror reflects your gift — nurturing through action, leading through kindness.	
			`; 
			break;
		
		case "ENFJ": 
			message = `
ENFJ – The Compassionate Leader (The Protagonist)
You’re the one who believes in people before they believe in themselves.
Like the mentor who lifts others quietly into their own greatness,
you lead from the heart, speak with warmth, and gather others with grace.
The Mirror reflects your influence — deep, lasting, and gentle.	
			`; 
			break;
		
		case "ENTJ": 
			message = `
ENTJ – The Driven Architect (The Commander)
You see inefficiency like a challenge to conquer.
Like the person who turns a wild idea into a working strategy,
you act with purpose, lead with clarity, and carry a fire that builds.
The Mirror reveals your edge — refined, bold, and always forward.	
			`; 
			break;
	}
	console.log(message);
}





const main = () => {
	
	
	while(true) {
		welcomeUser();
		console.log();
	
		let name = getName();
			
		navigateMenu(name);
		let personality = getQuestions(name);
		console.log();
		
		showResult(personality);
		break;
	}
}























main();