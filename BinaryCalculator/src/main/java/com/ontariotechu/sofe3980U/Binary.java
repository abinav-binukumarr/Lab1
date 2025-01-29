// Binary.java
package com.ontariotechu.sofe3980U;

/**
 * Represents an unsigned binary number.
 */
public class Binary
{
	private String number = "0";

	public Binary(String number) {
		if (number == null || number.isEmpty() || !number.matches("[01]+")) {
			this.number = "0";
		} else {
			this.number = number.replaceFirst("^0+", "");
			if (this.number.isEmpty()) {
				this.number = "0";
			}
		}
	}

	public String getValue() {
		return this.number;
	}

	public static Binary add(Binary num1, Binary num2) {
		int carry = 0;
		StringBuilder result = new StringBuilder();
		int i = num1.number.length() - 1, j = num2.number.length() - 1;
		while (i >= 0 || j >= 0 || carry > 0) {
			int sum = carry;
			if (i >= 0) sum += num1.number.charAt(i--) - '0';
			if (j >= 0) sum += num2.number.charAt(j--) - '0';
			result.insert(0, sum % 2);
			carry = sum / 2;
		}
		return new Binary(result.toString());
	}

	public static Binary or(Binary a, Binary b) {
		return bitwiseOperation(a, b, '|');
	}

	public static Binary and(Binary a, Binary b) {
		return bitwiseOperation(a, b, '&');
	}

	public static Binary multiply(Binary a, Binary b) {
		Binary result = new Binary("0");
		for (int i = b.getValue().length() - 1; i >= 0; i--) {
			if (b.getValue().charAt(i) == '1') {
				result = add(result, new Binary(a.getValue() + "0".repeat(b.getValue().length() - 1 - i)));
			}
		}
		return result;
	}

	private static Binary bitwiseOperation(Binary a, Binary b, char operator) {
		int maxLength = Math.max(a.getValue().length(), b.getValue().length());
		String paddedA = padBinary(a.getValue(), maxLength);
		String paddedB = padBinary(b.getValue(), maxLength);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < maxLength; i++) {
			char bitA = paddedA.charAt(i);
			char bitB = paddedB.charAt(i);
			if (operator == '|') {
				result.append((bitA == '1' || bitB == '1') ? '1' : '0');
			} else {
				result.append((bitA == '1' && bitB == '1') ? '1' : '0');
			}
		}
		return new Binary(result.toString());
	}

	private static String padBinary(String binary, int length) {
		while (binary.length() < length) {
			binary = "0" + binary;
		}
		return binary;
	}
}
