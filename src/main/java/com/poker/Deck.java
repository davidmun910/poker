package com.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;
    private int idx;

    public Deck() {
        this.cards = new ArrayList<>();
        this.idx = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(rank, suit));
            }
        }

        this.shuffleCards();
    }

    public void shuffleCards() {
        Collections.shuffle(this.cards);
        this.idx = 0;
    }

    public Card dealCard() {
        if (idx >= cards.size()) 
            throw new IllegalStateException("No cards left in the deck");
        return this.cards.get(idx++);
    }

    public List<Card> getCards() {
        return this.cards;
    }
}
