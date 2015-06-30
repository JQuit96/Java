/**
 * Purpose: Enter a number and have the program 
 * generate PI up to that many decimal places.
 */
package findPiToNthLimit;

/**
 * @author Julian D. Quitian
 * @date 6/16/2015
 */

import java.util.Scanner;

public class FindPiToNthLimit {

	/**
	 * 
	 */
	public FindPiToNthLimit(){}
	
	/**
	 * @param limit Number of decimal places to limit PI to
	 * @return String "3" if limit is 0
	 * @return String formattedPI otherwise.
	 */
	public static String formatPI(int limit)
	{
		if(limit == 0)
		{
			return "3";
		}
		String formattedPI;
		String PIWord = Double.toString(Math.PI);
		formattedPI = PIWord.substring(0, limit + 2);
		return formattedPI;
	}

	public static void main(String[] args) 
	{
		int limit = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Hello!");
		System.out.println("To how many decimal places would you like "
				+ "to limit PI?(Max. 15)");
		//Used to assure that input is an integer between 0 and 15.		
		do{
			System.out.println("Please enter a positive number less than 16");
			while(!in.hasNextInt()){
				System.out.println("Please enter a positive number less than 16");
				in.next();
			}
			limit=in.nextInt();
		}while(limit < 0 || limit > 15);

		
		//Close Scanner in
		in.close();
		
		System.out.println("PI formatted to your needs: " + formatPI(limit));		
	}
}
