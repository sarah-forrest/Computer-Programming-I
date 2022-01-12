import java.awt.*;
import java.util.*;

public class Hippo extends Critter {
   // Private variables measures the hippo's hunger, whether the hippo is hungry, number of 
   // moves made, and the random number corresponding to the direction the hippo moves
   private int hunger;
   private boolean hungry;
   private int moveCount;
   private int direction;
   
   // Constructor of the critter hippo, takes in hunger as a parameter 
   // which determines the hippo's color, attack, and whether the hippo eats
   public Hippo(int hunger) {
      this.hunger = hunger;
      this.moveCount = 5;
   } 
   
   // Returns whether or not the hippo eats: the hippo eats only if it is hungry
   public boolean eat() {
      if (hunger > 0) {
         hungry = true;
      } else {
         hungry = false;
      }
      hunger--;
      return hungry;
   }
   
   // Takes in the string or appearence of the opponent and returns the hippo's attack:
   // scartches if it is hungry, otherwise pounces regardless of the opponent
   public Attack fight(String opponent) {
      if (hunger > 0) {
         return Attack.SCRATCH;
      } else {
         return Attack.POUNCE;
      }
   }  
   
   // Returns the hippo's color: gray if it is hungry, otherwise white
   public Color getColor() {
      if (hunger > 0) {
         return Color.GRAY;
      } else {
         return Color.WHITE;
      }
   }
   
   // Returns the direction the hippo moves: 5 moves in a random direction
   public Direction getMove() {
      Random random = new Random();
      if (moveCount == 5) {
         direction = random.nextInt(4);
         moveCount = 0;
      }
      moveCount++;
      if (direction == 0) {
         return Direction.NORTH;
      } else if (direction == 1) {
         return Direction.EAST;
      } else if (direction == 2) {
         return Direction.SOUTH;
      } else {
         return Direction.WEST;
      }
   }
   
   // Returns the string value of the hippo: returns the hippo's hunger amount
   public String toString() {
      if (hunger <= 0) {
         hunger = 0;
      }
      return "" + hunger;
   }
}