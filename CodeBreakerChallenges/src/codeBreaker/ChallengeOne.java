/**
 * 
 */
package codeBreaker;

import java.util.Arrays;
/**
 * @author pierc
 *
 */
public class ChallengeOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String name = "Pierce Doherty";
		
		System.out.println("Name to be coded "+name);
		int[] coded = code(name);
		System.out.println(Arrays.toString(coded));
		
		char[] uncoded = uncoded(coded);
		System.out.println(Arrays.toString(uncoded));
		
	}

	private static int[] code(String name) {

		int[] coded = new int[name.length()];
		
		for(int loop=0;loop<name.length();loop++) {
			coded[loop]=(int)name.charAt(loop);
		}
		
		return coded;
	}
	
	private static char[] uncoded(int[] coded) {
		
		char[] uncoded = new char [coded.length];
		
		for (int loop=0;loop<coded.length;loop++) {
			uncoded[loop]=(char)coded[loop];
		}
		return uncoded;
		
		
		
		
	}

}
