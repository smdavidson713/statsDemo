import java.util.Scanner;
import java.io.*;
import java.lang.Math; 
// TASK #1 Add the file I/O import statement here

/**
   This class reads numbers from a file, calculates the
   mean and standard deviation, and writes the results
   to a file.
*/

public class StatsDemo
{
   // TASK #1 Add the throws clause
   public static void main(String[] args) throws IOException
   {
      double sum = 0;      // The sum of the numbers
      int count = 0;       // The number of numbers added
      double mean = 0;     // The average of the numbers
      double stdDev = 0;   // The standard deviation
      String line;         // To hold a line from the file
      double difference;   // The value and mean difference

      // Create an object of type Scanner
      Scanner keyboard = new Scanner (System.in);
      String filename;     // The user input file name

     // Prompt the user and read in the file name
      System.out.println("This program calculates " +
                         "statistics on a file " +
                         "containing a series of numbers");
      System.out.print("Enter the file name:  ");
      filename = keyboard.nextLine();

      // ADD LINES FOR TASK #2 HERE
     FileReader fileReader = new FileReader(filename); // Create a FileReader object passing it the filename
     BufferedReader bufferedReader = new BufferedReader(fileReader); // Create a BufferedReader object passing FileReader
                                                                     // object
      line = bufferedReader.readLine(); // Perform a priming read to read the first line of
                                        // the file
     while(line != null){  // Loop until you are at the end of the file
      sum += Double.valueOf(line); // Convert the line to a double value and add the
                              // value to sum
      count++;                // Increment the counter
      line = bufferedReader.readLine(); // Read a new line from the file

     }
      bufferedReader.close();  // Close the input file
     mean = sum / count;       // Store the calculated mean

      // ADD LINES FOR TASK #3 HERE
      fileReader = new FileReader(filename); // Reconnect FileReader object passing it the
                                                        // filename
      bufferedReader = new BufferedReader(fileReader); // Reconnect BufferedReader object passing
                                                                    // FileReader object
      sum = 0;   // Reinitialize the sum of the numbers
      count = 0; // Reinitialize the number of numbers added
      line = bufferedReader.readLine(); // Perform a priming read to read the first line of
                                        // the file
      while(line != null){  // Loop until you are at the end of the file
         difference = Double.valueOf(line) - mean;  // Convert the line into a double value and
                                                    // subtract the mean
         sum += (difference*difference); // Add the square of the difference to the sum
         count++; // Increment the counter
         line = bufferedReader.readLine(); // Read a new line from the file

      }
      bufferedReader.close(); // Close the input file
      stdDev =Math.sqrt(sum/count);  // Store the calculated standard deviation

      // ADD LINES FOR TASK #1 HERE
      FileWriter fileWriter = new FileWriter("Results.txt");   // Create a FileWriter object using "Results.txt"
      PrintWriter printWriter = new PrintWriter(fileWriter);    // Create a PrintWriter object passing the filewriter
      printWriter.printf("The mean is %.3f\n", mean);// Print the results to the output file
      printWriter.printf("The Standard Deviation is %.3f\n", stdDev);// Print the results to the output file 
      printWriter.close(); // Close the output file
   }
}