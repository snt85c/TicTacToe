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
      keys.put(7 , "00");
      keys.put(8 , "01");
      keys.put(9 , "02");
      keys.put(4 , "10");
      keys.put(5 , "11");
      keys.put(6 , "12");
      keys.put(1 , "20");
      keys.put(2 , "21");
      keys.put(3 , "22");
    }

    public void p1Plays(){
      String selection = "";
      boolean gameOn = true;
      while(gameOn){
        System.out.print("select a box: ");
      
        while(scan.hasNextInt()){
          selection = String.valueOf(scan.nextInt());
          if(Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > 9){
            System.out.print("wrong selection, select another: ");
            continue;
          }else{
            break;
          }
        }      
        selection = keys.get(Integer.valueOf(selection));
        int first = Integer.parseInt(String.valueOf(selection.charAt(0)));
        int second =Integer.parseInt(String.valueOf(selection.charAt(1)));
        if(!board.setBoard(first, second, "X")){
          System.out.println("slot busy, change selection");
          this.p1Plays();
        }
        if(board.checkWinCondition()){
          board.display();
          System.out.println("GAME OVER");
          //gameOn= false;
          this.start(); //neverending for testing, remove to game over
        }
      this.pcPlays(); 
     }
  }

  public void pcPlays(){
    while(true){
      int random =  rand.nextInt(9)+1;
      String selection = keys.get(random);
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
        return;
      }
    }
  }
}