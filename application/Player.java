package application;

import java.util.Scanner;

public class Player extends Person {
	
	// Constructors for Player
	public Player() {
		setName("Player");
	}
	
	public Player(String name) {
		setName(name);
	}
	
	public Player(String name, Hand hand) {
		setName(name);
		setHand(hand);
	}
	
	// Method prompts the player to hit or stand and does the appropriate calculations to their hand
	public void hitOrStand(Deck deck) {
		// If the person has Blackjack do not allow them to hit
		if (hasBlackJack()) {
			System.out.println(this.getName() + " has Blackjack!");
			return;
		}
		
		// Keep prompting user to enter H or S until correct input
		String decision = getDecision();
		boolean keepHitting = true;
		
		while (keepHitting) {
			// If the player entered hit, give them a card, then prompt if want to hit or stand continuously until stand
			if (decision.compareToIgnoreCase("H") == 0 && this.getHand().calculateTotal() < 21) {
				this.getHand().takeCard(deck); // Take card from deck
				System.out.println(this.getName() + "'s hand is: ");
				this.getHand().printHand(true); // Print the player's hand
				System.out.println(this.getName() + 
						"'s hand's total is: " + this.getHand().calculateTotal()); // Print the player's total rank
				if (this.getHand().calculateTotal() < 21) { // If they still have less than 21, allow them to hit again
					decision = getDecision(); // Prompt user if they want to hit or stand again
					// If the decision is Hit, continue while loop, if Stay exit while loop
					if (decision.compareToIgnoreCase("H") != 0)
						keepHitting = false;
				}
			}
			else if (this.getHand().calculateTotal() > 21) {
				System.out.println("You busted.");
				keepHitting = false;
			}
			else { // If player did not enter hit, display their hand and the hand's total rank
				System.out.println("Your hand's final total is: " + this.getHand().calculateTotal());
				keepHitting = false;
			}	
		}
	}
	
	// Method gets the player's decision to hit or Stand
	public String getDecision() {
		// Keep prompting user to enter H or S until correct input
			System.out.println("\nWould you like to Hit or Stand? Enter 'H' for hit, 'S' for stand: ");
			Scanner input = new Scanner(System.in);
			String decision = "A";
			boolean getDecision = true;
			while (getDecision) {
				try {
					decision = input.next();
					if (decision.compareToIgnoreCase("H") == 0 || decision.compareToIgnoreCase("S") == 0)
						getDecision = false; // Get the decision, stop the while loop if entered H or S, continue if not
					}
					catch (Exception e) { // Input.next may throw exception
						System.out.println("Invalid Input: Enter H or S: ");
					}
				}
				System.out.println("You entered: " + decision);
				return decision;
	}
	
}

