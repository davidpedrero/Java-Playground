import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeLoop {
  public static void main(String[] args){
    String[][] board = {{" - ", " - ", " - "},
                        {" - ", " - ", " - "},
                        {" - ", " - ", " - "}};

    System.out.println("\t" + Arrays.toString(board[0]));
    System.out.println("\t" + Arrays.toString(board[1]));
    System.out.println("\t" + Arrays.toString(board[2]) + "\n");

    Scanner input = new Scanner(System.in);
    int col;
    int row;

    // for loop tp provide 5 rounds of turns
    for (int turn = 0; turn < 5; turn++) {
      // X's turn
      System.out.print("X - Select a column (1 - 3) & select row (1 - 3) ");
      System.out.print("seperated by a space: ");
      col = input.nextInt();
      row = input.nextInt();

      if (board[row - 1][col - 1].equals(" - ")) {
        board[row - 1][col - 1] = " X ";
      } else {
        System.out.println("That spot is taken.");
      }

      System.out.println("\t" + Arrays.toString(board[0]));
      System.out.println("\t" + Arrays.toString(board[1]));
      System.out.println("\t" + Arrays.toString(board[2]) + "\n");

      // If 5th turn, end loop after X's turn - only 9 spaces to fill
      if (turn == 4) {
        break;
      }

      // O's turn
      System.out.print("O - Select column (1-3) & select row (1-3) ");
      System.out.print("separated by a space: ");
      col = input.nextInt();
      row = input.nextInt();
      if(board[row - 1][col - 1].equals(" - ")) {
        board[row - 1][col - 1] = " O ";
      }
      else {
        System.out.println("Sorry, that spot is taken.");
      }
      System.out.println("\t" + Arrays.toString(board[0]));
      System.out.println("\t" + Arrays.toString(board[1]));
      System.out.println("\t" + Arrays.toString(board[2]) + "\n");
    }
  }
}