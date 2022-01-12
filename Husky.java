import java.awt.*;

public class Husky extends Critter {
   private int moveCount;
   private Color purple;
   public Husky() {
      this.moveCount = 0;
      this.purple = new Color (111, 33, 188);
   }
   
   public boolean eat() {
      return true;
   }
   
   public Attack fight(String opponent) {
     if (opponent.equals("%")) {
         return Attack.ROAR;
      } else if (opponent.equals("^") || opponent.equals(">") || opponent.equals("V") || 
                 opponent.equals("<")) {
         return Attack.SCRATCH;
      } else if (opponent.equals ("0")) {
         return Attack.SCRATCH;
      } else {
         return Attack.ROAR;
      }
   }
   
   public Color getColor() {
      if (moveCount <= 20) {
         return Color.YELLOW;
      } else if (moveCount <= 40) {
         return purple;
      } else if (moveCount <= 60) {
         return Color.YELLOW;
      } else {
         return purple;
      }
   }
   
   public Direction getMove() {
      if (moveCount > 80) {
         moveCount = 0;
      }
      moveCount++;
      if (moveCount <= 10) {
         if (moveCount % 2 == 1) {
            return Direction.SOUTH;
         } else {
            return Direction.EAST;
         }
      } else if (moveCount <= 20) {
         if (moveCount % 2 == 1) {
            return Direction.NORTH;
         } else {
            return Direction.EAST;
         }
      } else if (moveCount <= 30) {
         if (moveCount % 2 == 1) {
            return Direction.SOUTH;
         } else {
            return Direction.EAST;
         }
      } else if (moveCount <= 40) {
         if (moveCount % 2 == 1) {
            return Direction.NORTH;
         } else {
            return Direction.EAST;
         }
      } else if (moveCount <= 50) {
         if (moveCount % 2 == 1) {
            return Direction.SOUTH;
         } else {
            return Direction.WEST;
         }
       } else if (moveCount <= 60) {
         if (moveCount % 2 == 1) {
            return Direction.NORTH;
         } else {
            return Direction.WEST;
         }
       } else if (moveCount <= 70) {
         if (moveCount % 2 == 1) {
            return Direction.SOUTH;
         } else {
            return Direction.WEST;
         }
      } else {
         if (moveCount % 2 == 1) {
            return Direction.NORTH;
         } else {
            return Direction.WEST;
         }
      }
   }
   
   public String toString() {
      return "^•ﻌ•^";
   }
}