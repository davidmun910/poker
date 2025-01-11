package com.poker;

public enum Role {
    BUTTON,                 // Dealer position
    SMALL_BLIND,            // Player to the left of the button
    BIG_BLIND,              // Player to the left of the small blind
    UNDER_THE_GUN,          // First position to act pre-flop
    UNDER_THE_GUN_PLUS_ONE, // Second position
    UNDER_THE_GUN_PLUS_TWO, // Third position (used in 9-handed games)
    MIDDLE_POSITION_ONE,    // Middle position (varies by number of players)
    MIDDLE_POSITION_TWO,    // Another middle position (optional)
    CUTOFF                  // Position directly to the right of the button
}