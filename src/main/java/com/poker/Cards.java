package com.poker;

import java.util.Map;
import java.util.HashMap;

public class Cards {
    public static final Map<Character, Integer> CARD_VALUES = new HashMap<>();
    static {
        CARD_VALUES.put('A', 14);
        CARD_VALUES.put('K', 13);
        CARD_VALUES.put('Q', 12);
        CARD_VALUES.put('J', 11);
        for (int i = 10; i >= 2; --i) {
            CARD_VALUES.put((char) i, i);
        }
    }

    /* 
     * Parameters: [char card] -> Card value (A, 2, 3, ...)
     * Output: [int] -> Return -1 if invalid card or the value for the given card
     */
    public static int getCardValue(char card) {
        return CARD_VALUES.getOrDefault(card, -1);
    }
}
