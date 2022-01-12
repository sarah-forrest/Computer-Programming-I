// This program draws an ascii art snowman using print and println statements 
// and a for loop to reduce redundancy

public class AsciiArt   {
   public static void main (String[]   args)   {
      System.out.println("**_|_|_**");
      for (int line = 1; line <= 3; line++) {
         for(int stars = 1; stars <= 4 - line; stars++)   {
            System.out.print("*");
         }
         System.out.print("(");
         for(int spaces = 1; spaces <= line - 1; spaces++)   {
            System.out.print(" ");
         }
         System.out.print(".");
         for(int spaces2 = 1; spaces2 <= line - 1; spaces2++)   {
            System.out.print(" ");
         }
         System.out.print(")");
         for(int stars2 = 1; stars2 <= 4 - line; stars2++)   {
            System.out.print("*");
         }
         System.out.println();
      }
   }
}
          