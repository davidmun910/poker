package com.poker;

import java.util.EnumMap;

public class Player {
    private Card[] hand;
    private final EnumMap<Chip, Integer> chips;

    public Player() {
        this.chips = new EnumMap<>(Chip.class);

        for (Chip chip : Chip.values()) {
            chips.put(chip, 0);
        }
    }

    public void dealIn(Card cardOne, Card cardTwo) {
        hand[0] = cardOne;
        hand[1] = cardTwo;
    }

    public void addChips(int[] amount) {
        chips.put(Chip.ONE, chips.get(Chip.ONE) + amount[0]);
        chips.put(Chip.FIVE, chips.get(Chip.FIVE) + amount[1]);
        chips.put(Chip.TEN, chips.get(Chip.TEN) + amount[2]);
        chips.put(Chip.TWENTY_FIVE, chips.get(Chip.TWENTY_FIVE) + amount[3]);
        chips.put(Chip.FIFTY, chips.get(Chip.FIFTY) + amount[4]);
        chips.put(Chip.HUNDRED, chips.get(Chip.HUNDRED) + amount[5]);
    }

    public void removeChips(int[] amount) {
        chips.put(Chip.ONE, chips.get(Chip.ONE) - amount[0]);
        chips.put(Chip.FIVE, chips.get(Chip.FIVE) - amount[1]);
        chips.put(Chip.TEN, chips.get(Chip.TEN) - amount[2]);
        chips.put(Chip.TWENTY_FIVE, chips.get(Chip.TWENTY_FIVE) - amount[3]);
        chips.put(Chip.FIFTY, chips.get(Chip.FIFTY) - amount[4]);
        chips.put(Chip.HUNDRED, chips.get(Chip.HUNDRED) - amount[5]);
    }
}