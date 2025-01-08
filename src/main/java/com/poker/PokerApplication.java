package com.poker;

public class PokerApplication {
    public static void main(String[] args) {
        String[] words = { "a", "aba", "ababa", "aa" };
        // Algorithms alg = new Algorithms();
        System.out.println(Algorithms.countPrefixSuffixPairs(words));
    }
}