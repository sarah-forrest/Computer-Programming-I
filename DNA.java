// This program interacts with the user to take in an input file and prints summary text about a 
// nucleotide sequence to an output file entered by the user. Output text includes region names and
// nucleotide sequences. Program calculates and prints nucleotide counts, mass percentages of each, 
// total mass, codons, and whether it meets criteria to be a protein.

import java.util.*;
import java.io.*;
public class DNA {
   public static final int MIN_CODONS = 5;
   public static final int PERCENTAGE_MASS = 30;
   public static final int UNIQUE_NUCLEOTIDES = 4;
   public static final int CODON = 3;
   public static void main(String[] args) throws FileNotFoundException {
      double[] masses = {135.128, 111.103, 151.128, 125.107, 100.000};
      Scanner console = new Scanner(System.in);
      File inputFile = input(console);
      PrintStream output = output(console);
      Scanner input = new Scanner(inputFile);
      while (input.hasNextLine()) {
         String regionName = input.nextLine();
         String nucleotides = input.nextLine();
         nucleotides = nucleotides.toUpperCase();
         String noDashes = nucleotides.replace("-", ""); 
         int[] counts = nucCounts(nucleotides, masses);
         int junk = junkCalc(nucleotides);
         double totalMass = totalMass(masses, junk, counts);
         double[] mass = massCalc(counts, masses, totalMass);
         String[] codons = codonList(noDashes);
         String check = checkProtien(codons, noDashes, mass);
         printOutput(regionName, nucleotides, counts, mass, totalMass, codons, check, output);
      }
   }
 
   // Prints the region name, nucleotides, nucleotide counts, total mass percentage, codon list, 
   // and protein classification to the output file specified by the user 
   public static void printOutput(String regionName, String nucleotides, int[] counts, 
                                  double[] mass, double totalMass, String[] codons, String check,
                                  PrintStream output) throws FileNotFoundException {
      output.println("Region Name: " + regionName);
      output.println("Nucleotides: " + nucleotides);
      output.println("Nuc. Counts: " + Arrays.toString(counts));
      output.println("Total Mass%: " + Arrays.toString(mass) + " of " + round(totalMass));
      output.println("Codons List: " + Arrays.toString(codons));
      output.println("Is Protein?: " + check);
      output.println();
   }
   
   // Counts and stores the number of times that each unique nucleotide appears in the sequence
   public static int[] nucCounts(String nucleotides, double[] masses) {
      int[] counts = new int[UNIQUE_NUCLEOTIDES]; 
      for(int i = 0; i < nucleotides.length(); i++) {
         String nucleotide = String. valueOf(nucleotides.charAt(i));
         if (nucleotide.equals("A")) {
            counts[0]++; 
         } else if (nucleotide.equals("C")) { 
            counts[1]++;
         } else if (nucleotide.equals("G")) {
            counts[2]++;
         } else if (nucleotide.equals("T")) 
            counts[3]++;
         }
      return counts;
   } 
   
   // Calculates and stores the number of times a dash appears in the nucleotide sequence
   public static int junkCalc(String nucleotides) {
      int junk = 0;
      for(int i = 0; i < nucleotides.length(); i++) {
         String nucleotide = String.valueOf(nucleotides.charAt(i));
         if (nucleotide.equals("-")) {
            junk++;
         }
      }
      return junk;
   }
   
   // Calculates and stores total mass of the nucleotide secuence by adding the mass percentages 
   // of each unique nucleotide and the mass of dashes if present in the sequence
   public static double totalMass(double[] masses, int junk, int[] counts) {
      double totalMass = 0;
      for (int i = 0; i < UNIQUE_NUCLEOTIDES; i++) {
         totalMass += (masses[i] * counts[i]);
      }
      totalMass += (junk * masses[4]);
      return totalMass;
   }
   
   // Calculates and stores the mass percentages of each unique nucleotide in the sequence
   public static double[] massCalc(int[] counts, double []masses, double totalMass) {
      double[] mass = new double [UNIQUE_NUCLEOTIDES];
      for (int i = 0; i < UNIQUE_NUCLEOTIDES; i++) {
         mass[i] = round((masses[i] * counts[i]) / totalMass * 100);    
      }
      return mass; 
   }
   
   // Splits the nucleotide sequence  up into codons that are 3 nucleotides in length each
   public static String[] codonList(String noDashes) {
      String[] codons = new String [noDashes.length() / CODON];
      for (int i = 0; i < (noDashes.length() / CODON); i++) {
         codons[i] = noDashes.substring(i * CODON, i * CODON + CODON);
      }
      return codons;
   }
   
   // Checks if a particular nucleotide sequence meets the classifications to be a protein by:
   // starting with an ATG codon, ending with a TAA, TAG of TGA codon, containing 5 or more codons,
   // and cytosine and guanine mass percentages adding to at least 30.
   public static String checkProtien(String[] codons, String noDashes, double[] mass) {
      String check = "YES"; 
      int stopCodon = ((noDashes.length() + 1) / CODON) - 1;
      if (!(codons[0].equals("ATG"))) {
         check = "NO";
      } if (!(codons[stopCodon].equals("TAA") || codons[stopCodon].equals("TAG") || 
            codons[stopCodon].equals("TGA"))) {
         check = "NO";
      } if (noDashes.length() / CODON < MIN_CODONS) {
         check = "NO";
      } if (mass[1] + mass[2] < PERCENTAGE_MASS) {
         check = "NO";
      }
      return check;
   }

   // Prints lines of introductory text and prompts user for an input file to use in the program
   public static File input(Scanner console) {
      System.out.println("This program reports information about DNA");
      System.out.println("nucleotide sequences that may encode proteins");
      System.out.print("Input file name? ");
      File inputFile = new File(console.nextLine());
      return inputFile;
   }
    
   // Prompts user for the name of an output file for the program to print output text to
   public static PrintStream output(Scanner console) throws FileNotFoundException {
      System.out.print("Output file name? ");
      PrintStream output = new PrintStream(console.nextLine());
      return output;
   }
   
   // Rounds values to one decimal place
   public static double round(double value) {
      return (Math.round(value * 10)) / 10.0;
   }
}
