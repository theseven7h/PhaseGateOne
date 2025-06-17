import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Phonebook {
	static ArrayList<String[]> contactList = new ArrayList<>();

	public static void addContact(String firstName, String lastName, String phoneNumber) {
		String[] contactInfo = {firstName, lastName, phoneNumber};
		contactList.add(contactInfo);
	}

	public static boolean checkContactListContainsContact() {
		if(contactList.size() < 1)
			return false;
		return true;
	}

	public static boolean checkPhoneNumber(String phoneNumber) {
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i)[2].equals(phoneNumber)) {
				return false;
			}
		}
		return true;
	}

	public static void displayContacts() {
		for(int i = 0; i < contactList.size(); i++) {
				System.out.println((i + 1) + ". \nFirst name: " + contactList.get(i)[0] + "\nLast name: " + contactList.get(i)[1] + "\nPhone number: " + contactList.get(i)[2]);
				System.out.println();
		}
	}

	public static void removeContact(String remove) {
		contactList.remove(Integer.parseInt(remove) - 1);
		System.out.println("...deleted successfully");
	}
	
	public static String findContactByPhoneNumber(String phoneNumber) {
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i)[2].equals(phoneNumber)) {
				return "First name: " + contactList.get(i)[0] + "\nLast name: " + contactList.get(i)[1] + "\nPhone number: " + contactList.get(i)[2] + "\n";
			}
		}
		return "Phone number does not exist!";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("""
1. Add contact
2. Remove contact
3. Find contact by phone number
4. Find contact by first name
5. Find contact by last name
6. Edit contact
0. Quit

-->\s""");

			int option;
			try {
				option = sc.nextInt();
				System.out.println();
				if(option > 6 || option < 0) {
					System.out.println("Invalid... choose between 0 - 6");
					System.out.println();
					continue;
				}
			} catch(Exception e) {
				System.out.println("Invalid... Enter a number");
				System.out.println();
				sc.nextLine();
				continue;
			}
			
			switch(option) {
				case 1: 
					System.out.print("First Name: ");
					String firstName = sc.next().trim();
					System.out.print("Last Name: ");
					String lastName = sc.next().trim();
					while(true) {
						System.out.print("Enter phone number: ");
						String phoneNumber = sc.next().trim();
						System.out.println();
						try {
							if(phoneNumber.length() != 11) {
								System.out.println("Invalid. Phone number must be 11 digits\n");
								continue;
							}
							Double.parseDouble(phoneNumber);
						} catch(Exception e) {
							System.out.println("Invalid. Phone number must contain only digits");
							System.out.println();
							continue;
						}
						if(!checkPhoneNumber(phoneNumber)) {
							System.out.println("Phone number already exists!");
							continue;
						}
						
						addContact(firstName, lastName, phoneNumber);
						break;
					}
					
					while(true) {
						System.out.print("...added successfully\n0. Back\n--> ");
						String back = sc.next().trim();
						if(back.equals("0"))
							break;	
						System.out.println("Invalid! Try again\n");
					}
					break;
					
				case 2: 
					if(!checkContactListContainsContact()) {
						System.out.println("Contact list is empty");
						System.out.println();
						continue;
					}
					displayContacts();
					while(true) {
						System.out.print("What contact are you removing: ");
						String remove = sc.next().trim();
						try {
							if(Integer.parseInt(remove) < 1 || Integer.parseInt(remove) > contactList.size()) {
								System.out.println("Invalid. Check again...");
								continue;
							}
							//Integer.parseInt(remove);
						} catch(Exception e) {
							System.out.println("Invalid. Input must be a digit");
							System.out.println();
							continue;
						}
						System.out.println(contactList.size());
						System.out.println(Arrays.toString(contactList.get(0)));
						removeContact(remove);
						break;
					}
					while(true) {
						System.out.print("...removed successfully\n0. Back\n--> ");
						String back = sc.next().trim();
						if(back.equals("0"))
							break;	
						System.out.println("Invalid! Try again\n");
					}
					break;
					
				case 3:
					if(!checkContactListContainsContact()) {
						System.out.println("Contact list is empty");
						continue;
					}
					while(true) {
						System.out.print("Enter the phone number: ");
						String phoneNum = sc.next().trim();
						System.out.println();
						System.out.print(findContactByPhoneNumber(phoneNum));
						if(!findContactByPhoneNumber(phoneNum).equals("Phone number does not exist!"))
							break;
					}
					System.out.println();
					while(true) {
						System.out.print("0. Back\n--> ");
						String back = sc.next().trim();
						if(back.equals("0"))
							break;	
						System.out.println("Invalid! Try again\n");
					}
					break;
			}
			System.out.println();

		}
	
			
	}
	
	
	
}