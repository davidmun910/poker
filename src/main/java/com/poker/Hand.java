package com.poker;

public enum Hand {
    HIGH_CARD(0),
    PAIR(1),
    TWO_PAIR(2),
    TRIPS(3),
    STRAIGHT(4),
    FLUSH(5),
    FULL_HOUSE(6),
    QUADS(7),
    STRAIGHT_FLUSH(8),
    ROYAL_FLUSH(9);

    private final int strength;

    Hand(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return this.strength;
    }
}