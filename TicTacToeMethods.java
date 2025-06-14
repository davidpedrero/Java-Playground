import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeMethods {
  public static void main(String[] args) {
    String[][] board = {{" - ", " - ", " - "},
                        {" - ", " - ", " - "},
                        {" - ", " - ", " - "}};

    // Array of player marks
    char[] player = {'X', 'O'};

    int col = 0;
    int row = 0;
    // Initialize so input while loop runs untile entry is valid
    boolean validSelection = false;

    Scanner input = new Scanner(System.in);

    // Draw initial empty board
    drawGame(board);

    // Start turns. Even turns are X, odd turns are O
    for (int turn = 0; turn < 9; turn++) {
      // Prompt for input until the user makes a valid move
      while (!validSelection) {
        System.out.print(player[turn % 2] + " - Select row (1 - 3) & " + "select column (1 - 3) separated by a space: ");
        row = input.nextInt();
        col = input.nextInt();

        if(isValidSelection(row, col)) {
          if(isPositionOpen(board, row, col)) {
            // Set player charater at position
            board[row - 1][col - 1] = " " + player[turn % 2] + " ";
            // while loop will end when selected move is valid
            validSelection = true;
          }
          else {
            // Position is not open
            System.out.println("Sorry, that spot is taken.");
          }
        }
        // Not a valid selection
        else {
          System.out.println("Sorry, that is not a valid selection.");
        }
        
      }
      drawGame(board);

      // Check if this is the fifth or later turn (turn starts at 0)
      if (turn >= 4) {
        int winningRow = checkForRowWin(board, player[turn % 2]);
        int winningColumn = checkForColumnWin(board, player[turn % 2]);
        int winningDiagonal = checkForDiagonalWin(board, player[turn % 2]);
    
        if (winningRow > 0 || winningColumn > 0 || winningDiagonal > 0) {
          System.out.println("\n" + player[turn % 2] + " wins!\n");
          break;
        }
      }
      // Set so that while loop repeats until next player makes valid move
      validSelection = false;
      } // end of for loop for turns
    } // end of main()


  public static void drawGame(String[][] board) {
    for(int row = 0; row < board.length; row++) {
      System.out.println(Arrays.toString(board[row]));
    }
    System.out.println(); // Add a blank line after drawing the board
  }

  public static boolean isValidSelection(int row, int column) {
    // ! needed to return true if selecton is valid position
    return !(row < 1 || row > 3 || column < 1 || column > 3);
  }

  public static boolean isPositionOpen(String[][] board, int row, int column) {
    return board[row - 1][column - 1].equals(" - ");
  }

  public static int checkForRowWin(String[][] board, char player) {
    // Variable to track row that holds a win
    int rowNumber = 0;
    for(int row = 0; row <= 3; row++) {
      if(board[row][0].equals(" " + player + " ") &&
        board[row][1].equals(" " + player + " ") &&
        board[row][2].equals(" " + player + " ")) {
        // Add 1 to row number to match human count (starting with 1)
        rowNumber = row + 1;
        break;
      }
    }
    // If rowNumber > 0, there is a winning row
    return rowNumber;
  }

  public static int checkForColumnWin(String[][] board, char player) {
    // Variable to track row that holds a win
    int colNumber = 0;
    for(int col = 0; col < 3; col++) {
      if(board[0][col].equals(" " + player + " ") &&
        board[1][col].equals(" " + player + " ") &&
        board[2][col].equals(" " + player + " ")) {
        // Correct for human count (starting with 1, not 0)
        colNumber = col + 1;
        break;
      }
    }
    // If colNumber > 0, there is a winning row
    return colNumber;
  }

  public static int checkForDiagonalWin(String[][] board, char player) {
    int diagonalNumber = 0;
    
    if(board[1][1].equals(" " + player + " ")) {
      if(board[0][0].equals(" " + player + " ") && board[2][2].equals(" " + player + " ")) {
        diagonalNumber = 1;
      }
      else if(board[0][2].equals(" " + player + " ") && board[2][0].equals(" " + player + " ")) {
        diagonalNumber = 2;
      }
    }

    return diagonalNumber;
  }
}