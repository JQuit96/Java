/**
 * Limit Calculator v1.0.0
 * Created by Julian D. Quitian on 12/28/2015.
 */
import com.singularsys.jep.Jep;     //Used to parse and evaluate function
import com.singularsys.jep.JepException;        //Used to parse and evaluate function

import java.util.InputMismatchException;
import java.util.Scanner;

public class LimitCalculator {
    public static void main(String[] args){
        Jep jep = new Jep();
        Scanner in = new Scanner(System.in);
        String function;
        int x;
        boolean valid;

        //User input to be entered into jep object for conversion
        System.out.print("Welcome to Limit Calculator!\n\nI will find the limit of the function: f(x) = ");
        function = in.next();
        System.out.print("...as x approaches: ");
        //Rejects anything but an int input
        while(!in.hasNextInt()){
            in.next();
        }
        x = in.nextInt();
        //Code provided by Jep API owner
        try {
           jep.addVariable("x", x);
           jep.parse(function);
           Object result = jep.evaluate();
                   System.out.println("\nLim(" + function + ") as x -> " + x + " = " + result);
        } catch (JepException e) {
           System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
