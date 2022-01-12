// This program interacts with the user to view or create a madlib by taking in an input file, 
// scanning the file for placeholders to be be filled in by the user, and printing the madlib to 
// an ouput file entered by the user. 

import java.io.*;
import java.util.*;

public class MadLibs {
   public static void main(String[] args) throws FileNotFoundException {
   Scanner console = new Scanner(System.in);
      intro();
      String option = "";
      while (!option.equals("q")) {
         option = option(console);
         if (option.equals("c")) {
            File inputFile = input(console);
            System.out.print("Output file name: ");
            File outputFile = new File(console.nextLine());      
            madlib(inputFile, outputFile, console); 
         } else if (option.equals("v")) {
            File inputFile = input(console);
            view(inputFile);
         }
      }
   }
   
   // Prompts user to enter whether they want to create a mad-lib, view their mad-lib or quit 
   // until a valid option of c, v, or q is typed
   public static String option(Scanner console) {
      String option = "";
      System.out.println();
      while (!(option.equals("c") || option.equals("v")|| option.equals("q"))) { 
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         option = console.nextLine();
         option = option.toLowerCase();
      } 
      return option;
   }        

   // Prompts the user to enter an input file name for use in creating the madlib.
   // Method prints a file not found message until an existing file is typed
   public static File input(Scanner console) throws FileNotFoundException {
      System.out.print("Input file name: ");
      File inputFile = new File(console.nextLine());
      while (!inputFile.exists()) {
         System.out.print("File not found. Try again: ");
         inputFile = new File(console.nextLine());
      }
      return inputFile;
   }
   
   // Prints the text from an input file entered by the user for user to view a madlib 
   public static void view(File inputFile) throws FileNotFoundException {
      Scanner input = new Scanner(inputFile);
      while (input.hasNextLine()) {
         System.out.println();
         Scanner tokenScanner = new Scanner(input.nextLine());
         while(tokenScanner.hasNext()) {
            String token = tokenScanner.next();
            System.out.print(token + " ");
         }
      }
      System.out.println();
   }
   
   // Scans the input file for placeholders and prompts user to enter part of speech type indicated 
   // Prints the madlib text with filled in user input to the output file entered by the user
   public static void madlib (File inputFile, File outputFile, Scanner console) 
      throws FileNotFoundException {
      PrintStream output = new PrintStream(outputFile);  
      Scanner input = new Scanner(inputFile);
      System.out.println(); 
      while (input.hasNextLine()) {
         Scanner tokenScanner = new Scanner(input.nextLine());
         while(tokenScanner.hasNext()) {
            String token = tokenScanner.next();
            if (!token.startsWith("<") || !token.endsWith(">")) { 
               output.print(token + " ");
            } else {
               token = token.replace("<", "");
               token = token.replace(">", ": ");
               token = token.replace("-", " ");
               token = token.toLowerCase();
               String firstLetter = String.valueOf(token.charAt(0));
               firstLetter = firstLetter.toLowerCase();
               String article = "a";
                  if (firstLetter.equals("a") || firstLetter.equals("e") || firstLetter.equals("i") 
                     || firstLetter.equals("o") || firstLetter.equals("u")) {
                     article += "n";
                  }
               System.out.print("Please type " + article + " " + token);
               String newToken = console.nextLine();
               output.print(newToken + " ");
            }   
         }  
         output.println();
      }  
      System.out.println("Your mad-lib has been created!");
   }  
   
   // prints the lines of introductory text to the program
   public static void intro() {
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
   }
}