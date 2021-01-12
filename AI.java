import java.util.HashMap;
import java.util.Random;

class AI{

  private HashMap <Integer,String> numpadKeys;
  private Board board;
  private Random rand = new Random();

  public AI(HashMap passedKeys, Board passedBoard){
    this.numpadKeys = passedKeys;
    this.board = passedBoard;
  }

  public void debug(){
    //for test only
    System.out.println(board.getBoxOnBoard(1,1));
    System.out.println(board.getBoxOnBoard(0,0));
  }


  public void randomMovement(){
    while(true){
      int action =  rand.nextInt(9)+1;
      String selection = numpadKeys.get(action);
      int firstCoordinate = Integer.parseInt(String.valueOf(selection.charAt(0)));
      int secondCoordinate =Integer.parseInt(String.valueOf(selection.charAt(1)));
      if(!board.setSymbolOnBoard(firstCoordinate, secondCoordinate, "O")){
          continue;
        } else {
          board.display();
          if(board.checkALLWinCondition()){
            System.out.println("GAME OVER");
          }
        break;
      }
    }
  }

  public boolean checkForImminentGameOverOnROWS(){
    String [][] tempBoard = board.getBoard();
    int firstCoordinate = 0;
    int secondCoordinate = 0;
    for(int row = 0 ; row < 3 ; row++ ){
      int countX = 0;
      int countEmpty = 0;
      for(int column = 0; column<3; column++){
        if(tempBoard[row][column].equals("X")){
          countX++;
        }
        if(tempBoard[row][column].equals(" ") && countEmpty<1){
          countEmpty++;
          firstCoordinate = row;
          secondCoordinate = column;
        }
        if(countX == 2 && countEmpty == 1){
          board.setSymbolOnBoard(firstCoordinate, secondCoordinate, "O");
          return true;
        }
      }
    }
    return false;
  }
}