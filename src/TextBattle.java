/*
 * Class: CS1A
 * Name: Russell Stolp
 * Description: A Simple text based combat game where two fighters battle based
 * on DnD style RNG.
 */

import java.util.Scanner;
import java.util.Random;
public class TextBattle {

   // Initialize hit points for each player
   private static int playerOneLife = 100;
   private static int playerTwoLife = 100;

   // Generates hit chance, hit damage, and outputs results
   private static void attack(int playerBeingAttacked, String attacker,
                              String victim) {
      Random rand = new Random();
      int attackChance = rand.nextInt(20) + 1;
      if (attackChance > 12) {
         int damage = rand.nextInt(15) + 1;
         if (playerBeingAttacked == playerTwoLife) {
            playerTwoLife -= damage;
            System.out.println(attacker + " hits " + victim + " for " + damage);
            System.out.println(victim + " has " + playerTwoLife + " life left.");
         }
         else {
            playerOneLife -= damage;
            System.out.println(attacker + " hits " + victim + " for " + damage);
            System.out.println(victim + " has " + playerOneLife + " life left.");
         }
      }
   }

   public static void main(String[] args) {

      //Setup Scanner
      Scanner input = new Scanner(System.in);

      //Get fighter names
      System.out.print("Enter fighter name one: ");
      String nameOne = input.nextLine();
      System.out.print("Enter fighter name two: ");
      String nameTwo = input.nextLine();

      // Loop attacks until one player has 0 life left and congratulate winner
      while (playerOneLife > 0 && playerTwoLife > 0) {
         attack(playerTwoLife, nameOne, nameTwo);
         if (playerTwoLife < 1) {
            System.out.println("Congrats fighter " + nameOne);
         }
         if (playerTwoLife > 0) {
            attack(playerOneLife, nameTwo, nameOne);
            if (playerOneLife < 1) {
               System.out.println("Congrats fighter " + nameTwo);
            }
         }
      }
   }
}
