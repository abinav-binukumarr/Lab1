// App.java
package com.ontariotechu.sofe3980U;

import org.joda.time.LocalTime;
import java.util.Scanner;

/**
 * Main application class.
 */
public class App
{
	/**
	 * Entry point of the program. Prints local time,
	 * then performs binary operations.
	 *
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		LocalTime currentTime = new LocalTime();
		System.out.println("Current local time: " + currentTime);

		Binary binary1 = new Binary("10101");
		System.out.println("First binary: " + binary1.getValue());

		Binary binary2 = new Binary("1100");
		System.out.println("Second binary: " + binary2.getValue());

		Binary sum = Binary.add(binary1, binary2);
		System.out.println("Sum: " + sum.getValue());

		Scanner scanner = new Scanner(System.in);

		System.out.println("\nEnter first binary number: ");
		String bin1 = scanner.nextLine();
		Binary newBinary1 = new Binary(bin1);

		System.out.println("Enter second binary number: ");
		String bin2 = scanner.nextLine();
		Binary newBinary2 = new Binary(bin2);

		Binary newSum = Binary.add(newBinary1, newBinary2);
		System.out.println("New sum: " + newSum.getValue());

		Binary orResult = Binary.or(newBinary1, newBinary2);
		System.out.println("OR result: " + orResult.getValue());

		Binary andResult = Binary.and(newBinary1, newBinary2);
		System.out.println("AND result: " + andResult.getValue());

		Binary multiplyResult = Binary.multiply(newBinary1, newBinary2);
		System.out.println("Multiplication result: " + multiplyResult.getValue());

		scanner.close();
	}
}
