// This program interacts with the user to collect input on midterm, final, and homework scores to
// calculate and print total points and weighted score of each catagory, overall percentage 
// and gpa with a message

import java.util.*;

public class Gradanator {
   public static final int EXAMCAP = 100;
   public static final int SECTIONCAP = 30;
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      intro();
      double weightedmidterm = midtermExam(console);
      double weightedfinal = finalExam(console);
      double weightedhw = userInputHomework(console);
      overall(weightedmidterm, weightedfinal, weightedhw);
   }
   
   // Method prints the lines of introductory text for the program
   public static void intro() {
      System.out.println("This program reads exam/homework scores");
      System.out.println("and reports your overall course grade.");
      System.out.println();
   }
   
   // Method prints the midterm section header and returns the weighted midterm value to main
   public static double midtermExam(Scanner console) {
      System.out.println("Midterm:");
      double weightedmidterm = userInputExams(console);
      return weightedmidterm;
   }
   
   // Method prints the final section header and returns the weighted final value to main
   public static double finalExam(Scanner console) {
      System.out.println("Final:");
      double weightedfinal = userInputExams(console);
      return weightedfinal;
   }
   
   // Method collects user input on exam weight, scores, and shifts for the exam sections
   // Method calculates total points and returns the weighted score value
   public static double userInputExams(Scanner console) {
      System.out.print("Weight (0-100)? ");
      int weight = console.nextInt();
      System.out.print("Score earned? ");
      int score = console.nextInt();
      System.out.print("Were scores shifted (1=yes, 2=no)? ");
      int option = console.nextInt();
      int totalpoints = score;
      if (option == 1) {
         System.out.print("Shift amount? ");
         int shift = console.nextInt();
         totalpoints = (score + shift);
      }
      if (totalpoints > EXAMCAP) {
         totalpoints = EXAMCAP;
      }
      int max = EXAMCAP;
      double weightedscore = calculateWeightedScore(weight, totalpoints, max);
      return weightedscore;
   }
   
   // Method collects user input on homework weight, scores and sections attended
   // Method calculates section and total points, prints section points and returns weighted score
   public static double userInputHomework(Scanner console) {
      System.out.println("Homework:");
      System.out.print("Weight (0-100)? ");
      int weight = console.nextInt();
      System.out.print("Number of assignments? ");
      int assignments = console.nextInt();
      int sumscore = 0;
      int summax = 0;
      for (int i = 1; i <= assignments; i++) {
         System.out.print("Assignment " + i + " score and max? ");
         sumscore = sumscore + console.nextInt();
         summax = summax + console.nextInt();
      }
      System.out.print("How many sections did you attend? ");
      int sections = console.nextInt();
      if (sections > 6) {
         sections = 6;
      }
      int sectionpoints = sections * 5;
      System.out.println("Section points = " + sectionpoints + " / " + SECTIONCAP);
      if (sumscore >= summax) {
         sumscore = summax;
      }
      int totalpoints = sumscore + sectionpoints;
      int max = summax + SECTIONCAP;
      double weightedhw = calculateWeightedScore(weight, totalpoints, max);
      return weightedhw;
   }
   
   // Method prints the total points and calculates and prints the weighted score
   // Method returns the weighted score
   public static double calculateWeightedScore(int weight, int totalpoints, int max) {
      System.out.println("Total points = " + totalpoints + " / " + max);
      double weightedscore = (double)totalpoints / max * weight;
      System.out.println("Weighted score = " + round(weightedscore) + " / " + weight);
      System.out.println();
      return weightedscore;
   }
   
   // Method calculates and prints the students overall percentage and gpa in the course.
   // Method prints a custom gpa-dependent message to the user.
   public static void overall(double weightedmidterm, double weightedfinal, double weightedhw) {
      double overallpercentage = round(weightedmidterm + weightedfinal + weightedhw);
      System.out.println("Overall percentage = " + overallpercentage);
      String message;
      double gpa = 0.0;
      if (overallpercentage >= 85) {
         gpa = 3.0;
         message = "Proud of you :')";
      } else if (overallpercentage >= 75) {
         gpa = 2.0;
         message = "Good work, high fives 4 u.";
      } else if (overallpercentage >= 60) {
         gpa = 0.7;
         message = "You passed.";
      } else {
         message = "You are a disappointment.";
      }
      System.out.println("Your grade will be at least: " + gpa);
      System.out.println(message);
   }
   
   // Method rounds values to one decimal place
   public static double round(double value) {
      return (Math.round(value * 10)) / 10.0;
   }
}