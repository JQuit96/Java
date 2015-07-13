 /**
  * Purpose: Calculate the total cost of tile it would take to cover a floor
  * plan of width and height, using a cost entered by the user.
  * @author Julian D. Quitian
  */
import java.util.Scanner;
import java.text.DecimalFormat;

public class TileCostEstimate{
  public static double TileCostEstimate(double height, double width, double pricePerSquareCm){
    double myHeight = height;
    double myWidth = width;
    double myPricePerSquareCm = pricePerSquareCm;
    double totalCost = myHeight * myWidth * myPricePerSquareCm;
    return totalCost;
  }
  public static double getHeight(){
    Scanner in = new Scanner(System.in);
    double userInput = 0;
    //Limits user input to desired values.
    do{
      System.out.println("Enter the tile height, in cm.");
      while(!in.hasNextDouble()){
        System.out.println("Only positive values are accepted");
        in.next();
      }
      userInput = in.nextDouble();
    }while(userInput <= 0);
    return userInput;
  }
  public static double getWidth(){
    Scanner in = new Scanner(System.in);
    double userInput = 0;
    //Limits user input to desired values.
    do{
      System.out.println("Enter the tile width, in cm.");
      while(!in.hasNextDouble()){
        System.out.println("Only positive values are accepted");
        in.next();
      }
      userInput = in.nextDouble();
    }while(userInput <= 0);
    return userInput;
  }
  public static double getPricePerSquareCm(){
    Scanner in = new Scanner(System.in);
    double userInput = 0;
    //Limits user input to desired values.
    do{
      System.out.println("Enter the cost per square cm");
      while(!in.hasNextDouble()){
        System.out.println("Only positive values are accepted");
        in.next();
      }
      userInput = in.nextDouble();
    }while(userInput <= 0);
    return userInput;
  }
  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("#.00");
    System.out.println("Welcome to Tile Cost Estimator");
    double height = getHeight();
    double width = getWidth();
    double ppscm = getPricePerSquareCm();
    double totalPrice = TileCostEstimate(height, width, ppscm);
    System.out.println("The cost estimate for covering this floor is $" + df.format(totalPrice));
  }
}
