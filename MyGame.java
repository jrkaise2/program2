/*
 * Author: 
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */
import java.util.*;

public class MyGame extends Game{

    public static void main(String[] args){
       int col;
       int number; 
       
       C4 c4 = new C4();
       c4.printBoard();
       
        System.out.println("");
        System.out.println("");
               
        System.out.println("Welcome to the game of " + c4.getName());
        System.out.println("");
        
        
        Scanner input = new Scanner(System.in);
            System.out.println("Enter number of players.");
            number = c4.setNumPlayers(input.nextInt());
            input.nextLine();
            
            System.out.println("\n");
            
            System.out.println("Number of players in this game: " + number);        
            
            c4.clearAgain(); 
            
              while (c4.isWinner() == false){ 
                    if (c4.isFull() == true)
                    {
                        System.out.println("The board is full, clearing board now...");
                        c4.clearAgain();
                    }
                    
               System.out.println("Current turn is: " + c4.getTurn()); 
               System.out.println("Enter your piece for which column?");   
               col = input.nextInt();
               input.nextLine();
               if(col != 1|| col !=2 || col !=3 || col !=4 || col !=5 || col !=6 || col != 7 || col !=8 || col != 9)
               {
                   System.out.println("Error: A number from 0-6 must be entered.");
               }
               c4.playPiece(col, c4.getTurn());
               if (c4.isColFull(col) == true)
                    {
                        System.out.println("Column is full. Please pick another column.");
                    }
                        
               c4.printBoard();
               System.out.println("");
               c4.nextTurn();
            }
               c4.winner();
                           
               /*if (c4.isFull() == false)
                  System.out.println("The board is not full. Keep playing.\n");
                 else
                  System.out.println("The board is full. No more tries possible.\n");     
              */
               }
    }
                
        
    

