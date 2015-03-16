
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author stevefoo
 */
public class makeMove {
    
    move[][] board = null;
    int player = 0;
    ArrayList<move> boardMoves = new ArrayList<>();
    
    makeMove(move[][]board, int player){
        this.board = board;
        this.player = player;
        int highestVal = 0;
        int playVal= 0;
        for(int i = 0; i<board.length;i++){
            for(int k = 0; k<board.length;k++){
                if(board[i][k].taken_by==0){
                    playVal = Math.abs(board[i][k].playerValue);
                    if(highestVal<board[i][k].aiValue){
                        highestVal = board[i][k].aiValue;
                        boardMoves.clear();
                        boardMoves.add(board[i][k]);
                        
                    } else if (highestVal<playVal){
                        highestVal = playVal;
                        boardMoves.clear();
                        boardMoves.add(board[i][k]);
                    } else if(highestVal==playVal){
                        boardMoves.add(board[i][k]);
                    } else if(highestVal==board[i][k].aiValue){
                        boardMoves.add(board[i][k]);
                    }
                }
            }
        }
    }
    
    public move[][] bestMove(){
        if(boardMoves.size()==1){
            board[boardMoves.get(0).row][boardMoves.get(0).column].taken_by=player;
            return board;
            //board[keyval/10][keyval%10] = boardMoves.get move value
        } else {
            //go through the values and check to see if they are corner or center movesONLY WORK WITH FIRST 4 turns
            //use RNG to determine which move to go to if there are more than 1 favored.
            //prioritize positives over negatives
            return board;
            
        }
    }
    
    
    
}
