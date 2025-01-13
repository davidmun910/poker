package com.poker;

import com.Constants;

public class Table {
    private final Player mainPot;
    private final Deck deck;
    private GameState gameState;
    private RoleManager roleManager;

    public Table() {
        this.mainPot = new Player(Constants.MAIN_POT_NAME, Constants.POT_BUY_IN);
        this.deck = new Deck();
        this.gameState = GameState.getInstance();
        this.roleManager = new RoleManager();
    }

    public void takeBet(Player player, int[] amount) {
        player.removeChips(amount);
        mainPot.addChips(amount);
    }

    public void givePool(Player player) {
        player.addChips(mainPot.removeAllChips());
    }

    public void resetTable() {
        deck.resetCards();
    }

    public void dealCards() {
        for (Player player : gameState.getPlayers()) {
            player.dealIn(deck.dealCard(), deck.dealCard());
        }
    }

    public RoleManager getRoleManager() {
        return this.roleManager;
    }

    public String getPot() {
        return mainPot.toString();
    }
}