package com.poker;

import java.util.List;
import java.util.ArrayList;

import com.Constants;


public class PokerApplication {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Deck deck = new Deck();

        players.add(new Player("David M", Constants.STANDARD_BUY_IN));
        players.add(new Player("Kavin M", Constants.STANDARD_BUY_IN));
        players.add(new Player("Kush G", Constants.STANDARD_BUY_IN));
        players.add(new Player("Krish A", Constants.STANDARD_BUY_IN));

        Table table = new Table(players, deck);

        table.addPlayer(new Player("Sheryl J", Constants.STANDARD_BUY_IN));
        table.dealCards();
        
        for (Player player : table.getPlayers()) {
            System.out.println(player.toString());
            Card[] cards = player.getHand();
            System.out.println(cards[0] + " | " + cards[1]);
        }

        System.out.println("************************************************");
        System.out.println(table.getPot());
        System.out.println("************************************************");

        int[] bet = { 1, 1, 1, 1, 1, 1 };

        for (Player player : table.getPlayers()) {
            player.getHand();
            table.takeBet(player, bet);
            System.out.println(player.toString());
        }

        System.out.println("************************************************");
        System.out.println(table.getPot());
        System.out.println("************************************************");

        table.givePool(table.getCurrPlayer());

        System.out.println("************************************************");
        System.out.println(table.getPot());
        System.out.println("************************************************");

        for (Player player : table.getPlayers()) {
            System.out.println(player.toString());
        }

        table.resetTable();

    }
}