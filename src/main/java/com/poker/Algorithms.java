package com.poker;

class Algorithms {
    public static Hand getHand(Card[] hand, Card[] communiCards) {
        // Array with all the cards
        Card[] totalCards = new Card[hand.length + communiCards.length];
        System.arraycopy(hand, 0, totalCards, 0, hand.length);
        System.arraycopy(communiCards, 0, totalCards, hand.length, communiCards.length);
        
        int numRank = 1;
        
        for (Card card : totalCards) {
            if (card.getRank == )
            if (card.getRank() == Rank.ACE) {
                ++numRank;
            }
        }

        if (numRank == 4) {
            return Hand.QUADS;
        }
        if 
        
        return Hand.HIGH_CARD;
    }
}
