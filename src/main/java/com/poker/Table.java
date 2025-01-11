package com.poker;

import java.util.EnumMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

import com.Constants;

public class Table {
    private int numPlayers;
    private int currPlayerIdx;
    private final List<Player> players;
    private final EnumMap<Chip, Integer> pot; 

    public Table(int numPlayers, String[] names, int[][] buyIn) {
        this.numPlayers = numPlayers;
        currPlayerIdx = ThreadLocalRandom.current().nextInt(0, numPlayers);
        players = new ArrayList<>(); 
        pot = new EnumMap<>(Chip.class);

        for (Chip chip : Chip.values()) {
            pot.put(chip, 0);
        }

        for (int i = 0; i < numPlayers; ++i) {
            Player player = new Player(names[i]);
            player.addChips(buyIn[i]);
            System.out.println(player.toString());
            players.add(player);
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

    public void moveToNextPlayer() {
        currPlayerIdx = (currPlayerIdx + 1) % numPlayers;
    }

    public Player getCurrPlayer() {
        return players.get(currPlayerIdx);
    }
}