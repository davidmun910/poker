package com.poker;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.Constants;

public class Table {
    private int numPlayers;
    private int currPlayerIdx;
    private final List<Player> players;
    private final Player mainPot;
    private final Deck deck; 

    public Table(List<Player> players, Deck deck) {
        this.numPlayers = players.size();
        this.currPlayerIdx = ThreadLocalRandom.current().nextInt(0, numPlayers);
        this.players = players;
        this.mainPot = new Player(Constants.MAIN_POT_NAME, Constants.POT_BUY_IN);
        this.deck = deck;
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
        for (Player player : players) {
            player.dealIn(deck.dealCard(), deck.dealCard());
        }
    }

    public int addPlayer(Player player) {
        if (numPlayers >= Constants.MAX_PLAYERS)
            return -1;

        ++numPlayers;
        players.add(player);

        return numPlayers;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Player getCurrPlayer() {
        return players.get(currPlayerIdx);
    }
    
    public void moveToNextPlayer() {
        currPlayerIdx = (currPlayerIdx + 1) % numPlayers;
    }

    public String getPot() {
        return mainPot.toString();
    }
}