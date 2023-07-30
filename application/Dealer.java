package application;

public class Dealer extends Person {

	// Constructor for the Dealer
	public Dealer() {
		setName("Dealer");
	}
	
	// Method hits or stands for the dealer
	public void hitOrStand(Deck deck) {
		// Check if the dealer started with Blackjack and exit out of method if so
		if (hasBlackJack()) {
			return;
		}
		// If the Dealers hand total is less than 17, keep hitting
		while (this.getHand().calculateTotal() < 17) {
			this.getHand().takeCard(deck);
		}
		
	}
	
}
