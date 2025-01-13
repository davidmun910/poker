package com.poker;

import java.util.List;

public class RoleManager {
    private GameState gameState;

    public RoleManager() {
        this.gameState = GameState.getInstance();
    }

    public void assignRoles() {
        List<Player> players = gameState.getPlayers();
        int buttonIndex = gameState.getButtonIndex();
        int numPlayers = players.size();

        for (int i = 0; i < numPlayers; i++) {
            int position = (buttonIndex + i) % numPlayers;

            Player currentPlayer = players.get(position);

            if (i == 0) {
                currentPlayer.setRole(Role.BUTTON);
            } else if (i == 1) {
                currentPlayer.setRole(Role.SMALL_BLIND);
            } else if (i == 2) {
                currentPlayer.setRole(Role.BIG_BLIND);
            } else {
                currentPlayer.setRole(Role.DEFAULT);
            }
        }
    }

    public void rotateButton() {
        int newButtonIndex = gameState.getButtonIndex() + 1;
        gameState.setButtonIndex(newButtonIndex);
    }
}