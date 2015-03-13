
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
public class First_two_moves {
    
    move [][] board = null;
    int turn;
    Random rand = new Random();
    
    
    First_two_moves(move [][] board, int turn){
        this.board = board;
        this.turn = turn;
    }
    
    void first_move(){
        if(turn%2==1){
            corner_move();           
        } else {
            if(board[0][0].taken_by!=0||board[0][2].taken_by!=0||board[2][0].taken_by!=0||board[2][2].taken_by!=0){
                board[1][1].taken_by="x";
            } else if(board[1][1].taken_by!=0){
                corner_move();
            } else {
                int corner = rand.nextInt(3)+1;
                if(corner%2==1){
                    board[1][1].taken_by="x";
                } else {
                    corner_move();
                }
            }
        }
    }
    
    void corner_move(){
        int corner = rand.nextInt(3)+1;
            switch(corner){
                case 1: board[0][0].taken_by = "x";
                    break;
                case 2: board[0][2].taken_by = "x";
                    break;
                case 3: board[2][0].taken_by = "x";
                    break;
                case 4: board[2][2].taken_by = "x";
                    break;
                default: System.out.println("Invalid move");
                        }
    }
    
    
    
    
    
}
