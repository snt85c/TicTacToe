import java.util.stream.*;
import java.util.Arrays;

class Board{
private String [][] board = new String [3][3];

  public void create(){
    for(int i = 0; i < 3; i++){
      for(int ii = 0; ii<3; ii++){
        board[i][ii]= " ";
      }
    }
  }

  public boolean setBoard(int first, int second, String selection){
    if(this.board[first][second] == "X" || this.board[first][second] == "O" ){
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
  }
  public boolean checkWinCondition(){
    if(checkWinRow() || checkWinColumn() || checkWinDiagonal() ){
      return true;
    }
    return false;
  }

public boolean checkWinRow(){
  String check;
  for(int i = 0; i < 3; i++){
    check = "";
      for(int ii = 0; ii<3; ii++){
        if(board[i][ii] == "X" || board[i][ii] == "O" ){
          check = check +  board[i][ii];
        }
      } 
      if(check.equals("XXX") ||  check.equals("OOO")){
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
      for(int ii = 0; ii<3; ii++){
        if(board[ii][i] == "X" || board[ii][i] == "O" ){
          check = check +  board[ii][i];
        }
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

}