public class QueenBoard {

  public static void main(String[] args) {
    QueenBoard board1 = new QueenBoard(10);
    board1.addQueen(5, 5);
    System.out.println(board1);
    board1.addQueen(2, 5);
    board1.addQueen(0, 0);
    System.out.println(board1);
    System.out.println(board1.queenInDanger(0, 0));

  }

  private int[][] board;

  public QueenBoard(int size) {
    board = new int[size][size];
    for (int x = 0; x < size; x++) {
      for (int y = 0; y < size; y++) {
        board[x][y] = 0;
      }
    }
  }

/**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString(){
    String output = "";
    for (int x = 0; x < board.length; x++) {
      for (int y = 0; y < board[0].length; y++) {
        if (board[x][y]==1) output+="Q ";
        else output += "_ ";
      }
      output+= "\n";
    }
    return output;
  }


  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    if (!isEmpty()) throw new IllegalStateException();
    return false;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    int output = 0;
    if (!isEmpty()) throw new IllegalStateException();
    return output;
  }



  private boolean queenInDanger(int r, int c) {
    for (int x = 0; x < board.length; x++) {
      for (int y = 0; y < board[0].length; y++) {
        if (x!=r&&board[x][c]==1) return true;
        if (y!=c&&board[r][y]==1) return true;
        if (x!=r && y!=c && (c-y)==(r-x) && board[x][y]==1) return true;
      }
    }
    return false;
  }

  private boolean addQueen(int r, int c) {
    board[r][c] = 1;
    return true;
  }

  private boolean removeQueen(int r, int c) {
    board[r][c] = 2;
    return true;
  }

  private boolean isEmpty() {
    for (int x = 0; x < board.length; x++) {
      for (int y = 0; y < board[x].length; y++) {
        if (board[x][y] != 0) return false;
      }
    }
    return true;
  }

}
