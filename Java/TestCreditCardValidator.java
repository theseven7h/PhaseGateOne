import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCreditCardValidator {
	CreditCardValidator ccv = new CreditCardValidator();
	
	@Test 
	public void testCheckTypeFunctionExists() {
		String entry = "4388576018410707";
		int length = entry.length();
		assertNotNull(ccv.checkType(entry, length));
	}
	
	@Test	
	public void testCheckTypeFunctionAmericanExpress() {
		String entry = "373233232323432";
		int length = entry.length();
		String actual = ccv.checkType(entry, length);
		String expected = "American Express Card"; 
		assertEquals(actual, expected);
	}	
		
	@Test
	public void testCheckTypeFunctionVisa() {
		String entry = "4388576018402626";
		int length = entry.length();
		String actual = ccv.checkType(entry, length);
		String expected = "Visa"; 
		assertEquals(actual, expected);
	}	
	
	@Test	
	public void testCheckTypeFunctionMasterCard() {
		String entry = "5388586018702826";
		int length = entry.length();
		String actual = ccv.checkType(entry, length);
		String expected = "MasterCard"; 
		assertEquals(actual, expected);
	}	
	
	@Test	
	public void testCheckTypeFunctionDiscover() {
		String entry = "6388676018402628";
		int length = entry.length();
		String actual = ccv.checkType(entry, length);
		String expected = "Discover";
		assertEquals(actual, expected);
	}	
	
	@Test	
	public void testCheckTypeFunctionInvalidCard() {
		String entry = "2388576018402626";
		int length = entry.length();
		String actual = ccv.checkType(entry, length);
		String expected = "Invalid Card"; 
		assertEquals(actual, expected);
	}
	
	@Test	
	public void testCheckValidityFunctionExists() {
		String entry = "4388576018410707";
		assertNotNull(ccv.checkValidity(entry));
	}
	
	@Test	
	public void testCheckValidityFunctionForValid() {
		String entry = "4388576018402626";
		String actual = ccv.checkValidity(entry);
		String expected = "Valid";
		assertEquals(actual, expected);
	}
	
	@Test	
	public void testCheckValidityFunctionForInvalid() {
		String entry = "4388576018410707";
		String actual = ccv.checkValidity(entry);
		String expected = "Invalid";
		assertEquals(actual, expected);
	}
}