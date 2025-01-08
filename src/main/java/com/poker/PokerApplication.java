package com.poker;

public class PokerApplication {
    private static char[] cards = new char[13];
    static {
        cards[9] = 'J';
        cards[10] = 'Q';
        cards[11] = 'K';
        cards[12] = 'A';
        for (int i = 2; i <= 10; ++i) {
            cards[i - 2] = (char) i;
        }
    }
    public static void main(String[] args) {
        // String[] words = { "a", "aba", "ababa", "aa" };
        // // Algorithms alg = new Algorithms();
        // System.out.println(Algorithms.countPrefixSuffixPairs(words));

        for (int i = 0; i < 13; ++i) {
            System.out.println(Cards.getCardValue(cards[i]));
        }
    }
}