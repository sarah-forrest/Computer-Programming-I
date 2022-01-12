import java.util.*;

public class BMI {
   public static void main(String[] args) {
       // better structure here: 
      intro();
      Scanner console = new Scanner(System.in);
      double bmi1 = userInput(console);
      double bmi2 = userInput(console);
      
      // don't have to have redundant copies of the same logic
      System.out.println("Person #1 body mass index = " + Math.round(bmi1 * 10.0) / 10.0);
      if (bmi1 < 18.5) {
         System.out.println("underweight");
      } else if (bmi1 < 25) {
         System.out.println("normal");
      } else if (bmi1 < 30) {
         System.out.println("overweight");
      } else { 
         System.out.println("obese");
      }

      System.out.println("Person #2 body mass index = " + Math.round(bmi2 * 10.0) / 10.0);
      if (bmi2 < 18.5) {
         System.out.println("underweight");
      } else if (bmi2 < 25) {
         System.out.println("normal");
      } else if (bmi2 < 30) {
         System.out.println("overweight");
      } else { 
         System.out.println("obese");
      } 
   }
   
   public static void intro() {
      System.out.println("This program reads in data for two people");
      System.out.println("and computes their body mass index (BMI)");
      System.out.println("and weight status.");
      System.out.println();
   }

     public static double userInput(Scanner console) {
      System.out.println("Enter next person's information:");
      System.out.print("height (in inches)? ");
      double height1 = console.nextDouble();
      System.out.print("weight (in pounds)? ");
      double weight1 = console.nextDouble();
      // TODO factor this calculation into a method:
      double bmi1 = weight1 / (height1 * height1) * 703;
      System.out.println();
      return bmi1;
   }
}