/**
 * Purpose: Calculate the monthly payments of a fixed term mortgage over given
 * Nth terms at a given interest rate.
 * @author Julian D. Quitian
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class MortgageCalculator{
  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("#.00");
    double monthlyPayment;
    int userInput;
    System.out.println("Welcome to Mortgage Calculator! This program calculates the fixed minimum monthly payments required to pay back a loan.");
    userInput = getChoiceSelection();
    if(userInput == 1){
      double[] data = getFixedCompoundingData();
      monthlyPayment = getFixedCompoundingMonthlyRate(data[0], data[1], data[2], (int)data[3]);
      System.out.println("Your monthly payment will be: $" + df.format(monthlyPayment));
    }
    else if(userInput == 2){
      double[] data = getContinuousCompoundingData();
      monthlyPayment = getContinuousCompoundingMonthlyRate(data[0], data[1], data[2]);
      System.out.println("Your monthly payment will be: $" + df.format(monthlyPayment));
    }
    else
      continue;
  }
  public static double[] getFixedCompoundingData(){
    double principal = getPositiveDoubleInput("Please enter principal", "Principal can only be a positive number");
    double annualInterestRate = getPositiveDoubleInput("Please enter annual interest rate as a percent(ie. 5)", "Interest rate can only be a positive number");
    double years = getYears();
    double monthsAsYears = (double)(getMonths())/12;
    double termLength = years + monthsAsYears;
    double compoundingsPerYear = (double)getPositiveIntInput("Please enter compoundings per year", "Positive integers accepted only");
    double[] data = {principal, annualInterestRate, termLength, compoundingsPerYear};
    return data;
  }
  public static double[] getContinuousCompoundingData(){
    double principal = getPositiveDoubleInput("Please enter principal", "Principal can only be a positive number");
    double annualInterestRate = getPositiveDoubleInput("Please enter annual interest rate as a percent(ie. 5)", "Interest rate can only be a positive number");
    double years = getYears();
    double monthsAsYears = (double)(getMonths())/12;
    double termLength = years + monthsAsYears;
    double[] data = {principal, annualInterestRate, termLength};
    return data;
  }
  /**
   * @param principal Total loan amount
   * @param annualInterestRate as a percent
   * @param termLength Length of loan in years
   * @param compoundingsPerYear Number of times interest is compounded.
   * @return monthlyPayment Monthly fixed amount to be paid
   */
   public static double getFixedCompoundingMonthlyRate(double principal, double annualInterestRate, double termLength, int compoundingsPerYear){
     double trueInterestRate = (annualInterestRate/100);  //Accounts for compounding period
     double a = 1 + trueInterestRate/compoundingsPerYear;
     double b = Math.pow(a, termLength * compoundingsPerYear);
     double totalBalance = principal * b;
     double monthlyPayment = totalBalance/(termLength * 12);
     return monthlyPayment;
   }
   /**
   * @param principal Total loan amount.
   * @param annualInterestRate as a percent
   * @param termLength in months
   * @return monthlyPayment Monthly fixed amount to be paid
    */
   public static double getContinuousCompoundingMonthlyRate(double principal, double annualInterestRate, double termLength){
     double trueInterestRate = (annualInterestRate/100);  //Accounts for compounding period
     double totalBalance = principal * Math.pow(Math.E,trueInterestRate * termLength);
     double monthlyPayment = totalBalance/(termLength * 12);
     return monthlyPayment;
   }
   public static int getChoiceSelection(){
     Scanner in = new Scanner(System.in);
     int userInput = 0;
     //Limits user input to desired values.
     do{
       System.out.println("Enter 1 for fixed compoundings per year, 2 for continuous compounding, and 3 to exit.");
       while(!in.hasNextInt()){
         System.out.println("[1]Fixed compounding [2]Continuous compounding [3]Exit");
         in.next();
       }
       userInput = in.nextInt();
     }while(userInput < 1 || userInput > 3);
     return userInput;
   }
   public static double getPositiveDoubleInput(String conditionOne, String conditionTwo){
     Scanner in = new Scanner(System.in);
     double userInput = 0;
     //Limits user input to desired values.
     do{
       System.out.println(conditionOne);
       while(!in.hasNextDouble()){
         System.out.println(conditionTwo);
         in.next();
       }
       userInput = in.nextDouble();
     }while(userInput <= 0);
     return userInput;
   }
    public static double getPositiveIntInput(String conditionOne, String conditionTwo){
     Scanner in = new Scanner(System.in);
     int userInput = 0;
     //Limits user input to desired values.
     do{
       System.out.println(conditionOne);
       while(!in.hasNextInt()){
         System.out.println(conditionTwo);
         in.next();
       }
       userInput = in.nextInt();
     }while(userInput <= 0);
     return userInput;
   }
    public static int getYears(){
       Scanner in = new Scanner(System.in);
       int userInput = 0;
       //Limits user input to desired values.
       do{
         System.out.println("Enter The number of years for your loan.");
         while(!in.hasNextInt()){
           System.out.println("Only positive integers allowed");
           in.next();
         }
         userInput = in.nextInt();
       }while(userInput < 0);
       return userInput;
   }
   public static int getMonths(){
       Scanner in = new Scanner(System.in);
       int userInput = 0;
       //Limits user input to desired values.
       do{
         System.out.println("Enter The number of additional months for your loan.");
         while(!in.hasNextInt()){
           System.out.println("Only positive integers 13 or less allowed");
           in.next();
         }
         userInput = in.nextInt();
       }while(userInput < 0 || userInput > 12);
       return userInput;
   }
}
