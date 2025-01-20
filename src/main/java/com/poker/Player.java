package com.poker;

import java.util.EnumMap;

import com.Constants;

public class Player {
    private final String name;
    private Role role;
    private int id;
    private final Card[] hand;
    private final EnumMap<Chip, Integer> chips;
    private boolean isFolded;

    public Player(String name, int id, int[] buyIn) {
        this.name = name;
        this.id = id;
        this.hand = new Card[2];
        this.chips = new EnumMap<>(Chip.class);
        this.isFolded = false;

        for (Chip chip : Chip.values()) {
            chips.put(chip, 0);
        }
        this.addChips(buyIn);
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean getIsFolded() {
        return this.isFolded;
    }

    public void setIsFolded(boolean isFolded) {
        this.isFolded = isFolded;
    }

    public void dealIn(Card cardOne, Card cardTwo) {
        hand[0] = cardOne;
        hand[1] = cardTwo;
    }

    public void addChips(int[] amount) {
        for (Chip chip : Chip.values()) {
            chips.putIfAbsent(chip, 0);
            chips.put(chip, chips.get(chip) + amount[chip.ordinal()]);
        }
    }

    public void removeChips(int[] amount) {
        for (Chip chip : Chip.values()) {
            chips.putIfAbsent(chip, 0);
            chips.put(chip, chips.get(chip) - amount[chip.ordinal()]);
        }
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
        Card[] card = getHand();
        return this.name + ": $" + getTotal() + " | " + getRole() + " | " + getId() + " | " + card[0] + " + " + card[1];
    }
}