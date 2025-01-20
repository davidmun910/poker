package com.poker;

public class PokerApplication {
    public static void main(String[] args) {
        Table table = new Table();
        GameState gameState = GameState.getInstance();

        gameState.addPlayer("Alice", new int[]{10, 5, 2, 1, 0, 1});
        gameState.addPlayer("Bob", new int[]{10, 5, 2, 1, 0, 1});
        gameState.addPlayer("Charlie", new int[]{10, 5, 2, 1, 0, 1});
        gameState.addPlayer("Diana", new int[]{10, 5, 2, 1, 0, 1});

        for (int round = 1; round <= 3; round++) {
            System.out.println("Round " + round);
            table.getRoleManager().assignRoles();
            table.dealCards();
            for (Player player : gameState.getAllPlayers()) {
                if (player.getRole() == Role.BIG_BLIND) {
                    table.takeBet(player, new int[] { 2, 1, 0, 1, 0, 1 });
                    continue;
                }
                if (player.getRole() == Role.SMALL_BLIND) {
                    gameState.fold(player);
                    continue;
                }

                table.takeBet(player, new int[] { 2, 0, 0, 0, 0, 0 });
            }
            
            System.out.println(table.getPot());
            System.out.println();
            gameState.getActivePlayers().forEach(System.out::println);
            table.getRoleManager().rotateButton();
            System.out.println();
            table.givePool(gameState.getPlayerById(0));
            gameState.getActivePlayers().forEach(System.out::println);
            System.out.println();
            System.out.println(table.getPot());
            System.out.println();
            System.out.println();
            System.out.println();
            gameState.reset();
        }
    }
}