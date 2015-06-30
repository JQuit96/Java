/**
 * Purpose: Enter a number and have the program generate the 
 * Fibonacci sequence to that number or to the Nth number.
 */
package fibonacciSequence;

/**
 * @author Julian D. Quitian
 * @date 6/19/15
 */

import java.util.Scanner;
import java.util.ArrayList;

public class FibonacciSequence {

	/**
	 * Default Constructor
	 */
	public FibonacciSequence() {}
	
	/**
	 * @param number Term (between 1 and 1836311903 inclusive) in Fibonacci sequence that limits how long output is
	 * @return sequence Fibonacci sequence up to number term or the next one.
	 */
	public static String toNumber(int number){
		String sequence = "";
		int firstTerm = 1, secondTerm = 1;
		int key= 0;
		ArrayList<Integer> list= new ArrayList<Integer>();
		list.add(firstTerm);
		list.add(secondTerm);
		
		//Creates Fibonacci sequence until last created term is greater than input number.
		for(int i = 2; key < number ; i++){
			list.add(firstTerm + secondTerm);
			firstTerm = secondTerm;
			secondTerm = list.get(i);
			key = list.get(i);
			}
		for(Integer a : list)
			sequence += a + " ";
		return sequence;
	}
	
	/**
	 * @param nthNumber Number(between 0 and 45 inclusive) defining how long sequence will be.
	 * @return sequence Fibonacci sequence String limited by nthNumber
	 */
	public static String toNthTerm(int nthNumber){
		String sequence = "";
		int firstTerm = 1, secondTerm = 1;
		ArrayList<Integer> list= new ArrayList<Integer>();
		list.add(firstTerm);
		list.add(secondTerm);
		
		//Creates Fibonacci sequence up to defined Nth term.
		for(int i = 2; i < nthNumber; i++){
			list.add(firstTerm + secondTerm);
			firstTerm = secondTerm;
			secondTerm = list.get(i);
			}
		for(Integer a : list)
			sequence += a + " ";
		if(nthNumber < 1)
			return "Invalid Input. Restart program please.";
		else if(nthNumber == 1)
			sequence = "1";
		else if(nthNumber == 2)
			sequence = "1 1";
		return sequence;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int selection;
		
		System.out.println("Generate Fibonacci sequence to [1]Specific Number"
				+ " or [2]Nth number?");
		
		do{
			System.out.print("Please choose one of the options above: ");
			while(!in.hasNextInt()){
				System.out.print("Please select option 1 or 2 only: ");
				in.next();
			}
			selection = in.nextInt();
		}while(selection < 1 || selection > 2);
		
		//Spacing for aesthetic purposes.
		System.out.println();
		
		//Finds input number in Fibonacci sequence, prints sequence up to that number.
		if(selection == 1){
			System.out.println("Until which number would you like to print the sequence?"
					+ "\nIf number is not in sequence, sequence will be printed up to the"
					+ " next number.");
			do{
				System.out.print("Number must be an integer greater than 0 and less than or equal to 1836311903: ");
				while(!in.hasNextInt()){
					System.out.print("Please enter a valid number: ");
					in.next();
				}
				selection = in.nextInt();
			}while(selection < 1 || selection > 1836311903);
			System.out.println("\nSequence: " + toNumber(selection));
		}
		//Print Fibonacci sequence up to inputted Nth term.
		else if(selection == 2){
			System.out.println("To which Nth term would you like to print the sequence?");
			do{
				System.out.print("Nth number must be a positive integer less than 47: ");
				while(!in.hasNextInt()){
					System.out.print("Please enter a valid Nth number: ");
					in.next();
				}
				selection = in.nextInt();
			}while(selection < 0 || selection > 46);
			System.out.println("\nSequence: " + toNthTerm(selection));
		}
		System.out.println("\nThank you!");
		in.close();
	}
}
