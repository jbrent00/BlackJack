package application;

import java.util.ArrayList;

public class Hand {
	
	// ArrayList hand will store the person's cards from the deck
	private ArrayList<Card> hand;
	
	// Constructor for Hand
	public Hand() {
		this.hand = new ArrayList<Card>(); // Creates an ArrayList
	}
	
	// Method to get the first card from the deck and place it into ArrayList hand, then remove first card
	public void takeCard(Deck deck) {
		this.hand.add(deck.getCardFromDeck()); // getCardFromDeck creates new card object with same values, removes first card
	}
	
	// Method to add a hand back into the deck
	public void addHandToDeck(Deck deck) {
		for (int i = 0; i < this.hand.size(); i++) {
			deck.addCard(this.hand.get(i));
		}
	}
	
	// Method to remove all of the cards from the hand
	public void removeCards() {
		this.hand.clear();
	}
	
	// Method to print the person's hand
	public void printHand(boolean showFirstCard) {
		if (showFirstCard) {
			for (int i = 0; i < this.hand.size(); i++) {
				System.out.println(this.hand.get(i).toString());
			}
		}	
		else {
			for (int i = 1; i < this.hand.size(); i++) {
				System.out.println(this.hand.get(i).toString());
			}
		}	
	}
	
	// Method returns a Card based on the index provided in parameter
	public Card getCardFromHand(int index) {
		return this.hand.get(index);
	}
	// Method returns the size of this hand
	public int getSizeOfHand() {
		return this.hand.size();
	}
	
	// Method to calculate the total rank of the hand
	public int calculateTotal() {
		int total = 0;
		int numOfAces = 0;
		
		for (int i = 0; i < this.hand.size(); i++) {
			if (this.hand.get(i).getRank() == 1) {// If the card is an ace, use 11 as the value
				total += 11;
				numOfAces++;
			}	
			else if (this.hand.get(i).getRank() > 1 && this.hand.get(i).getRank() < 11) // If the card is 2-10
				total += this.hand.get(i).getRank();
			else // If the card is jack, king, queen; use 10 as the value
				total += 10;
		}
		// While the total is greater than 21 and numOfAces > 0, use 1 as the value for ace
		while (total > 21 && numOfAces > 0) {
			total -= 10;
			numOfAces--;
		}
		return total;
	}
	
	
	
}
