
class Board{
  final private String [][] board = new String [3][3];

  public void create(){
    for(int i = 0; i < 3; i++){
      for(int ii = 0; ii<3; ii++){
        board[i][ii]= " ";
      }
    }
  }

  public boolean setBoard(int first, int second, String selection){
    if(this.board[first][second].equals("X") || this.board[first][second].equals("O")){
      return false;
    }
    this.board[first][second] = selection;
    return true;
  }

  public void display(){
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
    return checkWinRow() || checkWinColumn() || checkWinDiagonal() || checkDraw();
  }

  public boolean checkWinRow(){
    StringBuilder check;
    for(int i = 0; i < 3; i++){
      check = new StringBuilder();
        for(int ii = 0; ii<3; ii++){
          if(board[i][ii].equals("X") || board[i][ii].equals("O")){
            check.append(board[i][ii]);
          }
        } 
        if(check.toString().equals("XXX") ||  check.toString().equals("OOO")){
          System.out.println("rowWIN");
          return true;
        }
      }
    return false;
  }  

  public boolean checkWinColumn(){
    String check;
      for(int i = 0; i < 3; i++){
        check = "";
        for(int ii = 0; ii<3; ii++)
          if (board[ii][i].equals("X") || board[ii][i].equals("O")) {
            check = check + board[ii][i];
          }
        if(check.equals("XXX") ||  check.equals("OOO")){
          System.out.println("columnWIN");
          return true;
        }
      }
    return false;
  }

  public boolean checkWinDiagonal(){
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