package com.poker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.Constants;

public class GameState {
    private static GameState instance;
    private final List<Player> players;
    private final Queue<Integer> ids;
    private int numPlayers;
    private int buttonIndex;

    private GameState() {
        this.players = new ArrayList<>();
        this.ids = new LinkedList<>();
        this.numPlayers = 0;
        this.buttonIndex = 0;

        for (int i = 0; i < Constants.MAX_PLAYERS; ++i) {
            ids.add(i);
        }
    }

    public static synchronized GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public int addPlayer(String name, int[] buyIn) {
        if (numPlayers >= Constants.MAX_PLAYERS)
            return -1;
        
        players.add(new Player(name, (ids.poll()), buyIn));
        ++numPlayers;

        return numPlayers;
    } 

    public int removePlayer(Player player) {
        if (!players.contains(player)) {
            System.out.println("removePlayer: Player doesn't exist");
            return -1;
        }

        if (numPlayers <= 1) {
            System.out.println("removePlayer: Not enough players");
            return -1;
        }

        players.remove(player);
        if (!ids.offer(player.getId()))
            System.out.println("Ids is already full");

        --numPlayers;

        return numPlayers;
    }

    public void fold(Player player) {
        if (!players.contains(player)) {
            System.out.println("playerFold: Player doesn't exist");
            return;
        }
        
        player.setIsFolded(true);
    }

    public void reset() {
        for (Player player : this.players) {
            player.setIsFolded(false);
        }
    }

    public List<Player> getAllPlayers() {
        return players;
    }

    public List<Player> getActivePlayers() {
        List<Player> activePlayers = new ArrayList<>();
        for (Player player : this.players) {
            if (!player.getIsFolded())
                activePlayers.add(player);
        }

        return activePlayers;
    }

    public List<Player> getFoldedPlayers() {
        List<Player> foldedPlayers = new ArrayList<>();
        for (Player player : this.players) {
            if (player.getIsFolded())
                foldedPlayers.add(player);
        }

        return foldedPlayers;
    }

    public Player getPlayerById(int id) {
        for (Player player : this.players) {
            if (player.getId() == id)
                return player;
        }

        return null;
    }

    public int getButtonIndex() {
        return buttonIndex;
    }

    public void setButtonIndex(int buttonIndex) {
        this.buttonIndex = buttonIndex % players.size();
    }
}