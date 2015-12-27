/**
 * Number Names v1.0.0
 * Created by Julian D. Quitian on 12/26/2015.
 */
import java.util.Scanner;
public class NumberNames {
    public static String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    public static String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] others = {"", "Thousand", "Million", "Billion", "Trillion", "Quadrillion"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Hello! Print out the name you want spelled out: ");
        num= in.nextInt();
        System.out.println("The number is: " + spelloutNum(num));
    }
    //Handles any number (other than zero) less than 100
    private static String lessThan100(int number){
        String num = "";

        if (number >= 100){
            num += ones[number / 100] + "-Hundred ";
            number %= 100;
        }
        if (number >= 11 && number <= 19) {
            num += teens[number-10] + " ";
        } else if (number >= 20 || number == 10) {
            num += tens[number/10] + " ";
            number %= 10;
        }

        if (number >= 1 && number <= 9) {
            num += ones[number] + " ";
        }
        return num;
    }
    public static String spelloutNum(int number){
        String num = "";
        if(number == 0)
            return "Zero";
        else if(number < 0)
            return "Negative " + spelloutNum(-(number));
        else if(number < 100)
            num = lessThan100(number);

        int i = 0;
        while (number > 0) {
            if (number % 1000 != 0) {
                num = lessThan100(number % 1000) + others[i] + " " + num;
            }
            number /= 1000;
            ++i;
        }
        return num;
    }
}