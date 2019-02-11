public class Driver {

  public static void main(String[] args) {
    QueenBoard board1 = new QueenBoard(10);
    // board1.addQueen(5, 4);
    // System.out.println(board1);
    // board1.addQueen(6, 9);
    // System.out.println(board1);
    // System.out.println(board1.queenInDanger(9));
    // System.out.println(board1.toString1());
    board1 = new QueenBoard(14);
    // board1.addQueen(0, 0);
    // board1.addQueen(1, 0);
    System.out.println(board1.solve());
    // System.out.println(board1);
    System.out.println(board1.countSolutions());

  }
}
