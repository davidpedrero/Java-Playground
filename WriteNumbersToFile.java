import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class WriteNumbersToFile {
  public static void main(String[] args) {
    ArrayList<Integer> years = new ArrayList<>();
    years.add(1975);
    years.add(1979);
    years.add(1983);
    File numbersOutput = new File("years.txt");
    // Iterate iver ArrayList of years
    for(int year : years) {
      try {
        Files.writeString(numbersOutput.toPath(), Integer.toString(year) + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
      }
      catch(IOException ex) {
        System.out.println("Error writing to file: " + ex.getMessage());
      }
    }
  }
}