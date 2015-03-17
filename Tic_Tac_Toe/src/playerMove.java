
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author stevefoo
 */
public class playerMove {
    int player = 0;
    move[][]board = null;
    Scanner in = new Scanner(new InputStreamReader(System.in));
    int row = -1;
    int column = -1;
    
    
    playerMove(move [][] board, int player){
        this.board = board;
        this.player = player;
    }
    
    public move[][] start(){
        try{
        do{
        System.out.println("Please select a row (1-3)");
        row=in.nextInt();
        System.out.println("Please select a column (1-3)");
        column=in.nextInt();
        }while(validMove(row,column));
        board[row][column].taken_by=player;
        board[row][column].reset();
        System.out.println("...Computer's turn...");
        return board;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    private boolean validMove(int row, int column){
        if(1<=row&&3>=row&&1<=column&&3>=column){
            if(board[row][column].taken_by==0){
                return true;
            }
        }
        return false;
    }
    
    
    
}
