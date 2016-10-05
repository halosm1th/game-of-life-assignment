/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.util.Random;

/**
 *
 * @author Colin
 */
public class GameBoard {//start GameBoard
    
    private final int MAXROWS = 20;
    private final int MAXCOL = 20;
    private boolean[][] matrixArray = new boolean[MAXROWS][MAXCOL];
    final String delim2 = "[ ]+";
    final String delim = "[\n]+";
    
    public GameBoard(){//start matrix contructor
        randomBoard();
    }//end matrix constructor
    
    private void randomBoard(){//start random board
        for(int i = 0; i < 20; i++){//start row for
            
            for(int j = 0; j < 20; j++){//start column for
                matrixArray[i][j] = Math.random() < 0.5;
                
                //matrixArray[i][j] = false;
            }//end column for
            
        }//end row for
    }//end random board
    
    
    public GameBoard(String initMat){//start GameBoard
        setGameBoard(initMat);
    }//end GameBoard
    
    public void setGameBoard(String oldGame){// start setGameBoard
        
        
        
        
        String tokens[] = oldGame.split(delim);
        int row = 0;
        
        for(int i = 0; i < tokens.length; i++){//start for
            //split the input string into an array
            String[] tokens2 = tokens[i].split(delim2);
            
            //traverse each row array
            for(int j = 0; j < tokens2.length; j++){//start for loop
                
                if(tokens2[j] == "true"){
                    matrixArray[i][j] = true;
                }
                else{
                    matrixArray[i][j] = false;
                }
                
                //matrixArray[i][j] = Boolean.getBoolean(tokens2[j]);
                System.out.print(matrixArray[row][j]);
                //System.out.print(tokens[i] + ", ");
            }//end for loop
            System.out.println();
            //System.out.println(strin + "\t" + len);
            row++;          //increment row counter
        }//end for
        
    }//end setGameBoard
    
    public void setGameBoard(boolean[][] oldGame){//start setGameBoard
        
        
        for(int i = 0; i < MAXROWS; i++){//start row for
            
            for(int j = 0; i < MAXCOL; j++){//start column for
                matrixArray[i][j] = oldGame[i][j];
            }//end column for
            
        }//end row for
        
    }//end setGameBoard
    
    
    public void setMatrixValue(int rowNum, int colNum, boolean newState){//start setMatrixValue
        
        matrixArray[rowNum][colNum] = newState;
        
    }//end setMatrixValue
    
    public boolean getMatrixValue(int rowNum, int colNum){//startgetMatrixValue
        
        return matrixArray[rowNum][colNum];
        
    }//end getMatrixValue
    
    public String matrixToString(){//start matrixToString
        String matStr = "";
        
        for(int i = 0; i < MAXROWS; i++){//start row for
            
            for(int j = 0; j < MAXCOL; j++){//start column for
                
                if(matrixArray[i][j] == true){//start if
                    matStr += 1 + " ";
                }//end if
                else{//start else
                    matStr += 0 + " ";
                }//end else
                
            }//end column for
            matStr += "\n";
        }//end row for
        
        return matStr;
    }//end matrixToString
    
    public void printGameBoard(){//start printGameBoard
        System.out.println(matrixToString());
    }//end printGameBoard
    
    private int countSurrounding(int a, int b) {//start countSurrounding
        int count = 0;
        int[][] surrounding = {{a - 1, b - 1},
                               {a - 1, b    },
                               {a - 1, b + 1},
                               {a    , b - 1},
                               {a    , b + 1},
                               {a + 1, b - 1},
                               {a + 1, b    },
                               {a + 1, b + 1}};
        for (int i[]: surrounding) {
            try {
                if (matrixArray[i[0]][i[1]] == true) {
                    count++;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {}
        }
        return count;
    }//end countSurrounding 
    
    public void nextGen(){//start nextGen
        boolean[][] nextBoardArray = new boolean[MAXROWS][MAXCOL];
        for(int i = 0; i < MAXROWS; i++){//start row for
            
            for(int j = 0; j < MAXCOL; j++){//start column for
                
                int neighborsStatus = 0;
                neighborsStatus = countSurrounding(i, j);
                
                if(matrixArray[i][j] == true){//start if live
                    if(neighborsStatus > 3 || neighborsStatus < 2){
                        nextBoardArray[i][j] = false;
                    }
                    else{
                        nextBoardArray[i][j] = true;
                    }
                }//end if live
                else if(matrixArray[i][j] == false){
                    if(neighborsStatus == 3){
                        nextBoardArray[i][j] = true;
                    }
                }
                
            }//end column for
        }//end row for
        
        for(int i = 0; i < MAXROWS; i++){//start row for
            
            for(int j = 0; j < MAXCOL; j++){//start column for
                
                matrixArray[i][j] = nextBoardArray[i][j];
                
            }
        }
    }//end nextGen
    
    /*
    public void checkBirths(){//start checkBirths
        for(int i = 0; i < MAXROWS; i++){//start row for
            
            for(int j = 0; j < MAXCOL; j++){//start column for
                
                if(matrixArray[i][j] == false && countSurrounding(i, j) == 3){//start if

                    matrixArray[i][j] = true;
                    
                }//end if 
                //matrixArray[i][j] = oldGame[i][j];
            }//end column for
            
        }//end row for
    }//end checkBirths
    
    public void grimReaper(){//start grimReaper
        for(int i = 0; i < MAXROWS; i++){//start row for
            
            for(int j = 0; j < MAXCOL; j++){//start column for
                
                if(matrixArray[i][j] == true && (countSurrounding(i, j) > 3 || countSurrounding(i, j) < 2)){//start if
                    
                    matrixArray[i][j] = false;
                    

                }//end if 
                //matrixArray[i][j] = oldGame[i][j];
            }//end column for
            
        }//end row for
    }//end grimReaper
    */
    
}//end GameBoard
