package com.poker;

import com.Constants;

public class Table {
    private final Player mainPot;
    private final Deck deck;
    private GameState gameState;
    private RoleManager roleManager;
    private Card[] communityCards;

    public Table() {
        this.mainPot = new Player(Constants.MAIN_POT_NAME, -1, Constants.POT_BUY_IN);
        this.deck = new Deck();
        this.gameState = GameState.getInstance();
        this.roleManager = new RoleManager();
        this.communityCards = new Card[5];
    }

    public void takeBet(Player player, int[] amount) {
        player.removeChips(amount);
        mainPot.addChips(amount);
    }

    public void givePool(Player player) {
        player.addChips(mainPot.removeAllChips());
    }

    public void resetTable() {
        gameState.reset();
        deck.shuffleCards();
    }

    public Hand getHand(Player player) {
        return Algorithms.getHand(player.getHand(), communityCards);
    }

    public void dealPlayerCards() {
        for (Player player : gameState.getAllPlayers()) {
            player.dealIn(deck.dealCard(), deck.dealCard());
        }
    }

    public void dealCommunityCard(String turn) {
        deck.dealCard();
        switch (turn) {
            case "FLOP":
                for (int i = 0; i < 3; ++i) {
                    communityCards[i] = deck.dealCard();
                }
                break;
            case "TURN":
                communityCards[3] = deck.dealCard();
                break;
            case "RIVER":
                communityCards[4] = deck.dealCard();
                break;
            default:
                break;
        }
    }

    public Card[] getCommunityCards() {
        return this.communityCards;
    }
    
    public RoleManager getRoleManager() {
        return this.roleManager;
    }

    public String getPot() {
        return mainPot.toString();
    }
}