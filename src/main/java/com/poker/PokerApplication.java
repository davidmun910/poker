package com.poker;

public class PokerApplication {
    public static void main(String[] args) {
        Table table = new Table();
        GameState gameState = GameState.getInstance();

        gameState.addPlayer(new Player("Alice", new int[]{10, 5, 2, 1, 0, 0}));
        gameState.addPlayer(new Player("Bob", new int[]{10, 5, 2, 1, 0, 0}));
        gameState.addPlayer(new Player("Charlie", new int[]{10, 5, 2, 1, 0, 0}));
        gameState.addPlayer(new Player("Diana", new int[]{10, 5, 2, 1, 0, 0}));

        for (int round = 1; round <= 3; round++) {
            System.out.println("Round " + round);
            table.getRoleManager().assignRoles();
            table.dealCards();
            for (Player player : gameState.getPlayers()) {
                if (player.getRole() == Role.BIG_BLIND) {
                    table.takeBet(player, new int[] { 2, 0, 0, 0, 0, 0 });
                    continue;
                }
                if (player.getRole() == Role.SMALL_BLIND) {
                    table.takeBet(player, new int[] { 1, 0, 0, 0, 0, 0 });
                    continue;
                }

                table.takeBet(player, new int[] { 2, 0, 0, 0, 0, 0 });
            }
            
            System.out.println(table.getPot());
            System.out.println();
            gameState.getPlayers().forEach(System.out::println);
            table.getRoleManager().rotateButton();
            System.out.println();
            table.givePool(gameState.getPlayers().get(0));
            gameState.getPlayers().forEach(System.out::println);
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}