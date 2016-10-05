/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author Colin
 */
public class GameOfLife {//start class

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//start main
        // TODO code application logic here
        
        GameBoard mainGame = new GameBoard();
        
        
        mainGame.printGameBoard();
        //GameBoard placeHolder = new GameBoard(mainGame.matrixToString());
        
        for(int i = 0; i < 10; i++){//start for
            
            mainGame.nextGen();
            
            mainGame.printGameBoard();
        }//end for
        
        
        
        
    }//end main
    
}//end class
