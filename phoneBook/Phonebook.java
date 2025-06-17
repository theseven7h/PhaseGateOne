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
	
	public static String findContactByFirstName(String firstName) {
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i)[0].equals(firstName)) {
				return "First name: " + contactList.get(i)[0] + "\nLast name: " + contactList.get(i)[1] + "\nPhone number: " + contactList.get(i)[2] + "\n";
			}
		}
		return "Name does not exist!";
	}
	
	public static String findContactByLastName(String lastName) {
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i)[1].equals(lastName)) {
				return "First name: " + contactList.get(i)[0] + "\nLast name: " + contactList.get(i)[1] + "\nPhone number: " + contactList.get(i)[2] + "\n";
			}
		}
		return "Name does not exist!";
	}
	
	public static void editContact(String edit, String editChoice, String entry) {
		contactList.get(Integer.parseInt(edit) - 1)[Integer.parseInt(editChoice) - 1] = entry;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("""
1. Add contact
2. View contacts
3. Remove contact
4. Find contact by phone number
5. Find contact by first name
6. Find contact by last name
7. Edit contact
0. Quit

-->\s""");

			int option;
			try {
				option = sc.nextInt();
				System.out.println();
				if(option > 7 || option < 0) {
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
					System.out.println();
					while(true) {
						System.out.print("0. Back\n--> ");
						String back = sc.next().trim();
						if(back.equals("0"))
							break;	
						System.out.println("Invalid! Try again\n");
					}
					break;	
					
				case 3: 
					if(!checkContactListContainsContact()) {
						System.out.println("Contact list is empty");
						System.out.println();
						continue;
					}
					displayContacts();
					while(true) {
						System.out.print("Which contact do you want to remove: ");
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
					
				case 4:
					if(!checkContactListContainsContact()) {
						System.out.println("Contact list is empty");
						continue;
					}
					while(true) {
						System.out.print("Enter the phone number: ");
						String phoneNum = sc.next().trim();
						System.out.println();
						System.out.print(findContactByPhoneNumber(phoneNum));
						System.out.println();

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
					
				case 5:
					if(!checkContactListContainsContact()) {
						System.out.println("Contact list is empty");
						continue;
					}
					while(true) {
						System.out.print("Enter the first name: ");
						String name = sc.next().trim();
						System.out.println();
						System.out.print(findContactByFirstName(name));
						System.out.println();
						if(!findContactByFirstName(name).equals("Name does not exist!"))
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
					
				case 6:
					if(!checkContactListContainsContact()) {
						System.out.println("Contact list is empty");
						continue;
					}
					while(true) {
						System.out.print("Enter the last name: ");
						String name = sc.next().trim();
						System.out.println();
						System.out.print(findContactByLastName(name));
						System.out.println();
						if(!findContactByLastName(name).equals("Name does not exist!"))
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
					
				case 7:
					if(!checkContactListContainsContact()) {
						System.out.println("Contact list is empty");
						continue;
					}
					displayContacts();
					while(true) {
						System.out.print("Which contact do you want to edit: ");
						String edit = sc.next().trim();
						try {
							if(Integer.parseInt(edit) < 1 || Integer.parseInt(edit) > contactList.size()) {
								System.out.println("Invalid. Check again...");
								continue;
							}
						} catch(Exception e) {
							System.out.println("Invalid. Input must be a digit");
							System.out.println();
							continue;
						}
						
						while(true) {
							System.out.print("1. Edit first name\n2. Edit last name\n3. Edit phone number\n0. Back\n--> ");
							String editChoice = sc.next().trim();
							System.out.println();
							switch(editChoice) {
								case "1": 
									System.out.print("Enter first name: ");
									String fName = sc.next().trim();
									editContact(edit, editChoice, fName);
									break;
									
								case "2": 
									System.out.print("Enter last name: ");
									String lName = sc.next().trim();
									editContact(edit, editChoice, lName);
									break;
									
								case "3": 
									while(true) {
										System.out.print("Enter phone number: ");
										String number = sc.next().trim();
										System.out.println();
										try {
											if(number.length() != 11) {
												System.out.println("Invalid. Phone number must be 11 digits\n");
												continue;
											}
											Double.parseDouble(number);
										} catch(Exception e) {
											System.out.println("Invalid. Phone number must contain only digits");
											System.out.println();
											continue;
										}
										if(!checkPhoneNumber(number)) {
											System.out.println("Phone number already exists!");
											continue;
										}
										editContact(edit, editChoice, number);
										break;
									}
									break;
								
								case "0":
									break;
									
								default:
									System.out.println("Invalid... Try again");
							}
							break;
						}
						break;						
					}
					break;
					
				case 0:
					System.exit(0);
			}
			System.out.println();
		}
	}
}