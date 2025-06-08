import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckOut {
	static Scanner sc = new Scanner(System.in);

	public static String getCustomerName() {
		System.out.print("What is the customer's name: ");
		String customerName = sc.nextLine().trim();
		return customerName;	
	}
	
	public static String getItemBought() {
		System.out.print("What did the customer buy: ");
		String itemBought = sc.nextLine().trim();
		return itemBought;	
	}
	
	public static int getQuantity() {
		int quantity = 0;
		
		while(true) {
			System.out.print("How many pieces: ");
			String input = sc.nextLine();
			try {
				quantity = Integer.parseInt(input);
				if (quantity <= 0) {
					System.out.println("Quantity cannot be less than one");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("Invalid quantity! Try again");
			}
		}
		return quantity;	
	}
	
	public static double getPrice() {
		double pricePerUnit = 0;
		while(true) {
			System.out.print("How much per unit: ");
			String input = sc.nextLine();
			try {
				pricePerUnit = Double.parseDouble(input);
				if (pricePerUnit <= 0) {
					System.out.println("Price cannot be less than one");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("Invalid price! Try again");
			}
		}
		return pricePerUnit;	
	}
	
	public static double getItemTotal(int quantity, double pricePerUnit) {
		return quantity * pricePerUnit;
	}
	
	public static String getCashierName() {
		System.out.print("What is the your name: ");
		String cashierName = sc.nextLine().trim();
		return cashierName;	
	}
	
	public static double getSubtotal(ArrayList<HashMap<String, String>> allDetails) {
		double subtotal = 0;
		for(int det = 0; det < allDetails.size(); det++) {
			double total = Double.parseDouble(allDetails.get(det).get("total"));
			subtotal += total;
		}
		return subtotal;
	}
	
	public static double getDiscountAmount(double subtotal) {
		double discount = 0;
		while(true) {
			System.out.print("How much discount will they get(%): ");
			String input = sc.nextLine();
			try {
				discount = Double.parseDouble(input);
				if (discount <= 0) {
					System.out.println("Discount cannot be less than one");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("Invalid discount! Try again");
			}
		}
		return subtotal * (discount / 100);
	}
	
	public static double getVat(double subtotal) {
		final double VAT = 7.5;
		return subtotal * (VAT / 100);
	}
	
	public static double getBillTotal(double subtotal, double discount, double vat) {
		return subtotal - discount + vat;
	}
	
	public static double getAmountPaid(double billTotal) {
		double amountPaid = 0;
		while(true) {
			System.out.print("How much did the customer give to you: ");
			String input = sc.nextLine();
			try {
				amountPaid = Double.parseDouble(input);
				if(amountPaid < billTotal) {
					System.out.println("Amount insufficient! Try again");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("Invalid amount! Try again");
			}
		}
		return amountPaid;
	}
	
	public static double getBalance(double amountPaid, double billTotal) {
		return amountPaid - billTotal;
	}		
	
	public static boolean getResponse() {
		String response = "";
		while(true) {
			System.out.print("Add more items (yes/no): ");
			response = sc.nextLine().trim().toLowerCase();
			if(response.equals("yes") || response.equals("no")) {
				break;
			}
		}
		return response.equals("yes");
	}
		
	public static void main(String[] args) {
		HashMap<String, String> details = new HashMap<>();
		ArrayList<HashMap<String, String>> allDetails = new ArrayList<>();	
		
		String customerName = getCustomerName();;
		String itemBought = "";
		int quantity = 0;
		double pricePerUnit = 0;
		double itemTotal = 0;
		
	 	while(true) {
	 		details = new HashMap<>();
			
			itemBought = getItemBought();
			details.put("item", itemBought);
			
			quantity = getQuantity();
			details.put("qty", Integer.toString(quantity));
			
			pricePerUnit = getPrice();
			details.put("price", Double.toString(pricePerUnit));
			
			itemTotal = getItemTotal(quantity, pricePerUnit);
			details.put("total", Double.toString(itemTotal));
						
			allDetails.add(details);
			
			boolean response = getResponse();
			if(response == false) break;
		}
		
		String cashierName = getCashierName();
		double subtotal = getSubtotal(allDetails);
		double discount = getDiscountAmount(subtotal);
		double vat = getVat(subtotal);
		double billTotal = getBillTotal(subtotal, discount, vat);
		double amountPaid = getAmountPaid(billTotal);
		double balance = getBalance(amountPaid, billTotal);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a");
		LocalDateTime date = LocalDateTime.now();
		
		System.out.println();
		System.out.print("""
SEMICOLON STORES
MAIN BRANCH
LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
TEL: 03293828343
""");
		System.out.println("Date: " + date.format(fmt));
		System.out.println("Cashier: " + cashierName);
		System.out.println("Customer Name: " + customerName);
		
		String sym = "";
		for(int i = 0; i < 54; i++) sym += "=";
		System.out.println();
		System.out.println(sym);
		
		System.out.printf("%20s%6s%14s%14s%n","ITEM","QTY","PRICE","TOTAL(NGN)");
		String sym2 = "";
		for(int i = 0; i < 54; i++) sym2 += "-";
		System.out.println(sym2);
		
		for(int i = 0; i < allDetails.size(); i++) {
			String item = allDetails.get(i).get("item");
			int qty = Integer.valueOf(allDetails.get(i).get("qty"));
			double ttu = Double.valueOf(allDetails.get(i).get("price"));
			double itmTotal = Double.valueOf(allDetails.get(i).get("total"));
			
			System.out.printf("%20s%6d%14.2f%14.2f%n",item,qty,ttu,itmTotal);	
		}
		
		System.out.println(sym2);
		System.out.printf("%40s%14.2f%n", "Sub Total:", subtotal);
		System.out.printf("%40s%14.2f%n", "Discount:", discount);
		System.out.printf("%40s%14.2f%n", "VAT @ 17.50%:", vat);
		
		System.out.println(sym);
		
		System.out.printf("%40s%14.2f%n", "Bill Total:", billTotal);
		System.out.printf("%40s%14.2f%n", "Amount Paid:", amountPaid);
		System.out.printf("%40s%14.2f%n", "Balance:", balance);
				
		System.out.println(sym);
		System.out.printf("             %28s%n", "THANK YOU FOR YOUR PATRONAGE");
		
		System.out.println(sym);			
	}
}