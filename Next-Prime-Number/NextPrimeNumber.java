import java.util.Scanner; 
public class NextPrimeNumber{
  public static int NextPrimeNumber(int lastNumber) {
    lastNumber++;
    while(isPrime(lastNumber) == false){
      lastNumber++;
    }
    return lastNumber;
  }
  public static boolean isPrime(int number){
    int primeNumber = number;
    boolean isPrime = true;
      for(int i = 2; i < primeNumber; i++){
        if(primeNumber % i == 0)
          isPrime = false;
        else
          continue;
      }
    return isPrime;
  }
  public static int getUserInput(){
    Scanner in = new Scanner(System.in);
    int userInput = 0;
    //Limits user input to desired values.
    do{
      System.out.println("Press 1 to find the next prime number, and 2 to exit.");
      while(!in.hasNextInt()){
        System.out.println("1 for next prime integer, 2 to exit.");
        in.next();
      }
      userInput = in.nextInt();
    }while(userInput < 1 || userInput > 2);
    return userInput;
  }
  public static void main(String[] args) {
    System.out.println("Hello! Welcome to Next Prime Finder");
    System.out.println("2 is the first prime integer.");
    int lastNumber = 1, nextPrime;
    int userInput = getUserInput();
    while(userInput == 1){
      lastNumber = NextPrimeNumber(lastNumber);
      System.out.println("Next prime number: " + lastNumber);
      userInput = getUserInput();
    }
    System.out.println("Thank you for using NPF!");
  }
}
