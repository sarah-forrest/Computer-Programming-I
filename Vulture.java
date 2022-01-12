import java.awt.*;

public class Vulture extends Bird {
   // Private variable measures whether the vulture is hungry
   private boolean hungry;
   
   // Constructor of the vulture critter, sets the vulture hungry
   public Vulture() {
      this.hungry = true;
   }
   
   // Returns whether or not the vulture eats: eats only if it is hungry
   public boolean eat() {
      if (hungry) {
         hungry = false;
         return true;
      } else {
         return false;
      }
   }
   
   // Takes in the string or appearence of the opponent and returns the vulture's attack:
   // the attack of the bird super class, roars if the opponent is an ant, otherwise pounces
   public Attack fight(String opponent) {
		hungry = true;
      return super.fight(opponent);
   }
   
   // Returns the hippo's color: black
   public Color getColor() {
      return Color.BLACK;
   }
}