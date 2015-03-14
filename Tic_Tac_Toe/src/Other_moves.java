
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
public class Other_moves {
    
    move [][] board = null;
    private int turn=0;
   // Random rand = new Random();
    private int player =0;
    private int player2=0;
    
    
    Other_moves(move [][] board, int turn, int player){
        this.board = board;
        this.turn = turn;
        this.player = player;
        if(player%2==0){
            player2=1;
        } else {
            player2=2;
        }
    }
    
    move [][] algo(move[][]board, int turn, int player, int player2 ){
        int b=0;
        if(turn==9){
            return board;
        } else {
            maxVal(board,turn,player, player2);
        }
        return board;
        
    }
    
    int maxVal(move [][] board, int turn, int player, int player2){
        int score = Integer.MIN_VALUE/90;
        if(turn==10){
            return 0;
        }else if(winner(board,player2)){//looking for wrost case
                    return (turn-10)-2;
        }/*else if(forkcheck(board, player2)){
            return turn-10;         
        }else if(forkcheck(board, player)){
            return 10-turn;
        }*/
        turn++;
        for(int i = 0; i< board.length;i++){
            for(int j = 0; j<board.length;j++){
                 if(board[i][j].taken_by==0){
                    board[i][j].taken_by = player;
                    score = Math.max(score, minVal(board,turn, getPlayer2(), getPlayer()));
                    if(board[i][j].aiValue<score&&score!=Integer.MAX_VALUE/90&&score!=Integer.MIN_VALUE/90){
                        board[i][j].aiValue = score;
                    }
                    board[i][j].taken_by = 0;
                    score = Integer.MIN_VALUE/90;//this resets the score so it isn't the same a
                }
                
            }
        }
        if(score!=Integer.MAX_VALUE/90&&score!=Integer.MIN_VALUE/90){
            return score;
        } else {
            return 0;
        }
        
        
    }
    
    int minVal(move [][] board, int turn, int player, int player2){
        int score = Integer.MAX_VALUE/90;
        if(turn==10){
            return 0;
        } else if(winner(board,player2)){//actually looking for best value for computer
            return (10-turn)+2;
        }/*else if(forkcheck(board, player2)){
            return 10-turn;         
        } else if(forkcheck(board, player)){
            return turn-10;
        }*/
         turn++;
        for(int i = 0; i< board.length;i++){
            for(int j = 0; j<board.length;j++){
                if(board[i][j].taken_by==0){
                    board[i][j].taken_by = player;
                    score = Math.min(score, maxVal(board,turn, getPlayer(), getPlayer2()));
                    if(board[i][j].playerValue>score&&score!=Integer.MAX_VALUE/90&&score!=Integer.MIN_VALUE/90){//deal with winner scores. Overwriting correct scores
                        board[i][j].playerValue = score;
                    }
                    board[i][j].taken_by = 0;
                    score = Integer.MAX_VALUE/90;
                }
            }
        }
        if(score!=Integer.MAX_VALUE/90&&score!=Integer.MIN_VALUE/90){
            return score;
        } else {
            return 0;
        }
        
    }
    
    private boolean forkcheck(move[][]board, int player){
        for(int i = 0; i< board.length;i++){
            for(int j = 0; j<board.length;j++){
                if(board[i][j].taken_by==0){
                    board[i][j].taken_by=player;
                    if(fork(board,player)){
                        board[i][j].taken_by=0;
                        return true;   
                    }                 
                    board[i][j].taken_by=0;
                }
            }
        }
        return false;
    }
    
    private boolean fork(move[][]board, int player){//need to prioritze x vs o. fork needs to be consise. Mixes up x & o
        int count = 0;
        for(int i = 0; i< board.length;i++){
            for(int j = 0; j<board.length;j++){
                if(board[i][j].taken_by==0){
                    board[i][j].taken_by=player;
                    if(winner(board,player)){
                        count++;                       
                    }
                    board[i][j].taken_by=0;
                }            
            }
        }
        if(count>=2){
            return true;
        } else {
            return false; 
        }
    }
    
 /*   void first_move(){
        if(getTurn()%2==1){
            corner_move();           
        } else {
            if(board[0][0].taken_by!=0||board[0][2].taken_by!=0||board[2][0].taken_by!=0||board[2][2].taken_by!=0){
                board[1][1].taken_by=getPlayer();
            } else if(board[1][1].taken_by!=0){
                corner_move();
            } else {
                int corner = rand.nextInt(3)+1;
                if(corner%2==1){
                    board[1][1].taken_by=getPlayer();
                } else {
                    corner_move();
                }
            }
        }
    }*/
    
   /* private void corner_move(){
        int corner = rand.nextInt(3)+1;
            switch(corner){
                case 1: board[0][0].taken_by = getPlayer();
                    break;
                case 2: board[0][2].taken_by = getPlayer();
                    break;
                case 3: board[2][0].taken_by = getPlayer();
                    break;
                case 4: board[2][2].taken_by = getPlayer();
                    break;
                default: System.out.println("Invalid move");
                        }
    }*/
    
    
    
    private boolean winner(move[][] board, int player){
        int three_in_row = 0;
        for(int i = 0; i<=2;i++){
            for(int j = 0; j<=2;j++){
                if(board[i][j].taken_by==player){
                    three_in_row++;
                } else {
                    break;
                }
            }
            if(three_in_row==3){
                return true;
            } else {
                three_in_row=0;
            }
        }
        for(int i = 0; i<=2;i++){
            for(int j = 0; j<=2;j++){
                if(board[j][i].taken_by==player){
                    three_in_row++;
                } else {
                    break;
                }
            }
            if(three_in_row==3){
                return true;
            } else {
                three_in_row=0;
            }
        }
        if((board[0][0].taken_by==board[1][1].taken_by&&board[1][1].taken_by==board[2][2].taken_by&&player==board[1][1].taken_by)||(board[0][2].taken_by==board[1][1].taken_by&&board[1][1].taken_by==board[2][0].taken_by&&player==board[1][1].taken_by)){
            return true;
        }
        return false;
    }

    /**
     * @return the turn
     */
    public int getTurn() {
        return turn;
    }

    /**
     * @param turn the turn to set
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }

    /**
     * @return the player
     */
    public int getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(int player) {
        this.player = player;
    }

    /**
     * @return the player2
     */
    public int getPlayer2() {
        return player2;
    }

    /**
     * @param player2 the player2 to set
     */
    public void setPlayer2(int player2) {
        this.player2 = player2;
    }
    
    
    
}
