#!/bin/bash

javac -d bin src/main/java/com/poker/*.java

java -cp bin com.poker.PokerApplication