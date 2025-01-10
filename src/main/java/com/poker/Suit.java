package com.poker;

public enum Suit {
    HEARTS('H'),
    DIAMONDS('D'),
    SPADES('S'),
    CLUBS('C');

    private final char symbol;

    Suit(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }
}
