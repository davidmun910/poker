package com.poker;

public enum Rank {
    ACE('A', 14),
    KING('K', 13),
    QUEEN('Q', 12),
    JACK('J', 11),
    TEN('T', 10),
    NINE('9', 9),
    EIGHT('8', 8),
    SEVEN('7', 7),
    SIX('6', 6),
    FIVE('5', 5),
    FOUR('4', 4),
    THREE('3', 3),
    TWO('2', 2);
    
    private final char symbol;
    private final int val;

    Rank(char symbol, int val) {
        this.symbol = symbol;
        this.val = val;
    }
    
    public char getSymbol() {
        return this.symbol;
    }

    public int getValue() {
        return this.val;
    }
}
