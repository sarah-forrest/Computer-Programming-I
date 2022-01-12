import java.awt.*;

public class Ant extends Critter {
   // Private variables to measure the number of moves the ant has made and whether or not the 
   // ant moves south
   private int moveCount;
   private boolean walkSouth;
   
   // Constructor of the critter ant, takes in boolean walkSouth as a parameter which controls
   // whether the ant moves north or south
   public Ant(boolean walkSouth) {
      this.walkSouth = walkSouth;
      this.moveCount = 0;
   }
   
   // Returns whether or not the ant will eat: the ant always eats
   public boolean eat() {
      return true;
   }
   
   // Takes in the string or appearence of the opponent and returns the ant's attack: 
   // the ant always scratches regardless of the opponent
   public Attack fight(String opponent) {
      return Attack.SCRATCH;
   }  
   
	// Returns the ant's color: red
   public Color getColor() {
      return Color.RED;
   }
   
   // Returns the direction that the ant moves, either in a south east or north east direction
   public Direction getMove() {
      moveCount++;
      if (walkSouth) {
         if (moveCount % 2 == 1) {
            return Direction.SOUTH;
         } else {
            return Direction.EAST;
         }
      } else {
         if (moveCount % 2 == 1) {
            return Direction.NORTH;
         } else {
            return Direction.EAST;
         }
      }
   }
   
   // Returns the string value of the ant: %
   public String toString() {
      return "%"; 
   }
}
