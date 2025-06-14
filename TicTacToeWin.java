class TicTacToeWin {
  public static void main(String[] args) {
    // Board pattern to test
    // X has a win on the second rpw (array index 1 is row 2)
    String[][] board = {{" - ", " O ", " X "},
                        {" X ", " - ", " X "},
                        {" O ", " O ", " X "}
                       };
    int winningRow = checkForRowWin(board, 'X');
    if (winningRow > 0) {
      System.out.println("Win on row " + winningRow);
    }

    int winningCol = checkForColumnWin(board, 'O');
    if(winningCol > 0) {
      System.out.println("Win on column " + winningCol);
    }
  }

  public static int checkForRowWin(String[][] board, char player) {
    // Variable to track row that holds a win
    int rowNumber = 0;
    for (int row = 0; row < 3; row++) {
      if (board[row][0].equals(" " + player + " ") &&
         board[row][1].equals(" " + player + " ") &&
         board[row][2].equals(" " + player + " ")) {
        
        rowNumber = row + 1;
        break;
      }
    }
    
    return rowNumber;
  }

  public static int checkForColumnWin(String[][] board, char player) {
    // Variable to track row that holds a win
    int colNumber = 0;
    for(int col = 0; col < 3; col++) {
      if(board[0][col].equals(" " + player + " ") &&
        board[1][col].equals(" " + player + " ") &&
        board[2][col].equals(" " + player + " ")) {
        colNumber = col + 1;
        // Temporary statement to print out winning row
        System.out.println("Col:\n"+ board[0][col] + "\n" + 
          board[1][col] + "\n" + board[2][col]);
        break;
      }
    }
    // If colNumber > 0, there is a winning row
    return colNumber;
  }
}