import java.util.Arrays;

class Scores2DArray {
  public static void main(String[] args) {
    // Array of 3 rows & 4 columns
    // 2 pairs of square brackets declare 2D array of int
    int[][] scores = {
      {100, 92, 99, 85},
      {100, 95, 88, 91},
      {99, 100, 100, 100}
    };
    System.out.println(Arrays.deepToString(scores));
  }
}