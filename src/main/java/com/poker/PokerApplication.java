package com.poker;

// import com.Constants;

public class PokerApplication {
    public static void main(String[] args) {
        int numPlayers = 4;
        int[][] buyIns = new int[numPlayers][Chip.getNumChips()];
        String[] names = new String[numPlayers];

        for (int i = 0; i < numPlayers; ++i) {
            names[i] = "Kush Gohil";
            for (int j = 0; j < Chip.getNumChips(); ++j) {
                buyIns[i][j] = 5;
            }
        }

        Deck deck = new Deck();  
        Table table = new Table(numPlayers, names, buyIns);

        table.getCurrPlayer().dealIn(deck.dealCard(), deck.dealCard());
        System.out.println(table.getCurrPlayer().getHand());        
    }
}