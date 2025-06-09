import java.util.Scanner;

public class CreditCardValidator {	
	public static String checkType(String entry, int length) {
		String cardType = "Invalid Card";
		if ((Character.toString(entry.charAt(0)) + Character.toString(entry.charAt(1))).equals("37") && length == 15)
			cardType = "American Express Card"; 
		else {
			switch(Character.toString(entry.charAt(0))) {
				case "4": 
					if (length == 16)
						cardType = "Visa"; break;
										
				case "5": 
					if (length == 16) 
						cardType = "MasterCard"; break;
					
				case "6": 
					if (length == 16)
						cardType = "Discover"; break; 
					
				default: 
					cardType = "Invalid Card"; break;
			}
		} 
		return cardType;
	}
	
	public static String checkValidity(String entry) {
		int sumOddPlace = 0;
		int sumEvenPlace = 0;
		for(int i = entry.length() - 2; i >= 0; i -= 2) {
			int num = Integer.parseInt(Character.toString(entry.charAt(i))) * 2;
			if (num > 9)
				num = Integer.parseInt(Character.toString(Integer.toString(num).charAt(0))) + Integer.parseInt(Character.toString(Integer.toString(num).charAt(0)));
			sumEvenPlace += num;
		}
			
		for(int j = entry.length() - 1; j >= 0; j -= 2) {
			int num = Integer.parseInt(Character.toString(entry.charAt(j)));
			sumOddPlace += num;
		}
		
		if ((sumEvenPlace + sumOddPlace) % 10 == 0)
			return "Valid";
		else
			return "Invalid"	;
	}
		
	public static void displayResult(String entry) {
		String type = checkType(entry, entry.length());
		String number = entry;
		int length = entry.length();
		String validity = checkValidity(entry);
		
		System.out.println();
		String stars = "";
		for(int i = 0; i <= 38; i++) stars += "*";
		
		System.out.println(stars);
		
		System.out.printf("""
**Credit Card Type: %s
**Credit Card Number: %s
**Credit Card Digit Length: %d
**Credit Card Validity Status: %s%n""", type, number, length, validity
		);
		
		System.out.println(stars);
		System.out.println();
	}	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Hello, kindly enter card details to verify(13 - 16 digits): ");
			String entry = sc.next().trim();
			int length = entry.length();
			try {
				long number = Long.parseLong(entry);
			}
			catch (Exception e) {
				System.out.println("Please enter only numbers");
				continue;
			}
				
			if(length < 13 || length > 16) {
				System.out.println("Invalid card length! Try again");
				continue;
			}
			
			displayResult(entry);
			break	;
		}
		//4388576018410707 4388576018402626 373333333333333
	}
}	 
