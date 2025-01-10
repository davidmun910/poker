package com.poker;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final List<Card> cards;
    private final List<Card> usedCards;

    public Deck() {
        this.cards = new ArrayList<>();
        this.usedCards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(rank, suit));
            }
        }

        this.shuffleCards();
    }

    public void shuffleCards() {
        Collections.shuffle(this.cards);
    }

    public Card dealCard() {
        Card top = cards.remove(0);
        usedCards.add(top);
        return top;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public List<Card> getUsedCards() {
        return this.usedCards;
    }
}
