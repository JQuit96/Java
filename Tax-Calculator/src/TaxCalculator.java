/**
 * Tax Calculator v1.0.0
 * Created by Julian D. Quitian on 12/25/2015.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double price = 0, tax = 0;

        System.out.println("Hello! I will calculate the tax you will need for any item.");
        System.out.print("Please enter price of item: ");

        try{
            price = in.nextDouble();
        }
        catch (InputMismatchException a) {
            System.out.println("Invalid input. Please close program and try again.");
            System.exit(-1);
        }
        finally{
            System.out.println();
        }

        System.out.print("Please enter local tax [as percentage]: ");

        try{
            tax = in.nextDouble();
        }
        catch (InputMismatchException b) {
            System.out.println("Invalid input. Please close program and try again.");
            System.exit(-1);
        }
        finally{
            System.out.println();
        }

        System.out.println("Your total balance is: $" + ((price) + (price*(tax/100))));
    }
}
