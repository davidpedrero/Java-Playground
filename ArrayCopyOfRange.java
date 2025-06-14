import java.util.Arrays;

class ArrayCopyOfRange {
  public static void main(String[] args) {
    // Original array of 5 integers
    int[] scores = {77, 89, 100, 68, 95};
    System.out.println("Original: " + Arrays.toString(scores));
    Arrays.sort(scores);
    System.out.println("Sorted: " + Arrays.toString(scores));
    // start is 3rd from end, runs until the end - 1
    int[] topThree = Arrays.copyOfRange(scores, scores.length - 3, scores.length);
    System.out.println("Top 3: " + Arrays.toString(topThree));
  }
}