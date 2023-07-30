package application;

public class Card {
	
	// Data fields for the card's rank and suit
	private int rank;
	private String suit;
	
	// Constructor that take in the arguments rank and suit, and sets objects rank and suit
	public Card(int rank, String suit) {
		this.rank = rank;
		this.suit = suit;
		}
	
	// Constructor the creates a card from a card
	public Card(Card card) {
		this.rank = card.getRank();
		this.suit = card.getSuit();
	}
	
	// Getter and setter methods for card's rank and suit
	public int getRank() {
		return this.rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	// Method overrides toString returns string representation of the card
	@Override
	public String toString() {
		if (this.rank == 1)
			return "Ace of " + this.suit;
		else if (this.rank > 1 && this.rank < 11)
			return this.rank + " of " + this.suit;
		else if (this.rank == 11)
			return "Jack of " + this.suit;
		else if (this.rank == 12)
			return "Queen of " + this.suit;
		else
			return "King of " + this.suit;
	}
	
}

