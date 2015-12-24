/**
 * Purpose: Convert a decimal number to binary or a binary number
 * to its decimal equivalent.
 * @author Julian D. Quitian
 */

import java.util.Scanner;

 public class BinaryDecimalConverter{
   /**
    * Use {@code Scanner} to accept user input. Allows only {@code userInput} that
    * meets both {@code conditionOne} and {@code conditionTwo}, which stipulate
    * that only one of the given options is entered.
    *
    * @param conditionOne for {@code userInput} to be accepted.
    * @param conditionTwo for {@code userInput} to be accepted.
    * @return userInput once it meets requirements.
    */
   public static int getIntSelection(String conditionOne, String conditionTwo){
     Scanner in = new Scanner(System.in);
     int userInput;
     //Limits user input to desired values.
     do{
       System.out.print(conditionOne);
       while(!in.hasNextInt()){
         System.out.print(conditionTwo);
         in.next();
       }
       userInput = in.nextInt();
     }while(userInput <= 0 || userInput > 3);
     return userInput;
   }
   /**
    *
    */
   public static int binaryInputToDecimal(){
     int decimal;
     String binaryString = getBinary();
     decimal = Integer.parseInt(binaryString, 2);
     System.out.println(binaryString + " in binary equals " + decimal + " in decimal");
     return decimal;
   }
   /**
    *
    */
   public static String getBinary(){
     Scanner in = new Scanner(System.in);
     boolean restartLoop;
     String input;
     System.out.println("Please print binary to be converted");
     input = in.next();
     do{
       restartLoop = false;
       for(int i = 0; i < input.length(); i++){
         String temp = input.substring(i,i+1);
         if(!temp.equals("0") && !temp.equals("1")){
           restartLoop = true;
         }
       }
       if(restartLoop){
         System.out.println(input + " is not a binary, try again: ");
         input = in.next();
       }
     }while(restartLoop);
     return input;
   }
   public static void main(String[] args) {
     int userSelection;
     System.out.println("Welcome to Binary-Decimal Converter!");
     userSelection = getIntSelection("Enter [1] for Binary to Decimal, [2] for Decimal to Binary, "
                    + "or [3] to Exit: ", "[1] Binary-Decimal, [2] Decimal-Binary, [3] Exit: ");
     while(userSelection != 3){
       if(userSelection == 1){
         binaryInputToDecimal();
       }
         userSelection = getIntSelection("Enter [1] for Binary to Decimal, [2] for Decimal to Binary, "
          + "or [3] to Exit: ", "[1] Binary-Decimal, [2] Decimal-Binary, [3] Exit: ");
     }
   }
 }
