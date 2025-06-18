import java.util.Scanner;
import java.util.ArrayList;

public class BankeAtm {
	static ArrayList<String[]> accounts = new ArrayList<>();
	static long nextAccountNumber = 1000000000L;

	public static void createAccount(String firstName, String lastName, String pin) {
		String accountNumber = Long.toString(++nextAccountNumber);
		String balance = "0.0";
		String[] account = new String[]{firstName, lastName, accountNumber, pin, balance};
		accounts.add(account);
	}
	
	public static boolean checkAccountsNotEmpty() {
		if(accounts.size() < 1)
			return true;
		return false;
	}
	
	public static void viewAccount(String pin) {
		for(String[] account : accounts) {
			if(pin.equals(account[3])) {
				System.out.printf("First name: %s%nLast name: %s%nAccount number: %s%nPin: %s%nBalance: %s naira%n", account[0], account[1], account[2], account[3], account[4]);
				return;
			}
		}
		System.out.println("Pin invalid");
	}
	
	public static int verifyPin(String pin, String accountNumber) {
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i)[2].equals(accountNumber) && accounts.get(i)[3].equals(pin)) {
				return i;
			}
		}
		return -1;
	}
	
	public static String getBalance(int verify) {
		return accounts.get(verify)[4];
	}
	
	public static void deposit(int verify, double amount) {
		double balance = Double.parseDouble(accounts.get(verify)[4]);
		accounts.get(verify)[4] = String.valueOf(balance + amount);
	}
	
	public static void withdraw(int verify, double amount) {
		double balance = Double.parseDouble(accounts.get(verify)[4]);
		accounts.get(verify)[4] = String.valueOf(balance - amount);
	}
	
	public static void transfer(String accountNumber, int verify, double amount) {
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i)[2].equals(accountNumber)) {
				double balance = Double.parseDouble(accounts.get(i)[4]);
				accounts.get(i)[4] = String.valueOf(balance + amount);
				double myBalance = Double.parseDouble(accounts.get(verify)[4]);
				accounts.get(verify)[4] = String.valueOf(myBalance - amount);
			}
		}
	}
	
	public static void closeAccount(int verify) {
		accounts.remove(verify);
	}
	
	public static void changePin(int verify, String newPin) {
		accounts.get(verify)[3] = newPin;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("\nWELCOME TO BANKE ATM");
			System.out.print("""
											
1. Create an account
2. View account
3. Deposit money
4. Withdraw money
5. Check account balance
6. Transfer
7. Change pin
8. Close account
0. Quit

-->\s""");
			int option;
			try {
				option = sc.nextInt();
				System.out.println();
				if(option < 0 || option > 8) {
					System.out.println("Invalid option. Try again");
					continue;
				}
			} catch(Exception e) {
				System.out.println();
				System.out.println("Invalid option. Enter a number");
				continue;
			}
			
			switch(option) {
				case 1:
					System.out.print("Enter first name\n--> ");
					String firstName = sc.next().trim();
					
					System.out.print("Enter last  name\n--> ");
					String lastName = sc.next().trim();
					
					while(true) {
						System.out.print("Enter desired 4-digit pin\n--> ");
						String pin = sc.next().trim();	
						try {
							Integer.parseInt(pin);
							if(pin.length() != 4) {
								System.out.println("Invalid pin length. Try again");
								continue;	
							}
						} catch(Exception e) {
							System.out.println("Invalid. Pin must contain only numbers");
							continue;
						}
						createAccount(firstName, lastName, pin);
						while(true) {
							System.out.println();
							System.out.print("...account creation successful\n0. Back\n--> ");
							String back = sc.next().trim();
							if(back.equals("0"))
								break;
							System.out.println("Invalid. Try again");
						}
						break;
					}	
					break;
					
				case 2: 
					if(checkAccountsNotEmpty()) {
						System.out.println("No accounts currently... create an account first");
						continue;
					}
					while(true) {
						System.out.print("Enter your pin\n--> ");
						String pin = sc.next().trim();
						System.out.println();	
						try {
							Integer.parseInt(pin);
							if(pin.length() != 4) {
								System.out.println("Invalid pin length. Try again");
								continue;	
							}
			
						} catch(Exception e) {
							System.out.println("Invalid. Pin must contain only numbers");
							continue;
						}
						viewAccount(pin);
						while(true) {
							System.out.println();
							System.out.print("0. Back\n--> ");
							String back = sc.next().trim();
							if(back.equals("0"))
								break;
							System.out.println("Invalid. Try again");
						}
						break;
					}
					
					break;	
					
				case 3: 
					if(checkAccountsNotEmpty()) {
						System.out.println("No accounts currently... create an account first");
						continue;
						
					}
					while(true) {
						String accNum;
						while(true) {
							System.out.print("Enter the account number\n--> ");
							try {
								accNum = sc.next().trim();
								if(accNum.length() != 10) {
									System.out.println("Invalid. Account number must be 10 digits");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid inputs. Enter a valid amount");
								sc.nextLine();
							}
						}	
						System.out.println();
							
						double amount;
						while(true) {
							System.out.print("Enter the deposit amount\nMaximum of 100,000\n--> ");
							try {
								amount = sc.nextDouble();
								if(amount <= 0 || amount > 100000) {
									System.out.println("Invalid amount. Try again");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid inputs. Enter a valid amount");
								sc.nextLine();
							}
						}
						System.out.println();
						
						String pin;
						while(true) {
							System.out.print("Enter the pin\n--> ");
							try {
								pin = sc.next().trim();
								if(pin.length() != 4) {
									System.out.println("Invalid. Pin number must be 4 digits");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid. Pin must contain only digits");
								sc.nextLine();
							}
						}
						int verify = verifyPin(pin, accNum);
						if(verify == -1) {
							System.out.println("Invalid pin and/or account number. Start again");
							continue;
						}
						deposit(verify, amount);
						while(true) {
							System.out.println();
							System.out.print("...deposit successful\n0. Back\n--> ");
							String back = sc.next().trim();
							if(back.equals("0"))
								break;
							System.out.println("Invalid. Try again");
						}
						break;
					}
					break;
					
				case 4: 
					if(checkAccountsNotEmpty()) {
						System.out.println("No accounts currently... create an account first");
						continue;
						
					}
					while(true) {
						String accNum;
						while(true) {
							System.out.print("Enter the account number\n--> ");
							try {
								accNum = sc.next().trim();
								if(accNum.length() != 10) {
									System.out.println("Invalid. Account number must be 10 digits");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid inputs. Enter a valid amount");
								sc.nextLine();
							}
						}	
						System.out.println();
							
						double amount;
						while(true) {
							System.out.print("Enter the withdrawal amount\nMaximum of 100,000\n--> ");
							try {
								amount = sc.nextDouble();
								if(amount <= 0 || amount > 100000) {
									System.out.println("Invalid amount. Try again");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid inputs. Enter a valid amount");
								sc.nextLine();
							}
						}
						System.out.println();
						
						String pin;
						while(true) {
							System.out.print("Enter the pin\n--> ");
							try {
								pin = sc.next().trim();
								if(pin.length() != 4) {
									System.out.println("Invalid. Pin number must be 4 digits");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid. Pin must contain only digits");
								sc.nextLine();
							}
						}
						int verify = verifyPin(pin, accNum);
						if(verify == -1) {
							System.out.println("Invalid pin and/or account number. Start again");
							continue;
						}
						
						if(amount > Double.parseDouble(getBalance(verify))) {
							System.out.println("Insufficient funds. Start again");
							continue;
						}
						
						withdraw(verify, amount);
						while(true) {
							System.out.println();
							System.out.print("...withdrawal successful\n0. Back\n--> ");
							String back = sc.next().trim();
							if(back.equals("0"))
								break;
							System.out.println("Invalid. Try again");
						}
						break;
					}
					break;
				
				case 5:
					if(checkAccountsNotEmpty()) {
						System.out.println("No accounts currently... create an account first");
						continue;
					}
					while(true) {
						String accNum;
						while(true) {
							System.out.print("Enter the account number\n--> ");
							try {
								accNum = sc.next().trim();
								if(accNum.length() != 10) {
									System.out.println("Invalid. Account number must be 10 digits");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid inputs. Enter a valid amount");
								sc.nextLine();
							}
						}	
						System.out.println();
						
						String pin;
						while(true) {
							System.out.print("Enter the pin\n--> ");
							try {
								pin = sc.next().trim();
								if(pin.length() != 4) {
									System.out.println("Invalid. Pin number must be 4 digits");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid. Pin must contain only digits");
								sc.nextLine();
							}
						}
						int verify = verifyPin(pin, accNum);
						if(verify == -1) {
							System.out.println("Invalid pin and/or account number. Start again");
							continue;
						}
						System.out.println(getBalance(verify) + " naira");
						break;
					}
					while(true) {
						System.out.println();
						System.out.print("0. Back\n--> ");
						String back = sc.next().trim();
						if(back.equals("0"))
							break;
						System.out.println("Invalid. Try again");
					}
					break;
					
				case 6:
					if(checkAccountsNotEmpty()) {
						System.out.println("No accounts currently... create an account first");
						continue;
					}
					while(true) {
						String userAccNum;
						while(true) {
							System.out.print("Enter the user account number\n--> ");
							try {
								userAccNum = sc.next().trim();
								if(userAccNum.length() != 10) {
									System.out.println("Invalid. Account number must be 10 digits");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid inputs. Enter a valid amount");
								sc.nextLine();
							}
						}	
						System.out.println();
					
						String accNum;
						while(true) {
							System.out.print("Enter your account number\n--> ");
							try {
								accNum = sc.next().trim();
								if(accNum.length() != 10) {
									System.out.println("Invalid. Account number must be 10 digits");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid inputs. Enter a valid amount");
								sc.nextLine();
							}
						}	
						System.out.println();
						
						String pin;
						while(true) {
							System.out.print("Enter your pin\n--> ");
							try {
								pin = sc.next().trim();
								if(pin.length() != 4) {
									System.out.println("Invalid. Pin number must be 4 digits");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid. Pin must contain only digits");
								sc.nextLine();
							}
						}
						int verify = verifyPin(pin, accNum);
						if(verify == -1) {
							System.out.println("Your pin and/or account number is invalid. Start again");
							continue;
						}
						
						double amount;
						while(true) {
							System.out.print("Enter the transfer amount\nMaximum of 100,000\n--> ");
							try {
								amount = sc.nextDouble();
								if(amount <= 0 || amount > 100000) {
									System.out.println("Invalid amount. Try again");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid input. Enter a valid amount");
								sc.nextLine();
							}
						}
						System.out.println();
						if(amount > Double.parseDouble(getBalance(verify))) {
							System.out.println("Insufficient funds. Start again");
							continue;
						}
						
						transfer(userAccNum, verify, amount);
						while(true) {
							System.out.println();
							System.out.print("...transfer successful\n0. Back\n--> ");
							String back = sc.next().trim();
							if(back.equals("0"))
								break;
							System.out.println("Invalid. Try again");
						}
			
						break;
					}
					break;
				
				case 7: 
					if(checkAccountsNotEmpty()) {
						System.out.println("No accounts currently... create an account first");
						continue;
					}
					
					while(true) {
						String accNum;
						while(true) {
							System.out.print("Enter the account number\n--> ");
							try {
								accNum = sc.next().trim();
								if(accNum.length() != 10) {
									System.out.println("Invalid. Account number must be 10 digits");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid inputs. Enter a valid amount");
								sc.nextLine();
							}
						}	
						System.out.println();
						
						String pin;
						while(true) {
							System.out.print("Enter the present pin\n--> ");
							try {
								pin = sc.next().trim();
								if(pin.length() != 4) {
									System.out.println("Invalid. Pin number must be 4 digits");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid. Pin must contain only digits");
								sc.nextLine();
							}
						}
						System.out.println();
						
						int verify = verifyPin(pin, accNum);
						if(verify == -1) {
							System.out.println("Your pin and/or account number is invalid. Start again");
							continue;
						}
						
						String newPin;
						while(true) {
							System.out.print("Enter new 4-digit pin\n--> ");
							newPin = sc.next().trim();	
							try {
								Integer.parseInt(newPin);
								if(newPin.length() != 4) {
									System.out.println("Invalid pin length. Try again");
									continue;	
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid. Pin must contain only numbers");
								continue;
							}
						}
						System.out.println();
						
						changePin(verify, newPin);
						while(true) {
							System.out.println();
							System.out.print("...pin changed succesfully\n0. Back\n--> ");
							String back = sc.next().trim();
							if(back.equals("0"))
								break;
							System.out.println("Invalid. Try again");
						}
						break;
					}
					break;
				
				case 8:
					if(checkAccountsNotEmpty()) {
						System.out.println("No accounts currently... create an account first");
						continue;
					}
					
					while(true) {
						String accNum;
						while(true) {
							System.out.print("Enter your account number\n--> ");
							try {
								accNum = sc.next().trim();
								if(accNum.length() != 10) {
									System.out.println("Invalid. Account number must be 10 digits");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid inputs. Enter a valid amount");
								sc.nextLine();
							}
						}	
						System.out.println();
						
						String pin;
						while(true) {
							System.out.print("Enter your pin\n--> ");
							try {
								pin = sc.next().trim();
								if(pin.length() != 4) {
									System.out.println("Invalid. Pin number must be 4 digits");
									continue;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid. Pin must contain only digits");
								sc.nextLine();
							}
						}
						
						int verify = verifyPin(pin, accNum);
						if(verify == -1) {
							System.out.println("Your pin and/or account number is invalid. Start again");
							continue;
						}
						closeAccount(verify);
						
						while(true) {
							System.out.println();
							System.out.print("...account closed successful\n0. Back\n--> ");
							String back = sc.next().trim();
							if(back.equals("0"))
								break;
							System.out.println("Invalid. Try again");
						}
						break;
					}
					break;
					
				case 0:
					System.out.println("THANK YOU FOR USING BANKE BANK\nHave a nice day... ^_^");
					System.exit(0);							
			}
		}		
	}
}