/**
 * Credit Card Validator v1.0.0
 * Created by Julian D. Quitian on 12/24/2015.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreditCardValidator {
    static int selection, checkSum;
    static int[] numbers;
    static String cardNumber;
    static boolean restart;
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            restart = true;
            System.out.println("Credit Card Validator:\n");

            //1. Visa   2. MasterCard   3. American Express
            selection = menuSelection();
            switch (selection) {
                case 1: {
                    cardNumber = inputVisa();
                    break;
                }
                case 2: {
                    cardNumber = inputMasterCard();
                    break;
                }
                case 3: {
                    cardNumber = inputAmericanExpress();
                    break;
                }
            }

            checkSum = Integer.parseInt(cardNumber.substring(cardNumber.length() - 1)); //1.Remove checksum (last digit)

            numbers = stringToIntArray(cardNumber);

            reverseIntArray(numbers);                   //2. Reverse

            multiplyOddsByTwo(numbers);                 //3. Multiply odd positions by two(starts at 1)

            subtract9Over9(numbers);                    //4. Subtract 9 from numbers over 9

            if ((addIntArray(numbers) + checkSum) % 10 == 0)
                System.out.println("Card number is valid.");
            else
                System.out.println("Card number is invalid.");

            System.out.println("\nWould you like to try another number? [1]Yes [2]No");
            try {
                selection = in.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Please do not enter invalid input. Close program and start again, naughty.");
                System.exit(-1);
            }
            System.out.println();
            if(selection != 1 && selection != 2){
                do{
                    System.out.println("Please enter valid selection: ");
                    try {
                        selection = in.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("Please do not enter invalid input. Close program and start again, naughty.");
                        System.exit(-1);
                    }
                }while(selection != 1 && selection != 2);
            }
            if(selection == 2)
                restart = false;
        }while(restart);
    }
    public static int menuSelection(){
        int selection = 0;

        System.out.println("Please select your credit card issuer:");
        System.out.println("[1]Visa\n[2]MasterCard\n[3]American Express");
        System.out.print("Selection: ");

        try {
            selection = in.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Please do not enter invalid input. Close program and start again, naughty.");
            System.exit(-1);
        }
        System.out.println();

        if(selection != 1 && selection != 2 && selection != 3){
            do{
                System.out.println("Please enter valid selection: ");
                try {
                    selection = in.nextInt();
                }
                catch(InputMismatchException e){
                    System.out.println("Please do not enter invalid input. Close program and start again, naughty.");
                    System.exit(-1);
                }
            }while(selection != 1 && selection != 2 && selection != 3);
        }
        return selection;
    }
    public static String inputVisa(){
        String cardNumber;
        System.out.print("Please enter card number: ");
        cardNumber = in.next();
        if(!cardNumber.startsWith("4") || cardNumber.length() < 13 || cardNumber.length() > 16){
            do{
                System.out.print("Invalid number. Please try again: ");
                cardNumber = in.next();
            }while(!cardNumber.startsWith("4") || cardNumber.length() < 13 || cardNumber.length() > 16);
        }
        return cardNumber;
    }
    public static String inputMasterCard(){
        String cardNumber;
        System.out.print("Please enter card number: ");
        cardNumber = in.next();
        if((!cardNumber.startsWith("51") && !cardNumber.startsWith("52") && !cardNumber.startsWith("53") && !cardNumber.startsWith("54")) || cardNumber.length() < 16 || cardNumber.length() > 19){
            do{
                System.out.print("Invalid number. Please try again: ");
                cardNumber = in.next();
            }while((!cardNumber.startsWith("51") && !cardNumber.startsWith("52") && !cardNumber.startsWith("53") && !cardNumber.startsWith("54")) || cardNumber.length() < 16 || cardNumber.length() > 19);
        }
        return cardNumber;
    }
    public static String inputAmericanExpress(){
        String cardNumber;
        System.out.print("Please enter card number: ");
        cardNumber = in.next();
        if((!cardNumber.startsWith("34") && !cardNumber.startsWith("37")) || cardNumber.length() != 15){
            do{
                System.out.print("Invalid number. Please try again: ");
                cardNumber = in.next();
            }while((!cardNumber.startsWith("34") && !cardNumber.startsWith("37")) || cardNumber.length() != 15);
        }
        return cardNumber;
    }
    public static int[] stringToIntArray(String input){
        int[] numbers;
        numbers = new int[input.length() - 1];

        for(int i = 0; i < input.length() - 1; i++){
            try{
                numbers[i] = Integer.parseInt(input.substring(i, i + 1));
            }
            catch(NumberFormatException e) {
                System.out.println("You did not enter a valid card number format. Please close program and try again");
                System.exit(-1);
            }
        }
        return numbers;
    }
    public static void reverseIntArray(int[] numbers){
        for(int i = 0; i < numbers.length / 2; i++){
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - i - 1];
            numbers[numbers.length - i - 1] = temp;
        }
    }
    public static void multiplyOddsByTwo(int[] numbers){
        for(int i = 0; i < numbers.length; i++)
            if(i % 2 == 0)
                numbers[i] *= 2;
    }
    public static void subtract9Over9(int[] numbers) {
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] > 9)
                numbers[i] = numbers[i] - 9;
    }
    public static int addIntArray(int[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
            sum = sum + numbers[i];
        return sum;
    }
}
