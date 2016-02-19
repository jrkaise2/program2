/*
 * Author: Jeffrey Whitworth
   Co-author: John Kaiserlik 
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */

public class Game {
    private String gameName = "Connect Four";
    private int numPlayers;
    private int currPlayer = currentTurn();
    private int tries;
//declare member variables
    
public Game(){
    numPlayers = 0;
    currPlayer = 0;
    tries = 0;
}
//default constructor initializing zeros
    public Game(String name, int players) {
        this.gameName = name;
        this.numPlayers = players;
        this.currPlayer = 1;
        this.tries = 0;
    }
//arg-accepting constructor to initialize variables
    public String getName() {
        return this.gameName;
    }
//accessor method to return game name
    public int currentTurn() {
        return this.currPlayer;
    }
    //accessor method to return current turn
    public void next() {
        this.currPlayer = this.currPlayer == 1 ? 2 : 1;
        ++this.tries;
    }
//mutator method to change turns between players
    public void winner() {
        if (this.currPlayer == 1)
            this.currPlayer = 2;
        else
            this.currPlayer = 1;
        System.out.println("Player " + this.currPlayer + " has won " + this.gameName + "!!!");
        System.out.println("The game took " + this.getTries() + " tries to finish.");
    }
//method to return a print statement announcing the winner and # of tries
    public int getTries() {
        return this.tries;
    }
    //accessor method to return number of tries
    public int setNumPlayers(int num){
       return this.numPlayers = num;
    }
   //accessor method to return the set amount of players
}

