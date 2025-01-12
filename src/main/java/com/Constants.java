package com;

public class Constants {
    public static final int MAX_PLAYERS = 8;
    public static final int MIN_BUY_IN = 10;
    public static final int TOTAL_NUM_CHIPS = 6;
    public static final int[] STANDARD_BUY_IN = new int[TOTAL_NUM_CHIPS];
    
    static {
        STANDARD_BUY_IN[0] = 0;   
        STANDARD_BUY_IN[1] = 20;  
        STANDARD_BUY_IN[2] = 20; 
        STANDARD_BUY_IN[3] = 12; 
        STANDARD_BUY_IN[4] = 0;  
        STANDARD_BUY_IN[5] = 4;  
    }
}