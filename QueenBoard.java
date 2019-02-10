import java.io.*;
import java.util.*;

public class QueenBoard {

  public static void main(String[] args) {
    QueenBoard board1 = new QueenBoard(10);
    //board1.addQueen(5, 5);
    System.out.println(board1);
    board1.addQueen(2, 5);
    board1.addQueen(3, 6);
    //board1.addQueen(0, 0);
    System.out.println(board1);
    //System.out.println(board1.queenInDanger(2, 5));
    board1 = new QueenBoard(4);
    System.out.println(board1.solve(0,0));

  }

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
  public boolean solve(int r, int c){
    //if (countQueens()!=0) throw new IllegalStateException();
    if (countQueens()==board.length) return true;
    else if (r>=board.length && c >= board.length) return false;
    for (int x = r; x < board.length; x++) {
      for (int y = c; y < board.length; y++) {
        if (board[x][y]==0) addQueen(x,y);
        System.out.println(this.toString());
        if (queenInDanger(x, y)){
          removeQueen(x,y);
          //return solve(r, c+1);
        }
      }
    }
    return solve(r+1, c+1);
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    int output = 0;
    //if (countQueens()!=0) throw new IllegalStateException();
    return output;
  }



  private boolean queensInDanger(int idx) {
     for (int x = 0; x < board.length; x++) {
       if (board[x]==board[idx]) return true;
       if (x == (board[idx] - board[x])) return true;
     }
    //   for (int y = 0; y < board[0].length; y++) {
    //     if (x!=r&&board[x][c]==1) return true;
    //     if (y!=c&&board[r][y]==1) return true;
    //     if (x!=r && y!=c && (c-y)==(r-x) && board[x][y]==1) return true;
    //     if (x!=r && y!=c && (c-y)==(x-r) && board[x][y]==1) return true;
    //   }
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

  // private int countQueens() {
  //   int output = 0;
  //   for (int x = 0; x < board.length; x++) {
  //     for (int y = 0; y < board[x].length; y++) {
  //       if (board[x][y] == 1) output++;
  //     }
  //   }
  //   return output;
  // }

}
