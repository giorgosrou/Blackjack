package com.myProject.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    public List<Card> getCards() {
        return cards;
    }

    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int score = 0;
        int numAces = 0;

        for (Card card : cards) {
            score += card.getValue();
            if (card.getValue() == 11) {
                numAces++;
            }
        }

        while (score > 21 && numAces > 0) {
            score -= 10;
            numAces--;
        }

        return score;
    }

    public void display() {
        for (Card card : cards) {
            System.out.println(card);
        }
        System.out.println("Score: " + getScore());
    }
}
