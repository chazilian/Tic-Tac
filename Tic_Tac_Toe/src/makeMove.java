
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
    int turn = 0;
    move[][] board = null;
    int player = 0;
    ArrayList<move> boardMoves = new ArrayList<>();
    Random rand = new Random();
    
    makeMove(move[][]board, int player, int turn){
        this.turn = turn;
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
        int val=-99;
        ArrayList<move> favoredList = new ArrayList<>();
        if(boardMoves.size()==1){
            board[boardMoves.get(0).row][boardMoves.get(0).column].taken_by=player;
            board[boardMoves.get(0).row][boardMoves.get(0).column].reset();
            return board;
            //board[keyval/10][keyval%10] = boardMoves.get move value
        } else {
            ArrayList<move>corners=new ArrayList<>();
            if(turn<=5){
                for(move m:boardMoves){
                    if(m.row%2==0&&m.column%2==0){//will check if move is 4 corners
                        corners.add(m);
                    } else if(m.row==1&&m.column==1){//check the middle
                        board[1][1].taken_by=player;
                        board[1][1].reset();
                        return board;                       
                    }                   
                }
                if(!corners.isEmpty()){
                    for(move m:boardMoves){
                        if(val<m.value){
                            favoredList.clear();
                            favoredList.add(m);
                        } else if (val==m.value){
                            favoredList.add(m);
                        }                   
                    }
                    int c = rand.nextInt(favoredList.size());
                     board[boardMoves.get(c).row][boardMoves.get(c).column].taken_by=player;
                     board[boardMoves.get(c).row][boardMoves.get(c).column].reset();
                     return board;
                }
                
            } //no corners/mid left or past five turns
            for (move m : boardMoves) {
                if (val < m.value) {
                    favoredList.clear();
                    favoredList.add(m);
                } else if (val == m.value) {
                    favoredList.add(m);
                }
            }
            int r = rand.nextInt(favoredList.size());
            board[boardMoves.get(r).row][boardMoves.get(r).column].taken_by=player;
            board[boardMoves.get(r).row][boardMoves.get(r).column].reset();
            return board;
            }
            
            //go through the values and check to see if they are corner or center movesONLY WORK WITH FIRST 4 turns
            //use RNG to determine which move to go to if there are more than 1 favored.
            //prioritize positives over negatives
            
        
    }
    
    
    
}
