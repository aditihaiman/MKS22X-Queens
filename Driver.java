public class Driver {

  public static void main(String[] args) {
    //QueenBoard board1 = new QueenBoard(10);
    // board1.addQueen(5, 4);
    // System.out.println(board1);
    // board1.addQueen(6, 9);
    // System.out.println(board1);
    // System.out.println(board1.queenInDanger(9));
    // System.out.println(board1.toString1());
    //board1 = new QueenBoard(14);
    // board1.addQueen(0, 0);
    // board1.addQueen(1, 0);
    //System.out.println(board1.solve());
    // System.out.println(board1);
    //System.out.println(board1.countSolutions());

    runTest(5);


  }


  //testcase must be a valid index of your input/output array
  public static void runTest(int i){
    QueenBoard b;
    int[]tests =   {1,2,3,4,5,8};
    int[]answers = {1,0,0,2,10,92};
    if(i >= 0 && i < tests.length ){
      int size = tests[i];
      int correct = answers[i];
      b = new QueenBoard(size);
      int ans  = b.countSolutions();

      if(correct==ans){
        System.out.println("PASS board size: "+tests[i]+" "+ans);
      }else{
        System.out.println("FAIL board size: "+tests[i]+" "+ans+" vs "+correct);
      }
    }
  }

}
