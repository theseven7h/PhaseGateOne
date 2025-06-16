def welcome_user():
	welcome_message = """
----------------------------WELCOME TO THE MIRROR----------------------------
A space where your thoughts, patterns, 
and inner voice are gently reflected back to you.
This isn’t just a personality test. It’s a moment with yourself 
To understand why you are the way you are, without judgment, without noise.
Take a breath. Look inward"""
	
	print(welcome_message)

def get_name():
	name = ""
	while True:
		print("---------------------------------NAME---------------------------------\nBefore we begin, take a moment to look into the mirror.\nLet’s begin with your name, the one you recognize when you look inward")
	
		name = input("--> ").strip().upper()
		print()
		confirm_name = ""
		while True:
			print("---------------------------CONFIRM---------------------------\nIs " + name + " the name that feels true to the person you see within?\n1. It is\n2. No, I'll change it\n")
			confirm_name = input("--> ")
			
			
			if confirm_name in ["1", "2"]:
				break
			print("You chose wrong! Try again.")
		
		if confirm_name == "1":
			break
		elif confirm_name == "2":
			print("\nTry again\n")
	return name	

def navigate_menu(name):
	while True:
		print(f"""
-------------------BEFORE YOU BEGIN-------------------
{name}, I can walk you through why this matters, 
or you can step into The Mirror and find out as you go.
Either way, the reflection will meet you where you are.

1. Tell Me Why It Matters
2. I’m Ready to Begin
	""")
	
		menu_choice =  input("--> ")
		
		match(menu_choice):
			case "1": 
				while True:
					print("""
-----------------------THE MIRROR REVEALS-----------------------
The Mirror isn’t here to label you... it’s here to reveal you...
...patterns beneath your thoughts, choices, and emotions.
Not for perfection. 
Just for truth, the kind that brings clarity and self-trust.

If you’ve ever wondered, “Why am I like this?”
You're about to start finding out.

0. Back
					""")
					
					choice = input("--> ")
					
					if choice == "0": 
						break
					else:
						print("You chose wrong! Try again.")
					print()
						
			case "2": 
				print()
				print("Look into The Mirror... honestly")
			
			case _: 
				print("You chose wrong! Try again.")
				print()
				continue
				
		if menu_choice == "2":
			break

def get_questions(name):
	xtics = [[], [], [], []]
	countAB = [[], [], [], []]
	personality = []

	questions_A = [
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
	]
	
	questions_B = 	[
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
	]
	
	
	for i in range(20):
		print(questions_A[i])
		print(questions_B[i])
		print()
		
		choice = ""
		while True:
			choice = input("--> ").strip().upper()
			if choice in ["A", "B"]:
				break
			else:
				print("Wrong input! Try again.")

		rem = i % 4
		
		if choice == "A":
			xtics[rem].append(questions_A[i])				
		else:
			xtics[rem].append(questions_B[i])
		
		countAB[rem].append(choice.upper())
	
	print(f"Hello name, your selections:")	
	
	for j in range(len(xtics)):
		count = 0
		for k in range(len(xtics[j])):
			print(f"""
{xtics[j][k]}		
			""")			
		
		countA = 0
		countB = 0
		for l in countAB[j]:
			if l == "A": countA += 1
			elif l == "B": countB += 1
		
		personality.append("A") if countA > countB else personality.append("B")
		
		print(f"""
Number of selected As: {countA}		
Number of selected Bs: {countB}		
		""")
		print()
	
	personality[0] = "E" if personality[0] == "A" else "I"
	
	personality[1] = "S" if personality[1] == "A" else "N"
	
	personality[2] = "T" if personality[2] == "A" else "F"
	
	personality[3] = "J" if personality[3] == "A" else "P"
	
	return personality	

