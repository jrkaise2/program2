/*
 * Author: John Kaiserlik 
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */

public class C4 extends Game {

    private final int ROWS = 6;
    private final int COLS = 7;
    private int[][] board = new int[ROWS][COLS];

    public C4(String name, int players) {
        super(name, players);
    }

    public C4() {
        super();
        for (int r = 0; r < board.length; ++r) {
            for (int c = 0; c < board[r].length; ++c) {
                board[r][c] = 0;
            }
        }
    }
    
    private void clearBoard() {
        for (int r2 = 0; r2 < board.length; ++r2) {
            for (int c2 = 0; c2 < board[r2].length; ++c2) {
                board[r2][c2] = 0;
            }
        }
    }
    public void clearAgain(){
        this.clearBoard();
    }
    public int getPiece(int row, int col) {
        return this.board[row][col];
    }

    public int getTurn() {
        return super.currentTurn();//returns the int value of the current player
    }

    public boolean isColFull(int col) {

                if (board[5][col] !=0 && board[5-1][col] !=0
                    && board[5-2][col] !=0 && board[5-3][col] !=0
                    && board[5-4][col] !=0 && board[5-5][col] !=0) {
                    System.out.println("There's space in a column.");
                    return true;
        }
        return false;
    }

    private boolean isDiagWinner() {

        for (int r = 5; r>=3; r--) {

              if (board[r][0] !=0 && board[r][0] == board[r-1][0+1]
                  && board[r-1][0+1] !=0 && board[r-1][0+1] == board[r-2][0+2]
                  && board[r-2][0+2] !=0 && board[r-2][0+2] == board[r-3][0+3]){
                        return true;
              }
            }
        for (int r1 = 5; r1>=3; r1--) {

              if (board[r1][6] !=0 && board[r1][6] == board[r1-1][6-1]
                  && board[r1-1][6-1] !=0 && board[r1-1][6-1] == board[r1-2][6-2]
                  && board[r1-2][6-2] !=0 && board[r1-2][6-2] == board[r1-3][6-3]){
                        return true;
              }
            }
        for (int c2 = 5; c2 >=3; c2--){
               if (board[5][c2] !=0 && board[5][c2] == board[5-1][c2-1]
                  && board[5-1][c2-1] !=0 && board[5-1][c2-1] == board[5-2][c2-2]
                  && board[5-2][c2-2] !=0 && board[5-2][c2-2] == board[5-3][c2-3]){
                        return true;
          }
        }
        for (int c3 = 0; c3 <=3; c3++){
               if (board[5][c3] !=0 && board[5][c3] == board[5-1][c3+1]
                  && board[5-1][c3+1] !=0 && board[5-1][c3+1] == board[5-2][c3+2]
                  && board[5-2][c3+2] !=0 && board[5-2][c3+2] == board[5-3][c3+3]){
                        return true;
           }
        }
        return false;
    }

    public boolean isFull() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == 0) {
                    return false;
            }
        }
      }
        return true;
    }

    private boolean isHorizWinner() {

            for (int r9 = 0; r9 <= 5; ++r9) {
                if (board[r9][0] != 0 && board[r9][0] == board[r9][1]
                    && board[r9][1] != 0 && board[r9][1] == board[r9][2]
                    && board[r9][2] != 0 && board[r9][2] == board[r9][3])
                        return true;   
         }
         return false;
    }
    
    private boolean isVertWinner() {
        //win by 4 in a row      
            for (int c = 6; c >=0; c--) {
                if (board[5][c] != 0 && board[5][c] == board[4][c] 
                    && board[4][c] != 0 && board[4][c] == board[3][c]
                    && board[3][c] != 0 && board[3][c] == board[2][c]){
                    return true;
            }
    }
      return false;
    }

    public boolean isWinner() {

        if (isDiagWinner() == true || isHorizWinner() == true || isVertWinner() == true) {
            return true;
        } else {
            return false;
        }
    }

    public void nextTurn() {
        //call on super class
        super.next();

    }

    public void playPiece(int col, int player) {
        int r9=0;
            //for (int r9 = 0; r9 < board.length; ++r9) {
                if (board[r9][col] == 0 && board[r9+5][col] == board[r9+4][col] 
                        && board[r9+4][col] == board[r9+3][col] 
                        && board[r9+3][col] == board[r9+2][col] 
                        && board[r9+2][col] == board[r9+1][col] 
                        && board[r9+1][col] == board[r9][col]) 
                    board[r9+5][col] = getTurn();
                else if (board[r9+5][col] != 0 && board[r9+4][col] == 0)
                    board[r9+4][col] = getTurn();
                else if (board[r9+4][col] != 0 && board[r9+3][col] == 0)
                    board[r9+3][col] = getTurn();
                else if (board[r9+3][col] != 0 && board[r9+2][col] == 0)
                    board[r9+2][col] = getTurn();
                else if (board[r9+2][col] != 0 && board[r9+1][col] == 0)
                    board[r9+1][col] = getTurn();
                else if (board[r9+1][col] != 0 && board[r9][col] == 0)
                    board[r9][col] = getTurn();    
    }
        
    public void printBoard() {
        int count = 0;
        System.out.print(" A  B  C  D  E  F  G");
        if (count == 0) {
            System.out.println("");
        }
        int[][] array = new int[ROWS][COLS];

        for (int r2 = 0; r2 < array.length; ++r2) {

            for (int c2 = 0; c2 < array[r2].length; ++c2) {
                System.out.print("|" + board[r2][c2] + "|");
                count++;
                if (count == 7 || count == 14 || count == 21 || count == 28 || count == 35) {
                    System.out.println();
                }
            }
        }

    }
    public void printTest()
    {
        int count = 0;
        System.out.print(" 0  1  2  3  4  5  6");
        if (count == 0) {
            System.out.println("");
        }
        int[][] array = new int[ROWS][COLS];

        for (int r2 = 0; r2 < array.length; ++r2) {

            for (int c2 = 0; c2 < array[r2].length; ++c2) {
                System.out.print("|" + board[r2][c2] + "|");
                count++;
                if (count == 7 || count == 14 || count == 21 || count == 28 || count == 35) {
                    System.out.println();
                }
            }
        }
        }
    
}
