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
    int playerValue = 100;
    int taken_by = 0;
    
    move(int taken_by, int value){
        this.value = value;
        this.taken_by = taken_by;
    }
    
}
