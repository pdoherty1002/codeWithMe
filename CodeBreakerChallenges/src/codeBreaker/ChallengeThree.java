/**
 * 
 */
package codeBreaker;

/**
 * @author pierc
 *
 */
public class ChallengeThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int outer = 0; outer <= 2; outer++) {
			for (int inner = 1; inner < 11; inner++) {
				if (outer == 0) {
					System.out.print("*");
				} else if (outer == 1) {
					System.out.print("**");
				} else {
					System.out.print("***");
				}
				System.out.print(inner);
				if (inner != 10) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}

	}

}
