package com.poker;

public enum Chip {
    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY_FIVE(25),
    FIFTY(50),
    HUNDRED(100);

    private final int value;

    Chip(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static int getNumChips() {
        return 6;
    }
    
    @Override
    public String toString() {
        return "$" + value;
    }
}
