/**
 * Happy Numbers v1.0.0
 * A happy number is defined by the following process. Starting with any positive integer, replace
 * the number by the sum of the squares of its digits, and repeat the process until the number equals 1
 * (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Created by Julian D. Quitian on 12/26/2015.
 */

//Prints out happy numbers
public class HappyNumbers {
    public static void main(String[] args){
        int[] happyNumbers = new int[8];        //Size of happyNumbers = number of values found
        int number = 1, position = 0, temp, sum, loops;

        while(position != 8){   //Change number and happyNumbers length to obtain more happy numbers;
            temp = number;
            sum = 0;
            loops = 0;
            while(loops < 100000){                    //Increase for more accuracy; however, 100000 should be enough
                for(int i = 0; i < Integer.toString(temp).length(); i++){
                    sum += Math.pow(Integer.parseInt(Integer.toString(temp).substring(i, i + 1)),2);
                }
                temp = sum;
                if(sum == 1){
                    happyNumbers[position] = number;
                    number++;
                    position++;
                    break;
                }
                loops++;
                sum = 0;
            }
            number++;
        }

        for(int i : happyNumbers)
            System.out.println(i);
    }
}
