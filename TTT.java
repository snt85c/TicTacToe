import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

class TTT{
  
    Board board = new Board();
    private HashMap <Integer,String> keys = new HashMap<Integer,String>();
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    public void start(){
      board.create();
      this.keymapping();
      board.display();
      this.p1Plays();
    }

    public void keymapping(){ 
      //maps the numpad keys to coordinates in the board, which will be elaborated further at assignment of a value during gameplay
      keys.put(1 , "20");
      keys.put(2 , "21");
      keys.put(3 , "22");
      keys.put(4 , "10");
      keys.put(5 , "11");
      keys.put(6 , "12");
      keys.put(7 , "00");
      keys.put(8 , "01");
      keys.put(9 , "02");
    }

    public void p1Plays(){
      String selection = "";
      boolean gameOn = true;
      while(gameOn){
        System.out.print("select a box: ");
        try{
          while(scan.hasNextInt()){
            selection = String.valueOf(scan.nextInt());
            if(Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > 9){
              System.out.print("wrong selection, select another: ");
              continue;
            }else{
              break;
            }
          }
          //add the mapped value given from the numpad to a string, select the value at 0 and 1 of it and sends it to setBoard(). if the method return false, it means that the coordinate it has been sent to are full and will request a new set from the player
          selection = keys.get(Integer.valueOf(selection));
          int first = Integer.parseInt(String.valueOf(selection.charAt(0)));
          int second =Integer.parseInt(String.valueOf(selection.charAt(1)));
          if(!board.setBoard(first, second, "X")){
            System.out.println("slot busy, change selection");
            this.p1Plays();
          }
        
        if(board.checkWinCondition()){
          //checks all win condition, if true will end the current game, else the pc continues with his turn
          board.display();
          System.out.println("GAME OVER");
          //gameOn= false;
          this.start(); //neverending for testing, remove to game over
        }
        this.pcPlays(); 
        }catch(Exception e){
          System.out.println("not a number");
          scan.next();
        }    
     }
  }

  public void pcPlays(){
    //simple random selection from the pc, no AI involved.
    while(true){
      int action =  rand.nextInt(9)+1;
      String selection = keys.get(action);
      int first = Integer.parseInt(String.valueOf(selection.charAt(0)));
      int second =Integer.parseInt(String.valueOf(selection.charAt(1)));
      if(!board.setBoard(first, second, "O")){
        continue;
      } else {
        board.display();
        if(board.checkWinCondition()){
        System.out.println("GAME OVER");
        //gameOn= false;
        this.start(); //neverending for testing
      }
      break;
      }
    }
  }
}