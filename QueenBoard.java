import java.io.*;
import java.util.*;

public class QueenBoard {

  private int[] board;

  public QueenBoard(int size) {
    board = new int[size];
    for (int x = 0; x < size; x++) {
        board[x] = -1;
    }
  }

/**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *   Q _ _ _
  *   _ _ _ Q
  *   _ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString(){
    String output = "";
    for (int x = 0; x < board.length; x++) {
      for (int y = 0; y < board.length; y++) {
        if (board[y]==x) output+="Q ";
        else output += "_ ";
      }
      output+= "\n";
    }
    return output;
  }

  public String toString1(){
    return Arrays.toString(this.board);
  }


  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve() {
    if (!isEmpty()) throw new IllegalStateException();
    QueenBoard board1 = new QueenBoard(board.length);
    return solveHelp(board1, 0);
  }

  public static boolean solveHelp(QueenBoard newboard, int k){
    if (k==newboard.board.length) return true;
    for (int x = 0; x < newboard.board.length; x++) {
      newboard.addQueen(x, k);
      // System.out.println(newboard);
      if (!newboard.queenInDanger(k) && solveHelp(newboard, k+1)) return true;
      newboard.removeQueen(k);
    }
    return false;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */

  public int countSolutions() {
    if (!isEmpty()) throw new IllegalStateException();
    QueenBoard board1 = new QueenBoard(board.length);
    return countSolutionsHelp(board1, 0);
  }

  public static int countSolutionsHelp(QueenBoard newboard, int k){
    if (k==newboard.board.length){
      //System.out.println(newboard);
      return 1;
    }
    int total = 0;
    for (int x = 0; x < newboard.board.length; x++) {
      newboard.addQueen(x, k);
      if (!newboard.queenInDanger(k)) total+= countSolutionsHelp(newboard, k+1);
      newboard.removeQueen(k);
    }
    return total;
  }

  //---------------- HELPER METHODS -----------------//

  private boolean isEmpty() {
    for (int x = 0; x < board.length; x++) {
      if (board[x]!= -1) return false;
    }
    return true;
  }

  private boolean queenInDanger(int idx) {
     for (int x = 0; x < board.length; x++) {
       if (x!=idx&&board[x]==board[idx]) return true;
       if (x!=idx && board[x]!=-1 && Math.abs(board[idx] - board[x])==Math.abs(idx-x)) return true;
     }
    return false;
  }

  private boolean addQueen(int r, int c) {
    board[c] = r;
    return true;
  }

  private boolean removeQueen(int r) {
    board[r] = -1;
    return true;
  }

}
