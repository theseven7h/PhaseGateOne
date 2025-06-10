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


const getQuestions = () => {
	let questionsA = 
	[
  "A: expend energy, enjoy groups",
  "A: Interpret literally",
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
	
	let count = 0;
	for(let i = 0; i < a.length(); i++) {
		console.log(questionsA[i]);
		console.log(questionsB[i]);
		console.log();
		let choice = prompt("--> ");
		if(choice == "A")
			
	}
	
}





const main = () => {
	let energy = []
	let decision = []
	let insight = []
	let approach = []
	
	while(true) {
		getQuestions();
		welcomeUser();
		console.log();
	
		let name = getName();
			
		navigateMenu(name);
		
		break;
	}
}























main();