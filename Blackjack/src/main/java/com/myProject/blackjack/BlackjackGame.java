package com.myProject.blackjack;

import java.util.Scanner;

public class BlackjackGame {
    private final Deck deck;
    private final Hand playerHand;
    private final Hand dealerHand;
    private final Scanner scanner;

    public BlackjackGame() {
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to Blackjack!");

        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());

        System.out.println("Your hand:");
        playerHand.display();
        System.out.println("\nDealer's hand:");
        System.out.println(dealerHand.getCards().get(0));

        while (playerHand.getScore() < 21) {
            System.out.println("\nDo you want to hit or stand? (h/s)");
            String choice = scanner.nextLine();
            if (choice.equals("h")) {
                playerHand.addCard(deck.dealCard());
                System.out.println("\nYour hand:");
                playerHand.display();
            } else if (choice.equals("s")) {
                break;
            }
        }

        while (dealerHand.getScore() < 17) {
            dealerHand.addCard(deck.dealCard());
        }

        System.out.println("\nYour hand:");
        playerHand.display();
        System.out.println("\nDealer's hand:");
        dealerHand.display();

        int playerScore = playerHand.getScore();
        int dealerScore = dealerHand.getScore();

        if (playerScore > 21 || (dealerScore <= 21 && dealerScore > playerScore)) {
            System.out.println("\nDealer wins!");
        } else if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("\nYou win!");
        } else {
            System.out.println("\nIt's a tie!");
        }
    }
}
