// This program will draw a space needle using various characters, print and println statements
// A class constant allows replication in various sizes and redundancy is eliminated using for loops

public class SpaceNeedle   {
   public static final int SIZE = 7;
   public static void main (String[]   args)   {
      drawNeedle();
      drawTopRoundPart();
      drawMiddleLine();
      drawBottomRoundPart();
      drawNeedle();
      drawBase();
      drawTopRoundPart();
      drawMiddleLine();
   }
   
   // Method draws the rows of two lines used at the top and in the middle of the needle
   public static void drawNeedle()   {
      for (int line = 1; line <= SIZE; line++)   {
         for(int spaces = 1; spaces <= (3 * SIZE); spaces++)   {
            System.out.print(" ");
         }
         System.out.println("||");
      }
   }
   
   // Method draws the upper half circle of text used for the top round part of the space needle
   public static void drawTopRoundPart()   {
      for(int line = 1; line <= SIZE; line++)   {
         for(int spaces = 1; spaces <= (SIZE * 3) - (3 * line); spaces++)   {
            System.out.print(" ");
         }
         System.out.print("__");
         System.out.print("/");
         for(int colon = 1; colon <= 3 * line - 3; colon++)   {
            System.out.print(":");
         }
         System.out.print("||");
         for(int colon=1; colon <= 3 * line - 3; colon++)   {
            System.out.print(":");
         }
         System.out.print("\\");
         System.out.println("__");
      }
   }
   
   // Method produces the line of text that separates the top and bottom round parts
   // as well as the line at the very base of the figure
   public static void drawMiddleLine()  {
      System.out.print("|");
      for(int quotation = 1; quotation <= SIZE * 3; quotation++)   {
         System.out.print("\"\"");
      }
      System.out.println("|");
   }
   
   // Method produces that lower half circle of text used for the bottom round part of the needle
   // and again at the base of the figure
   public static void drawBottomRoundPart()   {
      for(int line = 1; line <= SIZE; line++)   {
         for(int spaces = 1; spaces <= 2 * line - 2; spaces++)   {
            System.out.print(" ");
         }
         System.out.print("\\");
         System.out.print("_");
         for(int backslash = 1; backslash <= (3 * SIZE + 1) - (2 * line); backslash++)   {
            System.out.print("/\\");
         }
         System.out.print("_");
         System.out.println("/");
      }
   }
   
   // Method draws the narrow rectangular post near the base of the space needle
   public static void drawBase()   {
      for(int line = 1; line <= SIZE * SIZE; line++)   {
         for(int spaces = 1; spaces <= 2 * SIZE + 1; spaces++)   {
            System.out.print(" ");
         }
         System.out.print("|");
         for(int mod1 = 1; mod1 <= SIZE - 2; mod1++)   {
            System.out.print("%");
         }
         System.out.print("||");
         for(int mod2 = 1; mod2 <= SIZE - 2; mod2++)   {
            System.out.print("%");
         }
         System.out.println("|");
      }
   }
}