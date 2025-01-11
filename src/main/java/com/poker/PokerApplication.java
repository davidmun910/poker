package com.poker;

public class PokerApplication {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Table table = new Table();

        for (int i = 0; i < 5; ++i) {
            Player player = new Player();
            table.addPlayer(player);
        }
    }
}