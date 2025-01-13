package com.poker;

import java.util.ArrayList;
import java.util.List;

import com.Constants;

public class GameState {
    private static GameState instance;
    private final List<Player> players;
    private int numPlayers;
    private int buttonIndex;

    private GameState() {
        this.players = new ArrayList<>();
        this.numPlayers = 0;
        this.buttonIndex = 0;
    }

    public static synchronized GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int addPlayer(Player player) {
        if (numPlayers >= Constants.MAX_PLAYERS)
            return -1;

        players.add(player);
        ++numPlayers;

        return numPlayers;
    }

    public int removePlayer(Player player) {
        if (numPlayers <= 1)
            return -1;

        players.remove(player);
        --numPlayers;

        return numPlayers;
    }

    public int getButtonIndex() {
        return buttonIndex;
    }

    public void setButtonIndex(int buttonIndex) {
        this.buttonIndex = buttonIndex % players.size();
    }
}