package com.poker;

import java.util.EnumMap;
import java.util.List;
import java.util.ArrayList;

import com.Constants;

public class Table {
    private int numPlayers;
    private final List<Player> players;
    private final EnumMap<Chip, Integer> pot; 

    public Table() {
        numPlayers = 0;
        players = new ArrayList<>(); 
        pot = new EnumMap<>(Chip.class);

        for (Chip chip : Chip.values()) {
            pot.put(chip, 0);
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
}