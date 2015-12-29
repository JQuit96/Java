/**
 * Collatz Conjecture v1.0.0
 * Created by Julian D. Quitian on 12/28/2015.
 * Collatz Conjecture - Start with a number n > 1. Find the number of steps it
 * takes to reach one using the following process: If n is even,
 * divide it by 2. If n is odd, multiply it by 3 and add 1.
 */
import java.util.Scanner;

public class CollatzConjecture {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        int input;
        System.out.println("Welcome to Collatz Conjecture Evaluator!");
        input = getUserInput();
        System.out.printf("It takes %d steps for %d to reach one through the Collatz Conjecture", collatzConjecture(input), input);
    }
    public static int getUserInput(){
        int userInput;
        //Limits user input to desired values.
        do{
            System.out.println("Enter number to be evaluated: ");
            while(!in.hasNextInt()){
                System.out.println("Please only enter a positive integer greater than zero: ");
                in.next();
            }
            userInput = in.nextInt();
        }while(userInput <= 1);
        return userInput;
    }
    //Collatz Conjecture method
    public static int collatzConjecture(int num){
        int steps = 0;
        while(num != 1){
            if(num % 2 == 0)
                num = num / 2;
            else
                num = (num * 3) + 1;
            steps++;
        }
        return steps;
    }
}
