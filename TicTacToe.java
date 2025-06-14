import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
  public static void main(String[] args) {
    int col;
    int row;
    Scanner input = new Scanner(System.in);
    String[][] board = {{" - ", " - ", " - "},
                       {" - ", " - ", " - "},
                       {" - ", " - ", " - "}};
    
    System.out.println("\t" + Arrays.toString(board[0]));
    System.out.println("\t" + Arrays.toString(board[1]));
    System.out.println("\t" + Arrays.toString(board[2]) + "\n");

    System.out.print("X - Select row (1 - 3) & select column (1 - 3) ");
    System.out.print("separated by a space: ");
    row = input.nextInt();
    col = input.nextInt();
    board[row - 1][col - 1] = " X ";
    System.out.println("\nTic-Tac-Toe Board:\n");
    System.out.println("\t" + Arrays.toString(board[0]));
    System.out.println("\t" + Arrays.toString(board[1]));
    System.out.println("\t" + Arrays.toString(board[2]) + "\n");

    System.out.print("O - Select row (1-3) & select column (1-3) ");
    System.out.print("separated by a space: ");
    row = input.nextInt();
    col = input.nextInt();
    // Mark the requested square. Subtract 1 to get correct square
    board[row - 1][col - 1] = " O ";
    System.out.println("\t" + Arrays.toString(board[0]));
    System.out.println("\t" + Arrays.toString(board[1]));
    System.out.println("\t" + Arrays.toString(board[2]) + "\n");

    if(board[row - 1][col - 1].equals(" - ")) {
      board[row - 1][col - 1] = " O ";
    }
    else {
      System.out.println("Sorry, that spot is taken.");
    }
  }
}