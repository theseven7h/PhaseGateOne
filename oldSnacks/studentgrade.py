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

def get_hardest_and_easiest(student_scores):
	passes_and_fails = get_passes_and_fails(student_scores)
	failures = passes_and_fails[1][0]
	hardest = 1
	
	passes = passes_and_fails[0][0]
	easiest = 1
	for i in range(len(passes_and_fails)):
		if passes_and_fails[1][i] > failures:
			failures = passes_and_fails[1][i]
			hardest = i + 1
		
		if passes_and_fails[0][i] < easiest:
			passes = passes_and_fails[0][i]
			easiest = i + 1
	return [[hardest, failures],[easiest, passes]]

def get_overall_highest_and_lowest(student_scores):
	overall_highest = student_scores[0][0]
	highest_student = 1
	highest_subject = 1
	
	overall_lowest = student_scores[0][0];
	lowest_student = 1
	lowest_subject = 1
	
	for i in range(len(student_scores)):
		for j in range(len(student_scores[0])):
			if student_scores[i][j] > overall_highest:
				overall_highest = student_scores[i][j]
				highest_student = i + 1
				highest_subject = j + 1
			
			if student_scores[i][j] < overall_lowest:
				overall_lowest = student_scores[i][j]
				lowest_student = i + 1
				lowest_subject = j + 1
	return [[overall_highest, highest_student, highest_subject], [overall_lowest, lowest_student, lowest_subject]]

def display_subject_summary(student_scores):
	highest_scores = get_highest_scores(student_scores)
	lowest_scores = get_lowest_scores(student_scores)
	subject_total = get_subject_total(student_scores)
	subject_average = get_subject_average(student_scores)
	passes_and_fails = get_passes_and_fails(student_scores)
	
	border = "=" * 34
	
	print(border)
	print("SUBJECT SUMMARY")
	
	for i in range(len(student_scores[0])):
		print(border)
		print(f"Subject {(i + 1)}")
		print(border)
		print(f"Highest Scoring Student: Student {highest_scores[1][i]}\nScore: {highest_scores[0][i]}\n")
		print(f"Lowest Scoring Student: Student {lowest_scores[1][i]}\nScore: {lowest_scores[0][i]}\n")
		print(f"Total Score: {subject_total[i]}")
		print(f"Average Score: {subject_average[i]:.2f}\n")
		print(f"Number of Passes: {passes_and_fails[0][i]}")
		print(f"Number of Fails: {passes_and_fails[1][i]}")
		print(border)
		print()
	
	hardest = get_hardest_and_easiest(student_scores)[0]
	easiest = get_hardest_and_easiest(student_scores)[1]
	overall_highest = get_overall_highest_and_lowest(student_scores)[0]
	overall_lowest = get_overall_highest_and_lowest(student_scores)[1]
	
	border = "*" * 34
	print(border)
	print(f"Hardest Subject: Subject {hardest[0]}\nFailures: {hardest[1]}\n")
	print(f"Easiest Subject: Subject {easiest[0]}\nPasses: {easiest[1]}\n")
	print(f"Overall Highest Score: {overall_highest[0]}\nScored by Student:{overall_highest[1]}\nIn Subject: {overall_highest[2]}\n")
	print(f"Overall Lowest Score: {overall_lowest[0]}\nScored by Student:{overall_lowest[1]}\nIn Subject: {overall_lowest[2]}")	
	print(border)
	print()

def get_best_and_worst_student(student_scores):
	best_student_total = -2000000000000000
	best_student = 1
	
	worst_student_total = 2000000000000000
	worst_student = 1
	
	for i in range(len(student_scores)):
		sum = 0
		for j in range(len(student_scores[0])):
			sum += student_scores[i][j]
			
		if sum > best_student_total:
			best_student_total = sum
			best_student = i + 1
		
		if sum < worst_student_total:
			worst_student_total = sum
			worst_student = i + 1
	return [[best_student, best_student_total], [worst_student, worst_student_total]]

def get_class_total(student_scores):
	class_total = 0
	for i in range(len(student_scores)):
		class_total += get_total(student_scores[i])
	return class_total

def get_class_average(student_scores):
	return get_class_total(student_scores) / len(student_scores)

def display_class_summary(student_scores):
	best_student = get_best_and_worst_student(student_scores)[0]
	worst_student = get_best_and_worst_student(student_scores)[1]
	class_total = get_class_total(student_scores)
	class_average = get_class_average(student_scores)
	
	border = "=" * 36
	
	print(border)
	print("CLASS SUMMARY")
	print(border)

	
	print(f"Best Graduating Student: Student {best_student[0]}\nScore: {best_student[1]}")
	print(border)
	
	print(f"Worst Graduating Student: Student {worst_student[0]}\nScore: {worst_student[1]}")
	print(border)
	
	print(f"Class Total Score: {class_total}")	
	print(f"Class Average Score: {class_average:.2f}")	
	print(border)



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
		
		while True:
			print("1. Scores table\n2. Subject Summary\n3. Class SUmmary\n0.Exit")
			
			ready = input("--> ").strip()				
			print()
			match(ready):
				case "1": 
					display_details(total, average, positions, student_scores)
					while True:
						print("\n0. Back")
						back = input("--> ").strip()
						
						if back == "0": break
						else: print("Invalid...")
						continue
					
				case "2": 
					display_subject_summary(student_scores)
					while True:
						print("\n0. Back")
						back = input("--> ").strip()
						
						if back == "0": break
						else: print("Invalid...")
						continue
					
				case "3": 
					display_class_summary(student_scores);
					while True:
						print("\n0. Back")
						back = input("--> ").strip()
						
						if back == "0": break
						else: print("Invalid...")
						continue
					
				case "0": 
					print()
					print("Exiting...")
					import sys
					sys.exit(0)
					
				case _: 
					print("Invalid! Check options...")
					print()
			print()
			
			
			
			
			
			
			
			
		
		
main()
