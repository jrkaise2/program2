/*
 * Author: John Kaiserlik
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */
import java.util.*;

public class MyGame extends Game{

    public static void main(String[] args){
       int col;
       int number; 
       int setTurn;
       int num =1;
//variable declarations
       C4 c4 = new C4();
       c4.printBoard();
       //create instance of C4
        System.out.println("");
        System.out.println("");
               
        System.out.println("Welcome to the game of " + c4.getName() + "!");
        System.out.println("");
        
        //print out welcoming message
        Scanner input = new Scanner(System.in);
        //create instance of Scanner
            System.out.println("Enter number of players.");
            number = c4.setNumPlayers(input.nextInt());
            input.nextLine();
            //set number of players
            System.out.println("\n");
            
            System.out.println("Number of players in this game: " + number);        
            //print number of players
            c4.clearAgain(); 
            c4.nextTurn();
            setTurn = c4.getTurn();
            //begin playing game through a do-while loop
            while (num == 1){
              do{
                  if (setTurn == 0)
                  {
                      setTurn = setTurn + 1;
                  }
                    System.out.println("Current turn is: " + c4.currentTurn());
                    if (c4.isFull() == true)
                    {
                        System.out.println("The board is full, clearing board now...");
                        c4.clearAgain();
                    }
               System.out.println("Enter your piece for which column? 0-6");   
               col = input.nextInt();
               input.nextLine();
               c4.playPiece(col, c4.getTurn());
               if (c4.isColFull(col) == true)
                    {
                        System.out.println("Column is full. Please pick another column.");
                    }
               c4.nextTurn();         
               c4.printBoard();
               System.out.println("");  
            } while  (c4.isWinner() == false);
               c4.winner();
                System.out.println("Do you wish to play again? '1' or yes, '2' for no");
                num = input.nextInt();
                if (num == 1)
                {
                    c4.clearAgain();
                }
            }//end while            
        }
    }
                
        
    

