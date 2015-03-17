
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
public class Main {
    
    public static void main(String [] args){
        
        Scanner in = new Scanner(System.in);
        String name = null;
        boolean winner = false;
        String first = null;
        int player = 2;//o
        int computer = 1;//x
        int turn =1;
        String move = null;
        
        move [][] board = new move[3][3];
        for(int i = 0; i<=2;i++){
            for(int j = 0; j<=2;j++){
                    board[i][j] = new move(0,i,j);
            }
        }
        turn = 0;
         Other_moves play = new Other_moves(board,turn,computer);
         play.setPlayer(computer);
         play.setPlayer2(player);
         play.algo(board, turn, computer, player);
         printBoard(board);
        //works for finding next move, but fucks up when it comes to blocking player moves.
        
        
    }
        
      /*  System.out.println("Welcome to the game of Tic-Tac-Toe.\nWhat is your name?");
        name = in.next();
        do{
            do{
            System.out.println("Do you want to go first?(Y/N)");
            first = in.next();
            if(first.toLowerCase().equals("y")){
                player =1;
                computer =2;
            } else if(first.toLowerCase().equals("n")){
                player = 2;
                computer = 1;
            }
            }while(player==0&&computer==0);
            move [][] board = new move[3][3];
            for(int i = 0; i<=2;i++){
                for(int j = 0; j<=2;j++){
                    board[i][j] = new move(0,0);
                }
            }
            do{//how to calculate cats game. Going to happen on turn 9
                printBoard(board);
                if(first.toLowerCase().equals("y")){
                    turn++;
                    System.out.println("Select a row and column in this way: (row column)");
                    move=in.next();
                    //player moves. Make sure to check if player plays on top of previous move
                    if (turn==9){
                        break;
                    }
                    Other_moves play = new Other_moves(board,turn,computer);
                    turn++;
                    if(turn<2){
                        play.first_move();
                    } else {
                        //recursive moves
                    }
                } else {
                    turn++;
                     Other_moves play = new Other_moves(board,turn,computer);
                    if(turn<2){
                        play.first_move();
                    } else {
                        //recursive moves
                    }
                    if (turn==9){
                        break;
                    }
                    turn++;
                    System.out.println("Select a row and column in this way: (row column)");
                    move=in.next();
                    //player moves. Make sure to check if player plays on top of previous move
                }
            }while(!winner || turn ==9);
            
            
            
            
        }while(!winner);
    }*/
    
    private static void printBoard(move[][]board){
        
        System.out.println("    1   2   3 ");
        
        for(int i = 0; i<=2;i++){
            System.out.print((i+1)+"  ");
            for(int j = 0; j<=2;j++){
                if(board[i][j].taken_by==1){
                    System.out.print(" X"+board[i][j].value);
                } else if (board[i][j].taken_by==2){
                    System.out.print(" O"+board[i][j].value);
                } else {
                    if(board[i][j].aiValue>Math.abs(board[i][j].playerValue)){
                        System.out.print(" "+board[i][j].aiValue);
                    }else{
                        System.out.print(" "+board[i][j].playerValue);
                    }
                }
                if(j!=2){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i!=2){
                System.out.println("   -----------");
            }
        }
        
    }
    
}
