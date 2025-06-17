for num in range(1, 11):
	if num % 4 == 0:
		count = 1
		sum = 0
		while count <= 5:
			sum += num ** count;
			count += 1
		print(sum, end=" ")