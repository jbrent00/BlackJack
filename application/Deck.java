package application;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	// Data field for a deck of cards and number of cards in the deck
	private ArrayList<Card> deck;
	private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"}; // Needed for for loop in constructor
	
	// Constructors for Deck
	public Deck() {
		this(1, false);
	}
	
	public Deck(int numOfDecks, boolean shuffle) {
		// Create an ArrayList to store cards in 
		this.deck = new ArrayList<Card>();
		// Create card objects and place into deck
		for (int d = 0; d < numOfDecks; d++) { // For each deck
			for (int s = 0; s < 4; s++) { // For each suit
				for (int r = 1; r < 14; r++) { // For each rank
					this.deck.add(new Card(r, this.suits[s]));
				}
			}	
		}
		
		// Shuffle deck of cards depending on boolean parameter
		if (shuffle)
			Collections.shuffle(this.deck);
		}
	
	// Method adds a card to the end of the deck
	public void addCard(Card card) {
		this.deck.add(card);
	}
	
	// Method prints the deck of cards
	public void printDeck() {
		for (int i = 0; i < this.deck.size(); i++) {
			System.out.println(this.deck.get(i).toString());
		}
	}
	
	// Method to get and remove the first Card from the Deck
	public Card getCardFromDeck() {
		Card card = new Card(deck.get(0));
		deck.remove(0);
		return card;
	}
	
	// Method to shuffle the deck
	public void shuffleDeck() {
		Collections.shuffle(this.deck);
	}
	
	// Method returns the deck
	public ArrayList<Card> getDeck() {
		return this.deck;
	}
	
	// Method returns the size of the deck 
	public int getSizeOfDeck() {
		return this.deck.size();
	}
}

