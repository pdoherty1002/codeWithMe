/**
 * 
 */
package codeBreaker;

/**
 * @author pierc
 *
 */
public class ChallengeTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] oneToOneHundred = new int[100];
		int seed = 1;
		for (int loop = 0; loop < oneToOneHundred.length; loop++) {
			oneToOneHundred[loop] = seed;
			seed++;

			if ((oneToOneHundred[loop] % 3 == 0) && (oneToOneHundred[loop] % 5 == 0)) {
				System.out.println("Fizz Buzz");
			} else if (oneToOneHundred[loop] % 3 == 0) {
				System.out.println("Fizz");
			} else if (oneToOneHundred[loop] % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(oneToOneHundred[loop]);
			}
		}

	}

}
