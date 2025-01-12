package com.poker;

import java.util.List;
import java.util.ArrayList;

import com.Constants;


public class PokerApplication {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        players.add(new Player("David M.", Constants.STANDARD_BUY_IN));
        players.add(new Player("Kavin M.", Constants.STANDARD_BUY_IN));
        players.add(new Player("Kush G.", Constants.STANDARD_BUY_IN));
        players.add(new Player("Krish A.", Constants.STANDARD_BUY_IN));

        Deck deck = new Deck();  
        Table table = new Table(players);
        
        for (Player player : table.getPlayers()) {
            player.dealIn(deck.dealCard(), deck.dealCard());
            System.out.println(player.toString() + " " + player.getHand());
        }
    }
}