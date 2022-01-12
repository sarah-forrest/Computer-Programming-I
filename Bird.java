
import java.awt.*;

public class Bird extends Critter {
   // Private variables to measure the number of moves made and which direction the bird moves
   private int moveCount;
   private Direction direction;
   
   // Constructor of the critter bird
   public Bird() {
      this.moveCount = 0;
   }
   
   // Takes in the string or appearence of the opponent and returns the bird's attack: 
   // roars if the opponent is an ant, otherwise pounces
   public Attack fight(String opponent) {
		if (opponent.equals("%")) {
         return Attack.ROAR;
      } else {
         return Attack.POUNCE;
      }
   }  
   
   // Returns the bird's color: blue
   public Color getColor() {
      return Color.BLUE;
   }
   
   // Returns the direction the bird moves: in a clockwise square with 3 moves in each direction
   public Direction getMove() {
      if (moveCount <= 2) {
         direction = Direction.NORTH;
      } else if (moveCount <= 5) {
         direction = Direction.EAST;
      } else if (moveCount <= 8) {
         direction = Direction.SOUTH;
      } else if (moveCount <= 11) {
         direction = Direction.WEST;
      }
      moveCount++;
      if (moveCount == 12) {
         moveCount = 0;
      }
      return direction;
   }
   
   // Returns the string value of the bird, a V shape that points in the direction that the bird moves
   public String toString() { 
      if (direction == Direction.EAST) { 
         return ">";
      } else if (direction == Direction.SOUTH) {
         return "v";
      } else if (direction == Direction.WEST) { 
         return "<";
      } else {
         return "^";
      }
   }
}