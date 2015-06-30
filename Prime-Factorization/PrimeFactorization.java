/**
 * Purpose: Have the user enter a number and find 
 * all Prime Factors (if there are any) and display them.
 */
package primeFactorization;


/**
 * @author Julian D. Quitian
 * @date 6/30/2015
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorization {
	/**
	 * @param number for which prime factorization will take place.
	 * @return primeFactors list of prime factors of number.
	 */
	  public static List<Integer> primeFactorization(int number) {
		  int n = number;
		   List<Integer> factors = new ArrayList<Integer>();
		   for (int i = 2; i <= n / i; i++) {
			   while (n % i == 0) {
		       factors.add(i);
		       n /= i;
			   }
		    }
		    if (n > 1) {
		      factors.add(n);
		    }
		    return factors;
		  }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int input;
		
		//Introduction Code
		System.out.println("Welcome to Prime Factorizer!");
		
		//Used to assure that input is an integer between 0 and 15.		
		do{
			System.out.print("Please enter the integer to be factorized: ");
			while(!in.hasNextInt()){
				System.out.print("Please enter an integer greater than two. If "
						+ "there is no output for a positive integer, please enter a smaller integer: ");
				in.next();
			}
			input=in.nextInt();
		}while(input <= 2);
		
		List<Integer> primeFactors = primeFactorization(input);
		
		System.out.print(input + " factorizes into the following numbers: ");
		for(int counter = 0; counter < primeFactors.size(); counter++)
		{
			if(counter == primeFactors.size() - 1)
				System.out.print(primeFactors.get(counter) + ".");
			else
				System.out.print(primeFactors.get(counter) + ", ");
		}
		in.close();
	}
}
