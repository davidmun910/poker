package com.poker;

public class PokerApplication {
    public static void main(String[] args) {
        Deck deck = new Deck();
        for (Card card : deck.getCards()) {
            System.out.println(card.toString());
        }

        System.out.println("-------------------------------");

        for (int i = 0; i < 5; ++i) {
            System.out.println(deck.dealCard().toString());
        }

        System.out.println("-------------------------------");

        for (Card card : deck.getUsedCards()) {
            System.out.println(card.toString());
        }
    }
}