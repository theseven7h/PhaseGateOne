import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class TestCheckOut {
	static Scanner sc = new Scanner(System.in);
	CheckOut check = new CheckOut();
	HashMap<String, String> details = new HashMap<>();
	ArrayList<HashMap<String, String>> allDetails = new ArrayList<>();
	

	@Test
	public void testGetCustomerNameFunctionExists() {
		assertNotNull(check.getCustomerName());
	}
	
	@Test
	public void testGetCustomerNameFunction() {
		String actual = check.getCustomerName();
		String expected = "James Tauri";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetItemBoughtFunctionExists() {
		assertNotNull(check.getItemBought());
	}
	
	@Test
	public void testGetItemBoughtFunction() {
		String actual = check.getItemBought();
		String expected = "Rice";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetQuantityFunctionExists() {
		assertNotNull(check.getQuantity());
	}
	
	@Test
	public void testGetQuantityFunction() {
		int actual = check.getQuantity();
		int expected = 12;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetPriceFunctionExists() {
		assertNotNull(check.getPrice());
	}
	
	@Test
	public void testGetPriceFunction() {
		double actual = check.getPrice();
		double expected = 1500;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetItemTotalExists() {
		assertNotNull(check.getItemTotal(3, 1500));
	}
	
	@Test
	public void testGetItemTotalFunction() {
		double actual = check.getItemTotal(3, 1500);
		double expected = 4500;
		assertEquals(actual, expected);
	}
		
	@Test
	public void testGetCashierNameExists() {
		assertNotNull(check.getCashierName());
	}
	
	@Test
	public void testGetCashierNameFunction() {
		String actual = check.getCashierName();
		String expected = "Adejare Victor";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetSubTotalExists() {
		details.put("total", "4500");
		allDetails.add(details);
		assertNotNull(check.getSubtotal(allDetails));
	}
	
	@Test
	public void testGetSubTotalFunction() {
		allDetails.clear();
		details.put("total", "4500");
		allDetails.add(details);
		double actual = check.getSubtotal(allDetails);
		double expected = 4500;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetSubTotalFunctionForMultipleTotals() {
		allDetails.clear();
		details.put("total", "4500");
		allDetails.add(details);
		details = new HashMap<>();
		details.put("total", "1300");
		allDetails.add(details);
		details = new HashMap<>();
		details.put("total", "2500");
		allDetails.add(details);
		
		double actual = check.getSubtotal(allDetails);
		double expected = 8300;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetDiscountAmountFunctionExists() {
		assertNotNull(check.getDiscountAmount(1000));
	}
	
	@Test
	public void testGetDiscountAmountFunction() {
		double actual = check.getDiscountAmount(1000);
		double expected = 220;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetVatFunctionExists() {
		assertNotNull(check.getVat(1000));
	}
	
	@Test
	public void testGetVatFunction() {
		double actual = check.getVat(1000);
		double expected = 75;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetBillTotalFunctionExists() {
		double subtotal = 5000, discount = 10, vat = check.getVat(subtotal);
		assertNotNull(check.getBillTotal(subtotal, discount, vat));
	}
	
	@Test
	public void testGetBillTotalFunction() {
		double subtotal = 5000, discount = 500, vat = check.getVat(subtotal);
		double actual = check.getBillTotal(subtotal, discount, vat);
		double expected = 4875;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetAmountPaidExists() {
		double billTotal = 5000;
		assertNotNull(check.getAmountPaid(billTotal));
	}
	
	@Test
	public void testGetAmountPaidFunction() {
		double billTotal = 5000;
		double actual = check.getAmountPaid(billTotal);
		double expected = 7000;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetBalanceFunctionExists() {
		double amountPaid = 10000, billTotal = 9500;
		assertNotNull(check.getBalance(amountPaid, billTotal));
	}
	
	@Test
	public void testGetBalanceFunction() {
		double amountPaid = 10000, billTotal = 9500;
		double actual = check.getBalance(amountPaid, billTotal);
		double expected = 500;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetResponseFunctionExists() {
		assertNotNull(check.getResponse());
	}
	
	@Test
	public void testGetResponseFunction() {
		assertTrue(check.getResponse());
	}	
}