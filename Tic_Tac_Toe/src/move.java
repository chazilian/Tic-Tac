/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author stevefoo
 */
public class move {
    
    int value = 0;
    int aiValue = 0;
    int playerValue = 0;
    int taken_by = 0;
    int row = 0;
    int column = 0;
    
    move(int taken_by ,int row, int column){
        this.taken_by = taken_by;
        this.row = row;
        this.column = column;
    }
    
    public void reset(){
        aiValue = 0;
        playerValue = 0;
    }
    
}