def show_result(personality):
	message = ""
	match("".join(personality)): 
		case "ISTJ": 
			message = """
ISTJ – The Grounded Archivist (The Inspector)
You are the one who keeps the plans when others forget them.
Like the friend who always remembers the group trip itinerary,
you thrive in structure, value loyalty, and lead by quiet example.
The Mirror reflects your strength in responsibility — steady, enduring, and true.	
			""" 
		
		case "ISFJ": 
			message = """
ISFJ – The Gentle Steward (The Protector)
You're the one who notices when someone’s hurting — even before they say a word.
Like the friend who brings soup when no one asked,
you protect peace in the smallest, most meaningful ways.
In the Mirror, we see a heart that heals through presence.	
			""" 
		
		case "INFJ": 
			message = """
INFJ – The Insightful Pathmaker (The Advocate)
You’ve often felt like an old soul in a loud world.
Like the writer who weaves purpose into every word,
you seek meaning, not attention — and quietly guide others toward their own light.
The Mirror sees a deep current beneath your calm surface.	
			""" 
		
		case "INTJ": 
			message = """
INTJ – The Strategic Visionary (The Architect)
You're the one who’s already five moves ahead in a room still deciding what to do.
Like an architect with blueprints the world hasn't caught up to yet,
you think in systems and see the future before it arrives.
The Mirror reflects your gift for vision, direction, and calculated transformation.	
			""" 		
		
		case "ISTP": 
			message = """
ISTP – The Independent Solver (The Virtuoso)
You’re the one who fixes things when others panic.
Like the person who silently disassembles a broken chair and reassembles it better,
you trust your hands, your instincts, your facts.
In the Mirror, we see quiet capability — practical, calm, and ready for anything.	
			""" 
		
		case "ISFP": 
			message = """
ISFP – The Quiet Creator (The Adventurer)
You feel the world like music.
Like the artist who paints their silence into color,
you express what can’t be spoken, creating beauty through experience.
The Mirror sees a soul that heals through presence, not performance.	
			""" 
		
		case "INFP": 
			message = """
INFP – The Idealistic Dreamer (The Mediator)
You’re the one who remembers small kindnesses long after they happened.
Like the person who stays up wondering how they made someone feel,
you carry a quiet flame of hope and honesty.
In the Mirror, your heart is revealed — tender, true, and deeply human.	
			""" 
		
		case "INTP": 
			message = """
INTP – The Inner Theorist (The Logician)
You've always questioned what others accept.
Like the person who rewrites the rules just to understand why they exist,
you explore ideas like caves — always curious, always deeper.
The Mirror reflects your mind: independent, brilliant, and never idle.	
			""" 
		
		case "ESTP": 
			message = """
ESTP – The Bold Instinctive (The Entrepreneur)
You’re the one who jumps into the unknown while others hesitate.
Like the first friend on the dance floor,
you live in action and thrive where energy moves fast.
The Mirror reflects your fearless spirit — sharp, daring, and alive.	
			""" 
		
		case "ESFP": 
			message = """
ESFP – The Expressive Spirit (The Entertainer)
You light up a room without even trying.
Like the person who turns an ordinary day into a spontaneous adventure,
you live fully, laugh freely, and love openly.
The Mirror sees your joy — a gift that makes others feel alive too.	
			""" 
	
		case "ENFP": 
			message = """
ENFP – The Curious Flame (The Campaigner)
"You’re the one who believes life is still full of undiscovered wonder.
Like the friend who turns deep conversations into new beginnings,
you chase ideas and people with fierce optimism.
The Mirror reflects your fire — wild, warm, and unafraid to feel everything."						""" 
		
		case "ENTP": 
			message = """
ENTP – The Possibility Weaver (The Debater)
You see connections where others see chaos.
Like the person who can debate for fun — and mean it —
you challenge assumptions, spark innovation, and stir every room you enter.
The Mirror reflects your brilliance: untamed, inventive, unstoppable.	
			""" 		
		
		case "ESTJ": 
			message = """
ESTJ – The Reliable Anchor (The Executive)
You’re the one people turn to when plans fall apart.
Like the person who organizes the chaos and makes it look effortless,
you lead with logic, protect tradition, and move with integrity.
In the Mirror, your clarity becomes others’ stability.	
			""" 
		
		case "ESFJ": 
			message = """
ESFJ – The Nurturing Organizer (The Consul)
You remember birthdays, forgotten chores, and how everyone likes their tea.
Like the host who makes everyone feel seen and safe,
you bring order and care in equal measure.
The Mirror reflects your gift — nurturing through action, leading through kindness.	
			""" 
		
		case "ENFJ": 
			message = """
ENFJ – The Compassionate Leader (The Protagonist)
You’re the one who believes in people before they believe in themselves.
Like the mentor who lifts others quietly into their own greatness,
you lead from the heart, speak with warmth, and gather others with grace.
The Mirror reflects your influence — deep, lasting, and gentle.	
			""" 
		
		case "ENTJ": 
			message = """
ENTJ – The Driven Architect (The Commander)
You see inefficiency like a challenge to conquer.
Like the person who turns a wild idea into a working strategy,
you act with purpose, lead with clarity, and carry a fire that builds.
The Mirror reveals your edge — refined, bold, and always forward.	
			""" 
	
	print(message)

def main():	
	while True:
		welcome_user()
		print()
	
		name = get_name()
		
		navigate_menu(name)
		personality = get_questions(name)
		print()
		
		while True:
			print("Are you now ready to see yourself? (yes/no)")
			ans = input("--> ").strip().lower()
			if(ans not in ["yes", "no"]):
				print("Wrong input!")
				continue
			if ans == "yes": break
			print("Take your time...")

		
		show_result(personality)
		break

#main()