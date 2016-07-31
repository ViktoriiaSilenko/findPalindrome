package palindrome;

import java.math.BigInteger;

public class Palindrome {

	private long multiplier1;
	private long multiplier2;

	public Palindrome(long multiplier1, long multiplier2) {
		this.multiplier1 = multiplier1;
		this.multiplier2 = multiplier2;
	}

	public long getMultiplier1() {
		return multiplier1;
	}

	public void setMultiplier1(long multiplier1) {
		this.multiplier1 = multiplier1;
	}

	public long getMultiplier2() {
		return multiplier2;
	}

	public void setMultiplier2(long multiplier2) {
		this.multiplier2 = multiplier2;
	}
	
	public BigInteger calculateValue() {
		return BigInteger.valueOf(multiplier1).multiply(BigInteger.valueOf(multiplier2));
	}

	@Override
	public String toString() {
		return "The palindrome is " + calculateValue()
				+ " = " + multiplier1 + " * " + multiplier2;
	}

}
