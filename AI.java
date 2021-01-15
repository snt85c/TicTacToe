import java.util.HashMap;
import java.util.Random;

class AI{

  private final HashMap numpadKeys;
  private final Board board;
  private final Random rand = new Random();
  private int firstCoordinate = 0;
  private int secondCoordinate = 0;

  public AI(HashMap passedKeys, Board passedBoard){
    this.numpadKeys = passedKeys;
    this.board = passedBoard;
  }

  public void manageAI(){
    do {
      if (this.checkForImminentGameOverOnDIAGONALS()) {
        board.display();
        System.out.println("avoid game over on diagonal");
        break;
      }
      if (this.checkForImminentGameOverOnROWS()) {
        board.display();
        System.out.println("avoid game over on row");
        break;
      }
      if (this.checkForImminentGameOverOnCOLUMNS()) {
        board.display();
        System.out.println("avoid game over on column");
        break;
      }
      randomMovement();
      board.display();
      System.out.println("performing random movement");
      break;
    } while (true);
    if(board.checkALLWinCondition()){
      board.display();
      System.out.println("GAME OVER");
    }
  }


  public void randomMovement(){
    while(true){
      int action =  rand.nextInt(9)+1;
      String selection = String.valueOf(numpadKeys.get(action));
      int firstCoordinate = Integer.parseInt(String.valueOf(selection.charAt(0)));
      int secondCoordinate =Integer.parseInt(String.valueOf(selection.charAt(1)));
      if(!board.setSymbolOnBoard(firstCoordinate, secondCoordinate, "O")){
      } else {
        if(board.checkALLWinCondition()){
          System.out.println("GAME OVER");
        }
        break;
      }
    }
  }

  public boolean checkForImminentGameOverOnROWS(){
    String [][] tempBoard = board.getBoard();
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

  public boolean checkForImminentGameOverOnCOLUMNS(){
    String [][] tempBoard = board.getBoard();
    for(int column = 0 ; column < 3 ; column++ ){
      int countX = 0;
      int countEmpty = 0;
      for(int row = 0; row<3; row++){
        if(tempBoard[column][row].equals("X")){
          countX++;
        }
        else if(tempBoard[column][row].equals(" ") && countEmpty<1){
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

  public boolean checkForImminentGameOverOnDIAGONALS(){
    String [][] tempBoard = board.getBoard();
    int countX = 0;
    int countEmpty = 0;
    for(int i = 0; i< 3 ; i++){
      //checks coordinates 0.0, 1.1, 2.2

      if(tempBoard[i][i].equals("X")){
        countX++;
      }
      if(tempBoard[i][i].equals(" ") && countEmpty<1){
        countEmpty++;
        firstCoordinate=i;
        secondCoordinate=i;
        System.out.println(firstCoordinate + " " + secondCoordinate);
      }
      if(countX==2 && countEmpty==1){
        board.setSymbolOnBoard(firstCoordinate, secondCoordinate, "O");
        return true;
      }
      countX=0;
      countEmpty=0;
    }
    for(int i = 0; i<3; i++){
      int ii = 2;
      //checks coordinates 0.2, 1.1, 2.0
      if(tempBoard[i][ii].equals("X")){
        countX++;
      }
      if(tempBoard[i][ii].equals(" ") && countEmpty<1){
        countEmpty++;
        firstCoordinate=i;
        secondCoordinate=i;
      }
      if(countX==2 && countEmpty==1){
        board.setSymbolOnBoard(firstCoordinate, secondCoordinate, "O");
        return true;
      }
      ii--;
    }
    return false;
  }
}