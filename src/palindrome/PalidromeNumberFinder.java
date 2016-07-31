package palindrome;

import java.math.BigInteger;
import static java.math.BigInteger.valueOf;
import static java.math.BigInteger.ZERO;

public final class PalidromeNumberFinder {
	private final BigInteger radix;
	
	public PalidromeNumberFinder(int radix) {
		this.radix = valueOf(radix);
	}

	/**
	 * Find the largest palindrome (a palindrome is a number that reads the same in either direction, e.g. 1221) 
	 * formed by the product of two three-digit numbers
	 * @param multipliersDigitCount is count of digits in each multiplier
	 * @return the largest palindrome
	 */
	public BigInteger calculateLargestPalindrome(int multipliersDigitCount) {
		BigInteger largestPalindrome = ZERO;
		if (multipliersDigitCount <= 0) {
			throw new IllegalArgumentException("Count of digits in multipliers cannot be <= 0");
		}

		int n = (int) Math.pow(radix.doubleValue(), multipliersDigitCount) - 1;
		int m = (int) Math.pow(radix.doubleValue(), multipliersDigitCount - 1);

		for (int i = n; i >= m; i--) {
			for (int j = n; j > i; j--) {
				BigInteger palindromeValue = valueOf(i).multiply(valueOf(j));
				
				if (isPalindrome(palindromeValue) && (palindromeValue.compareTo(largestPalindrome) > 0)) {
					largestPalindrome = palindromeValue;
				}
			}
		}

		return largestPalindrome;
	}
	
	public boolean isPalindrome(BigInteger number) {
		if (number == null) {
			return false;
		}
		
		if (number.signum() == -1) { // if number is negative
			throw new IllegalArgumentException("Number cannot be negative");
		}
		
		BigInteger remainder = ZERO;
		BigInteger reversedNumber = ZERO;
		BigInteger numberCopy = number;
		
		while(numberCopy.signum() != 0 ) {
	        remainder = numberCopy.remainder(radix);
	        reversedNumber = reversedNumber.multiply(radix).add(remainder);
	        numberCopy = numberCopy.divide(radix);
	    }
		
		return number.compareTo(reversedNumber) == 0;
	}

}
