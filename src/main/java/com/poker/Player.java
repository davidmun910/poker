package com.poker;

import java.util.EnumMap;

import com.Constants;

public class Player {
    private final String name;
    private Card[] hand;
    private final EnumMap<Chip, Integer> chips;

    public Player(String name, int[] buyIn) {
        this.name = name;
        this.hand = new Card[2];
        this.chips = new EnumMap<>(Chip.class);
        
        for (Chip chip : Chip.values()) {
            chips.put(chip, 0);
        }
        this.addChips(buyIn);
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

    public int[] removeAllChips() {
        int[] total = new int[Constants.TOTAL_NUM_CHIPS];
        int idx = 0;

        for (Chip chip : chips.keySet()) {
            total[idx] = chips.get(chip);
            chips.remove(chip);
            ++idx;
        }

        return total;
    }

    public int getTotal() {
        int total = 0;
        for (Chip chip : chips.keySet()) {
            total += chip.getValue() * chips.get(chip);
        }

        return total;
    }

    public Card[] getHand() {
        return this.hand;
    }

    @Override
    public String toString() {
        return this.name + ": $" + getTotal(); 
    }
}