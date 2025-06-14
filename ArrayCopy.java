import java.util.Arrays;

class ArrayCopy {
  public static void main(String[] args) {
    // Original array of 5 integers
    int[] scores = {77, 89, 100, 68, 95};
    System.out.println("Original: " + Arrays.toString(scores));
    // Copy larger array of 10 integers back to scores
    scores = Arrays.copyOf(scores, 10);
    System.out.println("Enlarged: " + Arrays.toString(scores)); 
  }
}