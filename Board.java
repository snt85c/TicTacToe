
class Board{
  final private String [][] board = new String [3][3];

  public void create(){
    //initialize an empty board
    for(int i = 0; i < 3; i++){
      for(int ii = 0; ii<3; ii++){
        board[i][ii]= " ";
      }
    }
  }

  public boolean setBoard(int first, int second, String selection){
    //gets the coordinate to change a box, as well as the sign the box will be changed with. if the box is not empty, return false, otherwise true and assign a letter
    if(this.board[first][second].equals("X") || this.board[first][second].equals("O")){
      return false;
    }
    this.board[first][second] = selection;
    return true;
  }

  public void display(){
    //basci checker display 3x3
    //empty the screen
    /*System.out.print("\033[H\033[2J");
    System.out.flush();*/
    //empty the screen
    System.out.println(" ╔═══╦═══╦═══╗ ");
    for(int i = 0; i < 3; i++){
      System.out.print(" ║ ");
      for(int ii = 0; ii<3; ii++){
          System.out.print(board[i][ii] + " ║ ");
      }
      System.out.println();
      if(i<2){
      System.out.println(" ╠═══╬═══╬═══╣ ");
      } else {
        System.out.println(" ╚═══╩═══╩═══╝ ");
      }
    }
    System.out.println("--------------------");
  }

  public boolean checkWinCondition(){
    //return the value of 4 winning condition
    return checkWinRow() || checkWinColumn() || checkWinDiagonal() || checkDraw();
  }

  public boolean checkWinRow(){
    //for every row, makes a string that contains the letter in it, if it is similar to "XXX" or "OOO" returns true
    StringBuilder check;
    for(int i = 0; i < 3; i++){
      check = new StringBuilder();
        for(int ii = 0; ii<3; ii++)
          if(board[i][ii].equals("X") || board[i][ii].equals("O")) {
            check.append(board[i][ii]);
        } 
        if(check.toString().equals("XXX") ||  check.toString().equals("OOO")){
          System.out.println("rowWIN");
          return true;
        }
      }
    return false;
  }  

  public boolean checkWinColumn(){
    //for every column, makes a string that contains the letter in it, if it is similar to "XXX" or "OOO" returns true
    StringBuilder check;
      for(int i = 0; i < 3; i++){
        check = new StringBuilder();
        for(int ii = 0; ii<3; ii++)
          if (board[ii][i].equals("X") || board[ii][i].equals("O")) {
            check.append(board[ii][i]); 
          }
          if(check.toString().equals("XXX") ||  check.toString().equals("OOO")){
          System.out.println("columnWIN");
          return true;
        }
      }
    return false;
  }

  public boolean checkWinDiagonal(){
    //checks a set of coordinates for diagonal win condition and returns true if the string contains XXX or OOO
    String check = board[0][0] +  board[1][1] + board[2][2]; 
    if(check.equals("XXX")|| check.equals("OOO")){
      System.out.println("diagonal win");
      return true;
    }
    check = board[0][2] +  board[1][1] + board[2][0]; 
    if(check.equals("XXX")|| check.equals("OOO")){
      System.out.println("diagonal win");
      return true;
    }
    return false;
  }

  public boolean checkDraw(){
    //counts the amount of empty spaces in the board. if 0, there are no more space left and proclaims draw
    int check=0;
    for(int i = 0; i < 3; i++){
        for(int ii = 0; ii<3; ii++){
          if(board[i][ii].equals(" ")){
            check++;
          }
        }
      }
      if(check == 0){
        System.out.println("Draw condition");
        return true;
      }
    return false;
  }

}