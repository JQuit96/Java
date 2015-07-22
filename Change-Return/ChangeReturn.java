/**
  * Purpose: User enters a cost and then the amount of money given. The program
  * will figure out the change and the number of quarters, dimes, nickels,
  * pennies needed for the change.
  * @author Julian D. Quitian
  *
  * <p>{@code BigDecimal} is used rather than {@code double} to perform the
  * majority of operations in this program in order to obtain a more accurate
  * result. Using primitive types did not produce the right amount of change.
  */

import java.util.Scanner; //Allows user input
import java.math.BigDecimal;  //Used for precision
import java.math.RoundingMode;  //Useful for BigDecimal operations
import java.math.MathContext; //Useful for BigDecimal operations


public class ChangeReturn{
  /**
   * Default constructor.
   */
  public static void main(String[] args) {
    double cost, payment;
    int[] change = new int[5];
    BigDecimal totalChange;

    System.out.println("Welcome to Change Return Calculator!");
    cost = getPositiveDoubleInput("Product Cost: $", "Invalid input. Product Cost: $");
    payment = getPayment("Payment Amount: $", "Invalid Payment. Payment Amount: $", cost);
    totalChange = new BigDecimal(payment - cost);
    totalChange = totalChange.setScale(2, BigDecimal.ROUND_HALF_UP);
    System.out.println("\nTotal change: $" + totalChange);
    change = getChange(totalChange);
    System.out.println("Dollars: " + change[0]);
    System.out.println("Quarters: " + change[1]);
    System.out.println("Dimes: " + change[2]);
    System.out.println("Nickels: " + change[3]);
    System.out.println("Pennies: " + change[4]);
  }
  /**
   * Use {@code Scanner} to accept user input. Allows only {@code userInput} that
   * meets both {@code conditionOne} and {@code conditionTwo}, which stipulate
   * that only a positive {@code double} is accepted.
   *
   * @param conditionOne for {@code userInput} to be accepted.
   * @param conditionTwo for {@code userInput} to be accepted.
   * @return userInput once it meets requirements.
   */
  public static double getPositiveDoubleInput(String conditionOne, String conditionTwo){
    Scanner in = new Scanner(System.in);
    double userInput = 0;
    //Limits user input to desired values.
    do{
      System.out.print(conditionOne);
      while(!in.hasNextDouble()){
        System.out.print(conditionTwo);
        in.next();
      }
      userInput = in.nextDouble();
    }while(userInput <= 0);
    return userInput;
  }
  /**
   * Similar to {@link getPositiveDoubleInput(String, String)} method.
   * Use additional {@code cost} variable  to modify {@code userInput}
   * requirements.
   *
   * @param conditionOne for {@code userInput} to be accepted.
   * @param conditionTwo for {@code userInput} to be accepted.
   * @param cost limits {@code userInput}.
   * @return userInput once requirements are met.
   */
  public static double getPayment(String conditionOne, String conditionTwo, double cost){
    Scanner in = new Scanner(System.in);
    double userInput = 0;
    //Limits user input to desired values.
    do{
      System.out.print(conditionOne);
      while(!in.hasNextDouble()){
        System.out.print(conditionTwo);
        in.next();
      }
      userInput = in.nextDouble();
    }while(userInput < cost);
    return userInput;
  }
  /**
   * Divides {@code BigDecimal} {@code totalChange} to be given by the values of
   * dollars, quarters, dimes, nickels, and pennies, located in {@code coins}.
   * {@code totalChange} is modified with each loop run to represent the
   * change to be given out by the remaining coin types.
   *
   * @param totalChange to be returned.
   * @return result int array containing amounts of each money type to be returned.
   */
  public static int[] getChange(BigDecimal totalChange){
    MathContext two = new MathContext(2);
    BigDecimal[] coins = {new BigDecimal("1"), new BigDecimal(".25"), new BigDecimal(".10"), new BigDecimal(".05"), new BigDecimal(".01")};
    BigDecimal[] change = new BigDecimal[5];
    int[] result = new int[5];
    for(int i = 0; i < coins.length; i++){
      change[i] = totalChange.divideToIntegralValue(coins[i], two);
      BigDecimal temp = change[i].multiply(coins[i], two);
      totalChange = totalChange.subtract(temp, two);
    }
    for(int i = 0; i < 5; i++){
      result[i]= change[i].intValue();
    }
    return result;
  }
}
