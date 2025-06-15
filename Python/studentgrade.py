def get_total(student_scores):
	total = 0
	for i in range(len(student_scores)):
		total += student_scores[i]
	return total	

def get_average(student_scores):
	return get_total(student_scores) / len(student_scores)

def get_positions(average):
	positions = [0] * len(average)
	for i in range((len(average) - 1), -1, -1):
		count = 0
		for j in range((len(average) - 1), -1, -1):
			if average[j] > average[i] or ((average[j] == average[i]) and (positions[j] == positions[i])):
				count += 1
		positions[i] = count
	return positions
	
def display_details(total, average, positions, studentScores):
	border = "=" * (36 + (len(studentScores) * 10))
	
	print(border)
	
	print(f"{'STUDENT':>9}", end="")
	for i in range(len(studentScores[0])):
		print(f"{'SUB':>9}{(i + 1)}", end="")
	
	print(f"{'TOT':>10}{'AVE':>11}{'POS':>6}")
	print(border)
	
	for j in range(len(studentScores)):
		print(f"{'Student':>7} {(j + 1)}", end="")
		for k in range(len(studentScores[0])):
			print(f"{studentScores[j][k]:>10}", end="")
		print(f"{total[j]:>10}{average[j]:>11.2f}{positions[j]:>6}", end="")
		print()
	print(border)

def get_highest_scores(student_scores):
	highest_scores = [0] * len(student_scores[0])
	index = [0] * len(student_scores[0])
	for i in range(len(student_scores[0])):
		highest_scores[i] = student_scores[0][i]
		index[i] = 1
		for j in range(len(student_scores)):
			if student_scores[j][i] > highest_scores[i]:
				highest_scores[i] = student_scores[j][i]
				index[i] = j + 1
	return [highest_scores,index]	

def get_lowest_scores(student_scores):
	lowest_scores = [0] * len(student_scores[0])
	index = [0] * len(student_scores[0])
	for i in range(len(student_scores[0])):
		lowest_scores[i] = student_scores[0][i]
		index[i] = 1
		for j in range(len(student_scores)):
			if student_scores[j][i] < lowest_scores[i]:
				lowest_scores[i] = student_scores[j][i]
				index[i] = j + 1
	return [lowest_scores,index]

def get_subject_total(student_scores):
	totals = [0] * len(student_scores[0]) 
	for i in range(len(student_scores[0])):
		for j in range(len(student_scores)):
			totals[i] += student_scores[j][i]
	return totals

def get_subject_average(student_scores):
	totals = get_subject_total(student_scores);
	averages = [0] * len(totals)
	for i in range(len(student_scores[0])):
		averages[i] = totals[i] / len(student_scores)
	return averages

def get_passes_and_fails(student_scores):
	passes = [0] * len(student_scores[0])
	fails = [0] * len(student_scores[0])
	
	for i in range(len(student_scores[0])):
		for j in range(len(student_scores)):
			if student_scores[j][i] >= 50: passes[i] += 1
			else: fails[i] += 1
	return [passes, fails]

def main():
	student_scores = []
	while True:
		while True:
			print("Enter number of students");
			students = input("--> ").strip()
			print()
			
			print("Enter number of subjects")
			subjects = input("--> ").strip()
			print()
			
			try:
				students = int(students)
				subjects = int(subjects)
				student_scores = [];
				if students < 1 or subjects < 1:
					print("Invalid!... Less than 1")
					continue
			except ValueError:
				print("Wrong inputs, start again")
				print()
				continue			
			
			for i in range(students):
				student_scores.append([0] * subjects)
				#student_scores[i] = [[] for j in range(subjects)]
			print()
			break
				
		border = "=" * 35
					
		for stu in range(len(student_scores)):
			for sub in range(len(student_scores[0])):
				print()
				while True:
					print(border)
					print("Entering score for student " + str(stu + 1) + "...")
					print("Enter score for subject " + str(sub + 1) + ", (0 - 100)")
					score_entry = input("--> ").strip()

					try:
						score_entry = int(score_entry)
					except ValueError:
						print()
						print("Wrong input, try again!")
						continue
					
					if score_entry < 0 or score_entry > 100:
						print("Invalid... between 0 - 100 only!")
						print(border)
						print()
						continue
					
					student_scores[stu][sub] = score_entry
					print("...saved successfully.")
					print(border)
					break
		
		
		total = []
		average = []
		
		for i in range(len(student_scores)):
			total.append([])
			average.append([])
			total[i] = get_total(student_scores[i])
			average[i] = get_average(student_scores[i])
		
		positions = get_positions(average)
		print()
		
		print(total, average, positions)
					
		display_details(total, average, positions, student_scores)
		'''display_subject_summary(student_scores)
		display_class_summary(student_scores)'''
		
		break
		
#main()
