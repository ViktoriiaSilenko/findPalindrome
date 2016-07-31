package palindrome;

import java.math.BigInteger;

public class PalidromeCalculator {

	/**
	 * Find the largest palindrome (a palindrome is a number that reads the same in either direction, e.g. 1221) 
	 * formed by the product of two three-digit numbers
	 * @return the largest palindrome
	 */
	public Palindrome calculateLargestPalindromeFrom3DigitMultiplier() {

		BigInteger largestPalindrome = BigInteger.ZERO;
		int multiplier1 = 0;
		int multiplier2 = 0;

		for (int i = 999; i > 100; i--) {
			for (int j = 999; j > i; j--) {
				BigInteger palindromeValue = new Palindrome(i, j).calculateValue();
				if (isPalindrome(palindromeValue) && (palindromeValue.compareTo(largestPalindrome) > 1)) {
					largestPalindrome = palindromeValue;
					multiplier1 = i;
					multiplier1 = j;
				}
			}
		}

		return new Palindrome(multiplier1, multiplier2);
	}

	private boolean isPalindrome(BigInteger number) {
		StringBuilder reverseNumber = new StringBuilder(number.toString()).reverse();
		return reverseNumber.toString().equals(number.toString());
	}

}
