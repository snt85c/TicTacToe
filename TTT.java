import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

class TTT{

    Board board = new Board();
    private HashMap <Integer,String> numpadKeys = new HashMap<Integer,String>();
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    AI ai = new AI(numpadKeys, board);

    public void start(){
        board.initializeBoardAsEmpty();
        this.keymapping();
        board.display();
        this.play();
    }

    public void keymapping(){
        //maps the numpad keys to coordinates in the board, which will be elaborated further at assignment of a value during gameplay
        numpadKeys.put(1 , "20");
        numpadKeys.put(2 , "21");
        numpadKeys.put(3 , "22");
        numpadKeys.put(4 , "10");
        numpadKeys.put(5 , "11");
        numpadKeys.put(6 , "12");
        numpadKeys.put(7 , "00");
        numpadKeys.put(8 , "01");
        numpadKeys.put(9 , "02");
    }

    public void play(){
        String selection = "";
        boolean gameOn = true;
        while(gameOn){
            System.out.print("select a box: ");
            try{
                while(scan.hasNextInt()){
                    selection = String.valueOf(scan.nextInt());
                    if(Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > 9){
                        System.out.print("wrong selection, select another: ");
                    }else{
                        break;
                    }
                }
                selection = numpadKeys.get(Integer.valueOf(selection));
                int firstCoordinate = Integer.parseInt(String.valueOf(selection.charAt(0)));
                int secondCoordinate =Integer.parseInt(String.valueOf(selection.charAt(1)));
                if(!board.setSymbolOnBoard(firstCoordinate, secondCoordinate, "X")){
                    System.out.println("slot busy, change selection");
                    this.play();
                }

                if(board.checkALLWinCondition()){
                    board.display();
                    System.out.println("GAME OVER");
                    //gameOn= false;
                    this.start(); //neverending for testing, remove to game over
                }
                ai.manageAI();
            }catch(Exception e){
                System.out.println("not a number");
                scan.next();
            }
        }
    }
}