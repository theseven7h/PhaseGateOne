for(let num = 1; num <= 10; num++) {
	if(num % 4 == 0) {
		for(let count = 1; count <= 5; count++) {
			process.stdout.write(Math.pow(num, count) + " ");
		}
	}
}