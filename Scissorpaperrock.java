import java.util.Random;
import java.util.Scanner;

public class Scissorpaperrock {

   public static void main (String[] args){
      Random rand = new Random();
      Scanner scanner = new Scanner(System.in);
      compareHands game = new compareHands();
      String aiConvertToString = "UNINITIALISED";
      int userToInt = 0;
      String userInput;

      do {
         int n = rand.nextInt(3);
         if (n == 0){
            aiConvertToString = "paper";
         }
         if (n == 1){
            aiConvertToString = "scissor";
         }
         if (n == 2){
            aiConvertToString = "rock";
         }

         System.out.println("Enter p, s or r: ");
         userInput = scanner.nextLine();
         if (userInput.equals ("p")){
            userInput = "paper";
            userToInt = 0;
         }
         if (userInput.equals ("s")){
            userInput = "scissor";
            userToInt = 1;
         }
         if (userInput.equals ("r")){
            userInput = "rock";
            userToInt = 2;
         }
         if (!userInput.equals ("paper") && !userInput.equals ("scissor") && !userInput.equals ("rock")){
            System.out.println("p, s or r only please");
            continue;
         }

         if (n == userToInt) {
            System.out.println("ai: " + aiConvertToString + " \nplayer: " + userInput + "\n DRAW!");
            continue;
         }
         if (game.Winner(n, userToInt)) {
            System.out.println("ai: " + aiConvertToString + " \nplayer: " + userInput + "\n");
            System.out.println("YOU WIN!");
         }
         if (!game.Winner(n, userToInt)) {
            System.out.println("ai: " + aiConvertToString + " \nplayer: " + userInput + "\n");
            System.out.println("YOU LOSE");
         }
      }while (!userInput.equals("exit"));


   }
}
class compareHands{
   // 0 = paper, 1 = scissors, 2 = rock
   public boolean Winner (int ai, int user){
      if (ai == 0){
         if (user == 1){
            return true;
         }
         if (user == 2){
            return false;
         }
      }
      if (ai == 1){
         if (user == 0){
            return false;
         }
         if (user == 2){
            return true;
         }
      }
      if (ai == 2){
         if (user == 0){
            return true;
         }
         if (user == 1){
            return false;
         }
      }
      return false;
   }
}